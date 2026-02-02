### 1. Hibernate & JPA Basics

1. What is the difference between **Hibernate** and **JPA**?
1. Explain the role of an **ORM framework** in Java applications.
1. What problems does Hibernate solve compared to plain JDBC?
1. List advantages and disadvantages of using Hibernate.

---

### 2. Annotations for Model Classes

1. What is the purpose of the `@Entity` annotation?
1. Difference between `@Table`, `@Entity`, and `@Column`.
1. Explain `@Id` vs `@GeneratedValue`.
1. What strategies exist for primary key generation in Hibernate?
1. Difference between `@OneToOne`, `@OneToMany`, `@ManyToOne`, and `@ManyToMany`.

---

### 3. hibernate.cfg.xml

1. What is the role of the **hibernate.cfg.xml** file?
1. Name at least five important properties configured in this file.
1. How do you specify database dialect in Hibernate?

---

### 4. XML Overview (Hibernate Mapping XML)

1. What is an `.hbm.xml` file used for?
1. How do you map a class to a table using XML?
1. Compare annotation-based mapping vs XML-based mapping.

---

### 5. Hibernate Architecture

1. Explain the Hibernate architecture diagram (SessionFactory → Session → Transaction → DB).
1. What is the role of the SessionFactory?
1. What is a Session in Hibernate?

---

### 6. Interfaces of Hibernate

1. Difference between:

* Session
* SessionFactory
* Transaction
* Query
* Criteria

1. What happens if you don’t commit a Transaction?

---

### 7. Object-Relational Mapping Concepts

1. What is ORM mapping?

---

### 8. Native SQL

1. What is Native SQL in Hibernate?
1. When would you prefer Native SQL over HQL?
1. How do you execute a native query using Hibernate?
1. What are the downsides of native SQL?

---

### 9. Object States

1. Explain the object states in Hibernate:
  * Transient
  * Persistent
  * Detached

1. What methods move an object between these states?
1. What happens when you call `session.save()`?

---

### 10. HQL (Hibernate Query Language)

1. What is HQL and how is it different from SQL?

---

### 11. Named Queries

1. What are Named Queries?
1. Difference between NamedQuery and NamedNativeQuery.
1. Where are named queries defined?
1. Advantages of named queries over dynamic queries.

---

### 12. ACID Properties

1. Explain ACID properties with real examples.
1. How does Hibernate support transactions?

---

### 13. Caching

1. What is first-level cache in Hibernate?
1. Why is first-level cache enabled by default?
1. What is second-level cache?
1. Difference between:
  * First level cache
  * Second level cache
1. What is the purpose of `@Cacheable`?

---

### 14. Criteria API

1. What is Criteria API used for?
1. Difference between HQL and Criteria API.
