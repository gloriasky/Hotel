package back.valadzko.kseniya.interfaces.managers;

import back.valadzko.kseniya.exceptions.SomethingWentWrong;

public interface IManager {

    Integer getCount() throws SomethingWentWrong;

    void save();
}
