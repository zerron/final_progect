package sport_system.model;

import java.util.List;

public interface FavoriteDAO {
	
	List<FavoriteBean> getThisAlls(int sportId);
	
	int save(FavoriteBean fb);
	
	int delete(FavoriteBean fb);

}
