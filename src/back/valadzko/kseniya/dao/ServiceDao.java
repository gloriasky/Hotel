package back.valadzko.kseniya.dao;

import back.valadzko.kseniya.interfaces.dao.IServiceDao;
import back.valadzko.kseniya.interfaces.model.IService;
import back.valadzko.kseniya.utills.XMLHelper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ServiceDao extends AbstractDao implements IServiceDao {

    private static IServiceDao serviceRepository;
    private List<IService> services;

    private ServiceDao() {
        readObjects();
    }

    public static IServiceDao getInstance() {
        if (serviceRepository == null) {
            serviceRepository = new ServiceDao();
        }
        return serviceRepository;
    }

    public List<IService> readAll() {
        return services;
    }

    public void update(IService changedService) {
        for (int i = 0; i < services.size(); i++) {
            if (changedService.getId().equals(services.get(i).getId())) {
                services.set(i, changedService);
            }
        }
    }

    public Integer getCount() {
        return services.size();
    }

    public List<IService> sort(Comparator<IService> comparator) {
        services.sort(comparator);
        return services;
    }

    public void addService(IService service) {
        if (services == null) {
            services = new ArrayList<>();
        }
        services.add(service);
    }

    public void writeObjects() {
        XMLHelper.writeToXML(this.services, "services.xml");
    }

    public void readObjects() {
        services = (List<IService>) XMLHelper.readFromXML("services.xml");
    }


}
