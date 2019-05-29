package back.valadzko.kseniya.services;

import back.valadzko.kseniya.dao.GuestDao;
import back.valadzko.kseniya.interfaces.dao.IGuestDao;
import back.valadzko.kseniya.interfaces.managers.IGuestManager;
import back.valadzko.kseniya.interfaces.model.IGuest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
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

    public List<IGuest> getCurrentGuests(){
        List<IGuest> curr = new ArrayList<>();
        List<IGuest> all = guestRepository.readAll();
        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getDateOfRelease().after(new Date())){
                curr.add(all.get(i));
            }
        }
        return curr;
    }

    public void update(IGuest guest) {
        guestRepository.update(guest);
    }

    public void addGuest(IGuest guest) {
        guestRepository.addGuest(guest);
    }

    public Integer getCount() {
        return getCurrentGuests().size();
    }

    public void save() {
        guestRepository.writeObjects();
    }
}
