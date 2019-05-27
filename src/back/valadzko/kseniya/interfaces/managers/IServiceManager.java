package back.valadzko.kseniya.interfaces.managers;

import back.valadzko.kseniya.interfaces.model.IService;
import java.util.Comparator;
import java.util.List;


public interface IServiceManager extends IManager {

    public static IServiceManager getInstance() {
        return null;
    }

    public List<IService> sort(Comparator<IService> comparator);

    public List<IService> readAll();

    public void update(IService changedService);

    public Integer getCount();

    public void changePrice(IService changedService);

    public void addService(IService service);


}
