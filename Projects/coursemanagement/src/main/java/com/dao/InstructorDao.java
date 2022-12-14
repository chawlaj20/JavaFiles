package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.entity.Instructor;
import com.util.HibernateUtil;

public class InstructorDao {
    
    /**
     * Save Instructor
     * @param instructor
     */
    public void saveInstructor(Instructor instructor) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(instructor);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

 

    /**
     * Update Instructor
     * @param instructor
     */
    public void updateInstructor(Instructor instructor) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(instructor);
            
            Instructor instructor2=session.get(Instructor.class,1);
            instructor2.setFirstName("ritu");
            instructor2.setEmail("ritu@gmail.com");
            
            System.out.println("update successfully");
            // commit transaction
            transaction.commit();
        } 
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

 

    /**
     * Delete Instructor
     * @param id
     */
    public void deleteInstructor(int id) {

 

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a instructor object
            Instructor instructor = session.get(Instructor.class, id);
            if (instructor != null) {
                session.delete(instructor);
                System.out.println("instructor is deleted");
            }


            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

 

    /**
     * Get Instructor By ID
     * @param id
     * @return
     */
    public Instructor getInstructor(int id) {

 

        Transaction transaction = null;
        Instructor instructor = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an instructor object
            instructor = session.get(Instructor.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return instructor;
    }
    
    /**
     * Get all Instructors
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Instructor> getAllInstructor() {

 

        Transaction transaction = null;
        List<Instructor> listOfInstructor = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an instructor object
            
            listOfInstructor = session.createQuery("from Instructor").getResultList();
            
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfInstructor;
    }
}