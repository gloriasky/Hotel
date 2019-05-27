package back.valadzko.kseniya.services;

import back.valadzko.kseniya.dao.GuestDao;
import back.valadzko.kseniya.interfaces.dao.IGuestDao;
import back.valadzko.kseniya.interfaces.managers.IGuestManager;
import back.valadzko.kseniya.interfaces.model.IGuest;

import java.util.Comparator;
import java.util.List;

public class GuestManager implements IGuestManager {
    private static IGuestManager guestManager;
    private IGuestDao guestRepository;

    private GuestManager() {
        this.guestRepository = GuestDao.getInstance();
    }

    public static IGuestManager getInstance() {
        if (guestManager == null) {
            guestManager = new GuestManager();
        }
        return guestManager;
    }

    public List<IGuest> sort(Comparator<IGuest> comparator) {
        return guestRepository.sort(comparator);
    }

    public List<IGuest> readAll() {
        return guestRepository.readAll();
    }

    public IGuest findGuest(IGuest guest) {
        List<IGuest> guests = guestRepository.readAll();
        IGuest necessaryGuest = null;
        for (int i = 0; i < getCount(); i++) {
            if (guest.equals(guests.get(i))) {
                necessaryGuest = guests.get(i);
                break;
            }
        }
        return necessaryGuest;
    }

    public void update(Integer guestNumber, IGuest guest) {
        guestRepository.update(guestNumber, guest);
    }

    public void addGuest(IGuest guest) {
        guestRepository.addGuest(guest);
    }

    public Integer getCount() {
        return guestRepository.getCount();
    }

    public void save() {
        guestRepository.writeObjects();
    }
}
