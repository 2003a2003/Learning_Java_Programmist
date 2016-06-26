package lesson7.part_03.frame_05.program;

import javax.swing.*;
import java.util.List;

public class Authorization {

    private boolean login = false;
    private boolean passwd = false;
    private Buffer buffer;
    private List<User> users;
    private int userID;

    public Authorization(String login, String passwd, Buffer buffer) {
        this.buffer = buffer;
        users = buffer.getUsers();
        String passwdMD5 = new Passwd().md5Custom(passwd);
        this.login = verifyUser(login);
        this.passwd = verifyPassword(passwdMD5);

        checkStateLogin();

    }

    private void checkStateLogin() {
        checkLogin();
        checkPassword();
    }

    private void checkPassword() {
        if(passwd ){
            System.out.println("Password is corect");
        }else {
            System.out.println("Password not corect");
        }
    }

    private void checkLogin() {
        if(login){
            System.out.println(" User is corect ");
        }else {
            System.out.println(" User is not correct ");
        }
    }

    private boolean verifyUser(String user) {
        List<User> users = buffer.getUsers();
        long id = 0;
        for (User u : users) {
            if (u.getLogin().equals(user)) {
                userID = (int) id;
                login = true;
            }
            id++;
        }
        return login;
    }

    private boolean verifyPassword(String passwdMD5) {
        if (users.get(userID).getPasswd().equals(passwdMD5)) {
            passwd = true;
        }
        return passwd;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean logim) {
        this.login = logim;
    }

    public boolean isPasswd() {
        return passwd;
    }

    public void setPasswd(boolean passwd) {
        this.passwd = passwd;
    }
}