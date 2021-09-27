package trusthab.coding.test.storage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import trusthab.coding.test.models.Device;
import trusthab.coding.test.utils.Utils;

public class DeviceStorage {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceStorage.class);
    private static final String FILE_NAME = "devices.json";

    private static DeviceStorage instance;

    private List<Device> devices;

    private DeviceStorage() {
	devices = new ArrayList<>();
	try {
	    String devicesContentFile = Utils.readResourcesFile(FILE_NAME);
	    JSONArray devicesAsJson = new JSONArray(devicesContentFile);
	    for (int i = 0; i < devicesAsJson.length(); i++) {
		JSONObject device = devicesAsJson.getJSONObject(i);
		devices.add(new Device(device));
	    }
	} catch (IOException e) {
	    LOGGER.error("Couldn't read json file: {}", e.getMessage());
	}
    }

    public static DeviceStorage getInstance() {
	if (instance == null) {
	    instance = new DeviceStorage();
	}
	return instance;
    }

    public List<Device> getDevices() {
	return devices;
    }

    public void setDevices(List<Device> devices) {
	this.devices = devices;
    }

    public Device findById(String id) {
	for (Device device : devices) {
	    if (device.getId().equals(id)) {
		return device;
	    }
	}
	return null;
    }

    public boolean add(Device device) {
	if (findById(device.getId()) == null) {
	    devices.add(device);
	    return true;
	}
	return false;
    }

    public boolean delete(String id) {
	Device deviceToDelete = findById(id);
	if (deviceToDelete != null) {
	    devices.remove(deviceToDelete);
	    return true;
	}
	return false;
    }

    public boolean update(String id, Device device) {
	int index = getIndex(id);
	if (index >= 0) {
	    devices.set(index, device);
	    return true;
	}
	return false;
    }

    public List<Device> findByLocation(int location) {
	return devices.stream().filter(d -> d.getLocation() == location).collect(Collectors.toList());
    }

    public List<Device> findByParentLocation(int parentLocation) {
	return devices.stream().filter(d -> d.getParentLocation() == parentLocation).collect(Collectors.toList());
    }

    public List<Device> findByConnected(boolean connected) {
	return devices.stream().filter(d -> d.isConnected() == connected).collect(Collectors.toList());
    }

    private int getIndex(String id) {
	for (int i = 0; i < devices.size(); i++) {
	    if (id.equals(devices.get(i).getId())) {
		return i;
	    }
	}
	return -1;
    }

}
