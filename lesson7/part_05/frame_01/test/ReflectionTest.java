import lesson7.part_05.frame_01.Customer;
import lesson7.part_05.frame_01.Reflection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class ReflectionTest {

    private Reflection reflection;
    private Customer customer;
    private List<Object> list;

    @Before
    public void init(){
        reflection = new Reflection();
        list = new ArrayList<>();
        customer = new Customer();

        list.add("Alex");
        list.add("5585856565");
    }

    @Test
    public void initClassTest() throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, IllegalAccessException {

        Assert.assertNotNull(Reflection.initClass(customer.getClass(), list ));


    }



}
