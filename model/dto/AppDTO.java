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
		builder.append("[���� ��Ϲ�ȣ: ");
		builder.append(appID);
		builder.append("], [�ǹ� �Ź� ��ȣ: ");
		builder.append(buildingID);
		builder.append("], [�Ź� Ÿ��: ");
		builder.append(tradeType);
		builder.append("], [�Ǹ���: ");
		builder.append(sellerID);
		builder.append("], [������ ����: ");
		builder.append(tenant + "]");
		
		return builder.toString();
	}
}
