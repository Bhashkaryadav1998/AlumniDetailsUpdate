package com.example.erp.dao.implementation;

import com.example.erp.bean.alumni_education;
import com.example.erp.bean.alumni_organisation;
import com.example.erp.dao.alumniDetailsDao;
import com.example.erp.dao.alumniOrganisationDao;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class alumniOrganisationDaoImpl implements alumniOrganisationDao {
    @Override
    public List<alumni_organisation> findMax(alumni_organisation alumni){
        try (Session session = SessionUtil.getSession()) {

            Query query = session.createQuery("from alumni_organisation where alumni_id=:id");
            query.setParameter("id", alumni.getAlumni_id());
            List<alumni_organisation> cur =new ArrayList<>();
            for (final Object fetch : query.list()) {
                cur.add((alumni_organisation) fetch);
            }
            return cur;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public boolean add(alumni_organisation alumni){
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(alumni);
            transaction.commit();
            return true;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }
    @Override
    public boolean updateDetails(alumni_organisation alumni){
        try (Session session = SessionUtil.getSession()) {
            System.out.println("In DaoImpl");
            Transaction tx = null;
            tx = session.beginTransaction();
            Query query = session.createQuery("update alumni_organisation set organisation=:org, position=:pos, joining_date=:jd,leaving_date=:ld "+"where id=:id");
            query.setParameter("id", alumni.getId());
            query.setParameter("org", alumni.getOrganisation());
            query.setParameter("pos", alumni.getPosition());
            query.setParameter("jd",alumni.getJoining_date());
            query.setParameter("ld",alumni.getLeaving_date());
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
    public boolean deleteDetails(alumni_organisation alumni){
        try (Session session = SessionUtil.getSession()) {
            Transaction tx = null;
            tx = session.beginTransaction();
            Query query = session.createQuery("delete from alumni_organisation where id=:id");
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
