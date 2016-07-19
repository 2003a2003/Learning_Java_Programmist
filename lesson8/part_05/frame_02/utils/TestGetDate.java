package lesson8.part_05.frame_02.utils;

import lesson8.part_05.frame_02.bf.BattleField;
import lesson8.part_05.frame_02.bf.tanks.BT7;
import lesson8.part_05.frame_02.bf.tanks.T34;
import lesson8.part_05.frame_02.bf.tanks.Tiger;

import java.io.File;
import java.util.Arrays;

public class TestGetDate {
    public static void main(String[] args) {
        WorkWithLogFile w = new WorkWithLogFile();
        String fileName = System.getProperty("user.dir") +
                "/src/lesson8/part_05/frame_02/log/action_log.txt".replace("/", File.separator);
        File file = new File(fileName);

        TestGetDate test = new TestGetDate();
        BattleField bf = new BattleField();
        BT7 bt7 = new BT7(bf);
        T34 t43 = new T34(bf);
        Tiger tiger = new Tiger(bf);

        System.out.println(Arrays.toString(w.returnActionList(file, bt7).toArray()));
        System.out.println(Arrays.toString(w.returnActionList(file, t43).toArray()));
        System.out.println(Arrays.toString(w.returnActionList(file, tiger).toArray()));
    }

    public int getStartLogick(File file, WorkWithLogFile w) {
        int rez = -1;
        String temp = w.readLogFile(file);
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
        String temp = w.readLogFile(file);
        int nextIndex = temp.indexOf("\n");
        while (nextIndex < temp.length()-1){
            if (h >= rezult[0].length) {
                h = 0;
                v++;
            }
            if (v == rezult.length || h == rezult[0].length) {
                break;
            }

            String data = temp.substring(0, nextIndex);
            if(data.split("_")[0].equals("bf")){
                rezult[v][h] = data.split("_")[1];
            }

            temp = temp.substring(nextIndex + 1, temp.length());
            nextIndex = temp.indexOf("\n");
            h++;

        }
        return rezult;

    }
}
