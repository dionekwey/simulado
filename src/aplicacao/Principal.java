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
				System.out.println("Em Construção!");
			break;
			
			case 2:
				em = emf.createEntityManager();
				System.out.println("Digite o código de um álbum: ");
				cod = Integer.parseInt(sc.nextLine());
				Espetaculo es = em.find(Espetaculo.class, cod);
				if (es == null) {
					System.out.println("Código inexistente!");
				}
				else {
					System.out.println("Nome do Espetáculo: " + es.getNome());
					System.out.println("Preço Total: " + es.precoTotal());
				}
				em.close();
			break;

			case 3:
				System.out.println("Fim do programa!");
			break;
			
			default : System.out.println("Opção inválida!");
			}
			
		} while (op != 3);
		
		emf.close();
		sc.close();
	}
}
