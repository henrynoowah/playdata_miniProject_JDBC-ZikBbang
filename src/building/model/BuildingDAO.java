package building.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import building.model.dto.BuildingDTO;
import building.model.util.DBUtil;

public class BuildingDAO {

	private static Properties sql = DBUtil.getSql();
	
	private static BuildingDAO instance = new BuildingDAO();

	private BuildingDAO() {}

	public static BuildingDAO getInstance() {
		return instance;
	}

	// 모든 Building정보 반환
	public ArrayList<BuildingDTO> getAllBuilding() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BuildingDTO> list = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getAllBuilding"));
			rset = pstmt.executeQuery();
			list = new ArrayList<BuildingDTO>();

			while (rset.next()) {				
				list.add(BuildingDTO.builder().buildingID(rset.getString(1))
											  .region(rset.getString(2))
											  .address(rset.getString(3))
											  .buildingType(rset.getString(4)).build());
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	// BuildingId로 검색한 결과 반환
	public BuildingDTO getBuilding(String buildingId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		BuildingDTO building = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getBuilding"));
			pstmt.setString(1, buildingId);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				building = BuildingDTO.builder().buildingID(rset.getString(1))
						  						.region(rset.getString(2))
						  						.address(rset.getString(3))
						  						.buildingType(rset.getString(4)).build();
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return building;
	}

	// 지역으로 해당 Building의 모든 정보 반환
	public ArrayList<BuildingDTO> getRegion(String buildingId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BuildingDTO> list = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getRegion"));
			pstmt.setString(1, buildingId);
			rset = pstmt.executeQuery();
			list = new ArrayList<BuildingDTO>();

			while (rset.next()) {
				list.add(BuildingDTO.builder().buildingID(rset.getString(1))
  											  .region(rset.getString(2))
  											  .address(rset.getString(3))
  											  .buildingType(rset.getString(4)).build());
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	// Building Type으로 해당 Building의 모든 정보 반환
	public ArrayList<BuildingDTO> getBuildingType(String buildingId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BuildingDTO> list = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getBuildingType"));
			pstmt.setString(1, buildingId);
			rset = pstmt.executeQuery();
			list = new ArrayList<BuildingDTO>();

			while (rset.next()) {
				list.add(BuildingDTO.builder().buildingID(rset.getString(1))
						  					  .region(rset.getString(2))
						  					  .address(rset.getString(3))
						  					  .buildingType(rset.getString(4)).build());
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	// 매물 정보 저장
	public boolean addBuilding(BuildingDTO building) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("addBuilding"));
			pstmt.setString(1, building.getBuildingID());
			pstmt.setString(2, building.getRegion());
			pstmt.setString(3, building.getAddress());
			pstmt.setString(4, building.getBuildingType());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// Building 수정
	public boolean updateBuilding(String buildingId, String region, String address, String type)
			throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement(sql.getProperty("updateBuilding"));
			pstmt.setString(1, region);
			pstmt.setString(2, address);
			pstmt.setString(3, type);
			pstmt.setString(4, buildingId);

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// BuildingId로 해당 Building 정보 삭제
	public boolean deleteBuilding(String buildingId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("deleteBuilding"));
			pstmt.setString(1, buildingId);

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
}
