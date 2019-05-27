package back.valadzko.kseniya.interfaces.model;

public interface IService {

    String getSection();

    void setSection(String section);

    String getName();

    void setName(String name);

    Integer getPrice();

    void setPrice(int price);

    Integer getId();

    void setId(int id);

    String toString();

    IService clone() throws CloneNotSupportedException;

    boolean equals(IService service);


}
