package back.valadzko.kseniya.utills.comparators;

import back.valadzko.kseniya.interfaces.model.IGuest;

import java.util.Comparator;

public class SortByDate implements Comparator<IGuest> {
    @Override
    public int compare(IGuest guest1, IGuest guest2) {
        if (guest1.getDateOfRelease().before(guest2.getDateOfRelease())) return -1;
        else if (guest1.getDateOfRelease().after(guest2.getDateOfRelease())) return 1;
        else return 0;
    }
}
