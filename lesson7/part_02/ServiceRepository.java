package lesson7.part_02;

import java.util.List;

public class ServiceRepository implements Service{

    private List<? extends Service> servicesConteiner;

    public ServiceRepository(){
    }

    public List<? extends Service> getServicesConteiner() {
        return servicesConteiner;
    }

    public void setServicesConteiner(List<? extends Service> servicesConteiner) {
        this.servicesConteiner = servicesConteiner;
    }

}