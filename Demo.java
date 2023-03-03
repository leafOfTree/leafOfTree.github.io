package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        post();
    }

    static void post() throws IOException {
        final HttpPost httpPost = new HttpPost("https://example.com");
        final String json = "{id: 1, name: James}";
        final StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Accept", "application/json");

        try (CloseableHttpClient client = HttpClients.createDefault();
             CloseableHttpResponse response = client.execute(httpPost)) {
            int statusCode = response.getStatusLine().getStatusCode();
            String result = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
            System.out.println(statusCode + " "+ result);
        }
    }
}

<dependencies>
    <dependency>
        <groupId>org.apache.httpcomponents</groupId>
        <artifactId>httpclient</artifactId>
        <version>4.5.13</version>
    </dependency>
</dependencies>
