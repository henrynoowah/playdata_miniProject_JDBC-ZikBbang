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
		builder.append("[직빵 등록번호: ");
		builder.append(appID);
		if(deposit == 0 && monthlyRent == 0) {
			if(tradePrice >= 10000) {
				double price = (double)tradePrice/10000;
				builder.append("], [매매가: ");
				builder.append(price + "억원]");
			}else {
				builder.append("], [매매가: ");
				builder.append(tradePrice + "만원]");
			}
		}else if(monthlyRent == 0 && tradePrice == 0) {
			if(deposit >= 10000) {
				double price = (double)deposit/10000;
				builder.append("], [보증금: ");
				builder.append(price + "억원]");
			}else {
				builder.append("], [보증금: ");
				builder.append(deposit + "만원]");
			}
		}else{
			if(deposit >= 10000) {
				double price = (double)deposit/10000;
				builder.append("], [보증금: ");
				builder.append(price + "억원]");
				builder.append(", [월세: ");
				builder.append(monthlyRent + "만원]");
			}else {
				builder.append("], [보증금: ");
				builder.append(deposit + "만원]");
				builder.append(", [월세: ");
				builder.append(monthlyRent + "만원]");
			}
		}
		
		return builder.toString();
	}
}
