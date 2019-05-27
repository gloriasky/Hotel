package back.valadzko.kseniya.facade;

import back.valadzko.kseniya.exceptions.SomethingWentWrong;
import back.valadzko.kseniya.interfaces.managers.IGuestManager;
import back.valadzko.kseniya.interfaces.managers.IRoomManager;
import back.valadzko.kseniya.interfaces.managers.IServiceManager;
import back.valadzko.kseniya.interfaces.model.IGuest;
import back.valadzko.kseniya.interfaces.model.IRoom;
import back.valadzko.kseniya.interfaces.model.IService;
import back.valadzko.kseniya.services.GuestManager;
import back.valadzko.kseniya.services.RoomManager;
import back.valadzko.kseniya.services.ServiceManager;
import org.apache.log4j.Logger;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Hotel {

    private final Logger logger = Logger.getLogger(Hotel.class);
    private IRoomManager roomManager;
    private IGuestManager guestManager;
    private IServiceManager serviceManager;
    private static Hotel hotel;

    private Hotel(){
        start();
    }

    public static Hotel getInstance(){
        if(hotel==null){
            hotel = new Hotel();
        }
        return hotel;
    }
    private void start(){
        try {
            roomManager = RoomManager.getInstance();
            guestManager = GuestManager.getInstance();
            serviceManager = ServiceManager.getInstance();
        }catch (Exception ex) {
            logger.error(ex);
        }
    }
    public boolean changeServicePrice(IService service){
       boolean isDone = true;
        try {
            serviceManager.changePrice(service);
        }catch (Exception ex){
            logger.error(ex);
            isDone = false;
        }
        return isDone;

    }
    public boolean changeRoomPrice(IRoom room){
        boolean isDone = true;
        try {
            roomManager.changePrice(room);
        }catch (Exception ex){
            logger.error(ex);
            isDone = false;
        }
        return isDone;
    }
    public boolean changeStatus(IRoom room){
        boolean isDone = true;
        try {
            roomManager.changeStatus(room);
        }catch (Exception ex){
            logger.error(ex);
            isDone = false;
        }
        return isDone;
     }
    public boolean addRoom(IRoom room){
        boolean isDone = true;
        try {
            roomManager.addRoom(room);
        }catch(Exception ex){
            logger.error(ex);
            isDone = false;
        }
        return isDone;
    }
    public boolean addGuest(IGuest guest){
        boolean isDone = true;
        try {
           guestManager.addGuest(guest);
        }catch(Exception ex){
            logger.error(ex);
            isDone = false;
        }
        return isDone;
    }
    public boolean addService(IService service){
        boolean isDone = true;
        try {
            serviceManager.addService(service);
        }catch(Exception ex){
            logger.error(ex);
            isDone = false;
        }
        return isDone;
    }
    public boolean setGuest(int roomNumber, IGuest guest){
        boolean isDone = true;
        try {
            roomManager.setGuest(roomNumber, guest);
        } catch (Exception ex) {
            logger.error(ex);
            isDone = false;
        }
        return isDone;
    }
    public boolean evictGuest(int roomNumber, IGuest guest){
        boolean isDone = true;
        try {
            roomManager.evictGuest(roomNumber, guest);
        }catch (Exception ex){
            logger.error(ex);
            isDone = false;
        }
        return isDone;
    }
    public List<IService> sortServices(Comparator<IService> comparator){
        return serviceManager.sort(comparator);
    }

    public List<IRoom> sortRooms(Comparator<IRoom> comparator){
        return roomManager.sort(comparator);
    }
    public List<IGuest> sortGuests(Comparator<IGuest> comparator) throws SomethingWentWrong {
        return guestManager.sort(comparator);
    }
    public List<IRoom> freeByTheDate(Date date){
        try {
            return roomManager.freeByTheDate(date);
        }catch (Exception ex){
            logger.error(ex);
            return null;
        }
    }
    public Integer getSum(IGuest guest){
        try {
            return roomManager.getSum(guest);
        }catch (Exception ex){
            logger.error(ex);
            return null;
        }
    }
    public Integer numberOfGuests(){
        try {
            return guestManager.getCount();
        }catch (Exception ex){
            logger.error(ex);
            return null;
        }
    }
    public List<IRoom> getRooms() {
        try {
            return roomManager.readAll();
        } catch (Exception ex) {
            logger.error(ex);
            return null;
        }
    }
    public int numberOfFreeRooms(){
        try {
            return roomManager.getNumberOfFreeRooms();
        }catch (Exception ex){
            logger.error(ex);
            return -1;
        }
    }
    public List<IGuest> getGuests(){
        try {
            return guestManager.readAll();
        }catch(Exception ex){
            logger.error(ex);
            return null;

        }
    }


    public List<IService> getServices(){
        try {
            return serviceManager.readAll();
        }catch (Exception ex){
            logger.error(ex);
            return null;
        }
    }
    public boolean end(){
        try {
            guestManager.save();
            roomManager.save();
            serviceManager.save();
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

}
