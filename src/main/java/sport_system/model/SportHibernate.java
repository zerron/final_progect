package sport_system.model;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class SportHibernate implements SportDAO {
	SessionFactory factory = null;

	public SportHibernate() {
		factory=HibernateUtil.getSessionFactory();
	}
	
	@Override
	public int save(SportBean pb){
		int update = 0;
		Session session = factory.openSession();
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			session.save(pb);
			tx.commit();
			update=1;
		}catch(Exception ex){
			if(tx!= null) tx.rollback();
			System.out.println(ex.getMessage());
		}finally{
			if (session!=null)session.close();
		}
		return update;
	}
	
	@Override
	public SportBean getSport(int pk){
		SportBean sport=null;
		Session session = factory.openSession();
		Transaction tx =null;
		try{
			tx=session.beginTransaction();
			Integer ipk=Integer.valueOf(pk);
			sport=(SportBean)session.get(SportBean.class, ipk);
			tx.commit();
			}catch(Exception ex){
				if(tx != null) tx.rollback();
				System.out.println(ex.getMessage());
			}finally{
				if(session != null) session.close();
			}
		return sport;
	}
	
	@Override
	public int deleteSport(SportBean pb){
		int update = 0;
		Session session = factory.openSession();
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			session.delete(pb);
			tx.commit();
			update=1;
		}catch(Exception ex){
			if(tx!= null) tx.rollback();
			System.out.println(ex.getMessage());
		}finally{
			if (session!=null)session.close();
		}
		return update;
	}
	
	@Override
	public int updateSport(SportBean pb){
		int update = 0;
		Session session = factory.openSession();
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			session.saveOrUpdate("SportBean", pb);
			tx.commit();
			update++;
		}catch(Exception ex){
			if(tx!= null) tx.rollback();
			System.out.println(ex.getMessage());
		}finally{
			if (session!=null)session.close();
		}
		return update;
	}
	
	@Override
	public List<SportBean> getAllSports() throws SQLException {

		List<SportBean> list= null;
		Session session = factory.openSession();
		Transaction tx =null;
		try{
			tx=session.beginTransaction();
			Query query=session.createQuery("from SportBean");
			list = query.list();
			tx.commit();
			}catch(Exception ex){
				if(tx != null) tx.rollback();
				System.out.println(ex.getMessage());
			}finally{
				if(session != null) session.close();
			}
		return list;
	}
	

}
