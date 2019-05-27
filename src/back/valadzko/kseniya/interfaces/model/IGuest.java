package back.valadzko.kseniya.interfaces.model;

import java.util.Date;
import java.util.List;

public interface IGuest {

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    Date getDateOfRelease();

    void setDateOfRelease(Date dateOfRelease);

    Date getArrivalDate();

    void setArrivalDate(Date arrivalDate);

    void setRoom(IRoom room);

    IRoom getRoom();

    void setServices(List<IService> services);

    List<IService> getServices();

    Integer getId();

    void setId(int id);

    String toString();

    boolean equals(IGuest guest);

    IGuest clone() throws CloneNotSupportedException;

}
