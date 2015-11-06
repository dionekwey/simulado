package aplicacao;

import dominio.*;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbConnect");
		EntityManager em = null;
		int cod, op;

		do {
			op = Tela.menu(sc);
			
			switch (op) {
			case 1:
				System.out.println("Em Constru��o!");
			break;
			
			case 2:
				em = emf.createEntityManager();
				System.out.println("Digite o c�digo de um �lbum: ");
				cod = Integer.parseInt(sc.nextLine());
				Espetaculo es = em.find(Espetaculo.class, cod);
				if (es == null) {
					System.out.println("C�digo inexistente!");
				}
				else {
					System.out.println("Nome do Espet�culo: " + es.getNome());
					System.out.println("Pre�o Total: " + es.precoTotal());
				}
				em.close();
			break;

			case 3:
				System.out.println("Fim do programa!");
			break;
			
			default : System.out.println("Op��o inv�lida!");
			}
			
		} while (op != 3);
		
		emf.close();
		sc.close();
	}
}
