package aplicacao;

import java.util.Scanner;

public class Tela {
	public static int menu(Scanner sc) {
		System.out.println("1 - Cadastrar um novo espetáculo");
		System.out.println("2 - Mostrar os dados de um espetáculo");
		System.out.println("3 - Sair");
		return Integer.parseInt(sc.nextLine());
	}
}
