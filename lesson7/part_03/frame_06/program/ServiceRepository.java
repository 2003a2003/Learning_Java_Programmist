package lesson7.part_03.frame_06.program;

import java.util.ArrayList;
import java.util.List;

public class ServiceRepository implements Service {

    private List<? extends Service> servicesConteiner;

    public ServiceRepository(){
        servicesConteiner = new ArrayList<>();
    }

    public List<? extends Service> getServicesConteiner() {
        return servicesConteiner;
    }

    public void setServicesConteiner(List<? extends Service> servicesConteiner) {
        this.servicesConteiner = servicesConteiner;
    }

}
