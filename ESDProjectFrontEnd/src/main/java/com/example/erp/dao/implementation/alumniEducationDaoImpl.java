package com.example.erp.dao.implementation;

import com.example.erp.bean.alumni_details;
import com.example.erp.bean.alumni_education;
import com.example.erp.dao.alumniEducationDao;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class alumniEducationDaoImpl implements alumniEducationDao {
    @Override
    public List<alumni_education> findMax(alumni_education alumni){
        try (Session session = SessionUtil.getSession()) {

            Query query = session.createQuery("from alumni_education where alumni_id=:id order by id desc");
            query.setParameter("id", alumni.getAlumni_id());
            List<alumni_education> cur=new ArrayList<>();
            for (final Object fetch : query.list()) {
                cur.add((alumni_education)fetch);
            }
            return cur;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public boolean add(alumni_education alumni){
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            System.out.println(alumni.getAlumni_id());
            session.save(alumni);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }
    @Override
    public boolean updateDetails(alumni_education alumni){
        try (Session session = SessionUtil.getSession()) {
            Transaction tx = null;
            tx = session.beginTransaction();
            System.out.println("In Update Txn");
            Query query = session.createQuery("update alumni_education set degree=:deg,passing_year=:py,joining_year=:jy,college_name=:cn,address=:adr "+"where id=:id");
            query.setParameter("id", alumni.getId());
            query.setParameter("deg", alumni.getDegree());
            query.setParameter("py", alumni.getPassing_year());
            query.setParameter("jy",alumni.getJoining_year());
            query.setParameter("cn",alumni.getCollege_name());
            query.setParameter("adr",alumni.getAddress());
            int result = query.executeUpdate();
            tx.commit();
            if(result>=1) return true;
            else return false;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }
    @Override
    public boolean deleteDetails(alumni_education alumni){
        try (Session session = SessionUtil.getSession()) {
            System.out.println("In delete Txn");
            Transaction tx = null;
            tx = session.beginTransaction();
            Query query = session.createQuery("delete from alumni_education where id=:id");
            query.setParameter("id", alumni.getId());
            int result = query.executeUpdate();
            tx.commit();
            if(result>=1) return true;
            else return false;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }
}
