package back.valadzko.kseniya.utills.comparators;

import back.valadzko.kseniya.interfaces.model.IRoom;

import java.util.Comparator;

public class SortByRoomId implements Comparator<IRoom> {

    public int compare(IRoom room1,IRoom room2) {
        if (room1.getId() < room2.getId()) return -1;
        else if (room1.getId().equals(room2.getId())) return 0;
        else return 1;
    }
}

