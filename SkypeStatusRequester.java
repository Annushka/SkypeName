package SkypeName;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: Анна
 * Date: 23.08.13
 * Time: 9:12
 * To change this template use File | Settings | File Templates.
 */
public class SkypeStatusRequester implements StatusRequester {

    @Override
    public String readStatus(String str) throws Exception {
        BufferedReader reader = null;
        try {
            String urlString = "https://login.skype.com/json/validator?new_username=" + str;
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
}
