package back.valadzko.kseniya.interfaces.dao;

import back.valadzko.kseniya.interfaces.model.IGuest;

import java.util.Comparator;
import java.util.List;

public interface IGuestDao extends GenericDao {

    public static IGuestDao getInstance() {
        return null;
    }

    public List<IGuest> readAll();

    public void update(Integer guestNumber, Object guest);

    public Integer getCount();

    public void addGuest(IGuest guest);

    public List<IGuest> sort(Comparator<IGuest> comparator);
}
