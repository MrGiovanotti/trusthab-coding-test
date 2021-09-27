package trusthab.coding.test.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import trusthab.coding.test.models.Device;
import trusthab.coding.test.services.DeviceService;
import trusthab.coding.test.storage.DeviceStorage;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Override
    public List<Device> findAll() {
	return DeviceStorage.getInstance().getDevices();
    }

    @Override
    public Device findById(String id) {
	return DeviceStorage.getInstance().findById(id);
    }

    @Override
    public boolean save(Device device) {
	return DeviceStorage.getInstance().add(device);
    }

    @Override
    public boolean delete(String id) {
	return DeviceStorage.getInstance().delete(id);
    }

    @Override
    public boolean update(String id, Device device) {
	return DeviceStorage.getInstance().update(id, device);
    }

    @Override
    public List<Device> findByLocation(int location) {
	return DeviceStorage.getInstance().findByLocation(location);
    }

    @Override
    public List<Device> findByParentLocation(int parentLocation) {
	return DeviceStorage.getInstance().findByParentLocation(parentLocation);
    }

    @Override
    public List<Device> findByConnected(boolean connected) {
	return DeviceStorage.getInstance().findByConnected(connected);
    }

}
