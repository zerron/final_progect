package member_system.model;

import java.util.HashMap;
import java.util.Map;

public class CheckService {
	
	public static DataBean memberIsExist(MemberBean queryMember) {
		String queryId = queryMember.getMemberId();
		MemberBean resultMember = new MemberDAO().selectByMemberid(queryId);
		Map<String,String> error = new HashMap<>();
		DataBean checkData = new DataBean(resultMember, error);
		
		if(queryMember.getGender() != 0 && resultMember != null) { 	// 註冊
			error.put("error_memID", "帳號重複");
		}
		
		return checkData;
	}

}
