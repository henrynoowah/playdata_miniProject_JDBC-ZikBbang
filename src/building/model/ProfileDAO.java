package building.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import building.model.dto.ProfileDTO;
import building.model.util.DBUtil;

public class ProfileDAO {
	
	private static Properties sql = DBUtil.getSql();
	
	private static ProfileDAO instance = new ProfileDAO();
	
	private ProfileDAO() {}
	
	public static ProfileDAO getInstance() {
		return instance;
	}
	
	
	//로그인정보 가져오기
	public ProfileDTO getProfile(String nickName, String pw) throws SQLException {
		ProfileDTO profile = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getProfile"));
			pstmt.setString(1, nickName);
			pstmt.setString(2, pw);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {	
				profile = ProfileDTO.builder().nickName(rset.getString(1))
											  .pw(rset.getString(2))
											  .sellerId(rset.getString(3)).build();
				
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		
		return profile;
	}
	
	
	// 계정정보 가져오기
	public ProfileDTO getProfile(String nickName) throws SQLException {
		ProfileDTO profile = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getProfile2"));
			pstmt.setString(1, nickName);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				profile = ProfileDTO.builder().nickName(rset.getString(1))
						  					  .pw(rset.getString(2))
						  					  .sellerId(rset.getString(3)).build();
				
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}		
		
		return profile;
	}

	
	//계정 로그인
	public boolean addProfile(String newNickName, String newPw) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("addProfile"));
			pstmt.setString(1, newNickName);
			pstmt.setString(2, newPw);
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				return true;
			}		
		} finally {
			DBUtil.close(con, pstmt);
		}
		
		return false;
	}

	
	public boolean addProfileSeller(String nickName, String sellerId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("addProfileSeller"));
			pstmt.setString(1, sellerId);
			pstmt.setString(2, nickName);
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				return true;
			}		
		} finally {
			DBUtil.close(con, pstmt);
		}		
		
		return false;
	}
}
