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

    @Test
    public void test3() throws IOException {
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

    //Посылается get-запрос с двумя параметрами
    @Test
    public void test4() throws IOException {
        String url = "http://api.rutracker.org/v1/get_forum_data?by=forum_id&val=1%2C7";
        JSONObject result = new JSONObject(baseTest.getStringByUrl(url));
        Object one = result.opt("1");
        //Проверяем, что параметр "1",переданный в запросе, действительно не имеет значения
        assertEquals(one,null);
    }


    @Test
    public void test6() throws IOException {
        //Проверяем, что отправленный запрос с парамтром, равным длине переменной типа long вернулся ответом без ошибок
        String url = "http://api.rutracker.org/v1/get_forum_data?by=forum_id&val=9223372036854775807";
        baseTest.getStringByUrl(url);
    }

    @Test
    public void test7() throws IOException {
        //Проверяем, что отправленный запрос с парамтром, равным длине переменной типа int вернулся ответом без ошибок
        String url = "http://api.rutracker.org/v1/get_forum_data?by=forum_id&val=2147483647";
        baseTest.getStringByUrl(url);
    }
}
