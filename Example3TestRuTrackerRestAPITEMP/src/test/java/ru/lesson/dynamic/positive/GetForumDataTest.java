package ru.lesson.dynamic.positive;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;
import org.testng.annotations.Test;
import ru.lesson.BaseTest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.testng.Assert.assertEquals;

/**
 * В качестве параметра принимаются элементы типа String
 */
public class GetForumDataTest {

    BaseTest baseTest = new BaseTest();

    @Test
    public void verifyResponseCodeWithOneRussianLetter() throws IOException {
        //Посылаем в запросе запрос с forum_id = р
        String url = "http://api.rutracker.org/v1/get_forum_data?by=forum_id&val=%u0440";
        //На сайте тест: ответ от сервера: "text": "Param [val] is empty"
        //Здесь проверка отрабатывает без ошибок
        assertEquals(baseTest.getResponseCode(url),200);
    }

    @Test
    public void verifyResponseCodeWithOneEnglishLetter() throws IOException {
        //Посылаем в запросе запрос с forum_id = w
        String url = "http://api.rutracker.org/v1/get_forum_data?by=forum_id&val=w";
        //На сайте тест: ответ от сервера: "text": "Param [val] is empty"
        //Здесь проверка отрабатывает без ошибок
        assertEquals(baseTest.getResponseCode(url),200);
    }
}