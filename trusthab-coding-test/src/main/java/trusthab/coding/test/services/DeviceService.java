package trusthab.coding.test.services;

import java.util.List;

import trusthab.coding.test.models.Device;

public interface DeviceService {

    List<Device> findAll();

    Device findById(String id);

    boolean save(Device device);

    boolean delete(String id);

    boolean update(String id, Device device);

    List<Device> findByLocation(int location);

    List<Device> findByParentLocation(int parentLocation);

    List<Device> findByConnected(boolean connected);

}
