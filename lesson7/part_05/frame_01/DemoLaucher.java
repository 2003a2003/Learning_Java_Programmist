package lesson7.part_05.frame_01;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DemoLaucher {
    public static void main(String[] args) throws IllegalAccessException,
            InvocationTargetException, InstantiationException, NoSuchMethodException, NoSuchFieldException {
        Customer customer = new Customer();

        List<Object> list = new ArrayList<>();
        list.add("Alex");
        list.add("5585856565");

        customer = Reflection.initClass(customer.getClass(), list);
        System.out.println("Customer Name: " + customer.getName() + " , phone: " + customer.getPhoneNumber());

        ApplicationManager apm = new ApplicationManager();

        apm.initStart(customer.getClass());

    }

}