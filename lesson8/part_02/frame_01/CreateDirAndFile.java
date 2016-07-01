package lesson8.part_02.frame_01;

import java.io.File;
import java.io.IOException;

public class CreateDirAndFile {

    public static void main(String[] args) throws IOException {
        String dirName = "first directory";

        String part = "src/lesson8/part_02/frame_01/";
        String directoryPart = getRelativeFileDir(part + dirName);

        createDir(directoryPart, dirName);

        String fileName = "test.txt";
        String filePart = part + "\\" + dirName;

        createFile(filePart, fileName);

        System.out.println();
        printDirectoryTree("src/lesson8");
    }

    public static void createDir(String part, String dirName){
        File f = new File(part);
        if(f.isDirectory()){
            System.out.println("Create directory is false, because the directory with name: " + f.getAbsolutePath() + " exists !!!");
        }else {
            System.out.println("Create directory with name: " + f.getAbsolutePath() + " is true!!!");
            f.mkdir();
        }
    }

    public static void createFile(String path, String fileName) throws IOException {
        File f = new File(path + "\\" + fileName);

        if(f.exists()){
            System.out.println("Create file is false, because the file with name: " + f.getAbsolutePath() + " exists !!!");
        }else {
            f.createNewFile();
            System.out.println("Create file with name: " + f.getAbsolutePath() + " is true!!!");
        }
    }

    public static void printDirectoryTree(String s){
        File file = new File(s);
        if(!file.isDirectory()){
            return;
        }

        String[] list = file.list();
        for (int i = 0; i < list.length ; i++) {
            File f = new File(s + File.separator + list[i]);
            if(f.isFile()){
//                System.out.println(s + File.separator + list[i]);
                System.out.println(f.getAbsolutePath());
            }else{
                printDirectoryTree(s + File.separator + list[i]);
            }
        }
    }

    public static String getRelativeFileDir(String path){
        return path.replace("/", File.separator);
    }
}