package building.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import building.controller.BuildingController;
import building.model.dto.AppDTO;
import building.model.dto.BuildingDTO;
import building.model.dto.PriceDTO;
import building.model.dto.SellerDTO;
import log4j.Log;

public class start {
	
	private static BuildingController bc = BuildingController.getInstance();
	

	public static void start() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = null;
		boolean triger = true;
		
		System.out.println("������ ���Ű� ȯ���մϴ�");
		System.out.print("����� �̸��� �����ּ��� : ");
		try {
			name = br.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		Log.inputName(name);

		try {
			while (triger) {
				System.out.println("============================== �޴��� �������ּ���. ============================== ");
				System.out.println(
						"1. �˻�            2. �߰�            3. ����            4. ����            5.�α�            0.����");
				int inputNum = Integer.parseInt(br.readLine());

				if (inputNum == 1) {
					System.out.println("============================================================");
					System.out.println("1. �Ź�����            2. �ǹ�����            3. ��������            4. �Ǹ�������");
					int search = Integer.parseInt(br.readLine());

					if (search == 1) {
						System.out.println("============================================================");
						System.out.println("1. ���Ź�            2. AppId �˻�");
						int app = Integer.parseInt(br.readLine());

						if (app == 1) {
							System.out.println();
							bc.getAllApp();
							System.out.println();
						} else if (app == 2) {
							System.out.println("============================================================");
							System.out.print("AppId�� �Է����ּ��� : ");
							String appId = br.readLine();

							System.out.println();
							bc.getAppId(appId);
							System.out.println();
						} else {
							System.out.println("�߸� �Է��ϼ̽��ϴ�");
						}
					} else if (search == 2) {
						System.out.println("============================================================");
						System.out
								.println("1. ���ǹ�            2. BuildingId �˻�            3.���� �˻�            4.�Ź����� �˻�");
						int building = Integer.parseInt(br.readLine());

						if (building == 1) {
							System.out.println();
							bc.getAllBuilding();
							System.out.println();
						} else if (building == 2) {
							System.out.println("============================================================");
							System.out.print("BuildingId�� �Է����ּ��� : ");
							String buildingId = br.readLine();

							System.out.println();
							bc.getBuildingId(buildingId);
							System.out.println();
						} else if (building == 3) {
							System.out.println("============================================================");
							System.out.print("������ �Է����ּ��� : ");
							String region = br.readLine();

							System.out.println();
							bc.getRegion(region);
							System.out.println();
						} else if (building == 4) {
							System.out.println("============================================================");
							System.out.print("�Ź������� �Է����ּ���(����, ���ǽ���, ��������) : ");
							String type = br.readLine();

							System.out.println();
							bc.getBuildingType(type);
							System.out.println();
						} else {
							System.out.println("�߸� �Է��ϼ̽��ϴ�");
						}
					} else if (search == 3) {
						System.out.println("============================================================");
						System.out.println("1. AppId �˻�            2. ���ϴ� ���ݴ� �˻�");
						int price = Integer.parseInt(br.readLine());

						if (price == 1) {
							System.out.println("============================================================");
							System.out.print("AppId�� �Է����ּ��� : ");
							String appId = br.readLine();

							System.out.println();
							bc.getPrice(appId);
							System.out.println();
						} else if (price == 2) {
							System.out.println("============================================================");
							System.out.print("���ϴ� ���� ������ �Է����ּ���(����, ������, �ŸŰ�) : ");
							String type = br.readLine();
							System.out.print("�ּ� ������ �Է����ּ���(����:����) : ");
							int min = Integer.parseInt(br.readLine());
							System.out.print("�ִ� ������ �Է����ּ���(����:����) : ");
							int max = Integer.parseInt(br.readLine());

							System.out.println();
							bc.getComeparePrice(type, min, max);
							System.out.println();
						} else {
							System.out.println("�߸� �Է��ϼ̽��ϴ�");
						}
					} else if (search == 4) {
						System.out.println("============================================================");
						System.out.println("1. ����Ǹ���            2. SellerId �˻�");
						int seller = Integer.parseInt(br.readLine());

						if (seller == 1) {
							bc.getAllSeller();
						} else if (seller == 2) {
							System.out.println("============================================================");
							System.out.print("SellerId�� �Է����ּ��� : ");
							String sellerId = br.readLine();

							System.out.println();
							bc.getSellerId(sellerId);
							System.out.println();
						} else {
							System.out.println("�߸� �Է��ϼ̽��ϴ�");
						}
					} else {
						System.out.println("�߸� �Է��ϼ̽��ϴ�");
					}
				} else if (inputNum == 2) {
					System.out.println("============================================================");
					System.out.println("1. �Ź�            2. �Ǹ���");
					int insert = Integer.parseInt(br.readLine());

					if (insert == 1) {
						int trade_price = 0;
						int deposit = 0;
						int monthly_rent = 0;
						String trade_type = null;
						
						System.out.println("============================================================");
						System.out.print("�߰��� Building Id�� �Է����ּ��� : ");
						String buildingId = br.readLine();
						
						boolean result = bc.getBuildingIdStart(buildingId);
						
						if(result != true) {
							System.out.print("�߰��� �ǹ��� ������ �Է����ּ��� : ");
							String region = br.readLine();
							System.out.print("�߰��� �ǹ��� �ּҸ� �Է����ּ��� : ");
							String address = br.readLine();
							System.out.print("�߰��� �ǹ��� ������ �Է����ּ���(����, ���ǽ���, ��������) : ");
							String type = br.readLine();
							System.out.print("�߰��� App Id�� �Է����ּ��� : ");
							String appId = br.readLine();
							
							boolean result2 = bc.getAppIdStart(appId);
							
							if(result2 != true) {
								System.out.print("�߰��� �Ź� ������ �Է����ּ���(����, ����, �Ÿ�) : ");
								trade_type = br.readLine();
								
								if(trade_type.equals("����")) {
									System.out.print("�߰��� �ǹ��� �������� �׼��� �Է����ּ���(����:����) : ");
									deposit = Integer.parseInt(br.readLine());
									System.out.print("�߰��� �ǹ��� ������ �׼� �Է����ּ���(����:����) : ");
									monthly_rent = Integer.parseInt(br.readLine());	
								}else if(trade_type.equals("����")) {
									System.out.print("�߰��� �ǹ��� �������� �׼��� �Է����ּ���(����:����) : ");
									deposit = Integer.parseInt(br.readLine());
								}else if(trade_type.equals("�Ÿ�")) {
									System.out.print("�߰��� �ǹ��� �ŸŰ��� �׼��� �Է����ּ���(����:����) : ");
									trade_price = Integer.parseInt(br.readLine());
								}else {
									System.out.println("�������� �ʴ� �Ź� �����Դϴ�");
								}
								
								System.out.print("�߰��� Seller Id�� �Է����ּ��� : ");
								String sellerId = br.readLine();
								
								System.out.print("�߰��� ������ ���θ� �Է����ּ���(TRUE or FALSE) : ");
								String tenant = br.readLine();
		
								BuildingDTO building = new BuildingDTO(buildingId, region, address, type);
								PriceDTO price = new PriceDTO(appId, deposit, monthly_rent, trade_price);
								AppDTO app = new AppDTO(appId, buildingId, trade_type, sellerId, tenant);
		
								System.out.println();
								bc.addBuilding(building);
								bc.addPrice(price);
								bc.addApp(app);
								System.out.println();
							}else {
								System.out.println("�ش� App Id�� �̹� �ִ� Id�Դϴ�");
							}
						}else {
							System.out.println("�ش� Building Id�� �̹� �ִ� Id�Դϴ�");
						}
					} else if (insert == 2) {
						System.out.println("============================================================");
						System.out.print("�߰��� Seller Id�� �Է����ּ��� : ");
						String sellerId = br.readLine();
						
						boolean result = bc.getSellerIdStart(sellerId);
						
						if(result != true) {
							System.out.print("�߰��� �Ǹ��� �̸��� �Է����ּ��� : ");
							String sellerName = br.readLine();
							System.out.print("�߰��� �Ǹ��� �޴��� ��ȣ�� �Է����ּ��� : ");
							String phone = br.readLine();
	
							SellerDTO seller = new SellerDTO(sellerId, sellerName, phone);
	
							System.out.println();
							bc.addSeller(seller);
							System.out.println();
						}else {
							System.out.println("�ش� Seller Id�� �̹� �ִ� Id�Դϴ�");
						}
					} else {
						System.out.println("�߸� �Է��ϼ̽��ϴ�");
					}
				} else if (inputNum == 3) {
					System.out.println("============================================================");
					System.out.println("1. �Ź�            2. �ǹ�            3. ����            4.�Ǹ���");
					int update = Integer.parseInt(br.readLine());

					if (update == 1) {
						System.out.println("============================================================");
						System.out.print("������ App Id�� �Է����ּ��� : ");
						String appId = br.readLine();

						boolean result = bc.getAppIdStart(appId);

						if (result == true) {
							System.out.println("\n1. �Ź� ����            2. ������ ����            3. �Ź� ������ ������ ����");
							int app = Integer.parseInt(br.readLine());

							if (app == 1) {
								System.out.println("============================================================");
								System.out.print("������ �Ź� ������ �Է����ּ���(����, ����, �Ÿ�) : ");
								String trade_type = br.readLine();

								System.out.println();
								bc.updateAppTradeType(appId, trade_type);
								System.out.println();
							} else if (app == 2) {
								System.out.println("============================================================");
								System.out.print("������ ������ ���θ� �Է����ּ���(TRUE or FALSE) : ");
								String tenant = br.readLine();

								bc.updateAppTenant(appId, tenant);
							} else if (app == 3) {
								System.out.println("============================================================");
								System.out.print("������ �Ź� ������ �Է����ּ���(����, ����, �Ÿ�) : ");
								String trade_type = br.readLine();
								System.out.print("������ ������ ���θ� �Է����ּ���(TRUE or FALSE) : ");
								String tenant = br.readLine();

								System.out.println();
								bc.updateAppTradeType(appId, trade_type);
								bc.updateAppTenant(appId, tenant);
								System.out.println();
							} else {
								System.out.println("�߸� �Է��ϼ̽��ϴ�");
							}
						} else {
							System.out.println();
							System.out.println("�ش� App Id�� �����ϴ�");
						}
					} else if (update == 2) {
						System.out.println("============================================================");
						System.out.print("������ Building Id�� �Է����ּ��� : ");
						String buildingId = br.readLine();

						boolean result = bc.getBuildingIdStart(buildingId);

						if (result == true) {
							System.out.print("������ �ǹ��� ������ �Է����ּ��� : ");
							String region = br.readLine();
							System.out.print("������ �ǹ��� �ּҸ� �Է����ּ��� : ");
							String address = br.readLine();
							System.out.print("������ �ǹ��� ������ �Է����ּ���(����, ���ǽ���, ��������) : ");
							String type = br.readLine();

							System.out.println();
							bc.updateBuilding(buildingId, region, address, type);
							System.out.println();
						} else {
							System.out.println();
							System.out.println("�ش� Building Id�� �����ϴ�");
						}
					} else if (update == 3) {
						System.out.println("============================================================");
						System.out.print("������ App Id�� �Է����ּ��� : ");
						String appId = br.readLine();

						boolean result = bc.getAppIdPriceStart(appId);

						if (result == true) {
							System.out.print("������ �������� �׼��� �Է����ּ���(����:����) : ");
							int deposit = Integer.parseInt(br.readLine());
							System.out.print("������ ������ �׼��� �Է����ּ���(����:����) : ");
							int monthly_rent = Integer.parseInt(br.readLine());
							System.out.print("������ �ŸŰ��� �׼��� �Է����ּ���(����:����) : ");
							int trade_price = Integer.parseInt(br.readLine());

							System.out.println();
							bc.updatePrice(appId, deposit, monthly_rent, trade_price);
							System.out.println();
						} else {
							System.out.println();
							System.out.println("�ش� App Id�� �����ϴ�");
						}
					} else if (update == 4) {
						System.out.println("============================================================");
						System.out.print("������ Seller Id�� �Է����ּ��� : ");
						String sellerId = br.readLine();

						boolean result = bc.getSellerIdStart(sellerId);

						if (result == true) {
							System.out.print("������ �Ǹ����� �̸��� �Է����ּ��� : ");
							String sellerName = br.readLine();
							System.out.print("������ �Ǹ����� �޴��� ��ȣ�� �Է����ּ��� : ");
							String phone = br.readLine();

							System.out.println();
							bc.updateSeller(sellerId, sellerName, phone);
							System.out.println();
						} else {
							System.out.println();
							System.out.println("�ش� Seller Id�� �����ϴ�");
						}
					} else {
						System.out.println("�߸� �Է��ϼ̽��ϴ�");
					}

				} else if (inputNum == 4) {
					System.out.println("============================================================");
					System.out.println("1. �Ź�            2. �Ǹ���");
					int delete = Integer.parseInt(br.readLine());

					if (delete == 1) {
						System.out.println("============================================================");
						System.out.print("������ App Id�� �Է����ּ��� : ");
						String appId = br.readLine();

						boolean result = bc.getAppIdStart(appId);
						if (result == true) {
							System.out.print("������ Building Id�� �Է����ּ��� : ");
							String buildingId = br.readLine();

							boolean result2 = bc.getBuildingIdStart(buildingId);

							if (result2 == true) {
								System.out.println();
								bc.deleteApp(appId);
								bc.deleteBuilding(buildingId);
								bc.deletePrice(appId);
								System.out.println();
							} else {
								System.out.println();
								System.out.println("�ش� Building Id�� �����ϴ�");
							}
						} else {
							System.out.println();
							System.out.println("�ش� App Id�� �����ϴ�");
						}
					} else if (delete == 2) {
						System.out.println("============================================================");
						System.out.print("������ Seller Id�� �Է����ּ��� : ");
						String sellerId = br.readLine();

						boolean result = bc.getSellerIdStart(sellerId);

						if (result == true) {
							System.out.println();
							bc.deleteSeller(sellerId);
							System.out.println();
						} else {
							System.out.println();
							System.out.println("�ش� Seller Id�� �����ϴ�");
						}
					} else {
						System.out.println("�߸� �Է��ϼ̽��ϴ�");
					}
				} else if (inputNum == 5) {
					File file = new File("C:\\20210628_lab\\88.log\\Building.log");
					BufferedReader bfr = new BufferedReader(new FileReader(file));
					try {
						String line = null;
						System.out.println("============================================================");
						while ((line = bfr.readLine()) != null) {
							System.out.println(line);
						}
						System.out.println();

					} catch (FileNotFoundException e) {
						e.getStackTrace();
					} catch (IOException e) {
						e.getStackTrace();
					} finally {
						try {
							bfr.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				} else if (inputNum == 0) {
					System.out.println("�ȳ��� ������! ���� �÷��� �����մϴ�.");
					Log.serviceClose(name);
					triger = false;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
