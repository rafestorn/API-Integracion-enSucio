package aiss.api.resources;

import java.util.Arrays;
import java.util.Collection;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.Device;

public class DeviceResource {

	private String uri = "https://api-electronicdevices-313314.nw.r.appspot.com/api/v1/devices";
	//private String uri = "http://localhost:8095/api/Devices";

	
	public Collection<Device> getAll() {
		ClientResource cr = null;
		Device [] Devices = null;
		try {
			cr = new ClientResource(uri);
			Devices = cr.get(Device[].class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving all Devices: " + cr.getResponse().getStatus());
			throw(re);
		}
		
		return Arrays.asList(Devices);
	}
	

	public Device getDevice(Integer DeviceId) {
		ClientResource cr = null;
		Device device = null;
		try {
			cr = new ClientResource(uri+"/"+DeviceId.toString());
			device = cr.get(Device.class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the device: " + cr.getResponse().getStatus());
		}
		
		return device;		
	}
	

	public Device addDevice(Device Device) {
		ClientResource cr = null;
		Device resultDevice = null;
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);
			resultDevice = cr.post(Device, Device.class);
			
		} catch (ResourceException re) {
			System.err.println("Error when adding the device: " + cr.getResponse().getStatus());
		}
		return resultDevice;

	}
	
	public boolean updateDevice(Device Device) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);
			cr.put(Device);
			
		} catch (ResourceException re) {
			System.err.println("Error when updating the device: " + cr.getResponse().getStatus());
			success = false;
		}
		return success;
	}
	

	public boolean deleteDevice(String DeviceId) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri + "/" + DeviceId);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			cr.delete();
			
		} catch (ResourceException re) {
			System.err.println("Error when deleting the Device: " + cr.getResponse().getStatus());
			success = false;
		}
		
		return success;
		
	}
}