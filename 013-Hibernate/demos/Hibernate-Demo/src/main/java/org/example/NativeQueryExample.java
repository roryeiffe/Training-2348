package org.example;

import jakarta.persistence.Query;
import org.example.models.Employee;
import org.example.util.SessionProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class NativeQueryExample {
    public static void main(String[] args) {
        Employee employee = new Employee("Luke", "Skywalker", "l@gmail.com");
        Employee employee2 = new Employee("Han", "Solo", "han@yahoo.com");
        Employee employee3 = new Employee("Leia", "Organa", "leai@gmail.com");

        Session session = SessionProvider.getSession();
        // persist some data to the db:
        try {
            Transaction transaction = session.beginTransaction();
//            session.persist(employee);
//            session.persist(employee2);
//            session.persist(employee3);
            transaction.commit();
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            session.close();
        }

        // Write a native query to retrieve employees with @gmail
        Session session1 = SessionProvider.getSession();
        String sql = "SELECT * FROM employee WHERE email LIKE '%gmail.com%'";
        try {

            // specify the SQL string and the class of entities that will be returned:
            Query query = session1.createNativeQuery(sql, Employee.class);
            List<Employee> employeeList = query.getResultList();
            System.out.println(employeeList);
        } catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            session1.close();
        }
    }
}
