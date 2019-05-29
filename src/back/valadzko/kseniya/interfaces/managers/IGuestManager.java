package back.valadzko.kseniya.interfaces.managers;

import back.valadzko.kseniya.utills.exceptions.SomethingWentWrong;
import back.valadzko.kseniya.interfaces.model.IGuest;

import java.util.Comparator;
import java.util.List;

public interface IGuestManager extends IManager {

    List<IGuest> readAll() throws SomethingWentWrong;

    List<IGuest> sort(Comparator<IGuest> comparators);

    void update(IGuest guest);

    void addGuest(IGuest guest) throws SomethingWentWrong;

    List<IGuest> getCurrentGuests();
}
