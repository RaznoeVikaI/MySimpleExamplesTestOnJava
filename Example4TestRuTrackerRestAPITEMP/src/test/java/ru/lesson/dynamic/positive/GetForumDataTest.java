package ru.lesson.dynamic.positive;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;
import ru.lesson.BaseTest;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class GetForumDataTest {

    BaseTest baseTest = new BaseTest();

    //Парсим json-ответ с сервера и проверяем его содержимое
    @Test
    public void verifyJsonResponseByDefaultSettings() throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("http://api.rutracker.org/v1/get_forum_data?by=forum_id&val=1%2C7");
        HttpResponse response = null;
        response = client.execute(request);
        HttpEntity entity = response.getEntity();
        //Ответ с сервера(json-ответ): {"result":{"1":null,"7":{"forum_name":"Зарубежное кино","parent_id":0}}}
        String content = EntityUtils.toString(entity);
        System.out.println(content);

        //Работает
        JSONObject result = new JSONObject(content);
        Object one = result.opt("1");
        //Проверяем, что 1 = null
        assertEquals(one,null);

        JSONObject result1 = (JSONObject) result.get("result");
        JSONObject seven = (JSONObject) result1.get("7");
        String forum_name = (String) seven.get("forum_name");
        //Проверяем, что forum_name = Зарубежное кино
        assertEquals(forum_name,"Зарубежное кино");

        int parent_id = (int) seven.get("parent_id");
        //Проверяем, что parent_id = 0
        assertEquals(parent_id,0);
    }

    @Test
    public void verifyJsonResponseOverLeftFrontier() throws IOException {
        String url = "http://api.rutracker.org/v1/get_forum_data?by=forum_id&val=-129";
        System.out.println(baseTest.getResponseJsonByUrl(url));
        JSONObject result = new JSONObject(baseTest.getStringByUrl(url));
        Object overRightFrontier = result.opt("-129");
        //Проверяем, что 1 = null
        assertEquals(overRightFrontier,null);
    }

    //On Left Border:-128
    @Test
    public void verifyJsonResponseoOnLeftBorder() throws IOException {
        String url = "http://api.rutracker.org/v1/get_forum_data?by=forum_id&val=-128";
        System.out.println(baseTest.getResponseJsonByUrl(url));
        JSONObject result = new JSONObject(baseTest.getStringByUrl(url));
        Object overRightFrontier = result.opt("-128");
        //Проверяем, что 1 = null
        assertEquals(overRightFrontier,null);
    }

    //Inside:8,53,120
    @Test
    public void verifyResponseInsideInterval() throws IOException {
        String url = "http://api.rutracker.org/v1/get_forum_name?by=forum_id&val=8%2C53%2C120";
        System.out.println(baseTest.getResponseJsonByUrl(url));

        //Работает
        JSONObject result = new JSONObject(baseTest.getResponseJsonByUrl(url));
        Object eight = result.opt("8");
        //Проверяем, что 8 = null
        assertEquals(eight,null);

        JSONObject result1 = (JSONObject) result.get("result");
        String fiftyThree = (String) result1.get("53");
        //Проверяем, что 53= Приключения и квесты
        assertEquals(fiftyThree,"Приключения и квесты");

        Object oneHundredAndTwenty = result.opt("120");
        //Проверяем, что 120 = null
        assertEquals(oneHundredAndTwenty,null);
    }

}
