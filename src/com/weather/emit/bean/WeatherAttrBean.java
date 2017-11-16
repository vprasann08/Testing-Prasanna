package com.weather.emit.bean;

import java.io.Serializable;

public class WeatherAttrBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8271833816017399279L;
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public String getStattionName() {
		return stattionName;
	}
	public void setStattionName(String stattionName) {
		this.stattionName = stattionName;
	}
	public float getElevation() {
		return elevation;
	}
	public void setElevation(float elevation) {
		this.elevation = elevation;
	}
	public float getLatitue() {
		return latitue;
	}
	public void setLatitue(float latitue) {
		this.latitue = latitue;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public float getTemparature() {
		return temparature;
	}
	public void setTemparature(float temparature) {
		this.temparature = temparature;
	}
	public float getPressure() {
		return pressure;
	}
	public void setPressure(float pressure) {
		this.pressure = pressure;
	}
	public float getHumidity() {
		return humidity;
	}
	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}
	public float getTpcp() {
		return tpcp;
	}
	public void setTpcp(float tpcp) {
		this.tpcp = tpcp;
	}
	public float getEmxt() {
		return emxt;
	}
	public void setEmxt(float emxt) {
		this.emxt = emxt;
	}
	public float getEmnt() {
		return emnt;
	}
	public void setEmnt(float emnt) {
		this.emnt = emnt;
	}
	private String station;
	private String stattionName;
	private float elevation;
	private float latitue;
	private float longitude;
	private String time;
	private float temparature;
	private float pressure;
	private float humidity;
	private float tpcp;
	private float emxt;
	private float emnt;	

}
