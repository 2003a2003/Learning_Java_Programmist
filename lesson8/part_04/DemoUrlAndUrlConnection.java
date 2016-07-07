package lesson8.part_04;


import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class DemoUrlAndUrlConnection {

    public static void main(String[] args) {

        String path = "/src/lesson8/part_04/";
        String fileName = "kademika.html";
        File file = new File(System.getProperty("user.dir") + (path + fileName).replace("/", File.separator));

        URL kademika = null;
        URLConnection urlConnection = null;
        try {
            kademika = new URL("http://work.kademika.com/");
            urlConnection = kademika.openConnection();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8), 1024); //"windows-1251" "UTF-8"

                OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
                BufferedWriter out = new BufferedWriter(osw, 1024)
        ) {

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
                out.write(inputLine);
            }
         } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
