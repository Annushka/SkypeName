package SkypeName;

import java.io.*;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: Анна
 * Date: 23.08.13
 * Time: 9:21
 * To change this template use File | Settings | File Templates.
 */
public class CesheSkypeStatusRequester implements StatusRequester {
    private File file;
    private SkypeStatusRequester sk;// = new SkypeStatusRequester();

    CesheSkypeStatusRequester(SkypeStatusRequester sreq) throws IOException {
        file = new File("File.txt");
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("New file File.txt has been created in the current directory");
        }
        sk = sreq;
    }

    public String readStatus(String str) throws Exception {
        return sk.readStatus(str);
    }

    public boolean validate(String str) throws Exception {
        str = str.toLowerCase();
        if (isNameExists(str)) {
            return searchingFile(str).equals("true");
        } else {
            String pattern = "^[a-z][a-z0-9\\.,\\-_]{5,31}$";
            // Create a Pattern object
            Pattern r = Pattern.compile(pattern);
            // Now create matcher object.
            Matcher m = r.matcher(str);
            if (m.find()) {
                String s = sk.readStatus(str);
                if (s.contains(":200,")) {
                    System.out.println("имени " + str + " еще нет");
                    addRecord(str, false);
                    return false;
                } else {
                    System.out.println("имя " + str + " уже есть");
                    addRecord(str, true);
                    return true;
                }


            } else {
                System.out.println("имя " + str + " не подходит");
                //addRecord(str,false);
                return false;
            }
        }
    }


    public boolean isNameExists(String name) throws Exception {
        return (searchingFile(name)) != null;
    }

    public void addRecord(String name, boolean value) throws Exception {
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        String lineSeparator = System.getProperty("line.separator");
        String content = name + "," + value + lineSeparator;
        bw.write(content);
        bw.close();
    }


    private String searchingFile(final String name) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        try {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer str = new StringTokenizer(line, ",");
                if (str.nextToken().equals(name)) {
                    return str.nextToken();
                }
            }
            return null;

        } finally {
            br.close();
        }
    }

    public static void main(String[] args) throws Exception {
        CesheSkypeStatusRequester l = new CesheSkypeStatusRequester(new SkypeStatusRequester());
        System.out.println("" + l.searchingFile("sunny3548"));
    }

}
