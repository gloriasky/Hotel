package back.valadzko.kseniya.interfaces.model;

public interface IRoom {

    Integer getPrice();

    void setPrice(int price);

    Integer getCapacity();

    void setCapacity(int capacity);

    Integer getNumberOfStars();

    void setNumberOfStars(int numberOfStars);

    Integer getId();

    void setId(Integer id);

    Status getStatus();

    void setStatus(Status status);

    void setGuest(IGuest guest);

    IGuest getGuest();

    boolean equals(IRoom room);

    IRoom clone() throws CloneNotSupportedException;

    String toString();


}
