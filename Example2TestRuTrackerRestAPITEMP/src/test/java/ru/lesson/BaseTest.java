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

/*    public void temp() throws IOException {
        URL url = new URL("http://exampleurl.ex");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");

        // You may need to copy over the cookies that Selenium has in order
        // to imitate the Selenium user (for example if you are testing a
        // website that requires a sign-in).
        //Set<Cookie> cookies = driver.manage().getCookies();
        Set<Cookie> cookies =
        String cookieString = "";

        for (Cookie cookie : cookies) {
            cookieString += cookie.getName() + "=" + cookie.getValue() + ";";
        }

        httpURLConnection.addRequestProperty("Cookie", cookieString);
        Assert.assertEquals(200, httpURLConnection.getResponseCode());
    }*/
}
