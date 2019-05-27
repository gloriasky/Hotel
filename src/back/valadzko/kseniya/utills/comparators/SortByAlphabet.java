package back.valadzko.kseniya.utills.comparators;

import back.valadzko.kseniya.interfaces.model.IService;

import java.util.Comparator;

public class SortByAlphabet implements Comparator<IService> {
    @Override
    public int compare(IService service1, IService service2) {
        if (service1.getName().compareToIgnoreCase(service2.getName()) == -1) {
            return -1;
        } else if (service1.getName().compareToIgnoreCase(service2.getName()) == 0) return 0;
        else return 1;
    }
}
