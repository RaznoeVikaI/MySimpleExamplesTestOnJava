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

public class GetForumDataTest {

    BaseTest baseTest = new BaseTest();

    //Посылается get-запрос с двумя параметрами
    @Test
    public void verifyResponseCodeWithTwoParametrsInt() throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("http://api.rutracker.org/v1/get_forum_data?by=forum_id&val=1%2C2");
        HttpResponse response = null;
        response = client.execute(request);

        //get all headers
        Header[] headers = response.getAllHeaders();

        //Берем текущую системную дату для проверки с датой,которая приходит в ответе с сервера
        Locale.setDefault(new Locale("en", "US"));
        Date datePP = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("E, d MMM Y HH:mm:ss zzz");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        //!Отличаются секунды
        assertEquals(headers[1].getValue(),sdf.format(datePP),"Дата,сгенерированная автоматически не совпадает с датой из Результата");
    }


    @Test
    public void verifyResponseCodeWithParametrInt() throws IOException {
        String url = "http://api.rutracker.org/v1/get_forum_data?by=forum_id&val=1%2C7";
        JSONObject result = new JSONObject(baseTest.getStringByUrl(url));
        Object one = result.opt("1");
        //Проверяем, что параметр "1",переданный в запросе, действительно не имеет значения
        assertEquals(one,null);
    }


    @Test
    public void verifyResponseCodeWithBigValueParametrLong() throws IOException {
        String url = "http://api.rutracker.org/v1/get_forum_data?by=forum_id&val=9223372036854775807";
        //Проверяем код ответа с сервера.Должен быть 200
        assertEquals(baseTest.getResponseCode(url),200);
    }

    @Test
    public void verifyResponseCodeWithBigValueParametrInt() throws IOException {
        String url = "http://api.rutracker.org/v1/get_forum_data?by=forum_id&val=2147483647";
        //Проверяем код ответа с сервера.Должен быть 200
        assertEquals(baseTest.getResponseCode(url),200);
    }
}
