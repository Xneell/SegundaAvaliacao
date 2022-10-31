
package teste3;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Sentimentos dos funcionarios!");
		System.out.println(" Feliz  = :-) ");
		System.out.println(" Triste = :-(");
		System.out.println("Digite um emoticons para cada funcionario e seu sentimento: ");
		String humor = input.nextLine();
	
		System.out.println(Humor.testaHumor(humor));
	
		input.close();
	}

}