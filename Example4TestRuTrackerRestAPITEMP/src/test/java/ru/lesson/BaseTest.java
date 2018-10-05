package ru.lesson;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Set;

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

    public int getResponseCode(String urlForResponseCode) throws IOException {
        URL url = new URL(urlForResponseCode);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        int statusCode = http.getResponseCode();
        return statusCode;
    }

    public String getResponseJsonByUrl(String url) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        HttpResponse response = null;
        response = client.execute(request);
        HttpEntity entity = response.getEntity();
        //Ответ с сервера(json-ответ): {"result":{"1":null,"7":{"forum_name":"Зарубежное кино","parent_id":0}}}
        String content = EntityUtils.toString(entity);
        return content;
    }
}
