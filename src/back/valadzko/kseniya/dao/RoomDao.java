package back.valadzko.kseniya.dao;

import back.valadzko.kseniya.interfaces.dao.IRoomDao;
import back.valadzko.kseniya.interfaces.model.IRoom;
import back.valadzko.kseniya.utills.XMLHelper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RoomDao extends AbstractDao implements IRoomDao {

    private List<IRoom> rooms;
    private static IRoomDao roomRepository;

    private RoomDao() {
        readObjects();
    }

    public static IRoomDao getInstance() {
        if (roomRepository == null) {
            roomRepository = new RoomDao();
        }
        return roomRepository;
    }

    public List<IRoom> readAll() {
        return rooms;
    }

    public void update(IRoom changedRoom) {
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getId().equals(changedRoom.getId())) {
                rooms.set(i, changedRoom);
            }
        }
    }

    public Integer getCount() {
        return rooms.size();
    }

    public List<IRoom> sort(Comparator<IRoom> comparator) {
        rooms.sort(comparator);
        return rooms;
    }

    public void addRoom(IRoom room) {
        if (rooms == null) {
            rooms = new ArrayList<>();
        }
        rooms.add(room);
    }

    public void writeObjects() {
        XMLHelper.writeToXML(this.rooms, "rooms.xml");
    }

    public void readObjects() {
        rooms = (List<IRoom>) XMLHelper.readFromXML("rooms.xml");
    }
}