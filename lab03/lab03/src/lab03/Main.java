package lab03;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner =  new Scanner(System.in);
		
		// Exibe menu de opções
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Exibir lista de Sinistros");
        System.out.println("2 - Exibir lista de Clientes");
        System.out.println("3 - Sair");
		
		
        // Lê opção escolhida pelo usuário
        int opcao = scanner.nextInt();

        // Executa ação de acordo com a opção escolhida
        switch (opcao) {
        
            case 1:
                // Exibe lista de sinistros
                System.out.println("Lista de sinistros:");
                for (Sinistro sinistro : Seguradora.listaSinistros) {
                    System.out.println(sinistro.getId());
                }
                break;
                
            case 2:
                // Exibe lista de clientes
                System.out.println("Lista de clientes:");
                for (Cliente clientes : Seguradora.listaClientes) {
                    System.out.println(clientes.getNome());
                }
                break;
                
            case 3:
                // Sair
                System.out.println("Saindo...");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

	}

}