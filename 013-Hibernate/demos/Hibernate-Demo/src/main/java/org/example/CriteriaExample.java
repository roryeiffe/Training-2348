package org.example;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.models.Employee;
import org.example.util.SessionProvider;
import org.hibernate.Session;

public class CriteriaExample {
    public static void main(String[] args) {
        Session session = SessionProvider.getSession();

        // builder will be used to create query
        CriteriaBuilder builder = session.getCriteriaBuilder();

        // query object will be used to define the query
        CriteriaQuery<Employee> query = builder.createQuery(Employee.class);

        Root<Employee> root = query.from(Employee.class);
        query.select(root)
                .where(builder.equal(root.get("email"), "han@yahoo.com"));

        Query query1 = session.createQuery(query);
        System.out.println(query1.getResultList());


    }
}
