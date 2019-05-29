package back.valadzko.kseniya.dao;

import back.valadzko.kseniya.interfaces.dao.IGuestDao;
import back.valadzko.kseniya.interfaces.model.IGuest;
import back.valadzko.kseniya.model.Guest;
import back.valadzko.kseniya.utills.XMLHelper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GuestDao extends AbstractDao implements IGuestDao {
    private List<IGuest> guests;
    private static IGuestDao guestRepository;
    private static Integer lastId = 0;

    private GuestDao() {
        readObjects();
    }

    public static IGuestDao getInstance() {
        if (guestRepository == null) {
            guestRepository = new GuestDao();
        }
        return guestRepository;
    }

    public List<IGuest> readAll() {
        return guests;
    }

    public void update(IGuest guest) {
        for (int i = 0; i < guests.size(); i++) {
            if (guest.getId().equals(guests.get(i).getId())) {
                guests.set(i, guest);
            }
        }
    }

    public Integer getCount() {
        return guests.size();
    }

    public void addGuest(IGuest guest) {
        if (guests == null) {
            guests = new ArrayList<>();
        }
        guests.add(guest);
    }

    public List<IGuest> sort(Comparator<IGuest> comparator) {
        guests.sort(comparator);
        return guests;
    }

    public void writeObjects() {
        XMLHelper.writeToXML(this.guests, "guests.xml");
    }

    public void readObjects() {
        this.guests = (List<IGuest>) XMLHelper.readFromXML("guests.xml");
    }
}
