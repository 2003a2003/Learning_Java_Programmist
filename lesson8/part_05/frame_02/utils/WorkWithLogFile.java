package lesson8.part_05.frame_02.utils;

import lesson8.part_05.frame_02.bf.tanks.AbstractTank;

import java.io.*;
import java.util.ArrayList;

public class WorkWithLogFile {

    private AbstractTank tank;
    private File logFile;
    private String fileName = "action_log.txt";
    private String path = "/src/lesson8/part_05/frame_02/log/";

    public WorkWithLogFile() {
    }

    public void createLogFile() throws IOException {
        logFile = new File(System.getProperty("user.dir") + (path + fileName).replace("/", File.separator));
        if (logFile.exists()) {
            logFile.delete();
        }

        logFile.createNewFile();
    }

    public void updateLogFile(File file, String data) throws IOException {
        StringBuilder sb = new StringBuilder();
        String oldFile = readLogFile(file);
        sb.append(oldFile + "\n");
        sb.append(data);
        writeLogFile(file, sb.toString());
    }

    public void writeLogFile(File file, String data) {
        try (
                FileOutputStream fos = new FileOutputStream(file.getAbsolutePath());
                BufferedOutputStream bos = new BufferedOutputStream(fos, 256);
//                OutputStreamWriter os = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
//                BufferedWriter bw = new BufferedWriter(os, 256)
        ) {
            bos.write(data.getBytes());
            //bw.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readLogFile(File file) {
        StringBuilder builder = new StringBuilder();
        try (
                FileInputStream fis = new FileInputStream(file.getAbsolutePath());
                BufferedInputStream bis = new BufferedInputStream(fis, 256)
//                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
//                BufferedReader br = new BufferedReader(isr, 256)
        ) {
//            String str;
//            while ((str = br.readLine()) != null) {
//                builder.append(str);
//            }
            int i;
            while ((i = bis.read()) !=-1){
                builder.append((char)i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public ArrayList<Object> readFromFileListObjaect(File file) throws Exception {
        ArrayList<Object> act = null;
        try (
                ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file.getAbsolutePath())))
        ) {
            act = (ArrayList<Object>)ois.readObject();
        }catch (IOException e){
            e.printStackTrace();
        }
        return act;
    }

    public void writeToFileListObject(File file, ArrayList<Object> list) throws Exception {
        try (
                ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file.getAbsolutePath())))
        ) {

            out.writeObject(list);
        }
    }

    public void writeToFileListObject(File file, Object o) throws Exception {
        try (
                ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file.getAbsolutePath())))
        ) {
            out.writeObject(o);
        }
    }

    public File getLogFile() {
        return logFile;
    }

    public void setLogFile(File logFile) {
        this.logFile = logFile;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
