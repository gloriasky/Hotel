package back.valadzko.kseniya.facade;

import back.valadzko.kseniya.utills.exceptions.SomethingWentWrong;
import back.valadzko.kseniya.interfaces.managers.IGuestManager;
import back.valadzko.kseniya.interfaces.managers.IRoomManager;
import back.valadzko.kseniya.interfaces.managers.IServiceManager;
import back.valadzko.kseniya.interfaces.model.IGuest;
import back.valadzko.kseniya.interfaces.model.IRoom;
import back.valadzko.kseniya.interfaces.model.IService;
import back.valadzko.kseniya.services.GuestManager;
import back.valadzko.kseniya.services.RoomManager;
import back.valadzko.kseniya.services.ServiceManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.List;

public class Hotel {

    private final Logger logger = LogManager.getLogger(Hotel.class.getName());
    private IRoomManager roomManager;
    private IGuestManager guestManager;
    private IServiceManager serviceManager;
    private static Hotel hotel;

    private Hotel() {
        start();
    }

    public static Hotel getInstance() {
        if (hotel == null) {
            hotel = new Hotel();
        }
        return hotel;
    }

    private void start() {
        try {
            logger.info("Initializing the system...");
            roomManager = RoomManager.getInstance();
            guestManager = GuestManager.getInstance();
            serviceManager = ServiceManager.getInstance();
            logger.info("Done!");
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    public void updateService(IService service) {
        try {
            logger.info("Updating service...");
            serviceManager.update(service);
            logger.info("Done!");
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    public void updateRoom(IRoom room) {
        try {
            logger.info("Updating room...");
            roomManager.update(room);
            logger.info("Done!");
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    public void updateGuest(IGuest guest) {
        try {
            logger.info("Updating guest...");
            guestManager.update(guest);
            logger.info("Done!");
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    public void addRoom(IRoom room) {
        try {
            logger.info("Adding room...");
            roomManager.addRoom(room);
            logger.info("Done!");
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    public void addGuest(IGuest guest) {
        try {
            logger.info("Adding guest...");
            guestManager.addGuest(guest);
            logger.info("Done!");
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    public void addService(IService service) {
        try {
            logger.info("Adding service...");
            serviceManager.addService(service);
            logger.info("Done!");
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    public void setGuest(int roomNumber, IGuest guest) {
        try {
            logger.info("setting guest...");
            roomManager.setGuest(roomNumber, guest);
            logger.info("Done!");
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    public void evictGuest(int roomNumber, IGuest guest) {
        try {
            logger.info("evicting guest...");
            roomManager.evictGuest(roomNumber, guest);
            logger.info("Done!");
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    public List<IService> sortServices(Comparator<IService> comparator) {
        return serviceManager.sort(comparator);
    }

    public List<IRoom> sortRooms(Comparator<IRoom> comparator) {
        return roomManager.sort(comparator);
    }

    public List<IGuest> sortGuests(Comparator<IGuest> comparator){
        return guestManager.sort(comparator);
    }

    public Integer getSum(IGuest guest) {
        try {
            return roomManager.getSum(guest);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return null;
        }
    }

    public Integer numberOfGuests() {
        try {
            return guestManager.getCount();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return null;
        }
    }

    public List<IRoom> getRooms() {
        try {
            return roomManager.readAll();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return null;
        }
    }

    public List<IRoom> getFreeRooms() {
        try {
            return roomManager.getFreeRooms();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return null;
        }
    }

    public List<IGuest> getGuests() {
        try {
            return guestManager.readAll();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return null;

        }
    }

    public List<IGuest> getCurrentGuests() {
        try {
            return guestManager.getCurrentGuests();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return null;
        }
    }

    public List<IService> getServices() {
        try {
            return serviceManager.readAll();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return null;
        }
    }

    public void end() {
        try {
            logger.info("Saving the data...");
            guestManager.save();
            roomManager.save();
            serviceManager.save();
            logger.info("Done");
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

}
