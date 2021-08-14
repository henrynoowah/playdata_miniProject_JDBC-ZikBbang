package building.model.dto;

public class SellerDTO {
	
	private String sellerID;
	private String name;
	private String phone;
	
	public SellerDTO() {}
	public SellerDTO(String sellerID, String name, String phone) {
		super();
		this.sellerID = sellerID;
		this.name = name;
		this.phone = phone;
	}

	public String getSellerID() {
		return sellerID;
	}

	public void setSellerID(String sellerID) {
		this.sellerID = sellerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

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
