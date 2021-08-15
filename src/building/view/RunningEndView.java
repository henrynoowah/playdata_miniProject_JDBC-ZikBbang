package building.view;

import java.util.ArrayList;

import building.model.dto.AppDTO;
import building.model.dto.BuildingDTO;
import building.model.dto.PriceDTO;
import building.model.dto.SellerDTO;

public class RunningEndView {

	// 모든 정보 출력
	public static void AppListView(ArrayList allApp) {
		if (allApp != null) {
			int length = allApp.size(); // 저장된 데이터 개수 반환

			if (length != 0) {
				for (int index = 0; index < length; index++) {
					System.out.println(allApp.get(index));
				}
			} else {
				System.out.println("요청하신 정보는 없습니다");
			}
		} else {
			System.out.println("요청하신 정보는 없습니다");
		}
	}

	// Region으로 검색한 결과 출력
	public static void allRegion(ArrayList<BuildingDTO> data) {
		if (data != null) {
			int length = data.size(); // 저장된 데이터 개수 반환

			if (length != 0) {
				for (int index = 0; index < length; index++) {
					System.out.println(data.get(index));
				}
			} else {
				System.out.println("요청하신 지역에 대한 정보는 없습니다");
			}
		} else {
			System.out.println("요청하신 지역에 대한 정보는 없습니다");
		}
	}

	// Building Type로 검색한 결과 출력
	public static void allBuildingType(ArrayList<BuildingDTO> data) {
		if (data != null) {
			int length = data.size(); // 저장된 데이터 개수 반환

			if (length != 0) {
				for (int index = 0; index < length; index++) {
					System.out.println(data.get(index));
				}
			} else {
				System.out.println("요청하신 건물 유형에 대한 정보는 없습니다");
			}
		} else {
			System.out.println("요청하신 건물 유형에 대한 정보는 없습니다");
		}
	}

	// 특정 App 출력
	public static void AppView(AppDTO app) {
		if (app != null) {
			System.out.println(app);
		} else {
			System.out.println("해당 App Id는 없습니다");
		}
	}

	// 특정 Building 출력
	public static void BuildingView(BuildingDTO building) {
		if (building != null) {
			System.out.println(building);
		} else {
			System.out.println("해당 Building Id는 없습니다");
		}
	}

	// 특정 Price 출력
	public static void PriceView(PriceDTO price) {
		if (price != null) {
			System.out.println(price);
		} else {
			System.out.println("해당 App Id는 없습니다");
		}
	}

	// 특정 Price 출력
	public static void ComparePriceView(ArrayList<PriceDTO> price) {
		if (price != null) {
			int length = price.size(); // 저장된 데이터 개수 반환

			if (length != 0) {
				for (int index = 0; index < length; index++) {
					System.out.println(price.get(index));
				}
			} else {
				System.out.println("해당 가격대의 매물에 대한 정보는 없습니다");
			}
		} else {
			System.out.println("해당 가격대의 매물은 없습니다");
		}
	}

	// 특정 Seller 출력
	public static void SellerView(SellerDTO seller) {
		if (seller != null) {
			System.out.println(seller);
		} else {
			System.out.println("해당 App Id는 없습니다");
		}
	}

	// Buildingupdate 성공, 실패시 메시지 출력 -
	public static void updateBuildingView(boolean result, String buildingId) {
		if (result == true) {
			System.out.println("\n요청하신 [Building Id : " + buildingId + "]의 건물 정보 수정 완료");
		} else {
			System.out.println("\n요청하신 [Building Id : " + buildingId + "] 수정 실패, id 재확인 하세요");
		}
	}

	// Priceupdate 성공, 실패시 메시지 출력 -
	public static void updatePriceView(boolean result, String appId) {
		if (result == true) {
			System.out.println("\n요청하신 [App Id : " + appId + "]의 가격 정보 수정 완료");
		} else {
			System.out.println("\n요청하신 [App Id : " + appId + "] 수정 실패, id 재확인 하세요");
		}
	}

	// Sellerupdate 성공, 실패시 메시지 출력 -
	public static void updateSellerView(boolean result, String sellerId) {
		if (result == true) {
			System.out.println("\n요청하신 [Seller Id : " + sellerId + "]의 판매자 정보 수정 완료");
		} else {
			System.out.println("\n요청하신 [Seller Id : " + sellerId + "] 수정 실패, id 재확인 하세요");
		}
	}

	// TradeTypeupdate 성공, 실패시 메시지 출력 -
	public static void updateTradeTypeView(boolean result, String appId) {
		if (result == true) {
			System.out.println("\n요청하신 [App Id : " + appId + "]의 거래 유형 수정 완료");
		} else {
			System.out.println("\n요청하신 [App Id : " + appId + "] 수정 실패, id 재확인 하세요");
		}
	}

	// Tenantupdate 성공, 실패시 메시지 출력 -
	public static void updateTenantView(boolean result, String appId) {
		if (result == true) {
			System.out.println("\n요청하신 [App Id : " + appId + "]의 세입자 여부 수정 완료");
		} else {
			System.out.println("\n요청하신 [App Id : " + appId + "] 수정 실패, id 재확인 하세요");
		}
	}

	// App insert 성공, 실패시 메시지 출력 -
	public static void insertAppView(boolean result, String Id) {
		if (result == true) {
			System.out.println("\n요청하신 [App Id : " + Id + "] App insert 완료");
		} else {
			System.out.println("\n요청하신 [App Id : " + Id + "] App insert 실패, id 재확인 하세요");
		}
	}

	// Building insert 성공, 실패시 메시지 출력 -
	public static void insertBuildingView(boolean result, String Id) {
		if (result == true) {
			System.out.println("\n요청하신 [Building Id : " + Id + "] Building insert 완료");
		} else {
			System.out.println("\n요청하신 [Building Id : " + Id + "] insert 실패, id 재확인 하세요");
		}
	}

	// Price insert 성공, 실패시 메시지 출력 -
	public static void insertPriceView(boolean result, String Id) {
		if (result == true) {
			System.out.println("\n요청하신 [App id : " + Id + "] Price insert 완료");
		} else {
			System.out.println("\n요청하신 [App id : " + Id + "] insert 실패, id 재확인 하세요");
		}
	}

	// Seller insert 성공, 실패시 메시지 출력 -
	public static void insertSellerView(boolean result, String Id) {
		if (result == true) {
			System.out.println("\n요청하신 [Seller Id : " + Id + "] Seller insert 완료");
		} else {
			System.out.println("\n요청하신 [Seller Id : " + Id + "] Seller 실패, id 재확인 하세요");
		}
	}

	// App delete 성공, 실패시 메시지 출력 -
	public static void deleteAppView(boolean result, String Id) {
		if (result == true) {
			System.out.println("\n요청하신 [App Id : " + Id + "] App delete 완료");
		} else {
			System.out.println("\n요청하신 [App Id : " + Id + "] App delete 실패, id 재확인 하세요");
		}
	}

	// Seller delete 성공, 실패시 메시지 출력 -
	public static void deleteSellerView(boolean result, String Id) {
		if (result == true) {
			System.out.println("\n요청하신 [Seller Id : " + Id + "] Seller delete 완료");
		} else {
			System.out.println("\n요청하신 [Seller Id : " + Id + "] Seller delete 실패, id 재확인 하세요");
		}
	}

	// 예외 상황 출력
	public static void showError(String message) {
		System.out.println(message);
	}
}
