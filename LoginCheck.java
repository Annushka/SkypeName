package SkypeName;//import com.sun.deploy.net.HttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.DefaultHttpClient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.message.AbstractHttpMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.URL;


/**
 * Created with IntelliJ IDEA.
 * User: Анна
 * Date: 02.08.13
 * Time: 9:41
 * To change this template use File | Settings | File Templates.
 */

@SuppressWarnings("deprecation")
public class LoginCheck {
    boolean validate(String str) throws Exception {
        char[] login = str.toCharArray();
        String Str = "";
        for (int i = 0; i < login.length; i++) {
            if (login[i] >= 'A' && login[i] <= 'Z') {
                login[i] = letter(login[i]);
            }
            Str += login[i];
        }
        // вызов функции адаптации букв верхнего регистра

        if (login[0] >= 'a' && login[0] <= 'z') {
            if (login.length >= 6 && login.length <= 32) {
                for (int i = 1; i < login.length; i++) {
                    char l = login[i];
                    if (l >= 0 && l <= '+' || l == '/' || l >= ':' && l <= '^' || l == '`' || l >= '{' && l <= 127) {
                        return false;
                    }

                }

                String url = "https://login.skype.com/json/validator?new_username=" + Str;
                System.out.println("Url is  - " + url);

                // make sure cookies is turn on
                //  CookieHandler.setDefault(new CookieManager());


                //  System.out.println("смотрим - "+readUrl(url));
                String s = readUrl(url);
                char[] answerStr = s.toCharArray();
                int answer = (answerStr[10] - 48) * 100 + (answerStr[11] - 48) * 10 + (answerStr[12] - 48);

                System.out.println();
                System.out.println("answer = " + answer);
                if (answer == 200) {
                    System.out.println("такого имени еще нет");
                    return false;
                } else {
                    System.out.println("такое имя уже есть");
                    return true;
                }
            }

        }
        return false;
    }

    char letter(char l) {
        if (l == 'A') return 'a';
        if (l == 'B') return 'b';
        if (l == 'C') return 'c';
        if (l == 'D') return 'd';
        if (l == 'E') return 'e';
        if (l == 'F') return 'f';
        if (l == 'G') return 'g';
        if (l == 'H') return 'h';
        if (l == 'I') return 'i';
        if (l == 'J') return 'j';
        if (l == 'K') return 'k';
        if (l == 'L') return 'l';
        if (l == 'M') return 'm';
        if (l == 'N') return 'n';
        if (l == 'O') return 'o';
        if (l == 'P') return 'p';
        if (l == 'Q') return 'q';
        if (l == 'R') return 'r';
        if (l == 'S') return 's';
        if (l == 'T') return 't';
        if (l == 'U') return 'u';
        if (l == 'V') return 'v';
        if (l == 'W') return 'w';
        if (l == 'X') return 'x';
        if (l == 'Y') return 'y';
        if (l == 'Z') return 'z';
        else return 0;
    }

    private String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }

    public static void main(String[] args) throws Exception {
        LoginCheck lch = new LoginCheck();
        System.out.println(lch.validate("ArleKino"));

    }

}
