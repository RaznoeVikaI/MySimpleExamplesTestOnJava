package ru.lesson.dynamic.negative;

import org.json.JSONObject;
import org.testng.annotations.Test;
import ru.lesson.BaseTest;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class GetForumDataTest {
    BaseTest baseTest = new BaseTest();

    @Test
    public void verifyResponseWithLetterInParameter() throws IOException {
        String url = "http://api.rutracker.org/v1/get_forum_name?by=forum_id&val=m";
        System.out.println(baseTest.getResponseJsonByUrl(url));
        JSONObject result = new JSONObject(baseTest.getResponseJsonByUrl(url));
        JSONObject result1 = (JSONObject) result.get("error");

        int code = (Integer) result1.get("code");
        //Проверем, что code = 1
        assertEquals(code,1);

        String text = (String) result1.get("text");
        //Проверяем, что text = Param [val] is empty
        assertEquals(text,"Param [val] is empty");
    }

    @Test
    public void verifyRenponseWithSpecialSymbolInParameter() throws IOException {
        String url = "http://api.rutracker.org/v1/get_forum_name?by=forum_id&val=%29";
        System.out.println(baseTest.getResponseJsonByUrl(url));
        JSONObject result = new JSONObject(baseTest.getResponseJsonByUrl(url));
        JSONObject result1 = (JSONObject) result.get("error");

        int code = (Integer) result1.get("code");
        //Проверем, что code = 1
        assertEquals(code,1);

        String text = (String) result1.get("text");
        //Проверяем, что text = Param [val] is empty
        assertEquals(text,"Param [val] is empty");
    }


    //Test с пустым парметром в браузере не проходит!Проверяю здесь
    @Test
    public void verifyRenponseWithEmptyInParameter() throws IOException {
        String url = "http://api.rutracker.org/v1/get_forum_name?by=forum_id&val=";
        System.out.println(baseTest.getResponseJsonByUrl(url));
        JSONObject result = new JSONObject(baseTest.getResponseJsonByUrl(url));
        JSONObject result1 = (JSONObject) result.get("error");

        int code = (Integer) result1.get("code");
        //Проверем, что code = 1
        assertEquals(code,1);

        String text = (String) result1.get("text");
        //Проверяем, что text = Param [val] is empty
        assertEquals(text,"Param [val] is empty");
    }
}
