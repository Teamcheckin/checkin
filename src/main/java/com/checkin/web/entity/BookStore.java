package com.checkin.web.entity;

public class BookStore {

	private Integer id;
	private String bgImg; 
	private String logoImg;
	private String address;
	private String instagramUrl;
	private Integer memberId;
	private String name;
	private String operatingTime;
	private String guName;
	private Double latitude;
	private Double longitude;
	
	public BookStore(Integer id, String bgImg, String logoImg, String address, String instagramUrl, Integer memberId,
			String name, String operatingTime, String guName, Double latitude, Double longitude) {
		super();
		this.id = id;
		this.bgImg = bgImg;
		this.logoImg = logoImg;
		this.address = address;
		this.instagramUrl = instagramUrl;
		this.memberId = memberId;
		this.name = name;
		this.operatingTime = operatingTime;
		this.guName = guName;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBgImg() {
		return bgImg;
	}

	public void setBgImg(String bgImg) {
		this.bgImg = bgImg;
	}

	public String getLogoImg() {
		return logoImg;
	}

	public void setLogoImg(String logoImg) {
		this.logoImg = logoImg;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getInstagramUrl() {
		return instagramUrl;
	}

	public void setInstagramUrl(String instagramUrl) {
		this.instagramUrl = instagramUrl;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOperatingTime() {
		return operatingTime;
	}

	public void setOperatingTime(String operatingTime) {
		this.operatingTime = operatingTime;
	}

	public String getGuName() {
		return guName;
	}

	public void setGuName(String guName) {
		this.guName = guName;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "BookStore [id=" + id + ", bgImg=" + bgImg + ", logoImg=" + logoImg + ", address=" + address
				+ ", instagramUrl=" + instagramUrl + ", memberId=" + memberId + ", name=" + name + ", operatingTime="
				+ operatingTime + ", guName=" + guName + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	
}
		
	

