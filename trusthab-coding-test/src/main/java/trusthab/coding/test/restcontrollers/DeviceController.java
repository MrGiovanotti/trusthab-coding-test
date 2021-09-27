package trusthab.coding.test.restcontrollers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import trusthab.coding.test.models.Device;
import trusthab.coding.test.services.DeviceService;

@RestController
@RequestMapping("/device")
public class DeviceController {

    private static final String MESSAGE_TAG = "message";

    @Autowired
    DeviceService deviceService;

    @GetMapping("/list")
    public List<Device> getAllDevices() {
	return deviceService.findAll();
    }

    @GetMapping("/view/{id}")
    public Device getDeviceById(@PathVariable String id) {
	return deviceService.findById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> create(@RequestBody Device device) {
	Map<String, Object> responseMap = new HashMap<>();
	HttpStatus httpStatus;
	if (deviceService.save(device)) {
	    responseMap.put(MESSAGE_TAG, "Device created");
	    httpStatus = HttpStatus.OK;
	} else {
	    responseMap.put(MESSAGE_TAG, "Device has not been created");
	    httpStatus = HttpStatus.CONFLICT;
	}
	return new ResponseEntity<>(responseMap, httpStatus);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable String id) {
	Map<String, Object> responseMap = new HashMap<>();
	HttpStatus httpStatus;
	if (deviceService.delete(id)) {
	    responseMap.put(MESSAGE_TAG, "Device deleted");
	    httpStatus = HttpStatus.OK;
	} else {
	    responseMap.put(MESSAGE_TAG, "Device has not been deleted");
	    httpStatus = HttpStatus.NOT_FOUND;
	}
	return new ResponseEntity<>(responseMap, httpStatus);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable String id, @RequestBody Device device) {
	Map<String, Object> responseMap = new HashMap<>();
	HttpStatus httpStatus;
	if (deviceService.update(id, device)) {
	    responseMap.put(MESSAGE_TAG, "Device updated");
	    httpStatus = HttpStatus.OK;
	} else {
	    responseMap.put(MESSAGE_TAG, "Device has not been updated");
	    httpStatus = HttpStatus.NOT_FOUND;
	}
	return new ResponseEntity<>(responseMap, httpStatus);
    }

}
