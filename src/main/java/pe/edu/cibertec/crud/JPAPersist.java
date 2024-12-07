package pe.edu.cibertec.crud;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.cibertec.entity.Libro;

import java.util.Date;

public class JPAPersist {

    public static void main(MysqlxDatatypes.Scalar.String[] args) {
        //referenciar al INF y EM
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
        EntityManager em = emf.createEntityManager();

        //crear libro
        Libro libro = new Libro("A4", "Titulo 4", "Autor 4", new Date(), 50.60, null);

        //registrar libro
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
    }
}
