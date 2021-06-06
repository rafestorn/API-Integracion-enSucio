package aiss.model.resources;

import static org.junit.Assert.*;
import java.util.Collection;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.restlet.resource.ResourceException;

import aiss.api.resources.DeviceResource;
import aiss.model.Device;

public class DeviceResourceTest {

	static Device Device1, Device2, Device3;
	static DeviceResource sr = new DeviceResource();
	
	@BeforeClass
	public static void setup() throws Exception {
		
		// Test Device 1
		Device1 = sr.addDevice(new Device("Test name", "test brand", 23, 32.5, 23.5, "test deviceType",
				356, "test processor",23, null, "test camera", "test os"));
		
		// Test Device 2
		Device2 = sr.addDevice(new Device("Test name2", "test brand2", 24, 31.5, 17.5, "test deviceType2",
				336, "test processor2",26, null, "test camera2", "test os2"));
		
	}

	@AfterClass
	public static void tearDown() throws Exception {
		sr.deleteDevice(Device1.getId().toString());
		sr.deleteDevice(Device3.getId().toString());
	}
	
	@Test
	public void testGetAll() {
		Collection<Device> Devices = sr.getAll();
		
		assertNotNull("The collection of Devices is null", Devices);
		
		// Show result
		System.out.println("Listing all Devices:");
		int i=1;
		for (Device s : Devices) {
			System.out.println("Device " + i++ + " : " + s.getName() + " (ID=" + s.getId().toString() + ")");
		}
	}

	@Test
	public void testGetDevice() {
		Device d = sr.getDevice(18);
		System.out.println("Device " + d.getName() + " (ID=" + d.getId().toString() + ")");
	}

	@Test
	public void testAddDevice() {
		
		//TODO

	}

	@Test
	public void testUpdateDevice() {
		
		String Devicename = "Update Device test name";
		String DeviceBrand = "Update Device test brand";
		String DeviceType = "Update Device test deviceType";
		Integer DeviceMem = 1024;
		
		// Update Device
		Device1.setName(Devicename);
		Device1.setBrand(DeviceBrand);
		Device1.setDeviceType(DeviceType);
		Device1.setMemory(DeviceMem);
		
		boolean success = sr.updateDevice(Device1);
		
		assertTrue("Error when updating the Device", success);
		
		Device Device  = sr.getDevice(Device1.getId());
		assertEquals("The Device's name has not been updated correctly", Devicename, Device.getName());
		assertEquals("The Device's artist has not been updated correctly", DeviceBrand, Device.getBrand());
		assertEquals("The Device's album has not been updated correctly", DeviceType, Device.getDeviceType());
		assertEquals("The Device's year has not been updated correctly", DeviceMem, Device.getMemory());
	}

	@Test(expected = ResourceException.class)
	public void testDeleteDevice() {
		
		// Delete Devices
		boolean success = sr.deleteDevice(Device2.getId().toString());
		
		assertTrue("Error when deleting the Device", success);
		
		Device Device  = sr.getDevice(Device2.getId());
		assertNull("The Device has not been deleted correctly", Device);
	}

}

