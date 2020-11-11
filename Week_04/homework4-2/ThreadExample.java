package com.zeke.Week04;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

/**
 * @Class ThreadExample
 * @Description ThreadExample
 * @Author zeke
 * @Date 9/11/2020 9:13 下午
 * @Version 1.0.0
 **/
public class ThreadExample {

    public static void main(String[] args) throws Exception {
        thread1();
        thread2();
    }

    public static void thread1() throws Exception {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                method();
                return "result";
            }
        });
        System.out.println("异步计算结果为："+ future.get());
    }

    public static void thread2() {
        CountDownLatch latch = new CountDownLatch(1);
        AtomicInteger result = new AtomicInteger();
        new Thread(() -> {
            method();
            result.incrementAndGet();
            latch.countDown();
        }).start();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("result:" + result.get());
    }

    private static void method() {
        // do something
        System.out.println("method invoked");
    }


    public static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception{
            String value="test";
            System.out.println("Ready to work");
            System.out.println("task done");
            return  value;
        }
    }
}
