package lab03;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;


public class Main {

	public static void main(String[] args) {

   //Instanciando um objeto seguradora
	String nomeseguradora = "Seguradora Unicamp";
	String telefone = "35514626";
	String email = "seguradora@unicamp.br";
	String enderecoseguradora = "Campinas";
	List<Sinistro> listaSinistros = new ArrayList<Sinistro>();
	List<Cliente> listaClientes = new ArrayList<Cliente>();
	Seguradora seguradora = new Seguradora(nomeseguradora,telefone,email,enderecoseguradora,listaSinistros,listaClientes);
	
	
	//Instanciando primeiro cliente PF
	String nome = "Daniele";
	String endereco = "Avenida 1";
	String tipoCliente = "PF";
	String cpf = "123.456.789-10";
	String genero = "feminimo";
	LocalDate dataLicenca = LocalDate.parse("2010-05-18");
	String educacao = "superior";
	LocalDate dataNascimento = LocalDate.parse("2000-07-18");
	String classeEconomica = "classe media";
		
	ClientePF novoclientePF = new ClientePF(nome,endereco,tipoCliente,cpf,
			genero,dataLicenca,educacao,dataNascimento,classeEconomica);
	
	//Cadastrando e removendo o cliente
	seguradora.cadastrarCliente(novoclientePF);
	seguradora.removerCliente(nome);
	
	//Instanciando primeiro cliente PJ
	String nome2 = "Unicamp";
	String endereco2 = "Avenida 2";
	String tipoCliente2 = "PJ";
	String cnpj = "46.068.425/0001-33";
	LocalDate dataFundacao = LocalDate.parse("1990-05-18");
	
	ClientePJ novoclientePJ = new ClientePJ(nome2,endereco2,tipoCliente2,cnpj,dataFundacao);
	
	//Cadastrando um cliente PJ
	seguradora.cadastrarCliente(novoclientePJ);
	
	
	//Chamando métodos validarCPF e validar CNPJ
	if(novoclientePF.validarCPF(cpf)) {
		System.out.println("O CPF informado é valido");
	}
	
	else {
		System.out.println("O CPF informado é invalido");
	}
	
	
	if(novoclientePJ.validarCNPJ(cnpj)) {
		System.out.println("O CNPJ informado é valido");
	}
	
	else {
		System.out.println("O CNPJ informado é invalido");
	}
	
	
	//Instanciando dois veiculos 
	Veiculo veiculo1 = new Veiculo("ABC-1234", "Ford", "Fiesta", 2021);
	Veiculo veiculo2 = new Veiculo("DEF-5678", "Chevrolet", "Onix", 2023);

	//Adicionando veiculos a clientes instanciados 
	novoclientePF.adicionarVeiculo(veiculo1);
	novoclientePJ.adicionarVeiculo(veiculo2);
	
	
	//Cadastrando clientes PF e PJ na seguradora 
	seguradora.cadastrarCliente(novoclientePF);
	seguradora.cadastrarCliente(novoclientePJ);
	
	//Gerando sinistro
	LocalDate data = LocalDate.parse("2023-07-18");
	seguradora.gerarSinistro(data,endereco,seguradora,veiculo1,novoclientePF);
	

	//Chamando metodo toString de cada classe
	System.out.println(seguradora.toString());
	System.out.println(novoclientePF.toString());
	System.out.println(novoclientePJ.toString());
	System.out.println(veiculo1.toString());
	System.out.println(veiculo2.toString());
	
	//Chamando metodos da classe seguradora
	seguradora.listarClientes(tipoCliente2);
	seguradora.visualizarSinistro(nome);
	seguradora.listarSinistros();
	
	//metodo que exibe menu de opcoes ao usuario
	menu(seguradora);
	
	}
	

	public static void menu(Seguradora seguradora) {
	    Scanner scanner = new Scanner(System.in);
	    
	    int opcao = 0;

	    do {
	        System.out.println("\nEscolha uma opção do menu:\n");
	        System.out.println("1 - Cadastrar Cliente PF");
	        System.out.println("2 - Cadastrar Cliente PJ");
	        System.out.println("3 - Cadastrar um veiculo");
	        System.out.println("4 - Listar clientes");
	        System.out.println("5 - Sair");

	        opcao = scanner.nextInt();
	        scanner.nextLine();

	        switch (opcao) {
	        
	            case 1:
	                //Cadastrar Cliente PF
	                System.out.print("Nome: ");
	                String nomePF = scanner.nextLine();

	                System.out.print("Endereço: ");
	                String enderecoPF = scanner.nextLine();

	                System.out.print("CPF: ");
	                String cpf = scanner.nextLine();

	                System.out.print("Gênero: ");
	                String genero = scanner.nextLine();

	                System.out.print("Data de licença (aaaa-mm-dd): ");
	                LocalDate dataLicenca = LocalDate.parse(scanner.nextLine());

	                System.out.print("Nível de educação: ");
	                String educacao = scanner.nextLine();

	                System.out.print("Data de nascimento (aaaa-mm-dd): ");
	                LocalDate dataNascimento = LocalDate.parse(scanner.nextLine());

	                System.out.print("Classe econômica: ");
	                String classeEconomica = scanner.nextLine();

	                ClientePF novoClientePF = new ClientePF(nomePF, enderecoPF, "PF", cpf, genero, dataLicenca, educacao, dataNascimento, classeEconomica);
	                seguradora.cadastrarCliente(novoClientePF);

	                System.out.println("Cliente PF cadastrado com sucesso!");

	                break;

	            case 2:
	            	
	                // Cadastrar Cliente PJ
	                System.out.print("Nome: ");
	                String nomePJ = scanner.nextLine();

	                System.out.print("Endereço: ");
	                String enderecoPJ = scanner.nextLine();

	                System.out.print("CNPJ: ");
	                String cnpj = scanner.nextLine();

	                System.out.print("Data de fundação (aaaa-mm-dd): ");
	                LocalDate dataFundacao = LocalDate.parse(scanner.nextLine());

	                ClientePJ novoClientePJ = new ClientePJ(nomePJ, enderecoPJ, "PJ", cnpj, dataFundacao);
	                seguradora.cadastrarCliente(novoClientePJ);

	                System.out.println("Cliente PJ cadastrado com sucesso!");

	                break;

	            case 3:
	            	
	                //Criar um  veículo
	                System.out.print("Placa do veículo: ");
	                String placa = scanner.nextLine();
	
	                System.out.print("Marca: ");
	                String marca = scanner.nextLine();
	
	                System.out.print("Modelo: ");
	                String modelo = scanner.nextLine();
	
	                System.out.print("Ano de fabricação: ");
	                int ano = scanner.nextInt();
	
	                Veiculo veiculo = new Veiculo(placa, marca, modelo, ano);
	                
	                break;
	                
	            case 4:
	            	
	            	//Listar clientes
	            	System.out.print("Insira o tipo do cliente PJ ou PF: ");
	                String tipoCliente = scanner.nextLine();
	                
	            	seguradora.listarClientes(tipoCliente);
	            	
	            	break;
	            	
	            case 5:
	                System.out.println("Encerrando programa");
	                scanner.close();
	                System.exit(0);
	                break;

	   }
	        
	    } while(opcao!=5);
	    
	}

}