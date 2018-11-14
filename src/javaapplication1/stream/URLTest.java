package javaapplication1.stream;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import rx.Observable;
import java.util.Scanner;

public class URLTest {

    private static final URLTest _instance = new URLTest();

    public static URLTest getInstance() {
        return _instance;
    }

    public static void main(String[] args) {

    }

    public Observable<String> getTitle(String url) {
        InputStream response = null;
        String rs = "";
        try {
            
            response = new URL(url).openStream();

            Scanner scanner = new Scanner(response);
            String responseBody = scanner.useDelimiter("\\A").next();
            rs = responseBody.substring(responseBody.indexOf("<title>") + 7, responseBody.indexOf("</title>"));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return Observable.just(rs);
    }
}
