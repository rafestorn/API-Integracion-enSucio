package aiss.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"name",
"brand",
"price",
"screenSize",
"weight",
"deviceType",
"storage",
"processor",
"memory",
"setColors",
"camera",
"os"
})
@Generated("jsonschema2pojo")
public class Device {

@JsonProperty("id")
private Integer id;
@JsonProperty("name")
private String name;
@JsonProperty("brand")
private String brand;
@JsonProperty("price")
private Integer price;
@JsonProperty("screenSize")
private Double screenSize;
@JsonProperty("weight")
private Double weight;
@JsonProperty("deviceType")
private String deviceType;
@JsonProperty("storage")
private Integer storage;
@JsonProperty("processor")
private String processor;
@JsonProperty("memory")
private Integer memory;
@JsonProperty("setColors")
private List<String> setColors = null;
@JsonProperty("camera")
private String camera;
@JsonProperty("os")
private String os;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();


public Device(String name, String brand, Integer price, Double screenSize, Double weight, String deviceType,
		Integer storage, String processor, Integer memory, List<String> setColors, String camera, String os) {
	super();
	this.name = name;
	this.brand = brand;
	this.price = price;
	this.screenSize = screenSize;
	this.weight = weight;
	this.deviceType = deviceType;
	this.storage = storage;
	this.processor = processor;
	this.memory = memory;
	this.setColors = setColors;
	this.camera = camera;
	this.os = os;
}

public Device(Integer id, String name, String brand, Integer price, Double screenSize, Double weight, String deviceType,
		Integer storage, String processor, Integer memory, List<String> setColors, String camera, String os) {
	super();
	this.id = id;
	this.name = name;
	this.brand = brand;
	this.price = price;
	this.screenSize = screenSize;
	this.weight = weight;
	this.deviceType = deviceType;
	this.storage = storage;
	this.processor = processor;
	this.memory = memory;
	this.setColors = setColors;
	this.camera = camera;
	this.os = os;
}

@JsonProperty("id")
public Integer getId() {
return id;
}

@JsonProperty("id")
public void setId(Integer id) {
this.id = id;
}

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("brand")
public String getBrand() {
return brand;
}

@JsonProperty("brand")
public void setBrand(String brand) {
this.brand = brand;
}

@JsonProperty("price")
public Integer getPrice() {
return price;
}

@JsonProperty("price")
public void setPrice(Integer price) {
this.price = price;
}

@JsonProperty("screenSize")
public Double getScreenSize() {
return screenSize;
}

@JsonProperty("screenSize")
public void setScreenSize(Double screenSize) {
this.screenSize = screenSize;
}

@JsonProperty("weight")
public Double getWeight() {
return weight;
}

@JsonProperty("weight")
public void setWeight(Double weight) {
this.weight = weight;
}

@JsonProperty("deviceType")
public String getDeviceType() {
return deviceType;
}

@JsonProperty("deviceType")
public void setDeviceType(String deviceType) {
this.deviceType = deviceType;
}

@JsonProperty("storage")
public Integer getStorage() {
return storage;
}

@JsonProperty("storage")
public void setStorage(Integer storage) {
this.storage = storage;
}

@JsonProperty("processor")
public String getProcessor() {
return processor;
}

@JsonProperty("processor")
public void setProcessor(String processor) {
this.processor = processor;
}

@JsonProperty("memory")
public Integer getMemory() {
return memory;
}

@JsonProperty("memory")
public void setMemory(Integer memory) {
this.memory = memory;
}

@JsonProperty("setColors")
public List<String> getSetColors() {
return setColors;
}

@JsonProperty("setColors")
public void setSetColors(List<String> setColors) {
this.setColors = setColors;
}

@JsonProperty("camera")
public String getCamera() {
return camera;
}

@JsonProperty("camera")
public void setCamera(String camera) {
this.camera = camera;
}

@JsonProperty("os")
public String getOs() {
return os;
}

@JsonProperty("os")
public void setOs(String os) {
this.os = os;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}