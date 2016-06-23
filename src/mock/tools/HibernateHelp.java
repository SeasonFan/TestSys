package mock.tools;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateHelp {
	
	private Configuration cfg=null;
	private SessionFactory factory=null;
	private Session session = null;
	public Session getSession() {
		return session;
	}



	public void setSession(Session session) {
		this.session = session;
	}



	public HibernateHelp()
	{
		 cfg = new Configuration().configure();  
         factory = cfg.buildSessionFactory();  
	}
	
	
	
	public void StartTran()
	{
		session = factory.openSession();  
        session.beginTransaction();  
	}
	
	public void FinishTran()
	{
		 session.getTransaction().commit(); 
		 if (session != null) {  
             if (session.isOpen()) {  
                 session.close();  
             }  
         } 
	}
	
	
	
	public List<?> QueryData(String Hql)
	{   
		StartTran();

	    Query qu= session.createQuery(Hql);
		List<?> ret= qu.list();	
	    
	    FinishTran();
	    return ret;
	}
	
	
	

	
	public void AddData(Object ob)
	{   
		StartTran();
		
		session.save(ob);
	    
	    FinishTran();
	}
	
	
	public void UpdateData(Object ob)
	{   
		StartTran();
		
		session.update(ob);
	    
	    FinishTran();
	}
}
