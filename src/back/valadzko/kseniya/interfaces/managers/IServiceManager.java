package back.valadzko.kseniya.interfaces.managers;

import back.valadzko.kseniya.interfaces.model.IService;
import java.util.Comparator;
import java.util.List;


public interface IServiceManager extends IManager {

    static IServiceManager getInstance() {
        return null;
    }

    List<IService> sort(Comparator<IService> comparator);

    List<IService> readAll();

    void update(IService changedService);

    Integer getCount();

    void addService(IService service);


}
