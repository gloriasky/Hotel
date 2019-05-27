package back.valadzko.kseniya.model;

import back.valadzko.kseniya.interfaces.model.IGuest;
import back.valadzko.kseniya.interfaces.model.IRoom;
import back.valadzko.kseniya.interfaces.model.Status;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

public class Room implements Serializable, Cloneable, IRoom {

    @XmlElement
    private Integer id;
    @XmlElement
    private Integer price;
    @XmlElement
    private Integer capacity;
    @XmlElement
    private Integer numberOfStars;
    @XmlElement
    private Status status;
    @XmlElement
    private IGuest guest;


    public Room() {
        this.id = null;
    }

    public Room(int id) {
        this.id = id;
    }

    public Room(Integer id, Integer price, Integer capacity, Integer numberOfStars, Status status) {
        this.id = id;
        this.price = price;
        this.capacity = capacity;
        this.numberOfStars = numberOfStars;
        this.status = status;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Integer getNumberOfStars() {
        return numberOfStars;
    }

    public void setNumberOfStars(int numberOfStars) {
        this.numberOfStars = numberOfStars;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = Status.valueOf(status);
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public IGuest getGuest() {
        return guest;
    }

    public void setGuest(IGuest guest) {
        this.guest = guest;
    }

    public boolean equals(IRoom room) {
        if (this.getId().equals(room.getId())) return true;
        else {
            return false;
        }
    }

    @Override
    public IRoom clone() throws CloneNotSupportedException {
        Room cloneRoom = new Room();
        cloneRoom.setStatus(this.status);
        cloneRoom.setPrice(this.price);
        cloneRoom.setCapacity(this.capacity);
        cloneRoom.setNumberOfStars(this.numberOfStars);
        return cloneRoom;
    }

    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("Room ");
        sBuilder.append(id);
        sBuilder.append(": \nprice = ");
        sBuilder.append(price);
        sBuilder.append(", \ncapacity = ");
        sBuilder.append(capacity);
        sBuilder.append(", \nnumber of stars = ");
        sBuilder.append(numberOfStars);
        sBuilder.append(", \nstatus = ");
        sBuilder.append(status);
        return sBuilder.toString();
    }
}
