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
"accessoryId",
"name",
"wireless",
"price",
"Devices"
})
@Generated("jsonschema2pojo")
public class Accessory {

@JsonProperty("accessoryId")
private Integer accessoryId;
@JsonProperty("name")
private String name;
@JsonProperty("wireless")
private Boolean wireless;
@JsonProperty("price")
private Double price;
@JsonProperty("Devices")
private List<Device> Devices = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();



public Accessory(Integer accessoryId, String name, Boolean wireless, Double price, List<Device> devices) {
	super();
	this.accessoryId = accessoryId;
	this.name = name;
	this.wireless = wireless;
	this.price = price;
	Devices = devices;
}

@JsonProperty("accessoryId")
public Integer getAccessoryId() {
return accessoryId;
}

@JsonProperty("accessoryId")
public void setAccessoryId(Integer accessoryId) {
this.accessoryId = accessoryId;
}

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("wireless")
public Boolean getWireless() {
return wireless;
}

@JsonProperty("wireless")
public void setWireless(Boolean wireless) {
this.wireless = wireless;
}

@JsonProperty("price")
public Double getPrice() {
return price;
}

@JsonProperty("price")
public void setPrice(Double price) {
this.price = price;
}

@JsonProperty("Devices")
public List<Device> getDevices() {
return Devices;
}

@JsonProperty("Devices")
public void setDevices(List<Device> Devices) {
this.Devices = Devices;
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