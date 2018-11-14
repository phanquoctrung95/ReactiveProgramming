/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1.stream;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Future;
import rx.Observable;

/**
 *
 * @author cpu10955
 */
public class Main {

    public static void main(String[] args) {
        query("url")
                .flatMap(urls -> Observable.from(urls))
                .filter(url -> !"".equals(url) && url != null)
                .flatMap(url -> getTitle(url))
                .subscribe(title -> System.out.println(title),
                        error -> System.out.println("error")
                );

    }

    static Observable<List<String>> query(String statement) {
        return Observable.just(Arrays.asList("", "https://stackoverflow.com/questions/40099397/how-can-i-get-the-page-title-information-from-a-url-in-java",
                "https://chat.zalo.me/",
                "https://github.com/ReactiveX/RxJava/wiki/Implementing-Your-Own-Operators",
                "https://huongdanjava.com/vi/su-dung-phuong-thuc-flatmap-cua-doi-tuong-stream-trong-java.html",
                "https://developers.redhat.com/blog/2017/06/30/5-things-to-know-about-reactive-programming/"));
    }

    static Observable<String> getTitle(String url) {
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
