package building.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import building.exception.NotExistException;
import building.model.BuildingService;
import building.model.start;
import building.model.dto.AppDTO;
import building.model.dto.BuildingDTO;
import building.model.dto.PriceDTO;
import building.model.dto.SellerDTO;
import building.view.RunningEndView;
import log4j.Log;

public class BuildingController {
	
	private BuildingService bs = BuildingService.getInstance();

	private static BuildingController instance = new BuildingController();

	private BuildingController() {}

	public static BuildingController getInstance() {
		return instance;
	}

	// ��� �Ź����� �˻� ����
	public void getAllApp() {
		try {
			RunningEndView.AppListView(bs.getAllApp());
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("��� �Ź����� �˻��� ���� �߻�");
		}
	}

	// ��� Building �˻� ����
	public void getAllBuilding() {
		try {
			RunningEndView.AppListView(bs.getAllBuilding());
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("��� �ǹ����� �˻��� ���� �߻�");
		}
	}

	// ��� Price �˻� ����
	public void getAllPrice() {
		try {
			RunningEndView.AppListView(bs.getAllPrice());
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("��� �������� �˻��� ���� �߻�");
		}
	}

	// ��� �Ǹ��� �˻� ����
	public void getAllSeller() {
		try {
			RunningEndView.AppListView(bs.getAllSeller());
		} catch (SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("��� �Ǹ������� �˻��� ���� �߻�");
		}
	}

	// AppId�� �Ź� ���� �˻�
	public void getAppId(String appId) {
		try {
			RunningEndView.AppView(bs.getApp(appId));
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("App Id�� �ش� �Ź� �˻� ���� ");
		}
	}

	// AppId�� �Ź� ���� ���� �˻�
	public boolean getAppIdStart(String appId) {
		try {
			AppDTO app = bs.getAppUser(appId);
			if (app != null) {
				return true;
			}
		} catch (SQLException | NotExistException e) {
			e.printStackTrace();
			RunningEndView.showError("App Id�� �ش� �Ź� �˻� ���� ");
		}

		return false;
	}

	// �ǹ� �Ź� ��ȣ�� �Ź� ���� �˻�
	public void getBuildingId(String buildingId) {
		try {
			RunningEndView.BuildingView(bs.getBuilding(buildingId));
		} catch (SQLException e) {
			e.printStackTrace();
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
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("Building Id�� �ش� �Ź� �˻� ���� ");
		}

		return false;
	}

	// �������� Building ���� �˻�
	public void getRegion(String region) {
		try {
			RunningEndView.allRegion(bs.getRegion(region));
		} catch (SQLException e) {
			e.printStackTrace();
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
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("�������� �ش� �Ź� �˻� ���� ");
		}

		return false;
	}

	// Building Type���� Building ���� �˻�
	public void getBuildingType(String type) {
		try {
			RunningEndView.allBuildingType(bs.getBuildingType(type));
		} catch (SQLException e) {
			e.printStackTrace();
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
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("Building Type���� �ش� �Ź� �˻� ���� ");
		}

		return false;
	}

	// AppId�� Price ���� �˻�
	public void getPrice(String appId) {
		try {
			RunningEndView.PriceView(bs.getPrice(appId));
		} catch (SQLException e) {
			e.printStackTrace();
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
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("App Id�� �ش� �Ź� �˻� ���� ");
		}

		return false;
	}

	// ���ݴ�� Price ���� �˻�
	public void getComeparePrice(String type, int min, int max) {
		try {
			if (min <= max) {
				RunningEndView.ComparePriceView(bs.getComparePrice(type, min, max));
			} else {
				System.out.println("�ּҰ����� �ִ밡�ݺ��� Ŭ ���� �����ϴ�");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("���ݴ�� �ش� ���� �˻� ���� ");
		}
	}

	// SellerId�� �Ǹ��� ���� �˻�
	public void getSellerId(String sellerId) {
		try {
			RunningEndView.SellerView(bs.getSeller(sellerId));
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("Seller Id�� �ش� �Ǹ��� �˻� ���� ");
		}
	}

	// SellerId�� ���� ���� ���� �˻�
	public boolean getSellerIdStart(String sellerId) {
		try {
			SellerDTO seller = bs.getSeller(sellerId);
			if (seller != null) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
			s.printStackTrace();
			RunningEndView.showError("building id�� �ǹ� ���� ���� ���� ��õ� �ϼ���");
		} catch (NotExistException s) {
			s.printStackTrace();
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
			s.printStackTrace();
			RunningEndView.showError("app id�� ���� ���� ���� ���� ��õ� �ϼ���");
		} catch (NotExistException s) {
			s.printStackTrace();
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
			s.printStackTrace();
			RunningEndView.showError("seller id�� �Ǹ��� ���� ���� ���� ��õ� �ϼ���");
		} catch (NotExistException s) {
			s.printStackTrace();
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
			s.printStackTrace();
			RunningEndView.showError("app id�� �Ź� ���� ���� ���� ��õ� �ϼ���");
		} catch (NotExistException s) {
			s.printStackTrace();
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
			s.printStackTrace();
			RunningEndView.showError("app id�� ������ ���� ���� ���� ��õ� �ϼ���");
		} catch (NotExistException s) {
			s.printStackTrace();
			RunningEndView.showError("app id �� Ȯ���� ��õ� �ϼ���");
		}
	}

	// ���ο� �Ź� ����(App) ���� ����
	public boolean addApp(AppDTO app) {
		boolean result = false;

		try {
			result = bs.addApp(app);
			RunningEndView.insertAppView(result, app.getAppID());
			Log.insertView(result, app.getAppID());
		} catch (SQLException s) {
			s.printStackTrace();
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
			s.printStackTrace();
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
			s.printStackTrace();
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
			s.printStackTrace();
			RunningEndView.showError("���ο� �Ź�(Seller) ����� ���� �߻�");
		}
		return result;
	}

	// Building ���� ����
	public boolean deleteBuilding(String buildingId) {
		boolean result = false;

		try {
			result = bs.deleteBuilding(buildingId);
			RunningEndView.deleteBuildingView(result, buildingId);
			Log.deleteView(result, buildingId);
		} catch (SQLException | NotExistException s) {
			s.printStackTrace();
			RunningEndView.showError("Building ���� ���� �߻�");
		}

		return result;
	}

	// Price ���� ����
	public boolean deletePrice(String appId) {
		boolean result = false;

		try {
			result = bs.deletePrice(appId);
			RunningEndView.deletePriceView(result, appId);
			Log.deleteView(result, appId);
		} catch (SQLException | NotExistException s) {
			s.printStackTrace();
			RunningEndView.showError("Price ���� ���� �߻�");
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
		} catch (SQLException | NotExistException s) {
			s.printStackTrace();
			RunningEndView.showError("Seller ���� ���� �߻�");
		}

		return result;
	}

	// App ���� ����
	public boolean deleteApp(String appId) {
		boolean result = false;

		try {
			result = bs.deleteApp(appId);
			RunningEndView.deleteAppView(result, appId);
			Log.deleteView(result, appId);
		} catch (SQLException | NotExistException s) {
			s.printStackTrace();
			RunningEndView.showError("App ���� ���� �߻�");
		}

		return result;
	}

	public void start() {
		Log.welcome();
		start.start();
	}
}
