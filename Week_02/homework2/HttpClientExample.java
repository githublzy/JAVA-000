package com.zeke.week02;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @Class HttpClientExample
 * @Description HttpClientExample
 * @Author zeke
 * @Date 26/10/2020 10:01 下午
 * @Version 1.0.0
 **/
public class HttpClientExample {

    public static void main(String[] args) {
        HttpGet httpGet = new HttpGet("http://localhost:8801/");
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(httpGet)) {
            if (response.getStatusLine().getStatusCode() == 200) {
                System.out.println("Response：" + EntityUtils.toString(response.getEntity(), "utf-8"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
