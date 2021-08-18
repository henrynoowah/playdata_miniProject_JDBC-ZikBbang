package building.model.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ProfileDTO {
	
	private String nickName;
	private String pw;
	private String sellerId;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[�г���: ");
		builder.append(nickName);
		builder.append("], [���: ");
		if(sellerId != null) {
			builder.append(" �Ǹ���], [�Ǹ���: ");
			builder.append(sellerId + "]");			
		} else {			
			builder.append(" �Ϲ�ȸ��]");
		}
		
		return builder.toString();
	}
}
