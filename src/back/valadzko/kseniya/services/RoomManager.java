package back.valadzko.kseniya.services;

import back.valadzko.kseniya.dao.GuestDao;
import back.valadzko.kseniya.dao.RoomDao;
import back.valadzko.kseniya.exceptions.SomethingWentWrong;
import back.valadzko.kseniya.interfaces.dao.IGuestDao;
import back.valadzko.kseniya.interfaces.dao.IRoomDao;
import back.valadzko.kseniya.interfaces.managers.IRoomManager;
import back.valadzko.kseniya.interfaces.model.IGuest;
import back.valadzko.kseniya.interfaces.model.IRoom;
import back.valadzko.kseniya.interfaces.model.Status;
import back.valadzko.kseniya.utills.exceptions.ThereIsNoSuchAGuestException;
import back.valadzko.kseniya.utills.exceptions.ThereIsNoSuchARoom;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class RoomManager implements IRoomManager {
    private static IRoomManager roomManager;
    private IRoomDao roomRepository = RoomDao.getInstance();
    private IGuestDao guestRepository = GuestDao.getInstance();

    private RoomManager() {
    }

    private IGuest findNecessaryGuest(IGuest guest) {
        for (int j = 0; j < guestRepository.readAll().size(); j++) {
            if (guest.equals(guestRepository.readAll().get(j))) {
                guest = guestRepository.readAll().get(j);
                return guest;
            }
        }
        return null;
    }

    public static IRoomManager getInstance() {
        if (roomManager == null) {
            roomManager = new RoomManager();
        }
        return roomManager;
    }

    public List<IRoom> sort(Comparator<IRoom> comparator) {
        return roomRepository.sort(comparator);
    }

    public void changeStatus(IRoom changedRoom) throws SomethingWentWrong {
        update(changedRoom);
    }

    public List<IRoom> readAll() {
        return roomRepository.readAll();
    }

    public void update(IRoom room) {
        roomRepository.update(room);
    }

    public Integer getCount() {
        return roomRepository.getCount();
    }

    public int getSum(IGuest guest) throws ThereIsNoSuchAGuestException {
        IGuest ourGuest = findNecessaryGuest(guest);
        if (ourGuest != null) {
            int sum = 0;
            long milliseconds = guest.getDateOfRelease().getTime() - guest.getArrivalDate().getTime();
            int days = (int) (milliseconds / (24 * 60 * 60 * 1000));
            sum += days * guest.getRoom().getPrice();
            for (int i = 0; i < guest.getServices().size(); i++) {
                sum += days*guest.getServices().get(i).getPrice();
            }
            return sum;
        } else {
            throw new ThereIsNoSuchAGuestException();
        }
    }

    public IRoom findNecessaryRoom(IRoom room) throws ThereIsNoSuchARoom {
        boolean thereIsSuchARoom = false;
        List<IRoom> rooms = roomRepository.readAll();
        for (int i = 0; i < rooms.size(); i++) {
            if (room.equals(rooms.get(i))) {
                room = rooms.get(i);
                thereIsSuchARoom = true;
            }
        }
        if (thereIsSuchARoom) {
            return room;
        } else {
            throw new ThereIsNoSuchARoom();
        }
    }

    public void addRoom(IRoom room) {
        roomRepository.addRoom(room);
    }

    public void setGuest(Integer id, IGuest guest) throws SomethingWentWrong {
        IRoom room;
        boolean allWentSucessful = false;
        List<IRoom> rooms = roomRepository.readAll();
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getId().equals(id)) {
                room = rooms.get(i);
                room.setStatus(Status.BUSY);
                guest.setRoom(room);
                room.setGuest(guest);
                roomRepository.update(room);
                allWentSucessful = true;
            }
        }
        if (!allWentSucessful) {
            throw new SomethingWentWrong();
        }
    }

    public void evictGuest(Integer id, IGuest guest) throws SomethingWentWrong {
        IRoom room;
        boolean allWentSucessful = false;
        List<IRoom> rooms = roomRepository.readAll();
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getId().equals(id)) {
                room = rooms.get(i);
                room.setStatus(Status.FREE);
                guest.setRoom(null);
                room.setGuest(null);
                rooms.set(i, room);
                allWentSucessful = true;
            }
        }
        if (!allWentSucessful) {
            throw new SomethingWentWrong();
        }
    }

    public void changePrice(IRoom changedRoom) {
        update(changedRoom);
    }

    public List<IRoom> freeByTheDate(Date date) {
        List<IRoom> allRooms = roomRepository.readAll();
        List<IRoom> freeRooms = new ArrayList<>();
        int numberOfFreeRooms = 0;
        for(int i = 0; i<allRooms.size();i++){
            if (allRooms.get(i).getStatus() == Status.FREE || allRooms.get(i).getGuest().getDateOfRelease().before(date)) {
                freeRooms.add(allRooms.get(i));
            }
        }
        return freeRooms;
    }

    @Override
    public int getNumberOfFreeRooms() {
        List<IRoom> allRooms = roomRepository.readAll();
        int numberOfFreeRooms = 0;
        for(int i = 0; i<allRooms.size();i++){
            if(allRooms.get(i).getStatus()==Status.FREE){
                numberOfFreeRooms++;
            }
        }
        return numberOfFreeRooms;
    }

    public void save() {
        roomRepository.writeObjects();
    }

}