package building.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import building.model.dto.PriceDTO;
import building.model.util.DBUtil;

public class PriceDAO {
	
	private static Properties sql = DBUtil.getSql();
	
	private static PriceDAO instance = new PriceDAO();

	private PriceDAO() {}

	public static PriceDAO getInstance() {
		return instance;
	}

	// ��� �Ź����� �˻�
	public ArrayList<PriceDTO> getAllPrice() throws SQLException {
		ArrayList<PriceDTO> list = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getAllPrice"));
			rset = pstmt.executeQuery();
			list = new ArrayList<PriceDTO>();

			while (rset.next()) {
				list.add(PriceDTO.builder().appID(rset.getString(1))
										   .deposit(rset.getInt(2))
										   .monthlyRent(rset.getInt(3))
										   .tradePrice(rset.getInt(4)).build());
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	// AppId�� �˻��� ��� ��ȯ
	public PriceDTO getPrice(String appId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		PriceDTO price = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getPrice"));
			pstmt.setString(1, appId);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				price = PriceDTO.builder().appID(rset.getString(1))
						   				  .deposit(rset.getInt(2))
						   				  .monthlyRent(rset.getInt(3))
						   				  .tradePrice(rset.getInt(4)).build();
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return price;
	}

	// ���ݴ뿡 �´� �Ź����� �˻�
	public ArrayList<PriceDTO> getComparePrice(String type, int min, int max) throws SQLException {
		ArrayList<PriceDTO> list = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			con = DBUtil.getConnection();

			if (type.equals("������")) {
				pstmt = con.prepareStatement(sql.getProperty("getComparePrice1"));
			} else if (type.equals("����")) {
				pstmt = con.prepareStatement(sql.getProperty("getComparePrice2"));
			} else if (type.equals("�ŸŰ�")) {
				pstmt = con.prepareStatement(sql.getProperty("getComparePrice3"));
			}

			pstmt.setInt(1, min);
			pstmt.setInt(2, max);
			rset = pstmt.executeQuery();
			list = new ArrayList<PriceDTO>();

			while (rset.next()) {
				list.add(PriceDTO.builder().appID(rset.getString(1))
						   				   .deposit(rset.getInt(2))
						   				   .monthlyRent(rset.getInt(3))
						   				   .tradePrice(rset.getInt(4)).build());
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	// �Ź� ���� ����
	public boolean addPrice(PriceDTO price) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("addPrice"));
			pstmt.setString(1, price.getAppID());
			pstmt.setInt(2, price.getDeposit());
			pstmt.setInt(3, price.getMonthlyRent());
			pstmt.setInt(4, price.getTradePrice());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// Price ����
	public boolean updatePrice(String appId, int deposit, int monthly_rent, int trade_price) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("updatePrice"));
			pstmt.setInt(1, deposit);
			pstmt.setInt(2, monthly_rent);
			pstmt.setInt(3, trade_price);
			pstmt.setString(4, appId);

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// AppId�� �ش� Price ���� ����
	public boolean deletePrice(String appId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("deletePrice"));
			pstmt.setString(1, appId);

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
