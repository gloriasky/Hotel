package back.valadzko.kseniya.utills.comparators;


import back.valadzko.kseniya.interfaces.model.IRoom;

import java.util.Comparator;

public class SortByNumberOfStars implements Comparator<IRoom> {
    @Override
    public int compare(IRoom room1, IRoom room2) {

        if (room1.getNumberOfStars() < room2.getNumberOfStars()) return -1;
        else if (room1.getNumberOfStars().equals(room2.getNumberOfStars())) return 0;
        else return 1;
    }

}
