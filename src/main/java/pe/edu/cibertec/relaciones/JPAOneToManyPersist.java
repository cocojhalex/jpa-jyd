package pe.edu.cibertec.relaciones;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.cibertec.entity.Categoria;
import pe.edu.cibertec.entity.Libro;

import java.util.Arrays;
import java.util.Date;

public class JPAOneToManyPersist {

    public static void main(String[] args) {

        //referenciar al EMF y EM
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
        EntityManager em = emf.createEntityManager();

        //crear categoria

        Categoria categoria = new Categoria("C200", "Categoria 200", null);

        // crear libros
        Libro libro01 = new Libro("A201", "Titulo", "Autor", new Date(), 34.56, categoria);
        Libro libro02 = new Libro("A202", "Titulo", "Autor", new Date(), 34.56, categoria);
        Libro libro03 = new Libro("A203", "Titulo", "Autor", new Date(), 34.56, categoria);

        // agregar libros a la categoria
        categoria.setLibros(Arrays.asList(libro01, libro02, libro03));

        // persist
        em.getTransaction().begin();
        em.persist(categoria);
        em.getTransaction().commit();

    }



}
