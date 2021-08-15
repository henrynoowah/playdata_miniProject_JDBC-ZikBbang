package building.model.dto;

public class AppDTO {
	
	private String appID;
	private String buildingID;
	private String tradeType;
	private String sellerID;
	private String tenant;
	
	public AppDTO () {}
	public AppDTO(String appID, String buildingID, String tradeType, String sellerID, String tenant) {
		super();
		this.appID = appID;
		this.buildingID = buildingID;
		this.tradeType = tradeType;
		this.sellerID = sellerID;
		this.tenant = tenant;
	}
	
	public String getAppID() {
		return appID;
	}

	public void setAppID(String appID) {
		this.appID = appID;
	}

	public String getBuildingID() {
		return buildingID;
	}

	public void setBuildingID(String buildingID) {
		this.buildingID = buildingID;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getSellerID() {
		return sellerID;
	}

	public void setSellerID(String sellerID) {
		this.sellerID = sellerID;
	}

	public String getTenant() {
		return tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[직빵 등록번호: ");
		builder.append(appID);
		builder.append("], [건물 매물 번호: ");
		builder.append(buildingID);
		builder.append("], [매물 타입: ");
		builder.append(tradeType);
		builder.append("], [판매자: ");
		builder.append(sellerID);
		builder.append("], [세입자 여부: ");
		builder.append(tenant + "]");
		
		return builder.toString();
	}
}
