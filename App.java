package telusko.DemoHQL;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
    	//Student st=new Student();
    	
    	Configuration cf=new Configuration().configure().addAnnotatedClass(Student.class);
    	SessionFactory sf=cf.buildSessionFactory();
    	Session session=sf.openSession();
    	Transaction tx=session.beginTransaction();
    	Query q=session.createQuery("from Student where marks=96");
    	List<Student> stu=q.list();
    	for(Student s:stu) {
    		System.out.println(s.getRollno()+" "+s.getName()+" "+s.getMarks());
    	}
    	
    	tx.commit();
    }
}
