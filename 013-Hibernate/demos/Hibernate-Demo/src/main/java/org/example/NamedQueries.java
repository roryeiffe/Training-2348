package org.example;

import org.example.models.Employee;
import org.example.util.SessionProvider;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class NamedQueries {
    public static void main(String[] args) {
        Session session = SessionProvider.getSession();

        Query query = session.getNamedQuery("viewAllEmployees");
        System.out.println(query.getResultList());

        query = session.getNamedQuery("viewGriffins");
        System.out.println(query.getResultList());

        query = session.getNamedQuery("findByEmail");
        query.setParameter("email", "l@gmail.com");
        System.out.println(query.getResultList());


    }
}
