package back.valadzko.kseniya.model;

import back.valadzko.kseniya.interfaces.model.IService;
import java.io.Serializable;

public class Service implements Serializable, Cloneable, IService {

    private Integer id;
    private String section;
    private String name;
    private Integer price;


    public Service() {
        this.id = null;
    }

    public Service(Integer id) {
        this.id = id;
    }

    public Service(Integer id, String section, String name, Integer price) {
        this.id = id;
        this.section = section;
        this.name = name;
        this.price = price;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("Service: \nsection = ");
        sBuilder.append(section);
        sBuilder.append(", \nname = ");
        sBuilder.append(name);
        sBuilder.append(", \nprice = ");
        sBuilder.append(price);
        return sBuilder.toString();
    }

    public boolean equals(IService service) {
        if (this.getId().equals(service.getId())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public IService clone() throws CloneNotSupportedException {
        Service cloneService = new Service();
        cloneService.setPrice(this.price);
        cloneService.setName(this.name);
        cloneService.setSection(this.section);
        return cloneService;
    }
}
