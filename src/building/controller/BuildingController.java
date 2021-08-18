package building.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import building.exception.DuplicateException;
import building.exception.NotExistException;
import building.model.BuildingService;
import building.model.dto.AppDTO;
import building.model.dto.BuildingDTO;
import building.model.dto.PriceDTO;
import building.model.dto.SellerDTO;
import building.view.RunningEndView;
import log4j.Log;

public class BuildingController {

	private static BuildingController instance = new BuildingController();
	private BuildingService bs = BuildingService.getInstance();

	private BuildingController() {
	}

	public static BuildingController getInstance() {
		return instance;
	}
	
	// 로그인 확인
	public boolean logIn(String nickName, String pw) {
		try {
			if(bs.getProfile(nickName, pw) != null) {
				return true;
			} 
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return false;
	}
	
	// 판매자 계정 확인
	public boolean checkProfile(String nickName, String pw) {
		try {
			if(bs.getProfile(nickName, pw).getSellerId() != null) {
				return true;
			};
		} catch (SQLException s) {
			s.printStackTrace();
		} catch (NullPointerException e) {
			// e.printStackTrace();
		}
		return false;
	}
	
	// 계정 판매자정보 추가
	public boolean addProfileSeller(String nickName, String sellerId) {
		try {
			return bs.addProfileSeller(nickName, sellerId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 모든 매물정보 검색 로직
	public void getAllApp() {
		try {
			RunningEndView.AppListView(bs.getAllApp());
			Log.seachAllApp();
		} catch (SQLException s) {
			RunningEndView.showError("모든 매물정보 검색시 에러 발생");
		}
	}
	
	// 회원가입
	public boolean register(String newNickName, String newPw) {
		try {
			return bs.addProfile(newNickName, newPw);		
		} catch (SQLException | DuplicateException s) {
			RunningEndView.showError("\n이미사용되고 있는 아이디입니다\n");
		}
		return false;
	}

	// 모든 Building 검색 로직
	public void getAllBuilding() {
		try {
			RunningEndView.AppListView(bs.getAllBuilding());
			Log.seachAllBuilding();
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("모든 건물정보 검색시 에러 발생");
		}
	}

	// 모든 Price 검색 로직
	public void getAllPrice() {
		try {
			RunningEndView.AppListView(bs.getAllPrice());
			Log.seachAllPrice();
		} catch (SQLException s) {
			RunningEndView.showError("모든 가격정보 검색시 에러 발생");
		}
	}

	// 모든 판매자 검색 로직
	public void getAllSeller() {
		try {
			RunningEndView.AppListView(bs.getAllSeller());
			Log.seachAllSeller();
		} catch (SQLException s) {
			RunningEndView.showError("모든 판매자정보 검색시 에러 발생");
		}
	}

	// AppId로 매물 정보 검색
	public void getAppId(String appId) {
		try {
			RunningEndView.AppView(bs.getApp(appId));
			Log.seachApp();
		} catch (SQLException s) {
			RunningEndView.showError("App Id로 해당 매물 검색 오류 ");
		} catch (NotExistException e) {
			RunningEndView.showError("App Id로 해당 매물 검색 오류 ");
		}
	}

	// AppId로 매물 정보 반환
	public AppDTO getAppIdContent(String appId) {
		AppDTO app = null;

		try {
			app = bs.getApp(appId);
		} catch (SQLException s) {
			RunningEndView.showError("App Id로 해당 매물 검색 오류 ");
		} catch (NotExistException e) {
			RunningEndView.showError("App Id로 해당 매물 검색 오류 ");
		}
		return app;
	}

	// AppId로 매물 정보 유무 검색
	public boolean getAppIdStart(String appId) {
		try {
			AppDTO app;
			app = bs.getApp(appId);
			if (app != null) {
				return true;
			}
		} catch (SQLException s) {
			RunningEndView.showError("App Id로 해당 매물 검색 오류 ");
		} catch (NotExistException e) {
			RunningEndView.showError("App Id로 해당 매물 검색 오류 ");
		}

		return false;
	}

	// 건물 매물 번호로 매물 정보 검색
	public void getBuildingId(String buildingId) {
		try {
			RunningEndView.BuildingView(bs.getBuilding(buildingId));
			Log.seachBuilding();
		} catch (SQLException s) {
			RunningEndView.showError("Building Id로 해당 건물 검색 오류 ");
		}
	}

	// BuildingId로 매물 정보 유무 검색
	public boolean getBuildingIdStart(String buildingId) {
		try {
			BuildingDTO building = bs.getBuilding(buildingId);
			if (building != null) {
				return true;
			}
		} catch (SQLException s) {
			RunningEndView.showError("Building Id로 해당 매물 검색 오류 ");
		}

		return false;
	}

	// 지역으로 Building 정보 검색
	public void getRegion(String region) {
		try {
			RunningEndView.allRegion(bs.getRegion(region));
			Log.seachRegion();
		} catch (SQLException s) {
			RunningEndView.showError("지역으로 해당 건물 검색 오류 ");
		}
	}

	// 지역으로 매물 정보 유무 검색
	public boolean getRegionStart(String region) {
		try {
			BuildingDTO building = bs.getBuilding(region);
			if (building != null) {
				return true;
			}
		} catch (SQLException s) {
			RunningEndView.showError("지역으로 해당 매물 검색 오류 ");
		}

		return false;
	}

	// Building Type으로 Building 정보 검색
	public void getBuildingType(String type) {
		try {
			RunningEndView.allBuildingType(bs.getBuildingType(type));
			Log.seachBuildingType();
		} catch (SQLException s) {
			RunningEndView.showError("Building Type으로 해당 건물 검색 오류 ");
		}
	}

	// Building Type으로 매물 정보 유무 검색
	public boolean getBuildingTypeStart(String type) {
		try {
			ArrayList<BuildingDTO> building = bs.getBuildingType(type);
			if (building != null) {
				return true;
			}
		} catch (SQLException s) {
			RunningEndView.showError("Building Type으로 해당 매물 검색 오류 ");
		}

		return false;
	}

	// AppId로 Price 정보 검색
	public void getPrice(String appId) {
		try {
			RunningEndView.PriceView(bs.getPrice(appId));
			Log.seachAllPrice();
		} catch (SQLException s) {
			RunningEndView.showError("App Id로 해당 가격 검색 오류 ");
		}
	}

	// AppId로 가격 정보 유무 검색
	public boolean getAppIdPriceStart(String appId) {
		try {
			PriceDTO app = bs.getPrice(appId);
			if (app != null) {
				return true;
			}
		} catch (SQLException s) {
			RunningEndView.showError("App Id로 해당 매물 검색 오류 ");
		}

		return false;
	}

	// 가격대로 Price 정보 검색
	public void getComeparePrice(String type, int min, int max) {
		try {
			if (min <= max) {
				RunningEndView.ComparePriceView(bs.getComparePrice(type, min, max));
				Log.seachCompare(type, min, max);
			} else {
				System.out.println("최소가격이 최대가격보다 클 수는 없습니다");
			}
		} catch (SQLException s) {
			RunningEndView.showError("가격대로 해당 가격 검색 오류 ");
		}
	}

	// SellerId로 판매자 정보 검색
	public void getSellerId(String sellerId) {
		try {
			RunningEndView.SellerView(bs.getSeller(sellerId));
			Log.seachSeller();
		} catch (SQLException s) {
			RunningEndView.showError("Seller Id로 해당 판매자 검색 오류 ");
		}
	}

	// SellerId로 판매자 정보 유무 검색
	public boolean getSellerIdStart(String sellerId) {
		try {
			SellerDTO seller = bs.getSeller(sellerId);
			if (seller != null) {
				return true;
			}
		} catch (SQLException s) {
			RunningEndView.showError("Seller Id로 해당 매물 검색 오류 ");
		}
		return false;
	}

	// BuildingId로 건물 정보 수정
	public void updateBuilding(String buildingId, String region, String address, String type) {
		try {
			boolean r = bs.updateBuilding(buildingId, region, address, type);
			RunningEndView.updateBuildingView(r, buildingId);
			Log.updateBuildingView(r, buildingId);
		} catch (SQLException s) {
			RunningEndView.showError("building id로 건물 정보 변경 오류 재시도 하세요");
		} catch (NotExistException e) {
			RunningEndView.showError("building id 재 확인후 재시도 하세요");
		}
	}

	// AppId로 가격 정보 수정
	public void updatePrice(String appId, int deposit, int monthly_rent, int trade_price) {
		try {
			boolean r = bs.updatePrice(appId, deposit, monthly_rent, trade_price);
			RunningEndView.updatePriceView(r, appId);
			Log.updatePriceView(r, appId);
		} catch (SQLException s) {
			RunningEndView.showError("app id로 가격 정보 변경 오류 재시도 하세요");
		} catch (NotExistException e) {
			RunningEndView.showError("app id 재 확인후 재시도 하세요");
		}
	}

	// sellerId로 판매자 정보 수정
	public void updateSeller(String sellerId, String name, String phone) {
		try {
			boolean r = bs.updateSeller(sellerId, name, phone);
			RunningEndView.updateSellerView(r, sellerId);
			Log.updateSellerView(r, sellerId);
		} catch (SQLException s) {
			RunningEndView.showError("seller id로 판매자 정보 변경 오류 재시도 하세요");
		} catch (NotExistException e) {
			RunningEndView.showError("seller id 재 확인후 재시도 하세요");
		}
	}

	// AppId로 매물 타입 정보 수정
	public void updateAppTradeType(String appId, String trade_type) {
		try {
			boolean r = bs.updateAppTradeType(appId, trade_type);
			RunningEndView.updateTradeTypeView(r, appId);
			Log.updateTradeTypeView(r, appId);
		} catch (SQLException s) {
			RunningEndView.showError("app id로 매물 정보 변경 오류 재시도 하세요");
		} catch (NotExistException e) {
			RunningEndView.showError("app id 재 확인후 재시도 하세요");
		}
	}

	// AppId로 세입자 정보 수정
	public void updateAppTenant(String appId, String tenant) {
		try {
			boolean r = bs.updateAppTenant(appId, tenant);
			RunningEndView.updateTenantView(r, appId);
			Log.updateTenantView(r, appId);
		} catch (SQLException s) {
			RunningEndView.showError("app id로 세입자 정보 변경 오류 재시도 하세요");
		} catch (NotExistException e) {
			RunningEndView.showError("app id 재 확인후 재시도 하세요");
		}
	}

	// 새로운 매물 정보(App) 저장 로직
	public boolean addApp(AppDTO app, BuildingDTO building, PriceDTO price) {
		boolean result = false;

		try {
			result = bs.addBuilding(building);
			result = bs.addPrice(price);
			result = bs.addApp(app);
			RunningEndView.insertAppView(result, app.getAppID());
			Log.insertView(result, app.getAppID());
		} catch (SQLException s) {
			RunningEndView.showError("새로운 매물(App) 저장시 에러 발생");
		}
		return result;
	}

	// 새로운 매물 정보(Building) 저장 로직
	public boolean addBuilding(BuildingDTO building) {
		boolean result = false;

		try {
			result = bs.addBuilding(building);
			RunningEndView.insertBuildingView(result, building.getBuildingID());
			Log.insertView(result, building.getBuildingID());
		} catch (SQLException s) {
			RunningEndView.showError("새로운 매물(Building) 저장시 에러 발생");
		}
		return result;
	}

	// 새로운 매물 정보(Price) 저장 로직
	public boolean addPrice(PriceDTO price) {
		boolean result = false;

		try {
			result = bs.addPrice(price);
			RunningEndView.insertPriceView(result, price.getAppID());
			Log.insertView(result, price.getAppID());
		} catch (SQLException s) {
			RunningEndView.showError("새로운 매물(Price) 저장시 에러 발생");
		}
		return result;
	}

	// 새로운 매물 정보(Seller) 저장 로직
	public boolean addSeller(SellerDTO seller) {
		boolean result = false;

		try {
			result = bs.addSeller(seller);
			RunningEndView.insertSellerView(result, seller.getSellerID());
			Log.insertView(result, seller.getSellerID());
		} catch (SQLException s) {
			RunningEndView.showError("새로운 매물(Seller) 저장시 에러 발생");
		}
		return result;
	}

	// Seller 정보 삭제
	public boolean deleteSeller(String sellerId) {
		boolean result = false;

		try {
			result = bs.deleteSeller(sellerId);
			RunningEndView.deleteSellerView(result, sellerId);
			Log.deleteView(result, sellerId);
		} catch (SQLException s) {
			RunningEndView.showError("Seller 삭제 에러 발생");
		} catch (NotExistException e) {
			RunningEndView.showError("Seller 삭제 에러 발생");
		}
		return result;
	}

	// App 정보 삭제
	public boolean deleteApp(String appId) {
		boolean result = false;
		AppDTO app = null;

		try {
			app = bs.getApp(appId);
		} catch (SQLException s) {
			RunningEndView.showError("App 삭제 에러 발생");
		} catch (NotExistException e) {
			RunningEndView.showError("App 삭제 에러 발생");
		}

		if (app != null) {
			try {
				result = bs.deleteApp(appId);
				if (result) {
					result = bs.deleteBuilding(app.getBuildingID());
					result = bs.deletePrice(appId);
				}
				RunningEndView.deleteAppView(result, appId);
				Log.deleteView(result, appId);
			} catch (SQLException s) {
				RunningEndView.showError("App 삭제 에러 발생");
			} catch (NotExistException e) {
				RunningEndView.showError("App 삭제 에러 발생");
			}
		}
		return result;
	}

	public void start() {
		Log.welcome();
		Start.start();
	}
}
