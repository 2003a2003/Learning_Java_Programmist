package lesson7.part_04.frame_04;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class DemoLaucher {
    public static void main(String[] args) throws IllegalAccessException,
            InvocationTargetException, InstantiationException, NoSuchMethodException {
        Customer customer = new Customer();

//        PrintClassInfo.printClassinfo(customer);
//        PrintClassInfo.printClassMetod(customer);
//        PrintClassInfo.printClassFields(customer);

//        System.out.println("*****************************");
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "Alex");
//        map.put("phoneNumber", "061558585");
//
//        customer = initClass(customer.getClass(), map);
//        System.out.println("Customer Name: " + customer.getName() + " , phone: " + customer.getPhoneNumber());

        List<Object> list = new ArrayList<>();
        list.add("Alex");
        list.add("5585856565");

        customer = initClass(customer.getClass(), list);
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

    public static <T> T initClass(Class<T> c, List<Object> list) throws IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class[] classes = new Class[list.size()];
        for (int i = 0; i < classes.length; i++){
            classes[i] = list.get(i).getClass();
        }

        Constructor constr = c.getConstructor(classes);
        T rezult = (T) constr.newInstance(list.toArray());

        return rezult;
    }
}