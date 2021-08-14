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
	
	//로그인정보 가져오기
	public static ProfileDTO getProfile(String nickName, String pw) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ProfileDTO profile = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from profile where nickname = ? and password = ?");
			pstmt.setString(1, nickName);
			pstmt.setString(2, pw);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				profile = new ProfileDTO(rset.getString(1), rset.getString(2), rset.getString(3));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		
		return profile;
	}

}
