package lesson7.part_04.frame_06;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class PrintClassInfo {

    public static void printClassinfo(Object o){
        System.out.println("Print Classinfo:");
        System.out.println("Class simple name: " + o.getClass().getSimpleName());
        System.out.println("Class paretn simple name: " + o.getClass().getSuperclass().getSimpleName());
    }

    public static void printClassMetod(Object o){
        System.out.println("Print Class Constructors:");
        for (Object metod : o.getClass().getConstructors()){
            System.out.println(metod);
        }

        System.out.println("Print Class Metods:");
        for (Object metod : o.getClass().getMethods()){
            System.out.println(metod);
        }
    }

    public static void printClassFields(Object o){
        System.out.println("Print Class Declared Fields:");
        for (Object declareField : o.getClass().getDeclaredFields()){
            System.out.println(declareField);
        }
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

    public static void setPrivates(Object o, Map<String, Object> map) throws NoSuchFieldException,
            IllegalAccessException {

        for (String str : map.keySet()) {
            Field field = o.getClass().getDeclaredField(str);
            field.setAccessible(true);
            field.set(o, map.get(str));
        }
    }
}