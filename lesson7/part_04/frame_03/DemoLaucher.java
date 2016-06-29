package lesson7.part_04.frame_03;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class DemoLaucher {
    public static void main(String[] args) throws IllegalAccessException,
            InvocationTargetException, InstantiationException {
        Customer customer = new Customer();

//        PrintClassInfo.printClassinfo(customer);
//        PrintClassInfo.printClassMetod(customer);
//        PrintClassInfo.printClassFields(customer);

        Map<String, Object> map = new HashMap<>();
        map.put("name", "Alex");
        map.put("phoneNumber", "061558585");

        customer = initClass(customer.getClass(), map);

        System.out.println("Customer Name: " + customer.getName() + " , phone: " + customer.getPhoneNumber());

    }

    public static <T> T initClass(Class<T> c, Map<String, Object> map) throws IllegalAccessException,
            InstantiationException, InvocationTargetException {

        T rezultat = c.newInstance();
        Method[] methods = c.getMethods();

        for (Method m : methods) {
            for (String str : map.keySet()) {
                if (m.getName().equalsIgnoreCase("set" + str)) {
                    m.invoke(rezultat, map.get(str));
                }
            }
        }

        return rezultat;
    }
}