package building.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PriceDTO {
	
	private String appID;
	private int deposit;
	private int monthlyRent;
	private int tradePrice;
	
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
