package lab04;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class AppMain {

	public AppMain() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
	
	//Instanciando dois veiculos 
	Veiculo veiculo1 = new Veiculo("ABC-1234", "Ford", "Fiesta", 2021);
	Veiculo veiculo2 = new Veiculo("DEF-5678", "Chevrolet", "Onix", 2023);

	//Instanciando primeiro cliente PF
	String nome = "Daniele";
	String endereco = "Avenida 1";
	String tipoCliente = "PF";
	double valorSeguro = 1000.00;
	String cpf = "123.456.789-10";
	String genero = "feminimo";
	LocalDate dataLicenca = LocalDate.parse("2010-05-18");
	String educacao = "superior";
	LocalDate dataNascimento = LocalDate.parse("2000-07-18");
	String classeEconomica = "classe media";
	int idade = 23;
	
	ClientePF novoclientePF = new ClientePF(nome,endereco,tipoCliente,valorSeguro,cpf,
			genero,dataLicenca,educacao,dataNascimento,classeEconomica,idade);

	//Instanciando primeiro cliente PJ
	String nome2 = "Unicamp";
	String endereco2 = "Avenida 2";
	String tipoCliente2 = "PJ";
	double valorSeguro2 = 50000.00;
	String cnpj = "46.068.425/0001-33";
	LocalDate dataFundacao = LocalDate.parse("1990-05-18");
	int qtdeFuncionarios = 50;
	
	ClientePJ novoclientePJ = new ClientePJ(nome2,endereco2,tipoCliente2,valorSeguro2,cnpj,
			dataFundacao,qtdeFuncionarios);
	
	//Instanciando um objeto seguradora
	String nomeseguradora = "Seguradora Unicamp";
	String telefone = "35514626";
	String email = "seguradora@unicamp.br";
	String enderecoseguradora = "Campinas";
	List<Sinistro> listaSinistros = new ArrayList<Sinistro>();
	List<Cliente> listaClientes = new ArrayList<Cliente>();
	Seguradora seguradora = new Seguradora(nomeseguradora,telefone,email,enderecoseguradora,listaSinistros,listaClientes);
	
	menu();
}
	
public static void menu() {
	Scanner scanner = new Scanner(System.in);
    MenuOperacoes opcao = null;
    
    while (opcao != MenuOperacoes.SAIR) {
        System.out.println("Selecione uma opção:");
        System.out.println("1 - Cadastros");
        System.out.println("2 - Listar");
        System.out.println("3 - Excluir");
        System.out.println("4 - Gerar Sinistro");
        System.out.println("5 - Transferir Seguro");
        System.out.println("6 - Calcular Receita Seguradora");
        System.out.println("0 - Sair");
        
        int entrada = scanner.nextInt();
        
        switch (entrada) {
            case 1:
                opcao = MenuOperacoes.CADASTROS;
                break;
            case 2:
                opcao = MenuOperacoes.LISTAR;
                break;
            case 3:
                opcao = MenuOperacoes.EXCLUIR;
                break;
            case 4:
                opcao = MenuOperacoes.GERAR_SINISTRO;
                break;
            case 5:
                opcao = MenuOperacoes.TRANSFERIR_SEGURO;
                break;
            case 6:
                opcao = MenuOperacoes.CALCULAR_RECEITA_SEGURADORA;
                break;
            case 0:
                opcao = MenuOperacoes.SAIR;
                break;
            default:
                System.out.println("Opção inválida");
                continue;
        }
        
        // Realize a ação correspondente à opção selecionada pelo usuário
        switch (opcao) {
            case CADASTROS:
                // Implemente a lógica para cadastrar clientes, veículos e seguradoras aqui
                break;
            case LISTAR:
                // Implemente a lógica para listar clientes, veículos e sinistros aqui
                break;
            case EXCLUIR:
                // Implemente a lógica para excluir clientes, veículos e sinistros aqui
                break;
            case GERAR_SINISTRO:
                // Implemente a lógica para gerar um sinistro aqui
                break;
            case TRANSFERIR_SEGURO:
                // Implemente a lógica para transferir um seguro aqui
                break;
            case CALCULAR_RECEITA_SEGURADORA:
                // Implemente a lógica para calcular a receita da seguradora aqui
                break;
            case SAIR:
                System.out.println("Saindo...");
                break;
        }
    }
    
    scanner.close();


}
}
	
	

