package hibernate;

import hibernate.HibernateUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Repo {
    
    public static List<Employee> allEmployees() {
        List<Employee> listAll = new ArrayList<>();
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx= null;
        Employee emp= null;
        try{
            tx=session.beginTransaction();
            String hql = "from Employee";
            Query query = session.createQuery(hql);
            listAll.addAll(query.list());
            tx.commit();
        }
        catch(HibernateException ex){}
        
        return listAll;
    }
    
    public static void insert(Employee e){
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx= null;
        try{
            tx=session.beginTransaction();
            session.persist(e);
            tx.commit();
        }
        catch(HibernateException ex){ex.printStackTrace();}
    }
    
    public static void delete (int id){
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx= null;
        try{
            tx=session.beginTransaction();
            Employee e = (Employee) session.get(Employee.class, id);
            session.delete(e);
            tx.commit();
        }
        catch(HibernateException ex){}
    }
    
    public static void update (Employee e) {
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx= null;
        try{
            tx=session.beginTransaction();
            Employee emp = (Employee) session.get(Employee.class, e.getId());
            emp = e;
            session.merge(emp);
            tx.commit();
        }
        catch(HibernateException ex){}
    }
    
    public static List<Employee> search (String param, String search) {
        List<Employee> listAll = new ArrayList();
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx= null;
        
        try{
            tx=session.beginTransaction();
            String hql = "from Employee where " + param + "=" + "'" + search + "'";
            Query query = session.createQuery(hql);
            listAll.addAll(query.list());
            tx.commit();
        }
        catch(HibernateException ex){}
        
        return listAll;
    }
    
    public static List<Employee> searchBetween (String param, int search1, int search2) {
       List<Employee> listAll = new ArrayList();
        Session session = HibernateUtil.createSessionFactory().openSession();
        Transaction tx= null;
        
        try{
            tx=session.beginTransaction();
            String hql = "from Employee where " + param + " between "+search1+" and "+search2;
            Query query = session.createQuery(hql);
            listAll.addAll(query.list());
            tx.commit();
        }
        catch(HibernateException ex){}
        
        return listAll;
   }
    
}
