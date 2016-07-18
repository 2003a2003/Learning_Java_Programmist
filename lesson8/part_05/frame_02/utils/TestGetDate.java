package lesson8.part_05.frame_02.utils;

import java.io.File;
import java.util.Arrays;

/**
 * Created by otroshenko on 18.07.2016.
 */
public class TestGetDate {
    public static void main(String[] args) {
        WorkWithLogFile w = new WorkWithLogFile();
        String fileName = System.getProperty("user.dir") +
                "/src/lesson8/part_05/frame_02/log/action_log — копия.txt".replace("/", File.separator);
        File file = new File(fileName);

        TestGetDate test = new TestGetDate();

        String[][] t =  test.getOldBattleField(file, w);

        for (String[] s : t){
            System.out.println(Arrays.toString(s));
        }

    }

    public int getStartLogick(File file, WorkWithLogFile w) {
        int rez = -1;
        String temp = w.readLogFile2(file);
        int nextIndex = temp.indexOf("\n");
        while (nextIndex < temp.length()-1){
            String data = temp.substring(0, nextIndex);
            if(data.split("_")[0].equals("StartLogick")){
                return Integer.parseInt(data.split("_")[1]);
            }
            temp = temp.substring(nextIndex + 1, temp.length()-1);
            nextIndex = temp.indexOf("\n");
        }
        return rez;
    }

    public String[][] getOldBattleField(File file, WorkWithLogFile w) {
        int h = 0;
        int v = 0;

        String[][] rezult = new String[9][9];
        String temp = w.readLogFile2(file);
        int nextIndex = temp.indexOf("\n");
        while (nextIndex < temp.length()-1){
            if (h == rezult[0].length) {
                h = 0;
                v++;
            }

            if (v == rezult.length && h == rezult[0].length) {
                break;
            }

            String data = temp.substring(0, nextIndex);
            if(data.split("_")[0].equals("bf")){
                rezult[v][h] = data.split("_")[1];
            }

            temp = temp.substring(nextIndex + 1, temp.length()-1);
            nextIndex = temp.indexOf("\n");
            h++;

        }
        return rezult;

    }
}
