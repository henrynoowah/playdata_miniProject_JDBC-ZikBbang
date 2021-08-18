package building.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import building.model.dto.SellerDTO;
import building.model.util.DBUtil;

public class SellerDAO {
	
	private static Properties sql = DBUtil.getSql();
	
	private static SellerDAO instance = new SellerDAO();

	private SellerDAO() {}

	public static SellerDAO getInstance() {
		return instance;
	}

	// ��� �Ǹ������� ��ȯ
	public ArrayList<SellerDTO> getAllSeller() throws SQLException {
		ArrayList<SellerDTO> list = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getAllSeller"));
			rset = pstmt.executeQuery();
			list = new ArrayList<SellerDTO>();

			while (rset.next()) {
//				list.add(new SellerDTO(rset.getString(1), rset.getString(2), rset.getString(3)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	// sellerId�� �˻��� ��� ��ȯ
	public SellerDTO getSeller(String sellerId) throws SQLException {
		SellerDTO seller = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getSeller"));
			pstmt.setString(1, sellerId);
			rset = pstmt.executeQuery();

			if (rset.next()) {
//				seller = new SellerDTO(rset.getString(1), rset.getString(2), rset.getString(3));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return seller;
	}

	// �Ź� ���� ����
	public boolean addSeller(SellerDTO seller) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("addSeller"));
			pstmt.setString(1, seller.getSellerID());
			pstmt.setString(2, seller.getName());
			pstmt.setString(3, seller.getPhone());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// sellerId�� �Ǹ��� ���� �����ϱ�
	public boolean updateSeller(String sellerId, String name, String phone) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("updateSeller"));
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			pstmt.setString(3, sellerId);

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// SellerId�� �ش� Seller ���� ����
	public boolean deleteSeller(String sellerId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("deleteSeller"));
			pstmt.setString(1, sellerId);

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
