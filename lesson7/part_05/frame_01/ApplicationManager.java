package lesson7.part_05.frame_01;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ApplicationManager<T> {
    private boolean checkServices;
    private boolean startService = false;

    public void initStart(Class<T> tClass){
        if(tClass.isAnnotationPresent(Service.class)){
            checkServices = true;
            System.out.println("Class has Annotation Service");
        }else {
            checkServices = false;
            System.out.println("Class has not Annotation Service");
        }
    }

    public void metodHaveAnotation(Class<T> tClass){
        Method[] methods = tClass.getMethods();
        for(Method md: methods){
            if(md.isAnnotationPresent(InitService.class));
            System.out.println("This metod: " + md.getName() + " has anotation");
            startService = true;
        }
    }

    public T getService(Class<T> tClass) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        for (Annotation ann : tClass.getAnnotations()) {
            if (ann instanceof Service) {
                for (Method method : tClass.getClass().getMethods()) {
                    for (Annotation methodAnn : method.getAnnotations()) {
                        if (methodAnn.annotationType().getSimpleName().equals(InitService.class.getSimpleName())) {
                            T service = tClass.newInstance();
                            method.invoke(service);
                            return service;
                        }
                    }
                }
            }
        }
        return null;
    }

    public boolean isCheckServices() {
        return checkServices;
    }

    public void setCheckServices(boolean checkServices) {
        this.checkServices = checkServices;
    }

    public boolean isStartService() {
        return startService;
    }

    public void setStartService(boolean startService) {
        this.startService = startService;
    }
}