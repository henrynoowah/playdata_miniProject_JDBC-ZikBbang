package building.model;

import java.sql.SQLException;
import java.util.ArrayList;

import building.exception.DuplicateException;
import building.exception.NotExistException;
import building.model.dto.AppDTO;
import building.model.dto.BuildingDTO;
import building.model.dto.PriceDTO;
import building.model.dto.ProfileDTO;
import building.model.dto.SellerDTO;

public class BuildingService {

	private static BuildingService instance = new BuildingService();
	private static AppDAO aIns = AppDAO.getInstance();
	private static BuildingDAO bIns = BuildingDAO.getInstance();
	private static PriceDAO pIns = PriceDAO.getInstance();
	private static SellerDAO sIns = SellerDAO.getInstance();
	private static ProfileDAO profileIns = ProfileDAO.getInstance();

	private BuildingService() {}

	public static BuildingService getInstance() {
		return instance;
	}
	
	// 로그인 정보 
	public ProfileDTO getProfile(String nickName, String pw) throws SQLException {
		return profileIns.getProfile(nickName, pw);
	}
	
	// 화원가입
	public boolean addProfile(String newNickName, String newPw) throws SQLException, DuplicateException {
		ProfileDTO profile = profileIns.getProfile(newNickName);
		if (profile != null) {
			throw new DuplicateException();
		}
		return profileIns.addProfile(newNickName, newPw);
	}
	
	// 계정 판매자 정보 추가
	public boolean addProfileSeller(String nickName, String sellerId) throws SQLException {
		return profileIns.addProfileSeller(nickName, sellerId);
	}


	// 모든 매물정보 반환
	public ArrayList<AppDTO> getAllApp() throws SQLException {
		return aIns.getAllApp();
	}

	// Appid로 존재 유무 검색하는 메소드
	public AppDTO getApp(String appId) throws SQLException, NotExistException {
		return aIns.getApp(appId);
	}

	// Building - CRUD
	public void notExistBuilding(String buildingId) throws NotExistException, SQLException {
		BuildingDTO building = bIns.getBuilding(buildingId);
		if (building == null) {
//			throw new NotExistException("검색하는 App Id가 미 존재합니다.");
			System.out.println("검색하는 Building Id가 미 존재합니다.");
		}
	}

	public boolean addBuilding(BuildingDTO building) throws SQLException {
		return bIns.addBuilding(building);
	}

	public boolean updateBuilding(String buildingId, String region, String address, String type)
			throws SQLException, NotExistException {
		notExistBuilding(buildingId);
		return bIns.updateBuilding(buildingId, region, address, type);
	}

	public boolean deleteBuilding(String buildingId) throws SQLException, NotExistException {
		notExistBuilding(buildingId);
		return bIns.deleteBuilding(buildingId);
	}

	public BuildingDTO getBuilding(String buildingId) throws SQLException {
		return bIns.getBuilding(buildingId);
	}

	public ArrayList<BuildingDTO> getRegion(String buildingId) throws SQLException {
		return bIns.getRegion(buildingId);
	}

	public ArrayList<BuildingDTO> getBuildingType(String buildingId) throws SQLException {
		return bIns.getBuildingType(buildingId);
	}

	public ArrayList<BuildingDTO> getAllBuilding() throws SQLException {
		return bIns.getAllBuilding();
	}

	// Price - CRUD
	public void notExistPrice(String appId) throws NotExistException, SQLException {
		PriceDTO price = pIns.getPrice(appId);
		if (price == null) {
//			throw new NotExistException("검색하는 App Id가 미 존재합니다.");
			System.out.println("검색하는 App Id가 미 존재합니다.");
		}
	}

	public boolean addPrice(PriceDTO price) throws SQLException {
		return pIns.addPrice(price);
	}

	public ArrayList<PriceDTO> getComparePrice(String type, int min, int max) throws SQLException {
		return pIns.getComparePrice(type, min, max);
	}

	public boolean updatePrice(String appId, int deposit, int monthly_rent, int trade_price)
			throws SQLException, NotExistException {
		notExistPrice(appId);
		return pIns.updatePrice(appId, deposit, monthly_rent, trade_price);
	}

	public boolean deletePrice(String appId) throws SQLException, NotExistException {
		notExistPrice(appId);
		return pIns.deletePrice(appId);
	}

	public PriceDTO getPrice(String appId) throws SQLException {
		return pIns.getPrice(appId);
	}

	public ArrayList<PriceDTO> getAllPrice() throws SQLException {
		return pIns.getAllPrice();
	}

	// Seller - CRUD
	public void notExistSeller(String sellerId) throws NotExistException, SQLException {
		SellerDTO seller = sIns.getSeller(sellerId);
		if (seller == null) {
//			throw new NotExistException("검색하는 Seller Id가 미 존재합니다.");
			System.out.println("검색하는 Seller Id가 미 존재합니다.");
		}
	}

	public boolean addSeller(SellerDTO sellerId) throws SQLException {
		return sIns.addSeller(sellerId);
	}

	public boolean updateSeller(String sellerId, String name, String phone) throws SQLException, NotExistException {
		notExistSeller(sellerId);
		return sIns.updateSeller(sellerId, name, phone);
	}

	public boolean deleteSeller(String recipientId) throws SQLException, NotExistException {
		notExistSeller(recipientId);
		return sIns.deleteSeller(recipientId);
	}

	public SellerDTO getSeller(String recipientId) throws SQLException {
		return sIns.getSeller(recipientId);
	}

	public ArrayList<SellerDTO> getAllSeller() throws SQLException {
		return sIns.getAllSeller();
	}

	// AppUserDAO - CRUD
	public void notExistApp(String appId) throws NotExistException, SQLException {
		AppDTO AppUser = aIns.getApp(appId);
		if (AppUser == null) {
//			throw new NotExistException("검색하는 App Id가 미 존재합니다.");
			System.out.println("검색하는 App Id가 미 존재합니다.");
		}
	}

	public boolean addApp(AppDTO app) throws SQLException {
		return aIns.addApp(app);
	}

	public boolean updateAppTradeType(String appId, String trade_type) throws SQLException, NotExistException {
		notExistApp(appId);
		return aIns.updateAppTradeType(appId, trade_type);
	}

	public boolean updateAppTenant(String appId, String tenant) throws SQLException, NotExistException {
		notExistApp(appId);
		return aIns.updateAppTenant(appId, tenant);
	}

	public boolean deleteApp(String appId) throws SQLException, NotExistException {
		notExistApp(appId);
		return aIns.deleteApp(appId);
	}

}
