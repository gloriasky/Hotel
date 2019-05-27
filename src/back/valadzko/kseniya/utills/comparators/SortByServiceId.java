package back.valadzko.kseniya.utills.comparators;

import back.valadzko.kseniya.interfaces.model.IService;

import java.util.Comparator;

public class SortByServiceId implements Comparator<IService> {

    public int compare(IService service1, IService service2) {
        if ( service1.getId() <service2.getId() ) return -1;
        else if (service1.getId().equals(service2.getId())) return 0;
        else return 1;
    }
}

