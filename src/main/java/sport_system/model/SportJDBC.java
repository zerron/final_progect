package sport_system.model;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class SportJDBC {
	DataSource ds;
	int sportId;

	public int getSportId() {
		return sportId;
	}

	public void setSportId(int sportId) {
		this.sportId = sportId;
	}

	public SportJDBC() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup(SystemUtil.JNDI);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public List<SportBean> getAllSportsJSON() throws SQLException {
		List<SportBean> list = new ArrayList<>();
		Connection con = ds.getConnection();
		try {
			String sql = "Select * from sport";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				//
				int id = rs.getInt("ID");
				String a = rs.getString("SPORTNAME");
				String b = rs.getString("ADDRESS");
				String c = rs.getString("PHONE");
				double d = rs.getDouble("LAT");
				double e = rs.getDouble("LNG");
				String f = rs.getString("INDOOR");
				String g = rs.getString("ITEAM");
				String h = rs.getString("COST");
				int i = rs.getInt("SCORE");
				Blob j = rs.getBlob("PICTURE");
				String k = rs.getString("blobFileName");
				String l = rs.getString("DETAIL");
				Timestamp m = rs.getTimestamp("STARTDATE");
				//Blob blob = rs.getBlob("CoverImage");
				
				SportBean sp=new SportBean(id, a,b , c, d, e, f, g, h, i, j, k, l,m);
				list.add(sp);
			}
		} finally {
			con.close();
		}
		return list;
	}
	public List<SportBean> getAllSports() throws SQLException {
		List<SportBean> list = new ArrayList<>();
		Connection con = ds.getConnection();
		try {
			String sql = "Select * from sport";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				//
				int id = rs.getInt("ID");
				String a = rs.getString("SPORTNAME");
				String b = rs.getString("ADDRESS");
				String c = rs.getString("PHONE");
				double d = rs.getDouble("LAT");
				double e = rs.getDouble("LNG");
				String f = rs.getString("INDOOR");
				String g = rs.getString("ITEAM");
				String h = rs.getString("COST");
				int i = rs.getInt("SCORE");
				Blob j = rs.getBlob("PICTURE");
				String k = rs.getString("blobFileName");
				String l = rs.getString("DETAIL");
				Timestamp m = rs.getTimestamp("STARTDATE");
				//Blob blob = rs.getBlob("CoverImage");
				
				SportBean sp=new SportBean(id, a,b , c, d, e, f, g, h, i, j, k, l,m);
				list.add(sp);
			}
		} finally {
			con.close();
		}
		return list;

	}

	public SportBean getSport() throws SQLException {
		Connection con = null;
		SportBean bb = null;
		try {
			String sql = "Select * from sport where ID = ?";

			con = ds.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, sportId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int a = rs.getInt("ID");
				String b = rs.getString("SPORTNAME");
				String c = rs.getString("ADDRESS");
				String d = rs.getString("PHONE");
				double e = rs.getDouble("LAT");
				double f = rs.getDouble("LNG");
				String g = rs.getString("INDOOR");
				String h = rs.getString("ITEAM");
				String i = rs.getString("COST");
				int j = rs.getInt("SCORE");
				Blob k = rs.getBlob("PICTURE");
				String l = rs.getString("blobFileName");
				String m = rs.getString("DETAIL");
				Timestamp n = rs.getTimestamp("STARTDATE");				
				
				bb = new SportBean(a, b, c, d, e,
						f, g, h, i,j,k,l,m,n);
			}
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return bb;

	}
}
