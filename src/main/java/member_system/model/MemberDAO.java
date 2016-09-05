package member_system.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {
	DataSource ds = null;
	private final String SERVER_INFO = "java:comp/env/finalProject";
	private final String INSERT = "INSERT INTO member(memberid, password, name, phone, email, gender, registertime) VALUES(?, ?, ?, ?, ?, ?, ?);";
	private final String UPDATE_INFORMATION = "UPDATE member SET name = ?, phone = ?, email = ?, gender = ? WHERE memberid = ?";
	private final String UPDATE_PASSWORD = "UPDATE member SET  password = ? WHERE memberid = ?";
	private final String SELECT_BY_MEMBERID = "SELECT * FROM member WHERE memberid = ?;";
	
	private final String DELETE = "DELETE FROM member WHERE ";

	// 初始化:連結資料庫
	public MemberDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup(SERVER_INFO);
		} catch (NamingException e) {
			System.out.println("[ERROR_MemberDAO]: " + e.getMessage());
		}
	}
	
	// 新增會員資料
	synchronized public MemberBean insert(MemberBean member) {
		try(
			PreparedStatement pstmt = ds.getConnection().prepareStatement(INSERT);	
			) {
				// 輸入會員註冊資料至SQL指令參數
				pstmt.setString(1, member.getMemberId());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setString(4, member.getPhone());
				pstmt.setString(5, member.getEmail());
				pstmt.setInt(6, member.getGender());
				pstmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
				// 執行SQL指令
				pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[ERROR_MemberDAO]: " + e.getMessage());
		}
		
		return member;
	}
	
	// 修改會員資料
	public MemberBean updateInfor(MemberBean member) {
		try(
			PreparedStatement pstmt = ds.getConnection().prepareStatement(UPDATE_INFORMATION);	
			) {
				// 輸入更新的會員資料至SQL指令參數
				pstmt.setString(1, member.getName());
				pstmt.setString(2, member.getPhone());
				pstmt.setString(3, member.getEmail());
				pstmt.setInt(4, member.getGender());
				// 指定欲修改資料的會員帳號至SQL指令參數
				pstmt.setString(5, member.getMemberId());
				// 執行SQL指令
				pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[ERROR_MemberDAO]: " + e.getMessage());
		}
		
		return member;
	}
	
	// 修改會員密碼
	public MemberBean updatePwd(MemberBean member) {
		try(
			PreparedStatement pstmt = ds.getConnection().prepareStatement(UPDATE_PASSWORD);	
			) {
				// 輸入更新的會員密碼至SQL指令參數
				pstmt.setString(1, member.getPassword());
				// 指定欲修改資料的會員帳號至SQL指令參數
				pstmt.setString(2, member.getMemberId());
				// 執行SQL指令
				pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[ERROR_MemberDAO]: " + e.getMessage());
		}
		
		return member;
	}
	
	// 刪除會員資料(後端管理者專用)
	public int delete(String columName, String value){
		String delete_params = DELETE + columName + " = ?;";
		int i = -1;
		try(
			PreparedStatement pstmt = ds.getConnection().prepareStatement(delete_params);	
			) {
				// 設定條件欄位的對應值
				pstmt.setString(1, value);
				// 執行SQL指令
				i = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[ERROR_MemberDAO]: " + e.getMessage());
		}
		return i;
	}

	// 以會員帳號查詢單筆會員資料
	synchronized public MemberBean selectByMemberid(String memberid) {
		MemberBean memberData = null;
		ResultSet result = null;
		
		try(
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_MEMBERID);	
			){
				// 輸入欲查詢的會員帳號至SQL指令參數
				pstmt.setString(1, memberid);
				// 執行SOL指令
				result = pstmt.executeQuery();
				// 判斷是否有查詢任何資料,將ResultSet物件的指標移動到下一筆資料(第一筆)
				if(result.next()) {
					// 將查詢出的資料封裝進MemberBean物件裡
					memberData = new MemberBean();
					memberData.setMemberId(result.getString("memberid"));
					memberData.setPassword(result.getString("password"));
					memberData.setName(result.getString("name"));
					memberData.setPhone(result.getString("phone"));
					memberData.setEmail(result.getString("email"));
					memberData.setGender(result.getInt("gender"));
					memberData.setRegisterTime(result.getTimestamp("registertime"));
				}
		} catch (SQLException e) {
			System.out.println("[ERROR_MemberDAO]: " + e.getMessage());
		}
		
		return memberData;
	}
	
	

}
