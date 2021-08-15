package building.view;

import building.controller.BuildingController;
import building.model.dto.AppDTO;
import building.model.dto.BuildingDTO;
import building.model.dto.PriceDTO;

public class RunningStartView {

	public static void main(String[] args) {
		BuildingController bc = BuildingController.getInstance();
		bc.start();
	}

}
