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
