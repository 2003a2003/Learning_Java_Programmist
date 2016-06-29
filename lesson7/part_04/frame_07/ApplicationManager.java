package lesson7.part_04.frame_07;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ApplicationManager<T> {
    private boolean checkServices = false;

    public void initStart(Class<T> tClass){
        if(tClass.isAnnotationPresent((Class<? extends Annotation>) Service.class)){
            checkServices = true;
            System.out.println("Class has Annotation Service");
        }else {
            System.out.println("Class has not Annotation Service");
        }
    }

}
