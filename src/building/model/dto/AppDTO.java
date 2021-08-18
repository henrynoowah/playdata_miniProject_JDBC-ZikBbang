package building.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppDTO {
	
	private String appID;
	private String buildingID;
	private String tradeType;
	private String sellerID;
	private String tenant;
	
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
