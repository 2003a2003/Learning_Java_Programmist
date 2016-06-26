package lesson7.part_03.frame_05.program;

import java.util.List;

public class DemoLauncher {

    public static void main(String[] args) {
        Buffer base = new Buffer();
        List<User> users = base.getUsers();
        createUsers(users);
        AutorizationGUI auturizGUI = new AutorizationGUI(base);
    }

    public static void createUsers(List<User> users){
        User usr1 = new User();
        User usr2 = new User();
        User usr3 = new User();

        usr1.setLogin("Alex");
        usr1.setPasswd("one");
        users.add(usr1);

        usr2.setLogin("Oleg");
        usr2.setPasswd("Two");
        users.add(usr2);

        usr3.setLogin("Igor");
        usr3.setPasswd("one");
        users.add(usr3);
    }
}