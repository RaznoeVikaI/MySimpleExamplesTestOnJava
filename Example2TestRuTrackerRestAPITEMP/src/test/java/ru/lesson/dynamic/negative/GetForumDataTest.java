package ru.lesson.dynamic.negative;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.lesson.BaseTest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.testng.Assert.assertEquals;

public class GetForumDataTest {

    BaseTest baseTest = new BaseTest();

    @Test
    public void verifyResponseCodeWithEmptyParametr() throws IOException {
        //!forum_id не присвоены значения
        String url = "http://api.rutracker.org/v1/get_forum_data?by=forum_id&val=";
        //baseTest.getStringByUrl(url);
        
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        HttpResponse response = null;
        response = client.execute(request);
        //Код ответа 200, при том что параметр не имеет значения!?
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
    }

    @Test
    public void verifyResponseCodeWithStringParametr() throws IOException {
        //!forum_id присвоено символьное значение - буква t
        String url = "http://api.rutracker.org/v1/get_forum_data?by=forum_id&val=t";
        baseTest.getStringByUrl(url);

    }

    @Test
    public void verifyResponseCodeWithSpecialStringParametr() throws IOException {
        //!forum_id присвоено символьное значение - \
        String url = "http://api.rutracker.org/v1/get_forum_data?by=forum_id&val=%5C";
        baseTest.getStringByUrl(url);
    }
}
