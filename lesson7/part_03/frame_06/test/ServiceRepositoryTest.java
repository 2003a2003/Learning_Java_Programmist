package lesson7.part_03.frame_06.test;

import lesson7.part_03.frame_06.program.Service;
import lesson7.part_03.frame_06.program.ServiceRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class ServiceRepositoryTest {

    private  ServiceRepository sr;

    @Before
    public void init() {
        sr = new ServiceRepository();
    }

    @Test
    public void checkDefaultServicesConteiner(){
        Assert.assertTrue("Default ServicesController should be null ", sr.getServicesConteiner().isEmpty());
    }

    @Test
    public void checkSetServicesConteiner(){
        List<? extends Service> servicesConteiner = new ArrayList<>();
        sr.setServicesConteiner(servicesConteiner);
        Assert.assertEquals(servicesConteiner, sr.getServicesConteiner());
    }
}