package back.valadzko.kseniya.interfaces.managers;

import back.valadzko.kseniya.exceptions.SomethingWentWrong;
import back.valadzko.kseniya.interfaces.model.IGuest;
import back.valadzko.kseniya.interfaces.model.IRoom;
import back.valadzko.kseniya.utills.exceptions.ThereIsNoSuchAGuestException;
import back.valadzko.kseniya.utills.exceptions.ThereIsNoSuchARoom;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

public interface IRoomManager extends IManager {

    public static IRoomManager getInstance() {
        return null;
    }

    public List<IRoom> sort(Comparator<IRoom> comparator);

    public void changeStatus(IRoom changedRoom) throws SomethingWentWrong;

    public List<IRoom> readAll();

    public void update(IRoom room);

    public Integer getCount();

    public int getSum(IGuest guest) throws ThereIsNoSuchAGuestException;

    public IRoom findNecessaryRoom(IRoom room) throws ThereIsNoSuchARoom;

    public void addRoom(IRoom room);

    public void setGuest(Integer id, IGuest guest) throws SomethingWentWrong;

    public void evictGuest(Integer id, IGuest guest) throws SomethingWentWrong;

    public void changePrice(IRoom changedRoom);

    public int getNumberOfFreeRooms();

    public List<IRoom> freeByTheDate(Date date);
}
