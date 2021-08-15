package building.view;

import java.util.ArrayList;

import building.model.dto.AppDTO;
import building.model.dto.BuildingDTO;
import building.model.dto.PriceDTO;
import building.model.dto.SellerDTO;

public class RunningEndView {

	// ��� ���� ���
	public static void AppListView(ArrayList allApp) {
		if (allApp != null) {
			int length = allApp.size(); // ����� ������ ���� ��ȯ

			if (length != 0) {
				for (int index = 0; index < length; index++) {
					System.out.println(allApp.get(index));
				}
			} else {
				System.out.println("��û�Ͻ� ������ �����ϴ�");
			}
		} else {
			System.out.println("��û�Ͻ� ������ �����ϴ�");
		}
	}

	// Region���� �˻��� ��� ���
	public static void allRegion(ArrayList<BuildingDTO> data) {
		if (data != null) {
			int length = data.size(); // ����� ������ ���� ��ȯ

			if (length != 0) {
				for (int index = 0; index < length; index++) {
					System.out.println(data.get(index));
				}
			} else {
				System.out.println("��û�Ͻ� ������ ���� ������ �����ϴ�");
			}
		} else {
			System.out.println("��û�Ͻ� ������ ���� ������ �����ϴ�");
		}
	}

	// Building Type�� �˻��� ��� ���
	public static void allBuildingType(ArrayList<BuildingDTO> data) {
		if (data != null) {
			int length = data.size(); // ����� ������ ���� ��ȯ

			if (length != 0) {
				for (int index = 0; index < length; index++) {
					System.out.println(data.get(index));
				}
			} else {
				System.out.println("��û�Ͻ� �ǹ� ������ ���� ������ �����ϴ�");
			}
		} else {
			System.out.println("��û�Ͻ� �ǹ� ������ ���� ������ �����ϴ�");
		}
	}

	// Ư�� App ���
	public static void AppView(AppDTO app) {
		if (app != null) {
			System.out.println(app);
		} else {
			System.out.println("�ش� App Id�� �����ϴ�");
		}
	}

	// Ư�� Building ���
	public static void BuildingView(BuildingDTO building) {
		if (building != null) {
			System.out.println(building);
		} else {
			System.out.println("�ش� Building Id�� �����ϴ�");
		}
	}

	// Ư�� Price ���
	public static void PriceView(PriceDTO price) {
		if (price != null) {
			System.out.println(price);
		} else {
			System.out.println("�ش� App Id�� �����ϴ�");
		}
	}

	// Ư�� Price ���
	public static void ComparePriceView(ArrayList<PriceDTO> price) {
		if (price != null) {
			int length = price.size(); // ����� ������ ���� ��ȯ

			if (length != 0) {
				for (int index = 0; index < length; index++) {
					System.out.println(price.get(index));
				}
			} else {
				System.out.println("�ش� ���ݴ��� �Ź��� ���� ������ �����ϴ�");
			}
		} else {
			System.out.println("�ش� ���ݴ��� �Ź��� �����ϴ�");
		}
	}

	// Ư�� Seller ���
	public static void SellerView(SellerDTO seller) {
		if (seller != null) {
			System.out.println(seller);
		} else {
			System.out.println("�ش� App Id�� �����ϴ�");
		}
	}

	// Buildingupdate ����, ���н� �޽��� ��� -
	public static void updateBuildingView(boolean result, String buildingId) {
		if (result == true) {
			System.out.println("\n��û�Ͻ� [Building Id : " + buildingId + "]�� �ǹ� ���� ���� �Ϸ�");
		} else {
			System.out.println("\n��û�Ͻ� [Building Id : " + buildingId + "] ���� ����, id ��Ȯ�� �ϼ���");
		}
	}

	// Priceupdate ����, ���н� �޽��� ��� -
	public static void updatePriceView(boolean result, String appId) {
		if (result == true) {
			System.out.println("\n��û�Ͻ� [App Id : " + appId + "]�� ���� ���� ���� �Ϸ�");
		} else {
			System.out.println("\n��û�Ͻ� [App Id : " + appId + "] ���� ����, id ��Ȯ�� �ϼ���");
		}
	}

	// Sellerupdate ����, ���н� �޽��� ��� -
	public static void updateSellerView(boolean result, String sellerId) {
		if (result == true) {
			System.out.println("\n��û�Ͻ� [Seller Id : " + sellerId + "]�� �Ǹ��� ���� ���� �Ϸ�");
		} else {
			System.out.println("\n��û�Ͻ� [Seller Id : " + sellerId + "] ���� ����, id ��Ȯ�� �ϼ���");
		}
	}

	// TradeTypeupdate ����, ���н� �޽��� ��� -
	public static void updateTradeTypeView(boolean result, String appId) {
		if (result == true) {
			System.out.println("\n��û�Ͻ� [App Id : " + appId + "]�� �ŷ� ���� ���� �Ϸ�");
		} else {
			System.out.println("\n��û�Ͻ� [App Id : " + appId + "] ���� ����, id ��Ȯ�� �ϼ���");
		}
	}

	// Tenantupdate ����, ���н� �޽��� ��� -
	public static void updateTenantView(boolean result, String appId) {
		if (result == true) {
			System.out.println("\n��û�Ͻ� [App Id : " + appId + "]�� ������ ���� ���� �Ϸ�");
		} else {
			System.out.println("\n��û�Ͻ� [App Id : " + appId + "] ���� ����, id ��Ȯ�� �ϼ���");
		}
	}

	// App insert ����, ���н� �޽��� ��� -
	public static void insertAppView(boolean result, String Id) {
		if (result == true) {
			System.out.println("\n��û�Ͻ� [App Id : " + Id + "] App insert �Ϸ�");
		} else {
			System.out.println("\n��û�Ͻ� [App Id : " + Id + "] App insert ����, id ��Ȯ�� �ϼ���");
		}
	}

	// Building insert ����, ���н� �޽��� ��� -
	public static void insertBuildingView(boolean result, String Id) {
		if (result == true) {
			System.out.println("\n��û�Ͻ� [Building Id : " + Id + "] Building insert �Ϸ�");
		} else {
			System.out.println("\n��û�Ͻ� [Building Id : " + Id + "] insert ����, id ��Ȯ�� �ϼ���");
		}
	}

	// Price insert ����, ���н� �޽��� ��� -
	public static void insertPriceView(boolean result, String Id) {
		if (result == true) {
			System.out.println("\n��û�Ͻ� [App id : " + Id + "] Price insert �Ϸ�");
		} else {
			System.out.println("\n��û�Ͻ� [App id : " + Id + "] insert ����, id ��Ȯ�� �ϼ���");
		}
	}

	// Seller insert ����, ���н� �޽��� ��� -
	public static void insertSellerView(boolean result, String Id) {
		if (result == true) {
			System.out.println("\n��û�Ͻ� [Seller Id : " + Id + "] Seller insert �Ϸ�");
		} else {
			System.out.println("\n��û�Ͻ� [Seller Id : " + Id + "] Seller ����, id ��Ȯ�� �ϼ���");
		}
	}

	// App delete ����, ���н� �޽��� ��� -
	public static void deleteAppView(boolean result, String Id) {
		if (result == true) {
			System.out.println("\n��û�Ͻ� [App Id : " + Id + "] App delete �Ϸ�");
		} else {
			System.out.println("\n��û�Ͻ� [App Id : " + Id + "] App delete ����, id ��Ȯ�� �ϼ���");
		}
	}

	// Seller delete ����, ���н� �޽��� ��� -
	public static void deleteSellerView(boolean result, String Id) {
		if (result == true) {
			System.out.println("\n��û�Ͻ� [Seller Id : " + Id + "] Seller delete �Ϸ�");
		} else {
			System.out.println("\n��û�Ͻ� [Seller Id : " + Id + "] Seller delete ����, id ��Ȯ�� �ϼ���");
		}
	}

	// ���� ��Ȳ ���
	public static void showError(String message) {
		System.out.println(message);
	}
}
