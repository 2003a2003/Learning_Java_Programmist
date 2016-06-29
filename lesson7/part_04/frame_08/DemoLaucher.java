package lesson7.part_04.frame_08;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class DemoLaucher {
    public static void main(String[] args) throws IllegalAccessException,
            InvocationTargetException, InstantiationException, NoSuchMethodException, NoSuchFieldException {
        Customer customer = new Customer();

        Map<String, Object> map = new HashMap<>();
        map.put("name", "Alex");
        map.put("phoneNumber", "061558585");

        Reflection.setPrivates(customer, map);
        System.out.println("Customer Name: " + customer.getName() + " , phone: " + customer.getPhoneNumber());

        ApplicationManager apm = new ApplicationManager();

        apm.initStart(customer.getClass());

    }

}