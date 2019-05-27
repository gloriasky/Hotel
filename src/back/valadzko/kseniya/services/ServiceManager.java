package back.valadzko.kseniya.services;

import back.valadzko.kseniya.dao.ServiceDao;
import back.valadzko.kseniya.interfaces.dao.IServiceDao;
import back.valadzko.kseniya.interfaces.managers.IServiceManager;
import back.valadzko.kseniya.interfaces.model.IService;

import java.util.Comparator;
import java.util.List;

public class ServiceManager implements IServiceManager {
    private static IServiceManager serviceManager;
    private IServiceDao serviceRepository = ServiceDao.getInstance();

    private ServiceManager() {
    }

    public static IServiceManager getInstance() {
        if (serviceManager == null) {
            serviceManager = new ServiceManager();
        }
        return serviceManager;
    }

    public List<IService> sort(Comparator<IService> comparator) {

        return serviceRepository.sort(comparator);
    }

    public List<IService> readAll() {
        return serviceRepository.readAll();
    }

    public void update(IService service) {
        serviceRepository.update(service);
    }

    public Integer getCount() {
        return serviceRepository.getCount();
    }

    public void changePrice(IService changedService) {
        List<IService> services = serviceRepository.readAll();
        for (int i = 0; i < services.size(); i++) {
            if (services.get(i).getId().equals(changedService.getId())) {
                services.get(i).setPrice(changedService.getPrice());
            }
        }
    }

    public void addService(IService service) {
        serviceRepository.addService(service);
    }

    public void save() {
        serviceRepository.writeObjects();
    }


}