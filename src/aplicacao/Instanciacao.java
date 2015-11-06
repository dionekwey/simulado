package aplicacao;

import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Banda;

public class Instanciacao {

	public static void main(String args[]) {
		
		Banda b1 = new Banda(null, "Iron Maiden", BigDecimal("200.00"));
		
		Banda b2 = new Banda(null, "ACDC", BigDecimal("200.00"));
		
		Banda b3 = new Banda(null, "Bon Jovi", BigDecimal("180.00"));
		
		Banda b4 = new Banda(null, "Scorpions", BigDecimal("160.00"));
		
		Banda b5 = new Banda(null, "Nightwish", BigDecimal("150.00"));

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbConnect");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.persist(b1);
		em.persist(b2);
		em.persist(b3);
		em.persist(b4);
		em.persist(b5);
		
		em.getTransaction().commit();

		System.out.println("Pronto!");
		
		em.close();
		emf.close();
	}

	private static BigDecimal BigDecimal(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
