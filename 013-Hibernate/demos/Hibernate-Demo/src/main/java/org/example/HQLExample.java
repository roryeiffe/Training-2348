package org.example;

import org.example.models.Employee;
import org.example.util.SessionProvider;
import org.hibernate.Session;
import org.hibernate.query.Query;


public class HQLExample {
    public static void main(String[] args) {
        // READ
        Session session1 = SessionProvider.getSession();
        // HQL reference class and field names as opposed to the table/column names
        String hql = "FROM Employee WHERE firstName='Lois'";
        Query query = session1.createQuery(hql, Employee.class);
        System.out.println(query.getResultList());
        session1.close();



        // UPDATE - In practice, it's best to update single objects by just editing fields and persisting to the database
        // This process of using HQL to make updates are only useful for bulk/batch updates
        session1 = SessionProvider.getSession();
        session1.beginTransaction();

        // Set up our query string including placeholders:
        Query query1 = session1.createQuery("UPDATE Employee SET firstName=:emp_name WHERE id=:emp_id");
        // Assign real values to the placeholders:
        query1.setParameter("emp_name", "Stewie");
        query1.setParameter("emp_id", 6);

        int count = query1.executeUpdate();
        System.out.println("Count (update): " + count);

        session1.getTransaction().commit();
        session1.close();

        // DELETE - we can use the following for deleitng in batches
        // but for deleting a singular entity, we can use session.delete(object)
        session1 = SessionProvider.getSession();
        session1.beginTransaction();
        Query query2 = session1.createQuery("DELETE Employee WHERE lastName=:name_to_delete");
        query2.setParameter("name_to_delete", "Griffin");
        count = query2.executeUpdate();

        System.out.println("Count (delete): " + count);

        session1.getTransaction().commit();
        session1.close();


    }
}
