package building.model;

import java.sql.SQLException;
import java.util.ArrayList;

import building.exception.NotExistException;
import building.model.dto.AppDTO;
import building.model.dto.BuildingDTO;
import building.model.dto.PriceDTO;
import building.model.dto.SellerDTO;

public class BuildingService {
	
	private static AppDAO app = AppDAO.getInstance();
	private static BuildingDAO build = BuildingDAO.getInstance();
	private static SellerDAO sell = SellerDAO.getInstance();
	private static PriceDAO price = PriceDAO.getInstance();

	private static BuildingService instance = new BuildingService();

	private BuildingService() {}

	public static BuildingService getInstance() {
		return instance;
	}

	// 모든 매물정보 반환
	public ArrayList<AppDTO> getAllApp() throws SQLException {
		return app.getAllApp();
	}
	
	public AppDTO getApp(String appId) throws SQLException {
		return app.getApp(appId);
	}

	// Appid로 존재 유무 검색하는 메소드
	public AppDTO getAppUser(String appId) throws SQLException, NotExistException {
		AppDTO appUser = app.getApp(appId);
		if (appUser == null) {
			throw new NotExistException("검색하는 직빵번호가 미 존재합니다.");
		}
		return appUser;
	}

	// Building - CRUD
	public void notExistBuilding(String buildingId) throws NotExistException, SQLException {
		BuildingDTO building = build.getBuilding(buildingId);
		if (building == null) {
			throw new NotExistException("검색하는 buildingId가 미 존재합니다.");
		}
	}

	public boolean addBuilding(BuildingDTO building) throws SQLException {
		return build.addBuilding(building);
	}

	public boolean updateBuilding(String buildingId, String region, String address, String type)
			throws SQLException, NotExistException {
		notExistBuilding(buildingId);
		return build.updateBuilding(buildingId, region, address, type);
	}

	public boolean deleteBuilding(String buildingId) throws SQLException, NotExistException {
		notExistBuilding(buildingId);
		return build.deleteBuilding(buildingId);
	}

	public BuildingDTO getBuilding(String buildingId) throws SQLException {
		return build.getBuilding(buildingId);
	}
	
	public ArrayList<BuildingDTO> getRegion(String buildingId) throws SQLException {
		return build.getRegion(buildingId);
	}

	public ArrayList<BuildingDTO> getAllBuilding() throws SQLException {
		return build.getAllBuilding();
	}
	
	public ArrayList<BuildingDTO> getBuildingType(String buildingId) throws SQLException {
		return build.getBuildingType(buildingId);
	}

	// Price - CRUD
	public void notExistPrice(String appId) throws NotExistException, SQLException {
		PriceDTO price1 = price.getPrice(appId);
		if (price1 == null) {
			throw new NotExistException("검색하는appId가 미 존재합니다.");
		}
	}
	
	public ArrayList<PriceDTO> getComparePrice(String type, int min, int max) throws SQLException {
		return price.getComparePrice(type,min,max);
	}

	public boolean addPrice(PriceDTO price1) throws SQLException {
		return price.addPrice(price1);
	}

	public boolean updatePrice(String appId, int deposit, int monthly_rent, int trade_price)
			throws SQLException, NotExistException {
		notExistBuilding(appId);
		return price.updatePrice(appId, deposit, monthly_rent, trade_price);
	}

	public boolean deletePrice(String appId) throws SQLException, NotExistException {
		notExistBuilding(appId);
		return price.deletePrice(appId);
	}

	public PriceDTO getPrice(String appId) throws SQLException {
		return price.getPrice(appId);
	}

	public ArrayList<PriceDTO> getAllPrice() throws SQLException {
		return price.getAllPrice();
	}
	
	

	// Seller - CRUD
	public void notExistSeller(String sellerId) throws NotExistException, SQLException {
		SellerDTO seller = sell.getSeller(sellerId);
		if (seller == null) {
			throw new NotExistException("검색하는 sellerId가 미 존재합니다.");
		}
	}

	public boolean addSeller(SellerDTO sellerId) throws SQLException {
		return sell.addSeller(sellerId);
	}

	public boolean updateSeller(String sellerId, String name, String phone)
			throws SQLException, NotExistException {
		notExistSeller(sellerId);
		return sell.updateSeller(sellerId, name, phone);
	}

	public boolean deleteSeller(String sellerId) throws SQLException, NotExistException {
		notExistSeller(sellerId);
		return sell.deleteSeller(sellerId);
	}

	public SellerDTO getSeller(String sellerId) throws SQLException {
		return sell.getSeller(sellerId);
	}

	public ArrayList<SellerDTO> getAllSeller() throws SQLException {
		return sell.getAllSeller();
	}
	

	// AppUserDAO - CRUD
	
	public static void notExistAppUser(String appUserId) throws NotExistException, SQLException {
		AppDTO AppUser = app.getApp(appUserId);
		if (AppUser == null) {
			throw new NotExistException("검색하는 재능기부 프로젝트가 미 존재합니다.");
		}
	}

	public boolean addApp(AppDTO appUser) throws SQLException {
		return app.addApp(appUser);
	}

	public boolean updateAppTradeType(String appUserId, String trade_type)
			throws SQLException, NotExistException {
		notExistAppUser(appUserId);
		return app.updateAppTradeType(appUserId, trade_type);
	}

	public boolean updateAppTenant(String appUserId, String tenant) throws SQLException, NotExistException {
		notExistAppUser(appUserId);
		return app.updateAppTenant(appUserId, tenant);
	}

	public boolean deleteApp(String appUserId) throws SQLException, NotExistException {
		notExistAppUser(appUserId);
		return app.deleteApp(appUserId);
	}

}
