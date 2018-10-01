package ru.lesson;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class BaseTest {
    public String getStringByUrl(String url) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("http://api.rutracker.org/v1/get_forum_data?by=forum_id&val=2147483647");
        HttpResponse response = null;
        response = client.execute(request);
        HttpEntity entity = response.getEntity();
        String content = EntityUtils.toString(entity);
        return content;
    }
}
