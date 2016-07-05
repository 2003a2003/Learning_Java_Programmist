package lesson8.part_03.frame_03;

import java.io.*;
import java.nio.charset.Charset;

public class DemoLauncher {

    public static void main(String[] args) {
        String currentEncoding = "utf-8";
        String neededEncoding = "cp1251";

        String startFileName = "/src/lesson8/part_03/frame_03/files/start_file_" + currentEncoding + ".txt";
        String fileName = System.getProperty("user.dir") + startFileName.replace("/", File.separator);

        //creane new file with currentEncoding codirivke
        write("Что то такое передаем :)", fileName, currentEncoding);
        System.out.println("***** Print the file before you change the encoding *****");
        System.out.println("Encoding: " + currentEncoding + ": " + read(fileName));

        File f = new File(fileName);
        changeEncoding(f, currentEncoding, neededEncoding);
    }

    public static void changeEncoding(File file, String currentEncoding, String neededEncoding) {
        String newName = file.getAbsolutePath().replace(file.getName(), "finish_file_" + neededEncoding + ".txt");

        StringBuilder builder = new StringBuilder();

        try (
                FileInputStream fis = new FileInputStream(file.getAbsolutePath());
                InputStreamReader isr = new InputStreamReader(fis, Charset.forName(currentEncoding));
                BufferedReader br = new BufferedReader(isr, 256);

                FileOutputStream fos = new FileOutputStream(newName);
                OutputStreamWriter osw = new OutputStreamWriter(fos, Charset.forName(neededEncoding));
                BufferedWriter bw = new BufferedWriter(osw, 256)
        ) {
            String str;
            while ((str = br.readLine()) != null) {
                bw.write(str);
            }
        } catch (UnsupportedEncodingException e) {
            System.err.println("Wrong Encoding!!!!");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.err.println("File search wrong!!!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Encoding: " + currentEncoding + " chenged to: " + neededEncoding);
        System.out.println("Encoding: " + neededEncoding + ": " + read(newName));
    }

    public static void write(String data, String fileName, String encoding) {
        try (
                FileOutputStream fos = new FileOutputStream(fileName);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos, encoding)
        ) {
            outputStreamWriter.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String read(String fileName) {
        StringBuilder builder = new StringBuilder();
        try (
                FileInputStream fis = new FileInputStream(fileName);
                InputStreamReader reader = new InputStreamReader(fis);
                BufferedReader bufferedReader = new BufferedReader(reader)
        ) {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                builder.append(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
