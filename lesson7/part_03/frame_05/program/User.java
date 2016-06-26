package lesson7.part_03.frame_05.program;

import java.awt.*;

public class User {

    private long id;
    private String login;
    private String passwd;

    private String firstName;
    private String secondName;

    private String email;
    private double balance;
    private double spent;
    private UsersGroup groups;

    public Image getImgUser() {
        return imgUser;
    }

    public void setImgUser(Image imgUser) {
        this.imgUser = imgUser;
    }

    private Image imgUser;


    public User() {
    }

    public long getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = new Passwd().md5Custom(passwd);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getSpent() {
        return spent;
    }

    public void setSpent(double spent) {
        this.spent = spent;
    }

    public UsersGroup getGroups() {
        return groups;
    }

    public void setGroups(UsersGroup groups) {
        this.groups = groups;
    }
}