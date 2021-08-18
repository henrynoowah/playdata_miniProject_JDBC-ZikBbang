package building.controller;

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

public class Start {
	
	static BuildingController bc = BuildingController.getInstance();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean trigger = false;
	static boolean loggedIn = false;
	static String nickName;
	static String pw;
	static int inputNum;
	
	public static void mainPage() {
		trigger = true;
		System.out.println("\n==================================== �޴��� �������ּ���. =======================================");
		System.out.println("1. �˻�            2. �߰�            3. ����            4. ����            5.�α�		6.�α׾ƿ�            0.����");
	}
	
	public static void loggedInPage() {
		try {
			while (trigger) {
				
				boolean checkSeller = bc.checkProfile(nickName, pw);
				
				mainPage();
				
				inputNum = Integer.parseInt(br.readLine());

				if (inputNum == 1) {
					System.out.println("\n============================================================");
					System.out.println("1. �Ź�����            2. �ǹ�����            3. ��������            4. �Ǹ�������");
					int search = Integer.parseInt(br.readLine());

					if (search == 1) {
						System.out.println("\n============================================================");
						System.out.println("1. ���Ź�            2. AppId �˻�");
						int app = Integer.parseInt(br.readLine());

						if (app == 1) {
							System.out.println();
							bc.getAllApp();
						} else if (app == 2) {
							System.out.println("\n============================================================");
							System.out.print("AppId�� �Է����ּ��� : ");
							String appId = br.readLine();

							System.out.println();
							bc.getAppId(appId);
						} else {
							System.out.println("\n�߸� �Է��ϼ̽��ϴ�");
						}
					} else if (search == 2) {
						System.out.println("\n============================================================");
						System.out
								.println("1. ���ǹ�            2. BuildingId �˻�            3.���� �˻�            4.�Ź����� �˻�");
						int building = Integer.parseInt(br.readLine());

						if (building == 1) {
							System.out.println();
							bc.getAllBuilding();
						} else if (building == 2) {
							System.out.println("\n============================================================");
							System.out.print("BuildingId�� �Է����ּ��� : ");
							String buildingId = br.readLine();

							System.out.println();
							bc.getBuildingId(buildingId);
						} else if (building == 3) {
							System.out.println("\n============================================================");
							System.out.print("������ �Է����ּ��� : ");
							String region = br.readLine();

							System.out.println();
							bc.getRegion(region);
						} else if (building == 4) {
							System.out.println("\n============================================================");
							System.out.print("�Ź������� �Է����ּ���(����, ���ǽ���, ��������) : ");
							String type = br.readLine();

							System.out.println();
							bc.getBuildingType(type);
						} else {
							System.out.println("/n�߸� �Է��ϼ̽��ϴ�");
						}
					} else if (search == 3) {
						System.out.println("\n============================================================");
						System.out.println("1. ��簡��            2. AppId �˻�            3. ���ϴ� ���ݴ� �˻�");
						int price = Integer.parseInt(br.readLine());

						if (price == 1) {
							System.out.println();
							bc.getAllPrice();
						} else if (price == 2) {
							System.out.println("\n============================================================");
							System.out.print("AppId�� �Է����ּ��� : ");
							String appId = br.readLine();

							System.out.println();
							bc.getPrice(appId);
						} else if (price == 3) {
							System.out.println("\n============================================================");
							System.out.print("���ϴ� ���� ������ �Է����ּ���(����, ������, �ŸŰ�) : ");
							String type = br.readLine();
							System.out.print("�ּ� ������ �Է����ּ���(����:����) : ");
							int min = Integer.parseInt(br.readLine());
							System.out.print("�ִ� ������ �Է����ּ���(����:����) : ");
							int max = Integer.parseInt(br.readLine());

							System.out.println();
							bc.getComeparePrice(type, min, max);
						} else {
							System.out.println("\n�߸� �Է��ϼ̽��ϴ�");
						}
					} else if (search == 4) {
						System.out.println("\n============================================================");
						System.out.println("1. ����Ǹ���            2. SellerId �˻�");
						int seller = Integer.parseInt(br.readLine());

						if (seller == 1) {
							bc.getAllSeller();
						} else if (seller == 2) {
							System.out.println("\n============================================================");
							System.out.print("SellerId�� �Է����ּ��� : ");
							String sellerId = br.readLine();

							System.out.println();
							bc.getSellerId(sellerId);
						} else {
							System.out.println("\n�߸� �Է��ϼ̽��ϴ�");
						}
					} else {
						System.out.println("\n�߸� �Է��ϼ̽��ϴ�");
					}
				} else if (inputNum == 2) {			
					System.out.println("\n============================================================");
					System.out.println("1. �Ź�            2. �Ǹ���");
					int insert = Integer.parseInt(br.readLine());
								
					if (insert == 1) {
						if(!(checkSeller)) {
							System.out.println("����� �y���ڰ� �ƴմϴ�");
							loggedInPage();
						} else {
							int trade_price = 0;
							int deposit = 0;
							int monthly_rent = 0;

							System.out.println("\n============================================================");
							System.out.print("�߰��� Building Id�� �Է����ּ��� : ");
							String buildingId = br.readLine();

							boolean result = bc.getBuildingIdStart(buildingId);

							if (result != true) {
								System.out.print("�߰��� �ǹ��� ������ �Է����ּ��� : ");
								String region = br.readLine();
								System.out.print("�߰��� �ǹ��� �ּҸ� �Է����ּ��� : ");
								String address = br.readLine();
								System.out.print("�߰��� �ǹ��� ������ �Է����ּ���(����, ���ǽ���, ��������) : ");
								String type = br.readLine();
								System.out.print("�߰��� App Id�� �Է����ּ��� : ");
								String appId = br.readLine();

								boolean result2 = bc.getAppIdStart(appId);

								if (result2 != true) {
									System.out.print("�߰��� �Ź� ������ �Է����ּ���(����, ����, �Ÿ�) : ");
									String trade_type = br.readLine();

									if(trade_type.equals("����") || trade_type.equals("����") || trade_type.equals("�Ÿ�")) {
										if (trade_type.equals("����")) {
											System.out.print("�߰��� �ǹ��� �������� �׼��� �Է����ּ���(����:����) : ");
											deposit = Integer.parseInt(br.readLine());
											System.out.print("�߰��� �ǹ��� ������ �׼� �Է����ּ���(����:����) : ");
											monthly_rent = Integer.parseInt(br.readLine());
										} else if (trade_type.equals("����")) {
											System.out.print("�߰��� �ǹ��� �������� �׼��� �Է����ּ���(����:����) : ");
											deposit = Integer.parseInt(br.readLine());
										} else if (trade_type.equals("�Ÿ�")) {
											System.out.print("�߰��� �ǹ��� �ŸŰ��� �׼��� �Է����ּ���(����:����) : ");
											trade_price = Integer.parseInt(br.readLine());
										}
										
										System.out.print("�߰��� Seller Id�� �Է����ּ��� : ");
										String sellerId = br.readLine();
										
										boolean result3 = bc.getSellerIdStart(sellerId);
										
										if(result3 == true) {
											System.out.print("�߰��� ������ ���θ� �Է����ּ���(TRUE or FALSE) : ");
											String tenant = br.readLine();
																						
											BuildingDTO building = BuildingDTO.builder().buildingID(buildingId)
																						.region(region).address(address)
																						.buildingType(type).build();
											
											PriceDTO price = PriceDTO.builder().appID(appId)
																	 .deposit(deposit)
																	 .monthlyRent(monthly_rent)
																	 .tradePrice(trade_price).build();
											
											AppDTO app = AppDTO.builder().appID(appId)
																		 .buildingID(buildingId)
																		 .tradeType(trade_type)
																		 .sellerID(sellerId)
																		 .tenant(tenant).build();

											System.out.println();
//											bc.addApp(app, building, price);
										}else {
											System.out.println("\n�ش� Seller Id�� �������� �ʽ��ϴ�");
										}
									} else {
										System.out.println("�������� �ʴ� �Ź� �����Դϴ�");
									}
								} else {
									System.out.println("\n�ش� App Id�� �̹� �ִ� Id�Դϴ�");
								}
							} else {
								System.out.println("\n�ش� Building Id�� �̹� �ִ� Id�Դϴ�");
							}
						}
										
					} else if (insert == 2) {
						System.out.println("\n============================================================");
						System.out.print("����� Seller Id�� �Է����ּ��� : ");
						String sellerId = br.readLine();

						boolean result = bc.getSellerIdStart(sellerId);

						if (!result) {
							System.out.print("�߰��� �Ǹ��� �̸��� �Է����ּ��� : ");
							String sellerName = br.readLine();
							System.out.print("�߰��� �Ǹ��� �޴��� ��ȣ�� �Է����ּ��� : ");
							String phone = br.readLine();
							
							SellerDTO seller = SellerDTO.builder().sellerID(sellerId)
																  .name(sellerName)
																  .phone(phone).build();

							System.out.println();
							bc.addSeller(seller);
							bc.addProfileSeller(nickName, sellerId);
							
						} else {
							System.out.println("\n�ش� Seller Id�� �̹� �ִ� Id�Դϴ�");
						}
					} else {
						System.out.println("�߸� �Է��ϼ̽��ϴ�");
					}	
				} else if (inputNum == 3) {
					if(!(checkSeller)) {
						System.out.println("����� �y���ڰ� �ƴմϴ�");
						loggedInPage();
					} else {
						System.out.println("\n============================================================");
						System.out.println("1. �Ź�            2. �ǹ�            3. ����            4.�Ǹ���");
						int update = Integer.parseInt(br.readLine());

						if (update == 1) {
							System.out.println("\n============================================================");
							System.out.print("������ App Id�� �Է����ּ��� : ");
							String appId = br.readLine();

							boolean result = bc.getAppIdStart(appId);

							if (result == true) {
								System.out.println("\n1. �Ź� ����            2. ������ ����            3. �Ź� ������ ������ ����");
								int app = Integer.parseInt(br.readLine());

								if (app == 1) {
									System.out.println("\n============================================================");
									System.out.print("������ �Ź� ������ �Է����ּ���(����, ����, �Ÿ�) : ");
									String trade_type = br.readLine();

									int deposit = 0;
									int monthly_rent = 0;
									int trade_price = 0;

									if(trade_type.equals("����") || trade_type.equals("����") || trade_type.equals("�Ÿ�")) {
										if (trade_type.equals("����")) {
											System.out.print("������ �ǹ��� �������� �׼��� �Է����ּ���(����:����) : ");
											deposit = Integer.parseInt(br.readLine());
											System.out.print("������ �ǹ��� ������ �׼� �Է����ּ���(����:����) : ");
											monthly_rent = Integer.parseInt(br.readLine());
										} else if (trade_type.equals("����")) {
											System.out.print("������ �ǹ��� �������� �׼��� �Է����ּ���(����:����) : ");
											deposit = Integer.parseInt(br.readLine());
										} else if (trade_type.equals("�Ÿ�")) {
											System.out.print("������ �ǹ��� �ŸŰ��� �׼��� �Է����ּ���(����:����) : ");
											trade_price = Integer.parseInt(br.readLine());
										} 
										
										System.out.println();
										bc.updateAppTradeType(appId, trade_type);
										bc.updatePrice(appId, deposit, monthly_rent, trade_price);
									}else {
										System.out.println("\n�������� �ʴ� �Ź� �����Դϴ�");
									}
								} else if (app == 2) {
									System.out.println("\n============================================================");
									System.out.print("������ ������ ���θ� �Է����ּ���(TRUE or FALSE) : ");
									String tenant = br.readLine();
									
									if(tenant.equals("TRUE") || tenant.equals("FALSE")) {
										bc.updateAppTenant(appId, tenant);
									}else {
										System.out.println("\nTRUE �Ǵ� FALSE�� �Է��� �����մϴ�");
									}
								} else if (app == 3) {
									System.out.println("\n============================================================");
									System.out.print("������ �Ź� ������ �Է����ּ���(����, ����, �Ÿ�) : ");
									String trade_type = br.readLine();
									System.out.print("������ ������ ���θ� �Է����ּ���(TRUE or FALSE) : ");
									String tenant = br.readLine();

									System.out.println();
									bc.updateAppTradeType(appId, trade_type);
									bc.updateAppTenant(appId, tenant);
								} else {
									System.out.println("\n�߸� �Է��ϼ̽��ϴ�");
								}
							} else {
								System.out.println("\n�ش� App Id�� �����ϴ�");
							}
						} else if (update == 2) {
							System.out.println("\n============================================================");
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
							} else {
								System.out.println("\n�ش� Building Id�� �����ϴ�");
							}
						} else if (update == 3) {
							System.out.println("\n============================================================");
							System.out.print("������ App Id�� �Է����ּ��� : ");
							String appId = br.readLine();

							boolean result = bc.getAppIdPriceStart(appId);

							if (result == true) {
								int deposit = 0;
								int monthly_rent = 0;
								int trade_price = 0;
								String trade_type = bc.getAppIdContent(appId).getTradeType();

								System.out.println("�ش� App Id�� ���� ������ " + trade_type + "�Դϴ�");

								if(trade_type.equals("����") || trade_type.equals("����") || trade_type.equals("�Ÿ�")) {
									if (trade_type.equals("����")) {
										System.out.print("������ �ǹ��� �������� �׼��� �Է����ּ���(����:����) : ");
										deposit = Integer.parseInt(br.readLine());
										System.out.print("������ �ǹ��� ������ �׼� �Է����ּ���(����:����) : ");
										monthly_rent = Integer.parseInt(br.readLine());
									} else if (trade_type.equals("����")) {
										System.out.print("������ �ǹ��� �������� �׼��� �Է����ּ���(����:����) : ");
										deposit = Integer.parseInt(br.readLine());
									} else if (trade_type.equals("�Ÿ�")) {
										System.out.print("������ �ǹ��� �ŸŰ��� �׼��� �Է����ּ���(����:����) : ");
										trade_price = Integer.parseInt(br.readLine());
									} 
									
									System.out.println();
									bc.updatePrice(appId, deposit, monthly_rent, trade_price);
								}else {
									System.out.println("\n�������� �ʴ� �Ź� �����Դϴ�");
								}
							} else {
								System.out.println("\n�ش� App Id�� �����ϴ�");
							}
						} else if (update == 4) {
							System.out.println("\n============================================================");
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
							} else {
								System.out.println();
								System.out.println("\n�ش� Seller Id�� �����ϴ�");
							}
						} else {
							System.out.println("\n�߸� �Է��ϼ̽��ϴ�");
						}
					}
				} else if (inputNum == 4) {
					if(!(checkSeller)) {
						System.out.println("����� �y���ڰ� �ƴմϴ�");
						loggedInPage();
					} else {
						System.out.println("\n============================================================");
						System.out.println("1. �Ź�            2. �Ǹ���");
						int delete = Integer.parseInt(br.readLine());

						if (delete == 1) {
							System.out.println("\n============================================================");
							System.out.print("������ App Id�� �Է����ּ��� : ");
							String appId = br.readLine();

							boolean result = bc.getAppIdStart(appId);
							if (result == true) {
								System.out.println();
								bc.deleteApp(appId);
							} else {
								System.out.println("\n�ش� App Id�� �����ϴ�");
							}
						} else if (delete == 2) {
							System.out.println("\n============================================================");
							System.out.print("������ Seller Id�� �Է����ּ��� : ");
							String sellerId = br.readLine();

							boolean result = bc.getSellerIdStart(sellerId);

							if (result == true) {
								System.out.println();
								bc.deleteSeller(sellerId);
							} else {
								System.out.println("\n�ش� Seller Id�� �����ϴ�");
							}
						} else {
							System.out.println("\n�߸� �Է��ϼ̽��ϴ�");
						}
					}				
				} else if (inputNum == 5) {
					File file = new File("C:\\20210628_lab\\88.log\\Building.log");
					BufferedReader bfr = new BufferedReader(new FileReader(file));
					try {
						String line = null;
						System.out.println("\n============================================================");
						while ((line = bfr.readLine()) != null) {
							System.out.println(line);
						}

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
				} else if(inputNum == 6) {
					System.out.println("\n�ȳ���������! �α׾ƿ��մϴ�.\n");
//					Log.logOut(nickName);
					trigger = false;
					start();
					
				} else if (inputNum == 0) {
					System.out.println("\n�ȳ��� ������! ���� �÷��� �����մϴ�.");
					Log.serviceClose(nickName);
					trigger = false;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
					br = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
	public static void loginPage() {
		
		nickName = null;
		pw = null;
		trigger = false;
		
		System.out.print("�г����� �����ּ��� : ");
		try {
			nickName = br.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.print("��й�ȣ�� �����ּ��� : ");
		try {
			pw = br.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		loggedIn = bc.logIn(nickName, pw);

		Log.inputName(nickName);
		
		if(!(loggedIn)) {
			System.out.println("\n���� �����Դϴ�\n");
			start();
		} else {
			trigger = true;
			Log.inputName(nickName);
			System.out.println("\nWelcome " + nickName + "!\n");
			loggedInPage();
		}
	}
	
	private static void registerPage() {
		
		String newNickName = null;
		String newPw = null;
		
		System.out.println("ȸ������");
		System.out.println("\n============================================================");
		System.out.print("�г����� �Է��ϼ��� : ");
		try {
			newNickName = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print("��й�ȣ�� �Է��ϼ��� : ");
		try {
			newPw = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		boolean register = bc.register(newNickName, newPw);
		
		if(register) {
			System.out.println("ȸ������ ����! �α����մϴ�");
			Log.register(newNickName);
			nickName = newNickName;
			pw = newPw;
			
			trigger = true;
			loggedInPage();
			
		} else {
			start();
		}
	}

	public static void start() {

		System.out.println("============================================================");
		System.out.println("������ ���Ű� ȯ���մϴ�");
		System.out.println("\n============================================================");
		System.out.println("1. �α���            2. ȸ������");
		try {
			inputNum = Integer.parseInt(br.readLine());
			
			if(inputNum == 1) {
				loginPage();
			} else if(inputNum == 2) {
				registerPage();
			} else {
				start();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
