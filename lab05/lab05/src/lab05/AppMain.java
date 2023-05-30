package lab05;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class AppMain {
	
	public AppMain() {
		
	}
	
	public static void main(String[] args) {
	
	System.out.println("Bem vindo ao sistema da seguradora\n");
		
	//Instanciando tres veiculos 
	Veiculo veiculo1 = new Veiculo("ABC-1234", "Ford", "Fiesta", 2021);
	Veiculo veiculo2 = new Veiculo("DEF-5678", "Chevrolet", "Onix", 2022);
	Veiculo veiculo3 = new Veiculo("GHI-1012", "Bmw", "Bmw x1", 2023);
	
   //Criando um objeto do tipo clientePF
	String nome = "Daniele";
	String telefone = "3551-4626";
	String endereco = "Avenida 1";
	String email = "daniele@ic.unicamp.br";
	String tipoCliente = "PF";
	String cpf = "123.456.789-10";
	String genero = "feminimo";
	String educacao = "superior";
	LocalDate dataNascimento = LocalDate.parse("2000-07-18");
	
	//Verifica se nome ou cpf informado é valido
	if(!Validacao.validarCPF(cpf) || !Validacao.validaNome(nome)) {
		System.out.println("Nome ou CPF inserido inválido\n");
	}
	
	//instancia clientePF
	ClientePF novoclientePF = new ClientePF(nome,telefone,endereco, email, tipoCliente, 
			cpf,genero, educacao, dataNascimento);

	//Criando um objeto do tipo clientePJ
	String nome2 = "Unicamp";
	String endereco2 = "Avenida 2";
	String telefone2 = "123456789";
	String email2 = "unicamp@unicamp.br";
	String tipoCliente2 = "PJ";
	double valorSeguro2 = 50000.00;
	String cnpj = "46.068.425/0001-33";
	LocalDate dataFundacao = LocalDate.parse("1990-05-18");
	int qtdeFuncionarios = 50;
	
	//Verifica se nome ou cnpj informado é valido
	if(!Validacao.validarCNPJ(cnpj) || !Validacao.validaNome(nome2)) {
		System.out.println("Nome ou CNPJ inserido inválido\n");
	}
	
	//instancia clientePJ
	ClientePJ novoclientePJ = new ClientePJ(nome2, telefone2, endereco2,
    		email2,tipoCliente2, cnpj, dataFundacao, qtdeFuncionarios);
	
    //Instanciando um objeto seguradora
	String cnpjseguradora = "46.068.425/0001-33";
	String nomeseguradora = "Seguradora Unicamp";
	String telefoneseguradora = "35514626";
	String emailseguradora = "seguradora@unicamp.br";
	String enderecoseguradora = "Campinas";
	
	Seguradora seguradora = new Seguradora(cnpjseguradora, nomeseguradora, telefoneseguradora, 
			emailseguradora, enderecoseguradora);
	
	//Instanciando um seguroPF na seguradora Unicamp para o cliente PF
	LocalDate dataInicio = LocalDate.parse("2023-05-24");
	LocalDate dataFim = LocalDate.parse("2024-05-23");
	
	seguradora.gerarSeguro(tipoCliente, dataInicio, dataFim, seguradora, 0.0, null, 
			veiculo1, novoclientePF);
	
	//Adiciona o cliente na lista de clientes da seguradora
	seguradora.cadastrarCliente(novoclientePF);
	
	// Obter a lista de seguros da seguradora
	ArrayList<Seguro> listaSeguros = seguradora.getListaSeguros();

	// Verificar se a lista de seguros não está vazia
	if (!listaSeguros.isEmpty()) {
	    // Obter o último seguro da lista (assumindo que o último seguro é o mais recente)
	    Seguro ultimoSeguroPF = listaSeguros.get(listaSeguros.size() - 1);
	    
	    
	    // Gerando um sinistro para o SeguroPF, que e o ultimo seguro gerado
	    LocalDate dataSinistro = LocalDate.now();
	    String enderecoSinistro = "Endereco sinistro PF";
	    
	    ultimoSeguroPF.gerarSinistro(dataSinistro, enderecoSinistro,
	    		seguradora, veiculo3, novoclientePF, null, ultimoSeguroPF);
	    
	    //visualiza informacoes do seguro gerado
	    System.out.println(ultimoSeguroPF.toString()+'\n');
	   
	}
		
	//Instanciando um condutor 
	String cpfcondutor = "135.567.765-10";
    String nomecondutor = "Maria";
    String telefonecondutor = "1235678";
    String enderecocondutor = "Rua A";
    String emailcondutor = "email@maria.com";
    LocalDate dataNasccondutor = LocalDate.parse("2002-05-23");
    
    Condutor condutor = new Condutor(cpfcondutor, nomecondutor, telefonecondutor, enderecocondutor,
    		emailcondutor, dataNasccondutor);
    
	
	//Instanciando uma frota e adicionando veiculos a lista de frotas
	String code = "caminhao";
	Frota frota = new Frota(code);
	frota.addVeiculo(veiculo2);
	frota.addVeiculo(veiculo3);
	
	//Instanciando um seguroPJ na seguradora Unicamp para o cliente PJ
	LocalDate dataInicioPJ = LocalDate.parse("2023-05-24");
	LocalDate dataFimPJ = LocalDate.parse("2024-05-23");
	
	 
	
	seguradora.gerarSeguro(tipoCliente2,dataInicioPJ, dataFimPJ,seguradora, 0.0,
    		frota,null,novoclientePJ);
	
	
	//Adiciona o clientePJ na lista de clientes da seguradora
	seguradora.cadastrarCliente(novoclientePJ);
	

	// Verificar se a lista de seguros não está vazia
	if (!listaSeguros.isEmpty()) {
	    // Obter o último seguro da lista (assumindo que o último seguro é o mais recente)
	    Seguro ultimoSeguroPJ = listaSeguros.get(listaSeguros.size() - 1);

	    // Chamar o método autorizarCondutor no último seguro, passando o condutor como parâmetro
	    ultimoSeguroPJ.autorizarCondutor(condutor);
	    
	    
	    // Gerando um sinistro para o SeguroPJ, que e o ultimo seguro gerado
	    LocalDate dataSinistro = LocalDate.now();
	    String enderecoSinistroPJ = "Endereco sinistro PJ";
	    
	    ultimoSeguroPJ.gerarSinistro(dataSinistro, enderecoSinistroPJ, seguradora, veiculo3, novoclientePJ, 
	    		condutor, ultimoSeguroPJ);
	    
	    //visualiza informacoes do seguro gerado
	    System.out.println(ultimoSeguroPJ.toString()+'\n');
	   
	}

	//Chama o metodo toString de todas as classes utilizadas
	
	System.out.println(novoclientePF.toString()+'\n');
	System.out.println(novoclientePJ.toString()+'\n');
	System.out.println(condutor.toString()+'\n');
	System.out.println(frota.toString()+'\n');
	System.out.println(seguradora.toString()+'\n');
	
	// Obter a lista de sinistros da seguradora
	ArrayList<Sinistro> listaSinistros = seguradora.getListaSinistros();
	
//	Sinistro ultimoSinistro = listaSinistros.get(listaSinistros.size() - 1);
	//ultimoSinistro.toString();
	
	System.out.println(veiculo1.toString()+'\n');
	System.out.println(veiculo2.toString()+'\n');
	System.out.println(veiculo3.toString()+'\n');
	
	menu();
}

 public static void menu() {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Para iniciar cadastre um Seguradora\n");
        
        System.out.print("CNPJ da Seguradora: ");
        String cnpjseguradora = scanner.nextLine();
        
        System.out.print("Nome da Seguradora: ");
        String nomeseguradora = scanner.nextLine();
        
        System.out.print("Telefone da Seguradora: ");
        String telefoneseguradora = scanner.nextLine();
        
        System.out.print("Email da Seguradora: ");
        String emailseguradora = scanner.nextLine();
        
        System.out.print("Endereço da Seguradora: ");
        String enderecoseguradora = scanner.nextLine();
        
        Seguradora seguradora = new Seguradora(cnpjseguradora, nomeseguradora, 
        		telefoneseguradora, emailseguradora, enderecoseguradora);
        
       
        ArrayList<Seguro> listaSeguros = seguradora.getListaSeguros();
        
        while (true) {
            System.out.println("MENU");
            System.out.println("1. Cadastrar Cliente PF");
            System.out.println("2. Cadastrar Cliente PJ");
            System.out.println("3. Cadastrar Veículo");
            System.out.println("4. Cadastrar Frota");
            System.out.println("5. Gerar Seguro PF");
            System.out.println("6. Gerar Seguro PJ");
            System.out.println("7. Gerar Sinistro PF");
            System.out.println("8. Consultar Seguro PF");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("Encerrar o programa");
                    return;

                case 1:
                    ClientePF clientePF = cadastrarClientePF();
                    seguradora.cadastrarCliente(clientePF);
                    System.out.println("Cliente PF cadastrado com sucesso!");
                    break;

                case 2:
                    ClientePJ clientePJ = cadastrarClientePJ();
                    seguradora.cadastrarCliente(clientePJ);
                    System.out.println("Cliente PJ cadastrado com sucesso!");
                    break;

                case 3:
                    cadastrarVeiculo();
                    System.out.println("Veículo cadastrado com sucesso!");
                    break;

                case 4:
                    Frota frota = new Frota("Frota A");
                    cadastrarFrota(frota);
                    System.out.println("Frota cadastrada com sucesso!");
                    break;

                case 5:
                    	gerarSeguroPF(seguradora);
                    break;

                case 6:
                	gerarSeguroPJ(seguradora);
                    break;

                case 7:
                	gerarSinistroPF(seguradora);
                    break;
                    
                case 8:
                	consultarSeguroPF(seguradora);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
 }
 
 public static ClientePF cadastrarClientePF() {
	    Scanner scanner = new Scanner(System.in);

	    System.out.println("CADASTRO DE CLIENTE PF");
	    
	    System.out.print("Nome: ");
	    String nome = scanner.nextLine();
	    
	    System.out.print("Telefone: ");
	    String telefone = scanner.nextLine();
	    
	    System.out.print("Endereço: ");
	    String endereco = scanner.nextLine();
	    
	    System.out.print("Email: ");
	    String email = scanner.nextLine();
	    
	  
	    String tipoCliente = "PF";
	    
	    System.out.print("CPF: ");
	    String cpf = scanner.nextLine();
	    
	    System.out.print("Gênero: ");
	    String genero = scanner.nextLine();
	    
	    System.out.print("Educação: ");
	    String educacao = scanner.nextLine();
	    
	    System.out.print("Data de Nascimento (no formato AAAA-MM-DD): ");
	    String dataNascStr = scanner.nextLine();
	    LocalDate dataNasc = LocalDate.parse(dataNascStr);

	    return new ClientePF(nome, telefone, endereco, email, tipoCliente,
	    		cpf, genero, educacao, dataNasc);
	}
 
 public static ClientePJ cadastrarClientePJ() {
	    Scanner scanner = new Scanner(System.in);

	    System.out.println("CADASTRO DE CLIENTE PJ");
	    
	    System.out.print("Nome: ");
	    String nome = scanner.nextLine();
	    
	    System.out.print("Telefone: ");
	    String telefone = scanner.nextLine();
	    
	    System.out.print("Endereço: ");
	    String endereco = scanner.nextLine();
	    
	    System.out.print("Email: ");
	    String email = scanner.nextLine();
	    
	    System.out.print("Tipo de Cliente: ");
	    String tipoCliente = scanner.nextLine();
	    
	    System.out.print("CNPJ: ");
	    String cnpj = scanner.nextLine();
	    System.out.print("Data de Fundação (no formato AAAA-MM-DD): ");
	    String dataFundacaoStr = scanner.nextLine();
	    LocalDate dataFundacao = LocalDate.parse(dataFundacaoStr);
	    
	    System.out.print("Quantidade de Funcionários: ");
	    int qtdeFuncionarios = scanner.nextInt();

	    return new ClientePJ(nome, telefone, endereco, email, tipoCliente, 
	    		cnpj, dataFundacao, qtdeFuncionarios);
	}

 public static Veiculo cadastrarVeiculo() {
	    Scanner scanner = new Scanner(System.in);

	    System.out.println("CADASTRO DE VEÍCULO");
	    System.out.print("Placa: ");
	    String placa = scanner.nextLine();
	    
	    System.out.print("Marca: ");
	    String marca = scanner.nextLine();
	    
	    System.out.print("Modelo: ");
	    String modelo = scanner.nextLine();
	    System.out.print("Ano de Fabricação: ");
	    int anoFabricacao = scanner.nextInt();
	    scanner.nextLine(); 
	    
	    return new Veiculo(placa, marca, modelo, anoFabricacao);
	}

 public static void cadastrarFrota(Frota frota) {
	    Scanner scanner = new Scanner(System.in);

	    System.out.println("CADASTRO DE FROTA");
	    System.out.print("Informe o número de veículos a serem cadastrados na frota: ");
	    int numVeiculos = scanner.nextInt();
	    scanner.nextLine();

	    for (int i = 0; i < numVeiculos; i++) {
	        System.out.println("\nCadastro do Veículo " + (i + 1));
	        
	        Veiculo veiculo = cadastrarVeiculo();
	        frota.addVeiculo(veiculo);
	    }
	    System.out.println("\nFrota cadastrada com sucesso!");
	}

public static void gerarSeguroPF(Seguradora seguradora) {
	
	//Considera a duracao do seguro a partir de um ano da data atual
	LocalDate dataInicio = LocalDate.now();
	LocalDate dataFim = dataInicio.plusYears(1);
	ClientePF clientepf = cadastrarClientePF(); //Cadastra um cliente do tipo PF
	Veiculo veiculo = cadastrarVeiculo(); // Método para cadastrar o veículo desejado
	
	seguradora.gerarSeguro("PF", dataInicio, dataFim, seguradora, 0.0, null, 
			veiculo,clientepf);
	System.out.println("Seguro PF gerado com sucesso!");
}

public static void gerarSeguroPJ(Seguradora seguradora) {
	
	//Considera a duracao do seguro a partir de um ano da data atual
	LocalDate dataInicio = LocalDate.now();
	LocalDate dataFim = dataInicio.plusYears(1);
	ClientePJ clientepJ = cadastrarClientePJ(); //Cadastra um cliente do tipo PJ
	Frota frota = new Frota("Frota B"); //crio um objeto do tipo frota
	cadastrarFrota(frota); //cadastro veiculos nessa frota
	
	seguradora.gerarSeguro("PJ", dataInicio, dataFim, seguradora, 0.0, frota, 
			null,clientepJ);
	System.out.println("Seguro PJ gerado com sucesso!");
	
}

public static void gerarSinistroPF(Seguradora seguradora) {
	
	// Obter a lista de seguros da seguradora
	ArrayList<Seguro> listaSeguros = seguradora.getListaSeguros();
	
	// Verificar se a lista de seguros não está vazia
	if (!listaSeguros.isEmpty()) {
	    // Obter o último seguro da lista (assumindo que o último seguro é o mais recente)
	    Seguro ultimoSeguroPF = listaSeguros.get(listaSeguros.size() - 1);
	    
	    // Gerando um sinistro para o SeguroPF, que e o ultimo seguro gerado
	    LocalDate dataSinistro = LocalDate.now();
	    String enderecoSinistro = "Endereco sinistro PF";
	    Veiculo veiculo = cadastrarVeiculo();
	    ClientePF clientePF = cadastrarClientePF();
	    
	    ultimoSeguroPF.gerarSinistro(dataSinistro, enderecoSinistro,
	    		seguradora, veiculo, clientePF, null, ultimoSeguroPF);
	    
	    //visualiza informacoes do seguro gerado
	    System.out.println(ultimoSeguroPF.toString()+'\n');
	   
	}
}

public static void consultarSeguroPF(Seguradora seguradora) {
    // Obter a lista de seguros da seguradora
    ArrayList<Seguro> listaSeguros = seguradora.getListaSeguros();

    System.out.println("Seguros PF cadastrados na seguradora:");

    // Percorrer a lista de seguros e imprimir apenas os seguros do tipo PF
    for (Seguro seguro : listaSeguros) {
        if (seguro instanceof SeguroPF) {
            SeguroPF seguroPF = (SeguroPF) seguro; 
            // Imprimir informações do seguro PF
            System.out.println(seguroPF.toString());
          
        }
    }
}


}

	

	


	
	

