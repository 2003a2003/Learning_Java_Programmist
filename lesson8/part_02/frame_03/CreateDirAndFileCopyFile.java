package lesson8.part_02.frame_03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

public class CreateDirAndFileCopyFile {

    public static void main(String[] args) throws IOException {
        String dirName = "first directory";
        String part = "src/lesson8/part_02/frame_03/";

        String directoryPart = getRelativeFileDir(part + dirName);
        createDir(directoryPart, dirName);

        String fileName = "test.txt";
        String filePart = part + dirName;
        createFile(filePart, fileName);

        String text = "First text add to file!!!";

        writeFile(fileName, filePart, text);
        System.out.println("Read file: " + fileName + ", next text: \n" + readFile(fileName, filePart));

        File file = new File(getRelativeFileDir(filePart + "/" + fileName));
        copyFile(file);


    }

    public static void createDir(String part, String dirName) {
        part.replace("/", File.separator);
        File f = new File(part);
        if (f.mkdir()) {
            System.out.println("Create directory with name: " + f.getAbsolutePath() + " is true!!!");
        } else {
            System.out.println("Create directory is false, because the directory with name: " + f.getAbsolutePath() + " exists !!!");
        }
    }

    public static void createFile(String path, String fileName) throws IOException {
        path = getRelativeFileDir(path + "/" + fileName);
        File f = new File(path);
        if (f.exists()) {
            System.out.println("Create file is false, because the file with name: " + f.getAbsolutePath() + " exists !!!");
        } else {
            f.createNewFile();
            System.out.println("Create file with name: " + f.getAbsolutePath() + " is true!!!");
        }
    }

    public static void printDirectoryTree(String s) {
        File file = new File(s);
        if (!file.isDirectory()) {
            return;
        }

        String[] list = file.list();
        for (int i = 0; i < list.length; i++) {
            File f = new File(s + File.separator + list[i]);
            if (f.isFile()) {
//                System.out.println(s + File.separator + list[i]);
                System.out.println(f.getAbsolutePath());
            } else {
                printDirectoryTree(s + File.separator + list[i]);
            }
        }
    }

    public static String getRelativeFileDir(String path) {
        return path.replace("/", File.separator);
    }

    public static void writeFile(String fileName, String path, String data) {
        FileOutputStream fos = null;
        path = path + "/" + fileName;
        path.replace("/", File.separator);

        try {
            fos = new FileOutputStream(path);
            fos.write(data.getBytes());
            System.out.println("File was chenge net text: " + data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {

                }
            }
        }
    }

    public static String readFile(String fileName, String path) {
        StringBuilder builder = new StringBuilder();
        FileInputStream fis = null;

        path = path + "/" + fileName;
        path.replace("/", File.separator);

        try {
            fis = new FileInputStream(path);
            int i;
            while (((i = fis.read()) != -1)) {
                builder.append((char) i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {

                }
            }
        }
        return builder.toString();
    }

    public static void copyFile(File file) throws IOException {
        String path = file.getPath().substring(0, file.getPath().lastIndexOf("\\") + 1);

        String oldname = file.getName();
        String newName = oldname.substring(0, oldname.indexOf(".")) + "_copy" + oldname.substring(oldname.lastIndexOf("."));

        File newFile = new File(getRelativeFileDir(path + newName));
        newFile.createNewFile();
        String data = readFile(file.getName(), path);
        writeFile(newFile.getName(), path, data);

        //Files.copy(file.toPath(), newFile.toPath());
    }
}