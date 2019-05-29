package back.valadzko.kseniya.model;

import back.valadzko.kseniya.interfaces.model.IGuest;
import back.valadzko.kseniya.interfaces.model.IRoom;
import back.valadzko.kseniya.interfaces.model.Status;
import java.io.Serializable;

public class Room implements Serializable, Cloneable, IRoom {

    private Integer id;
    private Integer price;
    private Integer capacity;
    private Integer numberOfStars;
    private Status status;
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
        return this.getId().equals(room.getId());
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
        sBuilder.append("Комната № ");
        sBuilder.append(id);
        sBuilder.append(": \nЦена = ");
        sBuilder.append(price);
        sBuilder.append(" RUB, \nВместимость = ");
        sBuilder.append(capacity);
        sBuilder.append(", \nКоличество звезд = ");
        sBuilder.append(numberOfStars);
        sBuilder.append(", \nСтатус = ");
        sBuilder.append(status);
        return sBuilder.toString();
    }
}
