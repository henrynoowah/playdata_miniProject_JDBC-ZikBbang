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
	
	// �α��� Ȯ��
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
	
	// �Ǹ��� ���� Ȯ��
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
	
	// ���� �Ǹ������� �߰�
	public boolean addProfileSeller(String nickName, String sellerId) {
		try {
			return bs.addProfileSeller(nickName, sellerId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// ��� �Ź����� �˻� ����
	public void getAllApp() {
		try {
			RunningEndView.AppListView(bs.getAllApp());
			Log.seachAllApp();
		} catch (SQLException s) {
			RunningEndView.showError("��� �Ź����� �˻��� ���� �߻�");
		}
	}
	
	// ȸ������
	public boolean register(String newNickName, String newPw) {
		try {
			return bs.addProfile(newNickName, newPw);		
		} catch (SQLException | DuplicateException s) {
			RunningEndView.showError("\n�̹̻��ǰ� �ִ� ���̵��Դϴ�\n");
		}
		return false;
	}

	// ��� Building �˻� ����
	public void getAllBuilding() {
		try {
			RunningEndView.AppListView(bs.getAllBuilding());
			Log.seachAllBuilding();
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("��� �ǹ����� �˻��� ���� �߻�");
		}
	}

	// ��� Price �˻� ����
	public void getAllPrice() {
		try {
			RunningEndView.AppListView(bs.getAllPrice());
			Log.seachAllPrice();
		} catch (SQLException s) {
			RunningEndView.showError("��� �������� �˻��� ���� �߻�");
		}
	}

	// ��� �Ǹ��� �˻� ����
	public void getAllSeller() {
		try {
			RunningEndView.AppListView(bs.getAllSeller());
			Log.seachAllSeller();
		} catch (SQLException s) {
			RunningEndView.showError("��� �Ǹ������� �˻��� ���� �߻�");
		}
	}

	// AppId�� �Ź� ���� �˻�
	public void getAppId(String appId) {
		try {
			RunningEndView.AppView(bs.getApp(appId));
			Log.seachApp();
		} catch (SQLException s) {
			RunningEndView.showError("App Id�� �ش� �Ź� �˻� ���� ");
		} catch (NotExistException e) {
			RunningEndView.showError("App Id�� �ش� �Ź� �˻� ���� ");
		}
	}

	// AppId�� �Ź� ���� ��ȯ
	public AppDTO getAppIdContent(String appId) {
		AppDTO app = null;

		try {
			app = bs.getApp(appId);
		} catch (SQLException s) {
			RunningEndView.showError("App Id�� �ش� �Ź� �˻� ���� ");
		} catch (NotExistException e) {
			RunningEndView.showError("App Id�� �ش� �Ź� �˻� ���� ");
		}
		return app;
	}

	// AppId�� �Ź� ���� ���� �˻�
	public boolean getAppIdStart(String appId) {
		try {
			AppDTO app;
			app = bs.getApp(appId);
			if (app != null) {
				return true;
			}
		} catch (SQLException s) {
			RunningEndView.showError("App Id�� �ش� �Ź� �˻� ���� ");
		} catch (NotExistException e) {
			RunningEndView.showError("App Id�� �ش� �Ź� �˻� ���� ");
		}

		return false;
	}

	// �ǹ� �Ź� ��ȣ�� �Ź� ���� �˻�
	public void getBuildingId(String buildingId) {
		try {
			RunningEndView.BuildingView(bs.getBuilding(buildingId));
			Log.seachBuilding();
		} catch (SQLException s) {
			RunningEndView.showError("Building Id�� �ش� �ǹ� �˻� ���� ");
		}
	}

	// BuildingId�� �Ź� ���� ���� �˻�
	public boolean getBuildingIdStart(String buildingId) {
		try {
			BuildingDTO building = bs.getBuilding(buildingId);
			if (building != null) {
				return true;
			}
		} catch (SQLException s) {
			RunningEndView.showError("Building Id�� �ش� �Ź� �˻� ���� ");
		}

		return false;
	}

	// �������� Building ���� �˻�
	public void getRegion(String region) {
		try {
			RunningEndView.allRegion(bs.getRegion(region));
			Log.seachRegion();
		} catch (SQLException s) {
			RunningEndView.showError("�������� �ش� �ǹ� �˻� ���� ");
		}
	}

	// �������� �Ź� ���� ���� �˻�
	public boolean getRegionStart(String region) {
		try {
			BuildingDTO building = bs.getBuilding(region);
			if (building != null) {
				return true;
			}
		} catch (SQLException s) {
			RunningEndView.showError("�������� �ش� �Ź� �˻� ���� ");
		}

		return false;
	}

	// Building Type���� Building ���� �˻�
	public void getBuildingType(String type) {
		try {
			RunningEndView.allBuildingType(bs.getBuildingType(type));
			Log.seachBuildingType();
		} catch (SQLException s) {
			RunningEndView.showError("Building Type���� �ش� �ǹ� �˻� ���� ");
		}
	}

	// Building Type���� �Ź� ���� ���� �˻�
	public boolean getBuildingTypeStart(String type) {
		try {
			ArrayList<BuildingDTO> building = bs.getBuildingType(type);
			if (building != null) {
				return true;
			}
		} catch (SQLException s) {
			RunningEndView.showError("Building Type���� �ش� �Ź� �˻� ���� ");
		}

		return false;
	}

	// AppId�� Price ���� �˻�
	public void getPrice(String appId) {
		try {
			RunningEndView.PriceView(bs.getPrice(appId));
			Log.seachAllPrice();
		} catch (SQLException s) {
			RunningEndView.showError("App Id�� �ش� ���� �˻� ���� ");
		}
	}

	// AppId�� ���� ���� ���� �˻�
	public boolean getAppIdPriceStart(String appId) {
		try {
			PriceDTO app = bs.getPrice(appId);
			if (app != null) {
				return true;
			}
		} catch (SQLException s) {
			RunningEndView.showError("App Id�� �ش� �Ź� �˻� ���� ");
		}

		return false;
	}

	// ���ݴ�� Price ���� �˻�
	public void getComeparePrice(String type, int min, int max) {
		try {
			if (min <= max) {
				RunningEndView.ComparePriceView(bs.getComparePrice(type, min, max));
				Log.seachCompare(type, min, max);
			} else {
				System.out.println("�ּҰ����� �ִ밡�ݺ��� Ŭ ���� �����ϴ�");
			}
		} catch (SQLException s) {
			RunningEndView.showError("���ݴ�� �ش� ���� �˻� ���� ");
		}
	}

	// SellerId�� �Ǹ��� ���� �˻�
	public void getSellerId(String sellerId) {
		try {
			RunningEndView.SellerView(bs.getSeller(sellerId));
			Log.seachSeller();
		} catch (SQLException s) {
			RunningEndView.showError("Seller Id�� �ش� �Ǹ��� �˻� ���� ");
		}
	}

	// SellerId�� �Ǹ��� ���� ���� �˻�
	public boolean getSellerIdStart(String sellerId) {
		try {
			SellerDTO seller = bs.getSeller(sellerId);
			if (seller != null) {
				return true;
			}
		} catch (SQLException s) {
			RunningEndView.showError("Seller Id�� �ش� �Ź� �˻� ���� ");
		}
		return false;
	}

	// BuildingId�� �ǹ� ���� ����
	public void updateBuilding(String buildingId, String region, String address, String type) {
		try {
			boolean r = bs.updateBuilding(buildingId, region, address, type);
			RunningEndView.updateBuildingView(r, buildingId);
			Log.updateBuildingView(r, buildingId);
		} catch (SQLException s) {
			RunningEndView.showError("building id�� �ǹ� ���� ���� ���� ��õ� �ϼ���");
		} catch (NotExistException e) {
			RunningEndView.showError("building id �� Ȯ���� ��õ� �ϼ���");
		}
	}

	// AppId�� ���� ���� ����
	public void updatePrice(String appId, int deposit, int monthly_rent, int trade_price) {
		try {
			boolean r = bs.updatePrice(appId, deposit, monthly_rent, trade_price);
			RunningEndView.updatePriceView(r, appId);
			Log.updatePriceView(r, appId);
		} catch (SQLException s) {
			RunningEndView.showError("app id�� ���� ���� ���� ���� ��õ� �ϼ���");
		} catch (NotExistException e) {
			RunningEndView.showError("app id �� Ȯ���� ��õ� �ϼ���");
		}
	}

	// sellerId�� �Ǹ��� ���� ����
	public void updateSeller(String sellerId, String name, String phone) {
		try {
			boolean r = bs.updateSeller(sellerId, name, phone);
			RunningEndView.updateSellerView(r, sellerId);
			Log.updateSellerView(r, sellerId);
		} catch (SQLException s) {
			RunningEndView.showError("seller id�� �Ǹ��� ���� ���� ���� ��õ� �ϼ���");
		} catch (NotExistException e) {
			RunningEndView.showError("seller id �� Ȯ���� ��õ� �ϼ���");
		}
	}

	// AppId�� �Ź� Ÿ�� ���� ����
	public void updateAppTradeType(String appId, String trade_type) {
		try {
			boolean r = bs.updateAppTradeType(appId, trade_type);
			RunningEndView.updateTradeTypeView(r, appId);
			Log.updateTradeTypeView(r, appId);
		} catch (SQLException s) {
			RunningEndView.showError("app id�� �Ź� ���� ���� ���� ��õ� �ϼ���");
		} catch (NotExistException e) {
			RunningEndView.showError("app id �� Ȯ���� ��õ� �ϼ���");
		}
	}

	// AppId�� ������ ���� ����
	public void updateAppTenant(String appId, String tenant) {
		try {
			boolean r = bs.updateAppTenant(appId, tenant);
			RunningEndView.updateTenantView(r, appId);
			Log.updateTenantView(r, appId);
		} catch (SQLException s) {
			RunningEndView.showError("app id�� ������ ���� ���� ���� ��õ� �ϼ���");
		} catch (NotExistException e) {
			RunningEndView.showError("app id �� Ȯ���� ��õ� �ϼ���");
		}
	}

	// ���ο� �Ź� ����(App) ���� ����
	public boolean addApp(AppDTO app, BuildingDTO building, PriceDTO price) {
		boolean result = false;

		try {
			result = bs.addBuilding(building);
			result = bs.addPrice(price);
			result = bs.addApp(app);
			RunningEndView.insertAppView(result, app.getAppID());
			Log.insertView(result, app.getAppID());
		} catch (SQLException s) {
			RunningEndView.showError("���ο� �Ź�(App) ����� ���� �߻�");
		}
		return result;
	}

	// ���ο� �Ź� ����(Building) ���� ����
	public boolean addBuilding(BuildingDTO building) {
		boolean result = false;

		try {
			result = bs.addBuilding(building);
			RunningEndView.insertBuildingView(result, building.getBuildingID());
			Log.insertView(result, building.getBuildingID());
		} catch (SQLException s) {
			RunningEndView.showError("���ο� �Ź�(Building) ����� ���� �߻�");
		}
		return result;
	}

	// ���ο� �Ź� ����(Price) ���� ����
	public boolean addPrice(PriceDTO price) {
		boolean result = false;

		try {
			result = bs.addPrice(price);
			RunningEndView.insertPriceView(result, price.getAppID());
			Log.insertView(result, price.getAppID());
		} catch (SQLException s) {
			RunningEndView.showError("���ο� �Ź�(Price) ����� ���� �߻�");
		}
		return result;
	}

	// ���ο� �Ź� ����(Seller) ���� ����
	public boolean addSeller(SellerDTO seller) {
		boolean result = false;

		try {
			result = bs.addSeller(seller);
			RunningEndView.insertSellerView(result, seller.getSellerID());
			Log.insertView(result, seller.getSellerID());
		} catch (SQLException s) {
			RunningEndView.showError("���ο� �Ź�(Seller) ����� ���� �߻�");
		}
		return result;
	}

	// Seller ���� ����
	public boolean deleteSeller(String sellerId) {
		boolean result = false;

		try {
			result = bs.deleteSeller(sellerId);
			RunningEndView.deleteSellerView(result, sellerId);
			Log.deleteView(result, sellerId);
		} catch (SQLException s) {
			RunningEndView.showError("Seller ���� ���� �߻�");
		} catch (NotExistException e) {
			RunningEndView.showError("Seller ���� ���� �߻�");
		}
		return result;
	}

	// App ���� ����
	public boolean deleteApp(String appId) {
		boolean result = false;
		AppDTO app = null;

		try {
			app = bs.getApp(appId);
		} catch (SQLException s) {
			RunningEndView.showError("App ���� ���� �߻�");
		} catch (NotExistException e) {
			RunningEndView.showError("App ���� ���� �߻�");
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
				RunningEndView.showError("App ���� ���� �߻�");
			} catch (NotExistException e) {
				RunningEndView.showError("App ���� ���� �߻�");
			}
		}
		return result;
	}

	public void start() {
		Log.welcome();
		Start.start();
	}
}
