package back.valadzko.kseniya.utills.comparators;

import back.valadzko.kseniya.interfaces.model.IService;

import java.util.Comparator;

public class SortServiceByPrice implements Comparator<IService> {

    public int compare(IService service1, IService service2 ) {
        if ( service1.getPrice() <service2.getPrice() ) return -1;
        else if (service1.getPrice().equals(service2.getPrice())) return 0;
        else return 1;
    }
}
