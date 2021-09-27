package trusthab.coding.test.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Device implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String id;
    private int location;

    @JsonProperty("mac_address")
    private String macAddress;

    private boolean connected;

    @JsonProperty("parent_location")
    private int parentLocation;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    private int signal;

    public Device(String id, int location, String macAddress, boolean connected, int parentLocation,
	    LocalDateTime updatedAt, int signal) {
	this.id = id;
	this.location = location;
	this.macAddress = macAddress;
	this.connected = connected;
	this.parentLocation = parentLocation;
	this.updatedAt = updatedAt;
	this.signal = signal;
    }

    public Device(JSONObject deviceAsJson) {
	id = deviceAsJson.getString("id");
	location = deviceAsJson.getInt("location");
	macAddress = deviceAsJson.getString("mac_address");
	connected = deviceAsJson.getBoolean("connected");
	parentLocation = deviceAsJson.getInt("parent_location");
	updatedAt = LocalDateTime.parse(deviceAsJson.getString("updated_at"),
		DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
	signal = deviceAsJson.getInt("signal");
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public int getLocation() {
	return location;
    }

    public void setLocation(int location) {
	this.location = location;
    }

    public String getMacAddress() {
	return macAddress;
    }

    public void setMacAddress(String macAddress) {
	this.macAddress = macAddress;
    }

    public boolean isConnected() {
	return connected;
    }

    public void setConnected(boolean connected) {
	this.connected = connected;
    }

    public int getParentLocation() {
	return parentLocation;
    }

    public void setParentLocation(int parentLocation) {
	this.parentLocation = parentLocation;
    }

    public LocalDateTime getUpdatedAt() {
	return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
	this.updatedAt = updatedAt;
    }

    public int getSignal() {
	return signal;
    }

    public void setSignal(int signal) {
	this.signal = signal;
    }

    @Override
    public String toString() {
	return "Device [id=" + id + ", location=" + location + ", macAddress=" + macAddress + ", connected=" + connected
		+ ", parentLocation=" + parentLocation + ", updatedAt=" + updatedAt + ", signal=" + signal + "]";
    }

}
