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
