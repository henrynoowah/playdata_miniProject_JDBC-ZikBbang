package building.model;

import java.sql.SQLException;
import java.util.ArrayList;

import building.exception.NotExistException;
import building.model.dto.AppDTO;
import building.model.dto.BuildingDTO;
import building.model.dto.PriceDTO;
import building.model.dto.ProfileDTO;
import building.model.dto.SellerDTO;

public class BuildingService {

	private static BuildingService instance = new BuildingService();

	private BuildingService() {
	}

	public static BuildingService getInstance() {
		return instance;
	}
	
	// 로그인 정보 
	public ProfileDTO getProfile(String nickName, String pw) throws SQLException {
		ProfileDTO profile = ProfileDAO.getProfile(nickName, pw);
		return profile;
	}
	
	// 모든 매물정보 반환
	public ArrayList<AppDTO> getAllApp() throws SQLException {
		return AppDAO.getAllApp();
	}

	// Appid로 존재 유무 검색하는 메소드
	public AppDTO getApp(String appId) throws SQLException, NotExistException {
		AppDTO app = AppDAO.getApp(appId);
		if (app == null) {
			throw new NotExistException("검색하는 App Id가 미 존재합니다.");
		}
		return app;
	}
	
	// Appid로 존재 유무 검색하는 메소드
	public AppDTO getAppState(String appId) throws SQLException, NotExistException {
		AppDTO app = AppDAO.getApp(appId);
		return app;
	}

	// Building - CRUD
	public void notExistBuilding(String buildingId) throws NotExistException, SQLException {
		BuildingDTO building = BuildingDAO.getBuilding(buildingId);
		if (building == null) {
//			throw new NotExistException("검색하는 App Id가 미 존재합니다.");
			System.out.println("검색하는 App Id가 미 존재합니다.");
		}
	}

	public boolean addBuilding(BuildingDTO building) throws SQLException {
		return BuildingDAO.addBuilding(building);
	}

	public boolean updateBuilding(String buildingId, String region, String address, String type)
			throws SQLException, NotExistException {
		notExistBuilding(buildingId);
		return BuildingDAO.updateBuilding(buildingId, region, address, type);
	}

	public boolean deleteBuilding(String buildingId) throws SQLException, NotExistException {
		notExistBuilding(buildingId);
		return BuildingDAO.deleteBuilding(buildingId);
	}

	public BuildingDTO getBuilding(String buildingId) throws SQLException {
		return BuildingDAO.getBuilding(buildingId);
	}
	
	public ArrayList<BuildingDTO> getRegion(String buildingId) throws SQLException {
		return BuildingDAO.getRegion(buildingId);
	}
	
	public ArrayList<BuildingDTO> getBuildingType(String buildingId) throws SQLException {
		return BuildingDAO.getBuildingType(buildingId);
	}

	public ArrayList<BuildingDTO> getAllBuilding() throws SQLException {
		return BuildingDAO.getAllBuilding();
	}

	// Price - CRUD
	public void notExistPrice(String appId) throws NotExistException, SQLException {
		PriceDTO price = PriceDAO.getPrice(appId);
		if (price == null) {
//			throw new NotExistException("검색하는 App Id가 미 존재합니다.");
			System.out.println("검색하는 App Id가 미 존재합니다.");
		}
	}

	public boolean addPrice(PriceDTO price) throws SQLException {
		return PriceDAO.addPrice(price);
	}
	
	public ArrayList<PriceDTO> getComparePrice(String type, int min, int max) throws SQLException {
		return PriceDAO.getComparePrice(type, min, max);
	}

	public boolean updatePrice(String appId, int deposit, int monthly_rent, int trade_price)
			throws SQLException, NotExistException {
		notExistPrice(appId);
		return PriceDAO.updatePrice(appId, deposit, monthly_rent, trade_price);
	}

	public boolean deletePrice(String appId) throws SQLException, NotExistException {
		notExistPrice(appId);
		return PriceDAO.deletePrice(appId);
	}

	public PriceDTO getPrice(String appId) throws SQLException {
		return PriceDAO.getPrice(appId);
	}

	public ArrayList<PriceDTO> getAllPrice() throws SQLException {
		return PriceDAO.getAllPrice();
	}

	// Seller - CRUD
	public void notExistSeller(String sellerId) throws NotExistException, SQLException {
		SellerDTO seller = SellerDAO.getSeller(sellerId);
		if (seller == null) {
//			throw new NotExistException("검색하는 Seller Id가 미 존재합니다.");
			System.out.println("검색하는 Seller Id가 미 존재합니다.");
		}
	}

	public boolean addSeller(SellerDTO sellerId) throws SQLException {
		return SellerDAO.addSeller(sellerId);
	}

	public boolean updateSeller(String sellerId, String name, String phone)
			throws SQLException, NotExistException {
		notExistSeller(sellerId);
		return SellerDAO.updateSeller(sellerId, name, phone);
	}

	public boolean deleteSeller(String recipientId) throws SQLException, NotExistException {
		notExistSeller(recipientId);
		return SellerDAO.deleteSeller(recipientId);
	}

	public SellerDTO getSeller(String recipientId) throws SQLException {
		return SellerDAO.getSeller(recipientId);
	}

	public ArrayList<SellerDTO> getAllSeller() throws SQLException {
		return SellerDAO.getAllSeller();
	}

	// AppUserDAO - CRUD
	public void notExistApp(String appId) throws NotExistException, SQLException {
		AppDTO AppUser = AppDAO.getApp(appId);
		if (AppUser == null) {
//			throw new NotExistException("검색하는 App Id가 미 존재합니다.");
			System.out.println("검색하는 App Id가 미 존재합니다.");
		}
	}

	public boolean addApp(AppDTO app) throws SQLException {
		return AppDAO.addApp(app);
	}

	public boolean updateAppTradeType(String appId, String trade_type)
			throws SQLException, NotExistException {
		notExistApp(appId);
		return AppDAO.updateAppTradeType(appId, trade_type);
	}

	public boolean updateAppTenant(String appId, String tenant) throws SQLException, NotExistException {
		notExistApp(appId);
		return AppDAO.updateAppTenant(appId, tenant);
	}

	public boolean deleteApp(String appId) throws SQLException, NotExistException {
		notExistApp(appId);
		return AppDAO.deleteApp(appId);
	}


}
