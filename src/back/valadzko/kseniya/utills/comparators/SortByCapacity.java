package back.valadzko.kseniya.utills.comparators;

import back.valadzko.kseniya.interfaces.model.IRoom;

import java.util.Comparator;

public class SortByCapacity implements Comparator<IRoom> {
    @Override
    public int compare(IRoom room1, IRoom room2) {
        if (room1.getCapacity() < room2.getCapacity()) return -1;
        else if (room1.getCapacity().equals(room2.getCapacity())) return 0;
        else return 1;
    }
}
