package back.valadzko.kseniya.interfaces.managers;

import back.valadzko.kseniya.utills.exceptions.SomethingWentWrong;

public interface IManager {

    Integer getCount() throws SomethingWentWrong;

    void save();
}
