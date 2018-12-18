package rsvier;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Baas baas = new Baas();
        baas.setNaam("baas1");
        Hond hond = new Hond();
        hond.setNaam("hond1");
        baas.addHond(hond);
//        hond.addBaas(baas);
        
        et.begin();
        em.persist(baas);
        em.persist(hond);
        et.commit();
        em.clear();
        

    }
}
