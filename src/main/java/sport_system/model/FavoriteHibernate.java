package sport_system.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class FavoriteHibernate implements FavoriteDAO {
	SessionFactory factory = null;

	public FavoriteHibernate() {
		this.factory = HibernateUtil.getSessionFactory();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FavoriteBean> getThisAlls(int sportId) {
		List<FavoriteBean> list = null;
		Session session = factory.openSession();
		Transaction tx =null;
		try{
			tx = session.beginTransaction();
			Query query = session.createQuery("from FavoriteBean where sportId = " + sportId);
			list = query.list();
			tx.commit();
			}catch(Exception ex){
				if(tx != null) 
					tx.rollback();
				System.out.println(ex.getMessage());
			}finally{
				if(session != null) session.close();
			}
		return list;
	}

	@Override
	public int save(FavoriteBean fb) {
		int update = 0;
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx=session.beginTransaction();
			session.save(fb);
			tx.commit();
			update = 1;
		}catch(Exception ex){
			if(tx != null) 
				tx.rollback();
			System.out.println(ex.getMessage());
		}finally{
			if (session != null)
				session.close();
		}
		return update;
	}

	@Override
	public int delete(FavoriteBean fb) {
		int update = 0;
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx=session.beginTransaction();
			session.delete(fb);;
			tx.commit();
			update = 1;
		}catch(Exception ex){
			if(tx != null) 
				tx.rollback();
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}finally{
			if (session != null)
				session.close();
		}
		return update;
	}

}
