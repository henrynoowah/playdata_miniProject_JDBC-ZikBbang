package building.model.dto;

public class ProfileDTO {
	
	private String nickName;
	private String pw;
	private String sellerId;
	
	public ProfileDTO() {}
	public ProfileDTO(String sellerID, String name, String phone) {
		super();
		this.nickName = sellerID;
		this.pw = name;
		this.sellerId = phone;
	}

	public String getSellerID() {
		return nickName;
	}

	public void setSellerID(String sellerID) {
		this.nickName = sellerID;
	}

	public String getName() {
		return pw;
	}

	public void setName(String name) {
		this.pw = name;
	}

	public String getPhone() {
		return sellerId;
	}

	public void setPhone(String phone) {
		this.sellerId = phone;
	}

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
