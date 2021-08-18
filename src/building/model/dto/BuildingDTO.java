package building.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BuildingDTO {
	
	private String buildingID;
	private String region;
	private String address;
	private String buildingType;
	
//	public BuildingDTO() {}
//	public BuildingDTO(String buildingID, String region, String address, String buildingType) {
//		super();
//		this.buildingID = buildingID;
//		this.region = region;
//		this.address = address;
//		this.buildingType = buildingType;
//	}
//	
//	public String getBuildingID() {
//		return buildingID;
//	}
//
//	public void setBuildingID(String buildingID) {
//		this.buildingID = buildingID;
//	}
//
//	public String getRegion() {
//		return region;
//	}
//
//	public void setRegion(String region) {
//		this.region = region;
//	}
//
//	public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}
//
//	public String getBuildingType() {
//		return buildingType;
//	}
//
//	public void setBuildingType(String buildingType) {
//		this.buildingType = buildingType;
//	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("[건물 매물 번호: ");
		builder.append(buildingID);
		builder.append("], [매물 지역: ");
		builder.append(region);
		builder.append("], \t[매물 상세 주소: ");
		builder.append(address);
		builder.append("], \t[매물 종류: ");
		builder.append(buildingType + "]");
		
		return builder.toString();
	}
}
