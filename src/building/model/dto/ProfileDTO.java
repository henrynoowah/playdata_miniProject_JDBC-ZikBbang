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
		builder.append("[닉네임: ");
		builder.append(nickName);
		builder.append("], [등급: ");
		if(sellerId != null) {
			builder.append(" 판매자], [판매자: ");
			builder.append(sellerId + "]");			
		} else {			
			builder.append(" 일반회원]");
		}
		
		return builder.toString();
	}
}
