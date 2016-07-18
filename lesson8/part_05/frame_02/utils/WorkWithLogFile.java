package lesson8.part_05.frame_02.utils;

import lesson8.part_05.frame_02.Direction;
import lesson8.part_05.frame_02.bf.BattleField;
import lesson8.part_05.frame_02.bf.tanks.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
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

    public void addDataToEndFile(File file, String data) {
        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsolutePath(), true))
        ) {
            bw.newLine();
            bw.append(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readLogFile(File file) {
        StringBuilder builder = new StringBuilder();
        String read = "";
        try (
                BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()))
        ) {
            String line;
            while((line = br.readLine()) != null){
                builder.append(line);
                builder.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public void addBattleFieldToFileBF(File file, BattleField bf) throws IOException {
        for (int v = 0; v < bf.getBfHeight() / bf.getSIZE_ONE_QUADRANT(); v++) {
            for (int h = 0; h < bf.getBfWidth() / bf.getSIZE_ONE_QUADRANT(); h++) {
                addDataToEndFile(file, ("bf_" + bf.getBattleFieldTemplate()[v][h]));
            }
        }
    }

    public String[][] returnOldBattleField(File file, int bfv, int bfh) {

        String[][] temp = new String[bfv][bfh];

        boolean stop = true;
        int v = 0;
        int h = 0;

        try (
                FileInputStream fis = new FileInputStream(file.getAbsolutePath());
                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr, 256)
        ) {
            String str;

            while ((str = br.readLine()) != null && stop) {
                if (str.split("_")[0].equals("bf")) {
                    if (h == bfh) {
                        h = 0;
                        v++;
                    }

                    if (v == bfv) {
                        stop = false;
                        continue;
                    }
                    temp[v][h] = str.split("_")[1];
                    h++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temp;
    }

    public ArrayList<Object> returnActionList(File file, AbstractTank tank) {
        String identifikator = "";
        if (tank instanceof BT7) {
            identifikator = "BT7";
        } else if (tank instanceof Tiger) {
            identifikator = "Tiger";
        } else if (tank instanceof T34) {
            identifikator = "T34";
        }

        ArrayList<Object> action = new ArrayList<>();

        try (
                FileInputStream fis = new FileInputStream(file.getAbsolutePath());
                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr, 256)
        ) {
            String str;

            while ((str = br.readLine()) != null) {
                if (str.split("_")[0].equals(identifikator)) {
                    if (str.split("_")[1].equals(Action.MOVE.toString())) {
                        action.add(Action.MOVE);
                    } else if (str.split("_")[1].equals(Direction.RIGHT.toString())) {
                        action.add(Direction.RIGHT);
                    } else if (str.split("_")[1].equals(Direction.LEFT.toString())) {
                        action.add(Direction.LEFT);
                    } else if (str.split("_")[1].equals(Direction.DOWN.toString())) {
                        action.add(Direction.DOWN);
                    } else if (str.split("_")[1].equals(Direction.UP.toString())) {
                        action.add(Direction.UP);
                    } else if (str.split("_")[1].equals(Action.FIRE.toString())) {
                        action.add(Action.FIRE);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return action;
    }

    public String getCoordTank(File file, String search) {
        String temp = readLogFile(file);
        String res = "";
        boolean searches = true;
        int startIndex = 0;

        while (searches) {

            if (startIndex == temp.length()) {
                break;
            }

            String coord = temp.substring(startIndex, temp.indexOf("\n"));

            if (coord.split(":").equals(search)) {

            }
            startIndex = temp.indexOf("\n") + 1;
        }

        return res;
    }

    public int getStartLogick(File file) {
        int rez = -1;
        String temp = readLogFile(file);
        int nextIndex = temp.indexOf("\n");
        while (nextIndex < temp.length() - 1) {
            String data = temp.substring(0, nextIndex);
            if (data.split("_")[0].equals("StartLogick")) {
                return Integer.parseInt(data.split("_")[1]);
            }
            temp = temp.substring(nextIndex + 1, temp.length() - 1);
            nextIndex = temp.indexOf("\n");
        }

        return rez;
    }

    public void writeLogFile(File file, String data) {
        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsolutePath()))
        ) {

            bw.append(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //get - set
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
