package aiss.model.resources;

import static org.junit.Assert.*;

import java.util.Collection;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.restlet.resource.ResourceException;

import aiss.api.resources.AccessoryResource;
import aiss.api.resources.DeviceResource;
import aiss.model.Accessory;
import aiss.model.Device;

public class AccessoryResourceTest {

	static Accessory Accessory, Accessory2, Accessory3, Accessory4;
	static Device Device;
	static AccessoryResource plr = new AccessoryResource();
	static DeviceResource sr = new DeviceResource();
	
	@BeforeClass
	public static void setUp() throws Exception {
		
		Accessory = plr.addAccessory(new Accessory("Test list 1"));
		Accessory2 = plr.addAccessory(new Accessory("Test list 2"));
		Accessory3 = plr.addAccessory(new Accessory("Test list 3"));
		
	
		Device = sr.addDevice(new Device("Test title","Test artist","Test album","2016"));
		if(Device!=null)
			plr.addDevice(Accessory.getId(), Device.getId());
	}

	@AfterClass
	public static void tearDown() throws Exception {
		plr.deleteAccessory(Accessory.getId());
		plr.deleteAccessory(Accessory3.getId());
		plr.deleteAccessory(Accessory4.getId());
		if(Device!=null)
			sr.deleteDevice(Device.getId());
	}

	@Test
	public void testGetAll() {
		Collection<Accessory> Accessorys = plr.getAll(); 
		
		assertNotNull("The collection of Accessorys is null", Accessorys);
		
		// Show result
		System.out.println("Listing all Accessorys:");
		int i=1;
		for (Accessory pl : Accessorys) {
			System.out.println("Accessory " + i++ + " : " + pl.getName() + " (ID=" + pl.getId() + ")");
		}
		
	}

	@Test
	public void testGetAccessory() {
		Accessory p = plr.getAccessory(Accessory.getId());
		
		assertEquals("The id of the Accessorys do not match", Accessory.getId(), p.getId());
		assertEquals("The name of the Accessorys do not match", Accessory.getName(), p.getName());
		
		// Show result
		System.out.println("Accessory id: " +  p.getId());
		System.out.println("Accessory name: " +  p.getName());

	}

	@Test
	public void testAddAccessory() {
		String AccessoryName = "Add Accessory test title";
		String AccessoryDescription = "Add Accessory test description";
		
		Accessory4 = plr.addAccessory(new Accessory(AccessoryName,AccessoryDescription));
		
		assertNotNull("Error when adding the Accessory", Accessory4);
		assertEquals("The Accessory's name has not been setted correctly", AccessoryName, Accessory4.getName());
		assertEquals("The Accessory's description has not been setted correctly", AccessoryDescription, Accessory4.getDescription());
	}

	@Test
	public void testUpdateAccessory() {
		String AccessoryName = "Updated Accessory name";

		// Update Accessory
		Accessory.setName(AccessoryName);

		boolean success = plr.updateAccessory(Accessory);
		
		assertTrue("Error when updating the Accessory", success);
		
		Accessory pl  = plr.getAccessory(Accessory.getId());
		assertEquals("The Accessory's name has not been updated correctly", AccessoryName, pl.getName());

	}

	@Test
	public void testDeleteAccessory() {
		boolean success = plr.deleteAccessory(Accessory2.getId());
		assertTrue("Error when deleting the Accessory", success);
		
		Accessory pl = plr.getAccessory(Accessory2.getId());
		assertNull("The Accessory has not been deleted correctly", pl);
	}

	@Test
	public void testAddDevice() {
		if(Device!=null) {
			boolean success = plr.addDevice(Accessory3.getId(), Device.getId());
			assertTrue("Error when adding the Device", success);
		}
	}

	@Test
	public void testRemoveDevice() {
		//TODO
	}

}
