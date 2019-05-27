package back.valadzko.kseniya.interfaces.dao;


import back.valadzko.kseniya.interfaces.model.IService;

import java.util.Comparator;
import java.util.List;

public interface IServiceDao extends GenericDao {

    public static IServiceDao getInstance() {
        return null;
    }

    public List<IService> readAll();

    public void update(IService changedService);

    public Integer getCount();

    public List<IService> sort(Comparator<IService> comparator);

    public void addService(IService service);

}
