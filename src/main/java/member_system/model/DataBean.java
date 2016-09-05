package member_system.model;

import java.util.Map;

public class DataBean {
	private MemberBean member;
	private Map<String, String> error;
	private String oldPassword;
	private String newPassword;
	
	
	public DataBean(MemberBean member, Map<String, String> error) {
		super();
		this.member = member;
		this.error = error;
	}
	public DataBean(Map<String, String> error) {
		this.error = error;
	}
	

	public MemberBean getMember() {
		return member;
	}

	public void setMember(MemberBean member) {
		this.member = member;
	}

	public Map<String, String> getError() {
		return error;
	}

	public void setError(Map<String, String> error) {
		this.error = error;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}



}
