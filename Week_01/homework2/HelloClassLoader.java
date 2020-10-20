package com.zeke.week01;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Method;

/**
 * @Class HelloClassLoader
 * @Description HelloClassLoader
 * @Author zeke
 * @Date 19/10/2020 9:45 PM
 * @Version 1.0.0
 **/
public class HelloClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try (InputStream inputStream = this.getClass().getResourceAsStream("Hello.xlass");
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024 * 4];
            int n;
            while ((n = inputStream.read(buffer)) != -1) {
                out.write(buffer, 0, n);
            }
            byte[] bytes = out.toByteArray();
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (255 - bytes[i]);
            }
            return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    public static void main(String[] args) {
        Class<?> hello = null;
        try {
            HelloClassLoader helloClassLoader = new HelloClassLoader();
            hello = helloClassLoader.loadClass("Hello");
            Object instance = hello.newInstance();
            Method helloMethod = hello.getMethod("hello");
            helloMethod.invoke(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
