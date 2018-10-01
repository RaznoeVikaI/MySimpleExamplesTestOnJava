package ru.lesson.dynamic.negative;

import org.testng.annotations.Test;
import ru.lesson.BaseTest;

import java.io.IOException;

public class GetForumDataTest {

    BaseTest baseTest = new BaseTest();

    @Test
    public void verifyResponseCodeWithEmptyParametr() throws IOException {
        //!forum_id не присвоены значения
        String url = "http://api.rutracker.org/v1/get_forum_data?by=forum_id&val=";
        baseTest.getStringByUrl(url);
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
