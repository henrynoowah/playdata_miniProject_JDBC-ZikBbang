package building.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import building.controller.BuildingController;
import building.model.dto.AppDTO;
import building.model.dto.BuildingDTO;
import building.model.dto.PriceDTO;
import building.model.dto.SellerDTO;
import log4j.Log;

public class start {

	public static void start() {
		BuildingController bc = BuildingController.getInstance();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = null;
		boolean triger = true;
		
		System.out.println("직빵에 오신걸 환영합니다");
		System.out.print("당신의 이름을 적어주세요 : ");
		try {
			name = br.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		Log.inputName(name);

		try {
			while (triger) {
				System.out.println("\n============================== 메뉴를 선택해주세요. ============================== ");
				System.out.println("1. 검색            2. 추가            3. 수정            4. 삭제            5.로그            0.종료");
				int inputNum = Integer.parseInt(br.readLine());

				if (inputNum == 1) {
					System.out.println("\n============================================================");
					System.out.println("1. 매물정보            2. 건물정보            3. 가격정보            4. 판매자정보");
					int search = Integer.parseInt(br.readLine());

					if (search == 1) {
						System.out.println("\n============================================================");
						System.out.println("1. 모든매물            2. AppId 검색");
						int app = Integer.parseInt(br.readLine());

						if (app == 1) {
							System.out.println();
							bc.getAllApp();
						} else if (app == 2) {
							System.out.println("\n============================================================");
							System.out.print("AppId를 입력해주세요 : ");
							String appId = br.readLine();

							System.out.println();
							bc.getAppId(appId);
						} else {
							System.out.println("\n잘못 입력하셨습니다");
						}
					} else if (search == 2) {
						System.out.println("\n============================================================");
						System.out.println("1. 모든건물            2. BuildingId 검색            3.지역 검색            4.매물종류 검색");
						int building = Integer.parseInt(br.readLine());

						if (building == 1) {
							System.out.println();
							bc.getAllBuilding();
						} else if (building == 2) {
							System.out.println("\n============================================================");
							System.out.print("BuildingId를 입력해주세요 : ");
							String buildingId = br.readLine();

							System.out.println();
							bc.getBuildingId(buildingId);
						} else if (building == 3) {
							System.out.println("\n============================================================");
							System.out.print("지역을 입력해주세요 : ");
							String region = br.readLine();

							System.out.println();
							bc.getRegion(region);
						} else if (building == 4) {
							System.out.println("\n============================================================");
							System.out.print("매물종류를 입력해주세요(원룸, 오피스텔, 전원주택) : ");
							String type = br.readLine();

							System.out.println();
							bc.getBuildingType(type);
						} else {
							System.out.println("/n잘못 입력하셨습니다");
						}
					} else if (search == 3) {
						System.out.println("\n============================================================");
						System.out.println("1. AppId 검색            2. 원하는 가격대 검색");
						int price = Integer.parseInt(br.readLine());

						if (price == 1) {
							System.out.println("\n============================================================");
							System.out.print("AppId를 입력해주세요 : ");
							String appId = br.readLine();

							System.out.println();
							bc.getPrice(appId);
						} else if (price == 2) {
							System.out.println("\n============================================================");
							System.out.print("원하는 가격 유형을 입력해주세요(월세, 보증금, 매매가) : ");
							String type = br.readLine();
							System.out.print("최소 가격을 입력해주세요(단위:만원) : ");
							int min = Integer.parseInt(br.readLine());
							System.out.print("최대 가격을 입력해주세요(단위:만원) : ");
							int max = Integer.parseInt(br.readLine());

							System.out.println();
							bc.getComeparePrice(type, min, max);
						} else {
							System.out.println("\n잘못 입력하셨습니다");
						}
					} else if (search == 4) {
						System.out.println("\n============================================================");
						System.out.println("1. 모든판매자            2. SellerId 검색");
						int seller = Integer.parseInt(br.readLine());

						if (seller == 1) {
							bc.getAllSeller();
						} else if (seller == 2) {
							System.out.println("\n============================================================");
							System.out.print("SellerId를 입력해주세요 : ");
							String sellerId = br.readLine();

							System.out.println();
							bc.getSellerId(sellerId);
						} else {
							System.out.println("\n잘못 입력하셨습니다");
						}
					} else {
						System.out.println("\n잘못 입력하셨습니다");
					}
				} else if (inputNum == 2) {
					System.out.println("\n============================================================");
					System.out.println("1. 매물            2. 판매자");
					int insert = Integer.parseInt(br.readLine());

					if (insert == 1) {
						int trade_price = 0;
						int deposit = 0;
						int monthly_rent = 0;
						
						System.out.println("\n============================================================");
						System.out.print("추가할 Building Id를 입력해주세요 : ");
						String buildingId = br.readLine();
						
						boolean result = bc.getBuildingIdStart(buildingId);
						
						if(result != true) {
							System.out.print("추가할 건물의 지역을 입력해주세요 : ");
							String region = br.readLine();
							System.out.print("추가할 건물의 주소를 입력해주세요 : ");
							String address = br.readLine();
							System.out.print("추가할 건물의 유형을 입력해주세요(원룸, 오피스텔, 전원주택) : ");
							String type = br.readLine();
							System.out.print("추가할 App Id를 입력해주세요 : ");
							String appId = br.readLine();
							
							boolean result2 = bc.getAppIdStart(appId);
							
							if(result2 != true) {
								System.out.print("추가할 매물 유형을 입력해주세요(월세, 전세, 매매) : ");
								String trade_type = br.readLine();
								
								if(trade_type.equals("월세")) {
									System.out.print("추가할 건물의 보증금의 액수를 입력해주세요(단위:만원) : ");
									deposit = Integer.parseInt(br.readLine());
									System.out.print("추가할 건물의 월세의 액수 입력해주세요(단위:만원) : ");
									monthly_rent = Integer.parseInt(br.readLine());	
								}else if(trade_type.equals("전세")) {
									System.out.print("추가할 건물의 보증금의 액수를 입력해주세요(단위:만원) : ");
									deposit = Integer.parseInt(br.readLine());
								}else if(trade_type.equals("매매")) {
									System.out.print("추가할 건물의 매매가의 액수를 입력해주세요(단위:만원) : ");
									trade_price = Integer.parseInt(br.readLine());
								}else {
									System.out.println("지원하지 않는 매물 유형입니다");
								}
								
								System.out.print("추가할 Seller Id를 입력해주세요 : ");
								String sellerId = br.readLine();
								
								System.out.print("추가할 세입자 여부를 입력해주세요(TRUE or FALSE) : ");
								String tenant = br.readLine();
								
								BuildingDTO building = new BuildingDTO(buildingId, region, address, type);
								PriceDTO price = new PriceDTO(appId, deposit, monthly_rent, trade_price);
								AppDTO app = new AppDTO(appId, buildingId, trade_type, sellerId, tenant);
		
								System.out.println();
								bc.addApp(app, building, price);
							}else {
								System.out.println("\n해당 App Id는 이미 있는 Id입니다");
							}
						}else {
							System.out.println("\n해당 Building Id는 이미 있는 Id입니다");
						}
					} else if (insert == 2) {
						System.out.println("\n============================================================");
						System.out.print("추가할 Seller Id를 입력해주세요 : ");
						String sellerId = br.readLine();
						
						boolean result = bc.getSellerIdStart(sellerId);
						
						if(result != true) {
							System.out.print("추가할 판매자 이름을 입력해주세요 : ");
							String sellerName = br.readLine();
							System.out.print("추가할 판매자 휴대폰 번호를 입력해주세요 : ");
							String phone = br.readLine();
	
							SellerDTO seller = new SellerDTO(sellerId, sellerName, phone);
	
							System.out.println();
							bc.addSeller(seller);
						}else {
							System.out.println("\n해당 Seller Id는 이미 있는 Id입니다");
						}
					} else {
						System.out.println("잘못 입력하셨습니다");
					}
				} else if (inputNum == 3) {
					System.out.println("\n============================================================");
					System.out.println("1. 매물            2. 건물            3. 가격            4.판매자");
					int update = Integer.parseInt(br.readLine());

					if (update == 1) {
						System.out.println("\n============================================================");
						System.out.print("수정할 App Id를 입력해주세요 : ");
						String appId = br.readLine();

						boolean result = bc.getAppIdStart(appId);

						if (result == true) {
							System.out.println("\n1. 매물 유형            2. 세입자 여부            3. 매물 유형과 세입자 여부");
							int app = Integer.parseInt(br.readLine());

							if (app == 1) {
								System.out.println("\n============================================================");
								System.out.print("수정할 매물 유형을 입력해주세요(월세, 전세, 매매) : ");
								String trade_type = br.readLine();

								int deposit = 0;
								int monthly_rent = 0;
								int trade_price = 0;
								
								if(trade_type.equals("월세")) {
									System.out.print("수정할 건물의 보증금의 액수를 입력해주세요(단위:만원) : ");
									deposit = Integer.parseInt(br.readLine());
									System.out.print("수정할 건물의 월세의 액수 입력해주세요(단위:만원) : ");
									monthly_rent = Integer.parseInt(br.readLine());	
								}else if(trade_type.equals("전세")) {
									System.out.print("수정할 건물의 보증금의 액수를 입력해주세요(단위:만원) : ");
									deposit = Integer.parseInt(br.readLine());
								}else if(trade_type.equals("매매")) {
									System.out.print("수정할 건물의 매매가의 액수를 입력해주세요(단위:만원) : ");
									trade_price = Integer.parseInt(br.readLine());
								}else {
									System.out.println("지원하지 않는 매물 유형입니다");
								}
								
								System.out.println();
								bc.updateAppTradeType(appId, trade_type);
								bc.updatePrice(appId, deposit, monthly_rent, trade_price);
							} else if (app == 2) {
								System.out.println("\n============================================================");
								System.out.print("수정할 세입자 여부를 입력해주세요(TRUE or FALSE) : ");
								String tenant = br.readLine();

								bc.updateAppTenant(appId, tenant);
							} else if (app == 3) {
								System.out.println("\n============================================================");
								System.out.print("수정할 매물 유형을 입력해주세요(월세, 전세, 매매) : ");
								String trade_type = br.readLine();
								System.out.print("수정할 세입자 여부를 입력해주세요(TRUE or FALSE) : ");
								String tenant = br.readLine();

								System.out.println();
								bc.updateAppTradeType(appId, trade_type);
								bc.updateAppTenant(appId, tenant);
							} else {
								System.out.println("\n잘못 입력하셨습니다");
							}
						} else {
							System.out.println("\n해당 App Id는 없습니다");
						}
					} else if (update == 2) {
						System.out.println("\n============================================================");
						System.out.print("수정할 Building Id를 입력해주세요 : ");
						String buildingId = br.readLine();

						boolean result = bc.getBuildingIdStart(buildingId);

						if (result == true) {
							System.out.print("수정할 건물의 지역을 입력해주세요 : ");
							String region = br.readLine();
							System.out.print("수정할 건물의 주소를 입력해주세요 : ");
							String address = br.readLine();
							System.out.print("수정할 건물의 유형을 입력해주세요(원룸, 오피스텔, 전원주택) : ");
							String type = br.readLine();

							System.out.println();
							bc.updateBuilding(buildingId, region, address, type);
						} else {
							System.out.println("\n해당 Building Id는 없습니다");
						}
					} else if (update == 3) {
						System.out.println("\n============================================================");
						System.out.print("수정할 App Id를 입력해주세요 : ");
						String appId = br.readLine();

						boolean result = bc.getAppIdPriceStart(appId);

						if (result == true) {
							int deposit = 0;
							int monthly_rent = 0;
							int trade_price = 0;
							String trade_type = bc.getAppIdContent(appId).getTradeType();
							
							System.out.println("해당 App Id의 가격 유형은 " + trade_type + "입니다");
							
							if(trade_type.equals("월세")) {
								System.out.print("수정할 건물의 보증금의 액수를 입력해주세요(단위:만원) : ");
								deposit = Integer.parseInt(br.readLine());
								System.out.print("수정할 건물의 월세의 액수 입력해주세요(단위:만원) : ");
								monthly_rent = Integer.parseInt(br.readLine());	
							}else if(trade_type.equals("전세")) {
								System.out.print("수정할 건물의 보증금의 액수를 입력해주세요(단위:만원) : ");
								deposit = Integer.parseInt(br.readLine());
							}else if(trade_type.equals("매매")) {
								System.out.print("수정할 건물의 매매가의 액수를 입력해주세요(단위:만원) : ");
								trade_price = Integer.parseInt(br.readLine());
							}else {
								System.out.println("지원하지 않는 매물 유형입니다");
							}
							
							System.out.println();
							bc.updatePrice(appId, deposit, monthly_rent, trade_price);
						} else {
							System.out.println("\n해당 App Id는 없습니다");
						}
					} else if (update == 4) {
						System.out.println("\n============================================================");
						System.out.print("수정할 Seller Id를 입력해주세요 : ");
						String sellerId = br.readLine();

						boolean result = bc.getSellerIdStart(sellerId);

						if (result == true) {
							System.out.print("수정할 판매자의 이름을 입력해주세요 : ");
							String sellerName = br.readLine();
							System.out.print("수정할 판매자의 휴대폰 번호를 입력해주세요 : ");
							String phone = br.readLine();

							System.out.println();
							bc.updateSeller(sellerId, sellerName, phone);
						} else {
							System.out.println();
							System.out.println("\n해당 Seller Id는 없습니다");
						}
					} else {
						System.out.println("\n잘못 입력하셨습니다");
					}

				} else if (inputNum == 4) {
					System.out.println("\n============================================================");
					System.out.println("1. 매물            2. 판매자");
					int delete = Integer.parseInt(br.readLine());

					if (delete == 1) {
						System.out.println("\n============================================================");
						System.out.print("삭제할 App Id를 입력해주세요 : ");
						String appId = br.readLine();

						boolean result = bc.getAppIdStart(appId);
						if (result == true) {
							String buildingId = null;
							try {
								buildingId = AppDAO.getApp(appId).getBuildingID();
							} catch (SQLException e) {
								e.printStackTrace();
							}

							System.out.println();
							bc.deleteApp(appId);
						} else {
							System.out.println("\n해당 App Id는 없습니다");
						}
					} else if (delete == 2) {
						System.out.println("\n============================================================");
						System.out.print("삭제할 Seller Id를 입력해주세요 : ");
						String sellerId = br.readLine();

						boolean result = bc.getSellerIdStart(sellerId);

						if (result == true) {
							System.out.println();
							bc.deleteSeller(sellerId);
						} else {
							System.out.println("\n해당 Seller Id는 없습니다");
						}
					} else {
						System.out.println("\n잘못 입력하셨습니다");
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
				} else if (inputNum == 0) {
					System.out.println("\n안녕히 가세요! 직빵 플랫폼 종료합니다.");
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
