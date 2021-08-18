package building.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Getter
@Setter
public class SellerDTO extends ProfileDTO {
	
	private String sellerID;
	private String name;
	private String phone;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[직빵 등록번호: ");
		builder.append(sellerID);
		builder.append("], [건물 매물 번호: ");
		builder.append(name);
		builder.append("], [매물 타입: ");
		builder.append(phone + "]");
		
		return builder.toString();
	}
}
