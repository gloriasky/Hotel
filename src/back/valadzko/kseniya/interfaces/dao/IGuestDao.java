package back.valadzko.kseniya.interfaces.dao;

import back.valadzko.kseniya.interfaces.model.IGuest;

import java.util.Comparator;
import java.util.List;

public interface IGuestDao extends GenericDao {

    static IGuestDao getInstance() {
        return null;
    }

    List<IGuest> readAll();

    void update(IGuest guest);

    Integer getCount();

    void addGuest(IGuest guest);

    List<IGuest> sort(Comparator<IGuest> comparator);
}
