package lesson7.part_05.frame_04.test;

import lesson7.part_05.frame_04.Customer;
import lesson7.part_05.frame_04.Reflection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lesson7.part_05.frame_04.Reflection.*;

@RunWith(JUnit4.class)
public class ReflectionTest {

    private Reflection reflection;
    private Customer customer;
    private List<Object> list;
    Map<String, Object> map;
    private String name;
    private String phoneNumber;

    @Before
    public void init() throws NoSuchFieldException, IllegalAccessException {
        reflection = new Reflection();
        list = new ArrayList<>();
        customer = new Customer();

        list.add("Alex");
        list.add("5585856565");

        name = "Alex";
        phoneNumber = "0653359565";

        map = new HashMap<>();
        map.put("name", name);
        map.put("phoneNumber", phoneNumber);
        setPrivates(customer, map);
    }

    @Test
    public void initClassTest() throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {
        Assert.assertNotNull(initClass(customer.getClass(), list));
    }

    @Test
    public void setPrivateTest() {
        Assert.assertEquals(name, customer.getName());
        Assert.assertEquals(phoneNumber, customer.getPhoneNumber());
    }
}