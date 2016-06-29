package lesson7.part_04.frame_06;

import java.lang.reflect.Field;
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

        setPrivates(customer, map);
        System.out.println("Customer Name: " + customer.getName() + " , phone: " + customer.getPhoneNumber());
    }


    public static void setPrivates(Object o, Map<String, Object> map) throws NoSuchFieldException,
            IllegalAccessException {

        for (String str : map.keySet()) {
            Field field = o.getClass().getDeclaredField(str);
            field.setAccessible(true);
            field.set(o, map.get(str));
        }
    }
}