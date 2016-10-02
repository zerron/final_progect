package sport_system.model;

import java.io.Serializable;

public class FavoriteBean implements Serializable {
	private int no;
	private String memberId;
	private int sportId;
	
	public FavoriteBean() {
		super();
	}
	
	public FavoriteBean(String memberId, int sportId) {
		super();
		this.memberId = memberId;
		this.sportId = sportId;
	}

	public FavoriteBean(int no, String memberId, int sportId) {
		super();
		this.no = no;
		this.memberId = memberId;
		this.sportId = sportId;
	}

	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getSportId() {
		return sportId;
	}

	public void setSportId(int sportId) {
		this.sportId = sportId;
	}

}
