package com.kgisl.JPAProject;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        // Create an EntityManagerFactory and retrieve an EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");
        EntityManager em = emf.createEntityManager();
        // Create and persist a Book entity
        Book book = new Book();
        book.setId(1L);
        book.setTitle("The Great Gatsby");
        book.setAuthor("F. Scott Fitzgerald");

        Book anotherBook = new Book();
        anotherBook.setId(2L);
        anotherBook.setTitle("To Kill a Mockingbird");
        anotherBook.setAuthor("Harper Lee");

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(book);
        em.persist(anotherBook);

        // transaction.commit();

        // Retrieve all books
        // List<Book> allBooks = getAllBooks(em);
        // Use JPQL to retrieve all books
        // Query query = em.createQuery("SELECT b FROM Book b");
        List<Book> allBooks = em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
        System.out.println("All Books:");
        for (Book b : allBooks) {
            System.out.println(b.getId() + ": " + b.getTitle() + " by " + b.getAuthor());
        }

        // Retrieve the Book entity
        Book retrievedBook = em.find(Book.class, 1L);
        System.out.println("Retrieved Book: " + retrievedBook.getTitle() + " by " + retrievedBook.getAuthor());
        // transaction.commit();=>Persitent context will be active so still values can be updated
        // this is possible only when this entity is within same em

        // Update the Book entity
        Book bookToUpdate = em.find(Book.class, 1L);
        bookToUpdate.setTitle("Potter");
        bookToUpdate.setAuthor("J.K. Rowling");
        System.out.println("Updated Book: " + bookToUpdate.getTitle() + " by " + bookToUpdate.getAuthor());

        // Find the book to delete
        Book bookToDelete = em.find(Book.class, 1L);
        em.remove(bookToDelete);
        System.out.println("Deleted Book ID 1L");
        // transaction.commit();

        // Query after delete
        List<Book> allBooksAfterDelete = em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
        System.out.println("All Books:");
        for (Book b : allBooksAfterDelete) {
            System.out.println(b.getId() + ": " + b.getTitle() + " by " + b.getAuthor());
        }

        // Close the EntityManager and EntityManagerFactory
        em.close();
        emf.close();

    }
}
