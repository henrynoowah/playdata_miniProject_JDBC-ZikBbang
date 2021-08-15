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
	
	private static AppDAO instance = new AppDAO();

	private AppDAO() {}

	public static AppDAO getInstance() {
		return instance;
	}
	
	private static Properties sql = DBUtil.getSql();
	//모든 매물정보 검색
	public  ArrayList<AppDTO> getAllApp() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AppDTO> list = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getAllApp"));
			rset = pstmt.executeQuery();
			
			list = new ArrayList<AppDTO>();
			while(rset.next()){
				list.add( new AppDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5)) );
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	//AppId로 검색한 결과 반환
	public AppDTO getApp(String appId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		AppDTO app = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getApp"));
			pstmt.setString(1, appId);
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				app = new AppDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return app;
	}
	
	//매물 정보 저장
	public boolean addApp(AppDTO app) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("addApp"));
			pstmt.setString(1, app.getAppID());
			pstmt.setString(2, app.getBuildingID());
			pstmt.setString(3, app.getTradeType());
			pstmt.setString(4, app.getSellerID());
			pstmt.setString(5, app.getTenant());
			
			int result = pstmt.executeUpdate();
		
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	//AppId로 매물 타입 수정
	public boolean updateAppTradeType(String appId, String trade_type) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement(sql.getProperty("updateAppTradeType"));
			pstmt.setString(1, trade_type);
			pstmt.setString(2, appId);
			
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	//AppId로 세입자 여부 수정
	public boolean updateAppTenant(String appId, String tenant) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement(sql.getProperty("updateAppTenant"));
			pstmt.setString(1, tenant);
			pstmt.setString(2, appId);
			
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	//AppId로 해당 App 정보 삭제 
	public boolean deleteApp(String appId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("deleteApp"));
			pstmt.setString(1, appId);
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
}
