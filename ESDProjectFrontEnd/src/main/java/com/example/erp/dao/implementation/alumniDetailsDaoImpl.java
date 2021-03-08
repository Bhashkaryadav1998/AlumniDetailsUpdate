package com.example.erp.dao.implementation;

import com.example.erp.bean.alumni_details;
import com.example.erp.dao.alumniDetailsDao;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class alumniDetailsDaoImpl implements alumniDetailsDao{
    @Override
    public alumni_details loginValidate(alumni_details alumni){
        try (Session session = SessionUtil.getSession()) {
            Query query = session.createQuery("from alumni_details where email=:email and password=:password");
            query.setParameter("email", alumni.getEmail());
            query.setParameter("password",alumni.getPassword());
            for (final Object fetch : query.list()) {
                return (alumni_details) fetch;
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
        return null;
    }
    @Override
    public alumni_details viewDetails(alumni_details alumni){
        try (Session session = SessionUtil.getSession()) {

            Query query = session.createQuery("from alumni_details where id=:id");
            query.setParameter("id", alumni.getId());
            System.out.println(query.list());
            for (final Object fetch : query.list()) {
                return (alumni_details) fetch;
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
        return null;
    }
    @Override
    public alumni_details updateDetails(alumni_details alumni){
        try (Session session = SessionUtil.getSession()) {
            System.out.println("In DaoImpl");
            Transaction tx = null;
            tx = session.beginTransaction();
            Query query = session.createQuery("update alumni_details set contact_number=:contact_number,email=:email "+"where id=:id");
            query.setParameter("id", alumni.getId());
            query.setParameter("email", alumni.getEmail());
            query.setParameter("contact_number", alumni.getContact_number());
            int result = query.executeUpdate();
            tx.commit();
            if(result>=1) return alumni;
            else return null;
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }
}
