package back.valadzko.kseniya.interfaces.managers;

import back.valadzko.kseniya.exceptions.SomethingWentWrong;
import back.valadzko.kseniya.interfaces.model.IGuest;

import java.util.Comparator;
import java.util.List;

public interface IGuestManager extends IManager {

    List<IGuest> readAll() throws SomethingWentWrong;

    List<IGuest> sort(Comparator<IGuest> comparators) throws SomethingWentWrong;

    void update(Integer guestNumber, IGuest guest);

    void addGuest(IGuest guest) throws SomethingWentWrong;
}
