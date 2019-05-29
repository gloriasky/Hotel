package back.valadzko.kseniya.interfaces.dao;

import back.valadzko.kseniya.interfaces.model.IRoom;

import java.util.Comparator;
import java.util.List;

public interface IRoomDao extends GenericDao {

    static IRoomDao getInstance() {
        return null;
    }

    List<IRoom> readAll();

    void update(IRoom changedRoom);

    Integer getCount();

    List<IRoom> sort(Comparator<IRoom> comparator);

    void addRoom(IRoom room);
}
