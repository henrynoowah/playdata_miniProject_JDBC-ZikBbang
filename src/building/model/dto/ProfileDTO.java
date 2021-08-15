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

	public String getNickName() {
		return nickName;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public String getPw() {
		return pw;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public String getSellerId() {
		return sellerId;
	}
	
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	
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
