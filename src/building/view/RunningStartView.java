package building.view;

import building.controller.BuildingController;

public class RunningStartView {

	public static void main(String[] args) {
		BuildingController bc = BuildingController.getInstance();
		bc.start();
	}

}
