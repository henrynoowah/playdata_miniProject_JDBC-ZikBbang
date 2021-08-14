package log4j;

import org.apache.log4j.Logger;

import building.controller.BuildingController;

public class Log {
	static Logger logger = Logger.getLogger("log4.Log");
	
	// 서비스 시작
	public static void welcome() {
		logger.info("서비스 실행");
	}
	
	// 이름 입력
	public static void inputName(String name) {
		logger.info(name + "님이 들어오셨습니다");
	}
	
	// 서비스 종료
	public static void serviceClose(String name) {
		logger.info(name + "님이 서비스를 종료하셨습니다");
	}

	// Buildingupdate 성공, 실패시 메시지 출력 -
	public static void updateBuildingView(boolean result, String buildingId) {
		if (result == true) {
			logger.info("요청하신 " + buildingId + "의 region, address, building_type 수정 완료");
		}
	}

	// Priceupdate 성공, 실패시 메시지 출력 -
	public static void updatePriceView(boolean result, String appId) {
		if (result == true) {
			logger.info("요청하신 " + appId + "의 deposit, monthly_rent, trade_price 수정 완료");
		}
	}

	// Priceupdate 성공, 실패시 메시지 출력 -
	public static void updateSellerView(boolean result, String sellerId) {
		if (result == true) {
			logger.info("요청하신 " + sellerId + "의 name, phone 수정 완료");
		}
	}

	// TradeTypeupdate 성공, 실패시 메시지 출력 -
	public static void updateTradeTypeView(boolean result, String appId) {
		if (result == true) {
			logger.info("요청하신 " + appId + "의 trade_type 수정 완료");
		}
	}

	// Tenantupdate 성공, 실패시 메시지 출력 -
	public static void updateTenantView(boolean result, String appId) {
		if (result == true) {
			logger.info("요청하신 " + appId + "의 tenant 수정 완료");
		}
	}

	// insert 성공, 실패시 메시지 출력 -
	public static void insertView(boolean result, String Id) {
		if (result == true) {
			logger.info("요청하신 " + Id + " insert 완료");
		}
	}

	// delete 성공, 실패시 메시지 출력 -
	public static void deleteView(boolean result, String Id) {
		if (result == true) {
			logger.info("요청하신 " + Id + " delete 완료");
		}
	}
}
