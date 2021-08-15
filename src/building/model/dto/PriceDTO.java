package building.model.dto;

public class PriceDTO {
	
	private String appID;
	private int deposit;
	private int monthlyRent;
	private int tradePrice;
	
	public PriceDTO() {}
	public PriceDTO(String appID, int deposit, int monthlyRent, int tradePrice) {
		super();
		this.appID = appID;
		this.deposit = deposit;
		this.monthlyRent = monthlyRent;
		this.tradePrice = tradePrice;
	}
	
	public String getAppID() {
		return appID;
	}

	public void setAppID(String appID) {
		this.appID = appID;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getMonthlyRent() {
		return monthlyRent;
	}

	public void setMonthlyRent(int monthlyRent) {
		this.monthlyRent = monthlyRent;
	}

	public int getTradePrice() {
		return tradePrice;
	}

	public void setTradePrice(int tradePrice) {
		this.tradePrice = tradePrice;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[���� ��Ϲ�ȣ: ");
		builder.append(appID);
		if(deposit == 0 && monthlyRent == 0) {
			if(tradePrice >= 10000) {
				double price = (double)tradePrice/10000;
				builder.append("], [�ŸŰ�: ");
				builder.append(price + "���]");
			}else {
				builder.append("], [�ŸŰ�: ");
				builder.append(tradePrice + "����]");
			}
		}else if(monthlyRent == 0 && tradePrice == 0) {
			if(deposit >= 10000) {
				double price = (double)deposit/10000;
				builder.append("], [������: ");
				builder.append(price + "���]");
			}else {
				builder.append("], [������: ");
				builder.append(deposit + "����]");
			}
		}else{
			if(deposit >= 10000) {
				double price = (double)deposit/10000;
				builder.append("], [������: ");
				builder.append(price + "���]");
				builder.append(", [����: ");
				builder.append(monthlyRent + "����]");
			}else {
				builder.append("], [������: ");
				builder.append(deposit + "����]");
				builder.append(", [����: ");
				builder.append(monthlyRent + "����]");
			}
		}
		
		return builder.toString();
	}
}
