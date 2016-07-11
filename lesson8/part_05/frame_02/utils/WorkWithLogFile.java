package lesson8.part_05.frame_02.utils;

import java.io.*;

public class WorkWithLogFile {
    private File logFile;
    private String fileName = "action_log.txt";
    private String path = "/src/lesson8/part_05/frame_02/log/";

    public WorkWithLogFile() {
    }

    public void createLogFile() throws IOException {
        logFile = new File(System.getProperty("user.dir") + (path + fileName).replace("/", File.separator));
        if (!logFile.exists()) {
            logFile.createNewFile();
        }
    }

    public void updateLogFile(File file, String data) throws IOException {
        StringBuilder sb = new StringBuilder();
        String oldFile = readLogFile(file) + "\n";
        sb.append(oldFile);
        sb.append(data);
        writeLogFile(file, sb.toString());
    }

    public void writeLogFile(File file, String data) {
        try (
                FileOutputStream fos = new FileOutputStream(file.getAbsolutePath());
                BufferedOutputStream bos = new BufferedOutputStream(fos, 256)
        ) {
            bos.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readLogFile(File file) {
        StringBuilder builder = new StringBuilder();
        try (
                FileInputStream fis = new FileInputStream(file.getAbsolutePath());
                BufferedInputStream bis = new BufferedInputStream(fis, 256);
        ) {
            int i;
            while ((i = bis.read()) != -1) {
                builder.append((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
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
