package com.runner;


import com.model.Batch;
import com.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestScheduler {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Scanner scanner = new Scanner(System.in);

        //TODO: Save Batches Data
//        Batch batch1 = new Batch(0,"7AM - 8AM", 6);
//        Batch batch2 = new Batch(0,"8AM - 9AM", 8);
//        Batch batch3 = new Batch(0,"9AM - 10AM", 4);
//        Batch batch4 = new Batch(0,"10AM - 11AM", 9);
//        Batch batch5 = new Batch(0,"11AM - 12PM", 5);
//        session.save(batch1);
//        session.save(batch2);
//        session.save(batch3);
//        session.save(batch4);
//        session.save(batch5);

        //TODO: Add User to Batch
        System.out.print("\nEnter batch id: ");
        int batchId = scanner.nextInt();
        scanner.nextLine();

        Batch batch = session.get(Batch.class, batchId);
        if (batch == null) {
            System.out.println("Batch ID not found in the database.");
            return; // or handle accordingly
        }
        int maxCapacity = batch.getMaxCapacity();
        if (maxCapacity > 0) {
            System.out.print("\nEnter username: ");
            String userName= scanner.nextLine();
            User user = new User(0, userName, batch);

            List<User> userList = batch.getUsers();
            if (userList == null)
                userList = new ArrayList<>();
            userList.add(user);
            batch.setUsers(userList);
            batch.setMaxCapacity(maxCapacity - 1);

            session.save(user);
            System.out.println(userName + " added in batch " + batchId);
        } else
            System.out.println("batch is full.");


        transaction.commit();
        session.close();
    }
}
