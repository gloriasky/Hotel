package back.valadzko.kseniya.utills.comparators;

import back.valadzko.kseniya.interfaces.model.IRoom;

import java.util.Comparator;

public class SortRoomByPrice implements Comparator<IRoom> {
    @Override
    public int compare(IRoom room1, IRoom room2) {
        if ( room1.getPrice() < room2.getPrice() ) return -1;
        else if (room1.getPrice().equals(room2.getPrice())) return 0;
        else return 1;
    }

}
