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
		builder.append("[���� ��Ϲ�ȣ: ");
		builder.append(sellerID);
		builder.append("], [�ǹ� �Ź� ��ȣ: ");
		builder.append(name);
		builder.append("], [�Ź� Ÿ��: ");
		builder.append(phone + "]");
		
		return builder.toString();
	}
}
