package back.valadzko.kseniya.model;

import back.valadzko.kseniya.interfaces.model.IGuest;
import back.valadzko.kseniya.interfaces.model.IRoom;
import back.valadzko.kseniya.interfaces.model.IService;
import back.valadzko.kseniya.utills.DateHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Guest implements Cloneable, IGuest, Serializable {

    private Integer id;
    private String firstName;
    private String lastName;
    private Date dateOfRelease;
    private Date arrivalDate;
    private IRoom room;
    private List<IService> services;


    public Guest() {
        this.id = null;
    }

    public Guest(String firstName, String lastName) {
        this.id = null;
        this.firstName = firstName;
        this.lastName = lastName;
        this.services = new ArrayList<>();
    }

    public Guest(Integer id, String firstName, String lastName, Date dateOfRelease) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfRelease = dateOfRelease;
        this.services = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(Date dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public IRoom getRoom() {
        return room;
    }

    public void setRoom(IRoom room) {
        this.room = room;
    }

    public List<IService> getServices() {
        return services;
    }

    public void setServices(List<IService> services) {
        this.services = services;
    }

    public String toString() {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(firstName);
        sBuilder.append(" ");
        sBuilder.append(lastName);
        if (room != null) {
            sBuilder.append("\nКомната = ");
            sBuilder.append(room.getId());
        }
        if (!services.isEmpty()) {
            sBuilder.append("\nПодключенные услуги: ");
            for (IService service : services) {
                sBuilder.append("\n" + service.getName());
            }
        }
        sBuilder.append("\nДата заселения: ");
        sBuilder.append(DateHelper.dateToString(arrivalDate));
        sBuilder.append("\nДата отъезда: ");
        sBuilder.append(DateHelper.dateToString(dateOfRelease));
        return sBuilder.toString();

    }

    public boolean equals(IGuest guest) {
        return this.getId().equals(guest.getId());
    }

    public IGuest clone() {
        Guest cloneGuest = new Guest();
        cloneGuest.setFirstName(this.getFirstName());
        cloneGuest.setLastName(this.getLastName());
        cloneGuest.setDateOfRelease(this.getDateOfRelease());
        return cloneGuest;
    }
}
