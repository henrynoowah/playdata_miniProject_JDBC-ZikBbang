package log4j;

import org.apache.log4j.Logger;

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
	
	// 회원가입 성공
	public static void register(String newNickName) {
		logger.info(newNickName + "회원가입성공");
	}
	
	// 서비스 종료
	public static void serviceClose(String name) {
		logger.info(name + "님이 서비스를 종료하셨습니다");
	}
	
	// 검색 - 모든 매물
	public static void seachAllApp() {
		logger.info("모든 매물을 검색하였습니다");
	}
	
	// 검색 - 모든 건물
	public static void seachAllBuilding() {
		logger.info("모든 건물을 검색하였습니다");
	}
	
	// 검색 - 모든 가격
	public static void seachAllPrice() {
		logger.info("모든 가격을 검색하였습니다");
	}
	
	// 검색 - 모든 판매자
	public static void seachAllSeller() {
		logger.info("모든 판매자를 검색하였습니다");
	}
	
	// App Id로 매물 검색
	public static void seachApp() {
		logger.info("App Id로 매물을 검색하였습니다");
	}
	
	// Building Id로 매물 검색
	public static void seachBuilding() {
		logger.info("Building Id로 건물을 검색하였습니다");
	}
	
	// 지역으로 매물 검색
	public static void seachRegion() {
		logger.info("지역으로 건물을 검색하였습니다");
	}
	
	// 건물 유형으로 매물 검색
	public static void seachBuildingType() {
		logger.info("건물 유형으로 건물을 검색하였습니다");
	}
		
	// App Id로 매물 검색
	public static void seachPrice() {
		logger.info("App Id로 가격을 검색하였습니다");
	}
	
	// App Id로 매물 검색
	public static void seachCompare(String type, int min, int max) {
		logger.info(min + " ~ " + max + "사이(단위 : 만원)의 " + type + "를(을) 검색하였습니다");
	}
	
	// Seller Id로 매물 검색
	public static void seachSeller() {
		logger.info("Seller Id로 판매자를 검색하였습니다");
	}

	// Buildingupdate 성공, 실패시 메시지 출력 -
	public static void updateBuildingView(boolean result, String buildingId) {
		if (result == true) {
			logger.info("요청하신 [Building Id : " + buildingId + "] region, address, building_type 수정 완료");
		}
	}

	// Priceupdate 성공, 실패시 메시지 출력 -
	public static void updatePriceView(boolean result, String appId) {
		if (result == true) {
			logger.info("요청하신 [직빵번호 : " + appId + "] deposit, monthly_rent, trade_price 수정 완료");
		}
	}

	// Sellerupdate 성공, 실패시 메시지 출력 -
	public static void updateSellerView(boolean result, String sellerId) {
		if (result == true) {
			logger.info("요청하신 [Seller Id : " + sellerId + "] name, phone 수정 완료");
		}
	}

	// TradeTypeupdate 성공, 실패시 메시지 출력 -
	public static void updateTradeTypeView(boolean result, String appId) {
		if (result == true) {
			logger.info("요청하신 [직빵번호 : " + appId + "] trade_type 수정 완료");
		}
	}

	// Tenantupdate 성공, 실패시 메시지 출력 -
	public static void updateTenantView(boolean result, String appId) {
		if (result == true) {
			logger.info("요청하신 [직빵번호 : " + appId + "] tenant 수정 완료");
		}
	}

	// insert 성공, 실패시 메시지 출력 -
	public static void insertView(boolean result, String Id) {
		if (result == true) {
			logger.info("요청하신 [직빵번호 : " + Id + "] insert 완료");
		}
	}

	// delete 성공, 실패시 메시지 출력 -
	public static void deleteView(boolean result, String Id) {
		if (result == true) {
			logger.info("요청하신 [직빵번호 : " + Id + "] delete 완료");
		}
	}

}
