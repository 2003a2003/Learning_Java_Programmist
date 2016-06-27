package lesson7.part_03.frame_05.test;

import lesson7.part_03.frame_05.program.Passwd;
import lesson7.part_03.frame_05.program.User;
import lesson7.part_03.frame_05.program.UsersGroup;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

import java.security.cert.TrustAnchor;

@RunWith(JUnit4.class)
public class DefaultCreateUserTests {

    private User user;
    private Passwd psw;

    @Before
    public void init() {
        user = new User();
        psw = new Passwd();
    }

    @Test
    public void checkLoginDefaultValue() {
        assertNull("Default login of user shouls be null", user.getLogin());
    }

    @Test
    public void checkPasswdDefaultValue() {
        assertNull("Default Passwd of user shouls be null", user.getPasswd());
    }

    @Test
    public void checkFirstNameDefaultValue() {
        assertNull("Default First Name of user shouls be null", user.getFirstName());
    }

    @Test
    public void checkSecondNameDefaultValue() {
        assertNull("Default Srcond Name of user shouls be null", user.getSecondName());
    }

    @Test
    public void checkEmailDefaultValue() {
        assertNull("Default Email of user shouls be null", user.getEmail());
    }

    @Test
    public void checkBalansDefaultValue() {
        assertTrue("Default start balans of user shouls be 0", user.getBalance() == 0.0);
    }

    @Test
    public void checkSpentDefaultValue() {
        assertTrue("Default start spent of user shouls be 0", user.getSpent() == 0.0);
    }

    @Test
    public void checkPGroupDefaultValue() {
        assertNull("Default Group of user shouls be null", user.getGroups());
    }

    @Test
    public void checkSetLogin(){
        String login = "Alex";
        user.setLogin(login);
        assertEquals(login, user.getLogin());
    }

    @Test
    public void checkSetPasswd(){
        String password = "one";
        user.setPasswd(password);
        assertEquals(psw.md5Custom(password), user.getPasswd());
    }

    @Test
    public void checkSetFirstName(){
        String firstName = "Aleksandr";
        user.setFirstName(firstName);
        assertEquals(firstName, user.getFirstName());
    }

    @Test
    public void checkSetSecondName(){
        String secondName = "Otroshko";
        user.setSecondName(secondName);
        assertEquals(secondName, user.getSecondName());
    }

    @Test
    public void checkSetEmail(){
        String email = "2020@ukr.net";
        user.setEmail(email);
        assertEquals(email, user.getEmail());
    }

    @Test
    public void checkUpdateBalance(){
        double firstBalance = user.getBalance();
        double balance = 50.20;
        user.updateBalance(balance);
        assertTrue(user.getBalance() == firstBalance + balance);
    }

    @Test
    public void checkUpdateSpent(){
        double firstSpent = user.getBalance();
        double addSpent = 50.20;
        user.updateSpent(addSpent);
        assertTrue(user.getSpent() == firstSpent + addSpent);
    }

    @Test
    public void checkSetGroup(){
        UsersGroup group = UsersGroup.USER;
        user.setGroups(group);
        assertEquals(group, user.getGroups());
    }
}
