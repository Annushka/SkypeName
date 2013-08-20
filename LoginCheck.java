package SkypeName;//import com.sun.deploy.net.HttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.DefaultHttpClient;

/*import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.message.AbstractHttpMessage;*/

import com.sun.xml.internal.ws.developer.MemberSubmissionAddressing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("deprecation")
public class LoginCheck implements SkypeName {

    public boolean validate(String str) throws Exception {
        if (str == "") {
            throw new Exception("login is not found");
        }
        str = str.toLowerCase();
        String pattern = "^[a-z][a-z0-9\\.,\\-_]{5,31}$";
        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);
        // Now create matcher object.
        Matcher m = r.matcher(str);
        if (m.find()) {
            System.out.println("Found value: " + m.group(0));
            String url = "https://login.skype.com/json/validator?new_username=" + str;
            System.out.println("Url is  - " + url);
            String s = readUrl(url);
            if (s.contains("200")) {
                System.out.println("такого имени еще нет");
                return false;
            } else {
                System.out.println("такое имя уже есть");
                return true;
            }


        } else {
            System.out.println("NO MATCH");
            return false;
        }
    }


    public String readUrl(String urlString) throws Exception {
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
        System.out.println(lch.validate("sunny3548"));

    }

}
