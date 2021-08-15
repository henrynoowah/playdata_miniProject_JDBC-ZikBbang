package log4j;

import org.apache.log4j.Logger;

public class Log {
	static Logger logger = Logger.getLogger("log4.Log");
	
	// ���� ����
	public static void welcome() {
		logger.info("���� ����");
	}
	
	// �̸� �Է�
	public static void inputName(String name) {
		logger.info(name + "���� �����̽��ϴ�");
	}
	
	// ȸ������ ����
	public static void register(String newNickName) {
		logger.info(newNickName + "ȸ�����Լ���");
	}
	
	// ���� ����
	public static void serviceClose(String name) {
		logger.info(name + "���� ���񽺸� �����ϼ̽��ϴ�");
	}
	
	// �˻� - ��� �Ź�
	public static void seachAllApp() {
		logger.info("��� �Ź��� �˻��Ͽ����ϴ�");
	}
	
	// �˻� - ��� �ǹ�
	public static void seachAllBuilding() {
		logger.info("��� �ǹ��� �˻��Ͽ����ϴ�");
	}
	
	// �˻� - ��� ����
	public static void seachAllPrice() {
		logger.info("��� ������ �˻��Ͽ����ϴ�");
	}
	
	// �˻� - ��� �Ǹ���
	public static void seachAllSeller() {
		logger.info("��� �Ǹ��ڸ� �˻��Ͽ����ϴ�");
	}
	
	// App Id�� �Ź� �˻�
	public static void seachApp() {
		logger.info("App Id�� �Ź��� �˻��Ͽ����ϴ�");
	}
	
	// Building Id�� �Ź� �˻�
	public static void seachBuilding() {
		logger.info("Building Id�� �ǹ��� �˻��Ͽ����ϴ�");
	}
	
	// �������� �Ź� �˻�
	public static void seachRegion() {
		logger.info("�������� �ǹ��� �˻��Ͽ����ϴ�");
	}
	
	// �ǹ� �������� �Ź� �˻�
	public static void seachBuildingType() {
		logger.info("�ǹ� �������� �ǹ��� �˻��Ͽ����ϴ�");
	}
		
	// App Id�� �Ź� �˻�
	public static void seachPrice() {
		logger.info("App Id�� ������ �˻��Ͽ����ϴ�");
	}
	
	// App Id�� �Ź� �˻�
	public static void seachCompare(String type, int min, int max) {
		logger.info(min + " ~ " + max + "����(���� : ����)�� " + type + "��(��) �˻��Ͽ����ϴ�");
	}
	
	// Seller Id�� �Ź� �˻�
	public static void seachSeller() {
		logger.info("Seller Id�� �Ǹ��ڸ� �˻��Ͽ����ϴ�");
	}

	// Buildingupdate ����, ���н� �޽��� ��� -
	public static void updateBuildingView(boolean result, String buildingId) {
		if (result == true) {
			logger.info("��û�Ͻ� [Building Id : " + buildingId + "] region, address, building_type ���� �Ϸ�");
		}
	}

	// Priceupdate ����, ���н� �޽��� ��� -
	public static void updatePriceView(boolean result, String appId) {
		if (result == true) {
			logger.info("��û�Ͻ� [������ȣ : " + appId + "] deposit, monthly_rent, trade_price ���� �Ϸ�");
		}
	}

	// Sellerupdate ����, ���н� �޽��� ��� -
	public static void updateSellerView(boolean result, String sellerId) {
		if (result == true) {
			logger.info("��û�Ͻ� [Seller Id : " + sellerId + "] name, phone ���� �Ϸ�");
		}
	}

	// TradeTypeupdate ����, ���н� �޽��� ��� -
	public static void updateTradeTypeView(boolean result, String appId) {
		if (result == true) {
			logger.info("��û�Ͻ� [������ȣ : " + appId + "] trade_type ���� �Ϸ�");
		}
	}

	// Tenantupdate ����, ���н� �޽��� ��� -
	public static void updateTenantView(boolean result, String appId) {
		if (result == true) {
			logger.info("��û�Ͻ� [������ȣ : " + appId + "] tenant ���� �Ϸ�");
		}
	}

	// insert ����, ���н� �޽��� ��� -
	public static void insertView(boolean result, String Id) {
		if (result == true) {
			logger.info("��û�Ͻ� [������ȣ : " + Id + "] insert �Ϸ�");
		}
	}

	// delete ����, ���н� �޽��� ��� -
	public static void deleteView(boolean result, String Id) {
		if (result == true) {
			logger.info("��û�Ͻ� [������ȣ : " + Id + "] delete �Ϸ�");
		}
	}

}
