package trusthab.coding.test.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import trusthab.coding.test.models.Device;
import trusthab.coding.test.services.DeviceService;

@Controller
public class HomeController {

    private static final String DEVICES_TAG = "devices";
    private static final String HOME_ROUTE = "/home/home";

    @Autowired
    DeviceService deviceService;

    @GetMapping("/")
    public String home(Model model) {
	List<Device> devices = deviceService.findAll();
	model.addAttribute(DEVICES_TAG, devices);
	return HOME_ROUTE;
    }

    @GetMapping("/view")
    public String view(@RequestParam String id, Model model) {
	Device device = deviceService.findById(id);
	List<Device> relatedDevices = deviceService.findByLocation(device.getLocation());
	model.addAttribute("device", device);
	model.addAttribute(DEVICES_TAG, relatedDevices);
	return "/home/view";
    }

    @GetMapping("/search-by-location")
    public String searchByLocation(@RequestParam int location, Model model) {
	List<Device> devices = deviceService.findByLocation(location);
	model.addAttribute(DEVICES_TAG, devices);
	return HOME_ROUTE;
    }

    @GetMapping("/search-by-parent-location")
    public String searchByParentLocation(@RequestParam int parentLocation, Model model) {
	List<Device> devices = deviceService.findByParentLocation(parentLocation);
	model.addAttribute(DEVICES_TAG, devices);
	return HOME_ROUTE;
    }

    @GetMapping("/search-by-connected")
    public String searchByConnected(@RequestParam boolean connected, Model model) {
	List<Device> devices = deviceService.findByConnected(connected);
	model.addAttribute(DEVICES_TAG, devices);
	return HOME_ROUTE;
    }

}
