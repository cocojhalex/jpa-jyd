package pe.edu.cibertec.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.cibertec.entity.Libro;

public class JPARemove {

    public static void main(String[] args) {

        //referenciar al INF y EM
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
        EntityManager em = emf.createEntityManager();


        //consultar libro
        Libro libro = em.find(Libro.class, "A4");

        //eliminar libro

        em.getTransaction().begin();
        em.remove(libro);
        em.getTransaction().commit();

    }
}
