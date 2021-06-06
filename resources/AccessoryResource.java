package aiss.api.resources;

import java.util.Arrays;
import java.util.Collection;

import org.restlet.data.MediaType;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.Accessory;
import aiss.model.Device;

public class AccessoryResource {

	private String uri = "https://api-electronicdevices-313314.nw.r.appspot.com/api/v1/accessories";
	//private String uri = "http://localhost:8095/api/lists";
	

	public Collection<Accessory> getAll() {
		
		ClientResource cr = null;
		Accessory [] lists = null;
		try {
			cr = new ClientResource(uri);
			lists = cr.get(Accessory[].class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the collections of Accessorys: " + cr.getResponse().getStatus());
		}
		
		return Arrays.asList(lists);
	}
	
	
	public Accessory getAccessory(String AccessoryId) {
		
		ClientResource cr = null;
		Accessory list = null;
		try {
			cr = new ClientResource(uri + "/" + AccessoryId);
			list = cr.get(Accessory.class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the Accessory: " + cr.getResponse().getStatus());
		}
		
		return list;

	}
	

	public Accessory addAccessory(Accessory pl) {
		
		ClientResource cr = null;
		Accessory resultAccessory = null;
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			resultAccessory = cr.post(pl,Accessory.class);
			
		} catch (ResourceException re) {
			System.err.println("Error when adding the Accessory: " + cr.getResponse().getStatus());
		}
		
		return resultAccessory;
	}
	

	public boolean updateAccessory(Accessory pl) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			cr.put(pl);
			
			
		} catch (ResourceException re) {
			System.err.println("Error when updating the Accessory: " + cr.getResponse().getStatus());
			success = false;
		}
		
		return success;
	}
	
	
	public boolean deleteAccessory(String AccessoryId) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri + "/" + AccessoryId);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			cr.delete();
			
		} catch (ResourceException re) {
			System.err.println("Error when deleting the Accessory: " + cr.getResponse().getStatus());
			success = false;
		}
		
		return success;
	}
	
	public boolean addDevice(String AccessoryId, String deviceId) {
		// TODO
		// Use	cr.post(" ") to avoid RESTlet crashing
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri + "/" + AccessoryId + "/" +deviceId);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			cr.post(deviceId);
			
		} catch (ResourceException re) {
			System.err.println("Error when deleting the Accessory: " + cr.getResponse().getStatus());
			success = false;
		}
		return success;
		
	}
	
	public boolean removeDevice(String AccessoryId, String deviceId) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri + "/" + AccessoryId + "/" +deviceId);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			cr.delete();
			
		} catch (ResourceException re) {
			System.err.println("Error when deleting the device: " + cr.getResponse().getStatus());
			success = false;
		}
		return success;
	}
	
}
