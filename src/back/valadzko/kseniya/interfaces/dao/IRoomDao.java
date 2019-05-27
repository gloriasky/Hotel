package back.valadzko.kseniya.interfaces.dao;

import back.valadzko.kseniya.interfaces.model.IRoom;

import java.util.Comparator;
import java.util.List;

public interface IRoomDao extends GenericDao {

    public static IRoomDao getInstance() {
        return null;
    }

    public List<IRoom> readAll();

    public void update(IRoom changedRoom);

    public Integer getCount();

    public List<IRoom> sort(Comparator<IRoom> comparator);

    public void addRoom(IRoom room);
}
