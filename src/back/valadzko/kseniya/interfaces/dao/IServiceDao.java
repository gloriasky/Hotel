package back.valadzko.kseniya.interfaces.dao;


import back.valadzko.kseniya.interfaces.model.IService;

import java.util.Comparator;
import java.util.List;

public interface IServiceDao extends GenericDao {

    static IServiceDao getInstance() {
        return null;
    }

    List<IService> readAll();

    void update(IService changedService);

    Integer getCount();

    List<IService> sort(Comparator<IService> comparator);

    void addService(IService service);

}
