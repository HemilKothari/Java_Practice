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

        while (true) {
            System.out.println("Badminton Scheduling System");
            System.out.println("1. Schedule user in a batch");
            System.out.println("2. Delete user in a batch");
            System.out.println("3. View all users by batches");
            System.out.println("4. View all users in a batch");
            System.out.println("5. Exit");
            System.out.print("Enter a choice(1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            Batch batch;
            int batchId = 0;
            int maxCapacity = 0;
            User user;
            Query query;

            switch (choice) {
                case 1:
                    //TODO: Add User to Batch
                    System.out.print("\nEnter batch id: ");
                    batchId = scanner.nextInt();
                    scanner.nextLine();

                    batch = session.get(Batch.class, batchId);
                    System.out.println(batch);
                    if (batch == null) {
                        System.out.println("Batch ID not found in the database.");
                        return; // or handle accordingly
                    }
                    maxCapacity = batch.getMaxCapacity();
                    if (maxCapacity > 0) {
                        System.out.print("\nEnter username: ");
                        String userName = scanner.nextLine();
                        user = new User(0, userName, batch);

                        List<User> userList = batch.getUsers();
                        if (userList == null) userList = new ArrayList<>();
                        userList.add(user);
                        batch.setUsers(userList);
                        batch.setMaxCapacity(maxCapacity - 1);

                        session.save(user);
                        System.out.println(userName + " added in batch " + batchId);
                    } else System.out.println("batch is full.");

                    transaction.commit();
                    break;

                case 2:
                    // TODO: Delete user from a batch
                    System.out.print("Enter User Name: ");
                    String userName = scanner.nextLine();

                    query = session.createQuery("from User where userName = :userName");
                    query.setParameter("userName", userName);
                    user = (User) query.uniqueResult();

                    if (user == null) {
                        System.out.println("No user found.");
                        return;
                    }

                    batch = user.getBatchInfo();
                    maxCapacity = batch.getMaxCapacity();
                    batch.setMaxCapacity(maxCapacity + 1);
                    session.delete(user);
                    System.out.println(userName + " deleted.");

                    transaction.commit();
                    break;

                case 3:
                    // TODO: View all users by batches
                    query = session.createQuery("from Batch");
                    ArrayList<Batch> batchList = (ArrayList<Batch>) query.list();
                    for (Batch batch1 : batchList) {
                        System.out.println(batch1);
                        batchId = batch1.getBatchId();
                        Query userQuery = session.createQuery("from User where batchId = :batchId", User.class);
                        userQuery.setParameter("batchId", batchId);
                        ArrayList<User> userList = (ArrayList<User>) userQuery.list();

                        for (User user1 : userList)
                            System.out.println(user1);
                    }

                    transaction.commit();
                    break;

                case 4:
                    // TODO: View all users in a batch
                    System.out.print("\nEnter batch id: ");
                    batchId = scanner.nextInt();
                    scanner.nextLine();

                    query = session.createQuery("from User where batchId = :batchId", User.class);
                    query.setParameter("batchId", batchId);
                    ArrayList<User> userList = (ArrayList<User>) query.list();

                    for (User user2 : userList)
                        System.out.println(user2);

                    transaction.commit();
                    break;

                case 5:
                    // TODO: Exit
                    System.out.println("Exiting...");
                    session.close();
                    System.exit(0);

                default:
                    System.out.println("Enter choice from given options.");
            }
        }

    }
}
