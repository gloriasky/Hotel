package back.valadzko.kseniya.interfaces.managers;

import back.valadzko.kseniya.utills.exceptions.SomethingWentWrong;
import back.valadzko.kseniya.interfaces.model.IGuest;
import back.valadzko.kseniya.interfaces.model.IRoom;
import back.valadzko.kseniya.utills.exceptions.ThereIsNoSuchAGuestException;
import back.valadzko.kseniya.utills.exceptions.ThereIsNoSuchARoom;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

public interface IRoomManager extends IManager {

    static IRoomManager getInstance() {
        return null;
    }

    List<IRoom> sort(Comparator<IRoom> comparator);

    List<IRoom> readAll();

    void update(IRoom room);

    Integer getCount();

    int getSum(IGuest guest) throws ThereIsNoSuchAGuestException;

    void addRoom(IRoom room);

    void setGuest(Integer id, IGuest guest) throws SomethingWentWrong;

    void evictGuest(Integer id, IGuest guest) throws SomethingWentWrong;

    List<IRoom> getFreeRooms();

}
