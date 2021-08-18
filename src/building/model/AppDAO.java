package building.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import building.model.dto.AppDTO;
import building.model.util.DBUtil;

public class AppDAO {
	
	private static Properties sql = DBUtil.getSql();
	
	private static AppDAO instance = new AppDAO();

	private AppDAO() {}

	public static AppDAO getInstance() {
		return instance;
	}

	// ��� �Ź����� �˻�
	public ArrayList<AppDTO> getAllApp() throws SQLException {
		ArrayList<AppDTO> list = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getAllApp"));
			rset = pstmt.executeQuery();

			list = new ArrayList<AppDTO>();

			while (rset.next()) {
				list.add(AppDTO.builder().appID(rset.getString(1))
										 .buildingID(rset.getString(2))
										 .tradeType(rset.getString(3))
										 .sellerID(rset.getString(4))
										 .tenant(rset.getString(5)).build());
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	// AppId�� �˻��� ��� ��ȯ
	public AppDTO getApp(String appId) throws SQLException {
		AppDTO app = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getApp"));
			pstmt.setString(1, appId);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				app = AppDTO.builder().appID(rset.getString(1))
						 			  .buildingID(rset.getString(2))
						 			  .tradeType(rset.getString(3))
						 			  .sellerID(rset.getString(4))
						 			  .tenant(rset.getString(5)).build();
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return app;
	}

	// �Ź� ���� ����
	public boolean addApp(AppDTO app) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("addApp"));
			pstmt.setString(1, app.getAppID());
			pstmt.setString(2, app.getBuildingID());
			pstmt.setString(3, app.getTradeType());
			pstmt.setString(4, app.getSellerID());
			pstmt.setString(5, app.getTenant());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// AppId�� �Ź� Ÿ�� ����
	public boolean updateAppTradeType(String appId, String trade_type) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement(sql.getProperty("updateAppTradeType"));
			pstmt.setString(1, trade_type);
			pstmt.setString(2, appId);

			result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// AppId�� ������ ���� ����
	public boolean updateAppTenant(String appId, String tenant) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement(sql.getProperty("updateAppTenant"));
			pstmt.setString(1, tenant);
			pstmt.setString(2, appId);


			result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// AppId�� �ش� App ���� ����
	public boolean deleteApp(String appId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("deleteApp"));
			pstmt.setString(1, appId);

			result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// AppId�� ���� ��� ���� ����
	public boolean deleteAllApp(String appId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("deleteApp"));
			pstmt.setString(1, appId);

			result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
}
