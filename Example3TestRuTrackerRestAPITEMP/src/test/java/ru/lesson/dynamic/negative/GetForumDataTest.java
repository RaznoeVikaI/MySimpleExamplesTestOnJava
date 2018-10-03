package ru.lesson.dynamic.negative;


import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
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
    public void verifyResponseCodeWithParametrInt() throws IOException {
        String url = "http://api.rutracker.org/v1/get_forum_data?by=forum_id&val=1%2C7";
        //Проверяем рекцию запроса, если forum_id - это цифра
        assertEquals(baseTest.getResponseCode(url),200);
    }

    @Test
    public void verifyResponseCodeWithSpecialStringParametr() throws IOException {
        String url = "http://api.rutracker.org/v1/get_forum_data?by=forum_id&val=%29";
        //Проверяем рекцию запроса, если forum_id - это сивол )
        assertEquals(baseTest.getResponseCode(url),200);
    }

    @Test
    public void verifyResponseCodeWithEmptyParametr() throws IOException {
        String url = "http://api.rutracker.org/v1/get_forum_data?by=forum_id&val=";
        //Проверяем рекцию запроса, если forum_id - пустая строка
        assertEquals(baseTest.getResponseCode(url),200);
    }
}
