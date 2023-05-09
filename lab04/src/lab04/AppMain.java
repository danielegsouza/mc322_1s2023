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
	
	if(!Validacao.validarCPF(cpf) || !Validacao.validaNome(nome)) {
		System.out.println("Nome ou CPF inserido inválido");
	}
	
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
	
	if(!Validacao.validarCNPJ(cnpj) || !Validacao.validaNome(nome2)) {
		System.out.println("Nome ou CNPJ inserido inválido");
	}
	
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
	
	//Adicionando veiculos a clientes instanciados 
	novoclientePF.adicionarVeiculo(veiculo1);
	novoclientePJ.adicionarVeiculo(veiculo2);
	
	//Cadastrando clientes PF e PJ na seguradora 
	seguradora.cadastrarCliente(novoclientePF);
	seguradora.cadastrarCliente(novoclientePJ);
	
	//Gerando dois sinistros
	LocalDate data = LocalDate.parse("2023-07-18");
	seguradora.gerarSinistro(data,endereco,seguradora,veiculo1,novoclientePF);
	
	LocalDate data2 = LocalDate.parse("2023-05-07");
	seguradora.gerarSinistro(data2,endereco2,seguradora,veiculo2,novoclientePJ);
	
	//Chamando metodos da classe seguradora
	System.out.println("Listar clientes pelo tipo:");
	seguradora.listarClientes(tipoCliente2);
	
	System.out.println("Visualizar Sinistros de um cliente:");
	seguradora.visualizarSinistro(nome);
	
	System.out.println("Listar Sinistros:");
	seguradora.listarSinistros();
	
	seguradora.calcularReceita();
	
	// Atualiza o valor do seguro de cada cliente
	seguradora.calcularPrecoSeguroCliente(novoclientePF);
	seguradora.calcularPrecoSeguroCliente(novoclientePJ);
	
	// Mostrar a receita total da seguradora
	double receitaTotal = seguradora.calcularReceita();
	System.out.println("Receita total da seguradora: R$" + receitaTotal);
	//Chama a funcao que contem menu de opcoes
	menu();
}
	
public static void menu() {
	
	//Instanciando um objeto seguradora
	String nomeseguradora = "Seguradora Unicamp";
	String telefone = "35514626";
	String email = "seguradora@unicamp.br";
	String enderecoseguradora = "Campinas";
	List<Sinistro> listaSinistros = new ArrayList<Sinistro>();
    List<Cliente> listaClientes = new ArrayList<Cliente>();
    List<Seguradora> listaSeguradoras = new ArrayList<Seguradora>();
    
	Seguradora seguradora = new Seguradora(nomeseguradora,telefone,email,enderecoseguradora,listaSinistros,listaClientes);
	
	listaSeguradoras.add(seguradora);
	
	 Scanner scanner = new Scanner(System.in);
     int opcao = -1;

     do {
         System.out.println("Escolha uma opção:");
         for (MenuOperacoes operacao : MenuOperacoes.values()) {
             System.out.println(operacao.getOperacao() + " - " + operacao.name().replace("_", " "));
         }
         try {
             opcao = Integer.parseInt(scanner.nextLine());
             MenuOperacoes menu = MenuOperacoes.values()[opcao - 1];

             switch (menu) {
                 case CADASTRAR_CLIENTE_PF_PJ:
                      cadastrarCliente(seguradora);
                     break;
                 case CADASTRAR_VEICULO:
                     cadastrarVeiculo(listaClientes);
                     break;
                 case CADASTRAR_SEGURADORA:
                     cadastrarSeguradora(listaClientes, listaSinistros,listaSeguradoras);
                     break;
                 case LISTAR_CLIENTE_POR_SEGURADORA:
                     listarClienteSeguradora(seguradora);
                     break;
                 case LISTAR_SINISTROS_POR_SEGURADORA:
                     listarSinistrosSeguradora(listaSeguradoras);
                     break;
                 case LISTAR_SINISTRO_CLIENTE:
                    listarSinistrosCliente(listaSeguradoras);
                     break;
                 case LISTAR_VEICULO_CLIENTE:
                    listarVeiculosCliente(listaClientes);
                     break;
                 case LISTAR_VEICULO_SEGURADORA:
                     listarVeiculosSeguradora(listaSeguradoras);
                     break;
                 case EXCLUIR_CLIENTE:
                     excluirCliente(listaClientes);
                     break;
                 case EXCLUIR_VEICULO:
                     excluirVeiculo(listaClientes);
                     break;
                 case EXCLUIR_SINISTRO:
                	 excluirSinistro(listaSeguradoras);
                     break;
                 case GERAR_SINISTRO:
                     gerarSinistro(listaSeguradoras);
                     break;
                 case TRANSFERIR_SEGURO:
                     transferirSeguro(listaSeguradoras);
                     break;
                 case CALCULAR_RECEITA_SEGURADORA:
                     calcularReceitaSeguradora(listaSeguradoras);
                     break;
                 case SAIR:
                     System.out.println("Encerrando o sistema");
                     break;
                 default:
                     System.out.println("Opção inválida");
             }

         } catch (NumberFormatException e) {
             System.out.println("Por favor, digite um número válido!");
         } catch (IndexOutOfBoundsException e) {
             System.out.println("Opção inválida. Tente novamente.");
         }

     } while (opcao != 0);

     scanner.close();
 }

public static void cadastrarCliente(Seguradora seguradora) {
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Cadastro de Cliente");
    System.out.println("Nome: ");
    String nome = sc.nextLine();
    
    if(!Validacao.validaNome(nome)) {
    	System.out.println("Nome invalido");
    	
    }
    
    System.out.println("Endereço: ");
    String endereco = sc.nextLine();
    
    System.out.println("Valor do seguro: ");
    double valorSeguro = sc.nextDouble();
    
    sc.nextLine(); 
    System.out.println("CPF/CNPJ: ");
    String cpfCnpj = sc.nextLine();
    
    System.out.println("Tipo de cliente (PF ou PJ): ");
    String tipoCliente = sc.nextLine();
    
    if (tipoCliente.equalsIgnoreCase("pf")) {
    	
    	if(!Validacao.validarCPF(cpfCnpj)) {
   		 System.out.println("O CPF informado é invalido, reinicie a operacao");
   		 
   	}
    	
        System.out.println("Gênero (M/F): ");
        String genero = sc.nextLine();
        
        System.out.println("Data de nascimento (AAAA-MM-DD): ");
        LocalDate dataNascimento = LocalDate.parse(sc.nextLine());
        
        System.out.println("Data da licença de motorista (AAAA-MM-DD): ");
        LocalDate dataLicenca = LocalDate.parse(sc.nextLine());
        
        System.out.println("Nível de escolaridade: ");
        String educacao = sc.nextLine();
        
        System.out.println("Classe econômica: ");
        String classeEconomica = sc.nextLine();
        
        System.out.println("Idade: ");
        int idade = sc.nextInt();
        
        ClientePF clientePF = new ClientePF(nome, endereco, tipoCliente, valorSeguro, cpfCnpj, genero, dataLicenca, educacao, dataNascimento, classeEconomica, idade);
        seguradora.cadastrarCliente(clientePF);
    } 
    else if (tipoCliente.equalsIgnoreCase("pj")) {
    	
    	if(!Validacao.validarCNPJ(cpfCnpj)) {
    		 System.out.println("O CNPJ informado é invalido, reinicie a operacao");
    	}
    	
    	System.out.println("Data de Fundação (AAAA-MM-DD): ");
        LocalDate dataFundacao = LocalDate.parse(sc.nextLine());
       
        System.out.println("Número de funcionários: ");
        int qtdeFuncionarios = sc.nextInt();
        
        ClientePJ clientePJ = new ClientePJ(nome, endereco, tipoCliente, valorSeguro, cpfCnpj, dataFundacao, qtdeFuncionarios);
        seguradora.cadastrarCliente(clientePJ);
        
    } else {
        System.out.println("Tipo de cliente inválido!");
    }
}

public static void listarClienteSeguradora(Seguradora seguradora) {
    System.out.println("Clientes PF:");
    seguradora.listarClientes("pf");
    
    System.out.println("\nClientes PJ:");
    seguradora.listarClientes("pj");
}


public static void cadastrarVeiculo(List<Cliente> listaClientes) {
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Insira o nome do Cliente: ");
    String nomeCliente = sc.nextLine();
    
    Cliente clienteEncontrado = null;
    for (Cliente cliente : listaClientes) {
        if (cliente.getNome().equals(nomeCliente)) {
            clienteEncontrado = cliente;
            break;
        }
    }
    if (clienteEncontrado != null) {
        System.out.println("Cadastro de Veículo");
        System.out.println("Placa: ");
        String placa = sc.nextLine();
        System.out.println("Marca: ");
        String marca = sc.nextLine();
        System.out.println("Modelo: ");
        String modelo = sc.nextLine();
        System.out.println("Ano de fabricação: ");
        int anoFabricacao = sc.nextInt();

        Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricacao);
        clienteEncontrado.adicionarVeiculo(veiculo);
        
    } 
    
    else {
        System.out.println("Cliente não encontrado.");
    }
}


public static void cadastrarSeguradora(List<Cliente> listaClientes,
		List<Sinistro> listaSinistros, List<Seguradora> listaSeguradoras) {
	
    Scanner sc = new Scanner(System.in);
    System.out.println("Cadastro de Seguradora");
    
    System.out.println("Nome: ");
    String nome = sc.nextLine();
    
    System.out.println("Telefone: ");
    String telefone = sc.nextLine();
    
    System.out.println("Email: ");
    String email = sc.nextLine();
    
    System.out.println("Endereço: ");
    String endereco = sc.nextLine();
    
    Seguradora seguradora = new Seguradora(nome, telefone, email, endereco,
    		listaSinistros,listaClientes);
    
    listaSeguradoras.add(seguradora);
}


public static void listarSinistrosPorSeguradora(String nomeSeguradora,List<Seguradora> listaSeguradoras) {
    for (Seguradora seguradora : listaSeguradoras) {
    	
        if (seguradora.getNome().equals(nomeSeguradora)) {
        	
            for (Sinistro sinistro : seguradora.getListaSinistros()) {
                System.out.println(sinistro.toString());
            }
            return; 
    }
        else {
        	System.out.println("Seguradora não encontrada.");
        }
        }
}
        

public static void calcularReceitaSeguradora(List<Seguradora> listaSeguradoras) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Digite o nome da seguradora: ");
    String nomeSeguradora = scanner.nextLine();
    
    Seguradora seguradoraEncontrada = null;
    for (Seguradora seguradora : listaSeguradoras) {
        if (seguradora.getNome().equals(nomeSeguradora)) {
            seguradoraEncontrada = seguradora;
            break;
        }
    }
    if (seguradoraEncontrada != null) {
        seguradoraEncontrada.calcularReceita();
    } 
    else {
        System.out.println("Seguradora não encontrada.");
    }
}


public static void excluirCliente(List<Cliente> listaClientes) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Excluir Cliente");
    System.out.println("Digite o nome do cliente: ");
    String nomeCliente = sc.nextLine();

    boolean clienteEncontrado = false;
    for (Cliente cliente : listaClientes) {
        if (cliente.getNome().equals(nomeCliente)) {
            listaClientes.remove(cliente);
            System.out.println("Cliente removido com sucesso.");
            clienteEncontrado = true;
            break;
        }
    }

    if (!clienteEncontrado) {
        System.out.println("Cliente não encontrado.");
    }
}


public static void excluirVeiculo(List<Cliente> listaClientes) {
	
    Scanner sc = new Scanner(System.in);
    System.out.println("Exclusão de Veículo");
    System.out.println("Nome do Cliente: ");
    String nomeCliente = sc.nextLine();

    Cliente clienteEncontrado = null;
    for (Cliente cliente : listaClientes) {
        if (cliente.getNome().equals(nomeCliente)) {
            clienteEncontrado = cliente;
            break;
        }
    }

    if (clienteEncontrado == null) {
        System.out.println("Cliente não encontrado.");
    } 
    
    else {
        System.out.println("Placa do Veículo: ");
        String placa = sc.nextLine();

        //procura numa lista de veiculos de um dado cliente um veiculo com aquela placa
        boolean veiculoEncontrado = false;
        for (Veiculo veiculo : clienteEncontrado.getListaVeiculos()) {
            if (veiculo.getPlaca().equals(placa)) {
                clienteEncontrado.removerVeiculo(veiculo);
                veiculoEncontrado = true;
                System.out.println("Veículo excluído com sucesso.");
                break;
            }
        }

        if (!veiculoEncontrado) {
            System.out.println("Veículo não encontrado.");
        }
    }
}


public static void excluirSinistro(List<Seguradora> listaSeguradoras) {

    Scanner sc = new Scanner(System.in);
    System.out.println("Exclusão de Sinistro");

    System.out.println("Nome da Seguradora: ");
    String nomeSeguradora = sc.nextLine();

    System.out.println("Nome do Cliente: ");
    String nomeCliente = sc.nextLine();

    // Procura a seguradora na lista de seguradoras
    Seguradora seguradoraEncontrada = null;
    for (Seguradora seguradora : listaSeguradoras) {
        if (seguradora.getNome().equals(nomeSeguradora)) {
            seguradoraEncontrada = seguradora;
            break;
        }
    }

    if (seguradoraEncontrada == null) {
        System.out.println("Seguradora não encontrada.");
        return;
    }

    // Procura o cliente na lista de clientes da seguradora
    Cliente clienteEncontrado = null;
    for (Cliente cliente : seguradoraEncontrada.getListaClientes()) {
        if (cliente.getNome().equals(nomeCliente)) {
            clienteEncontrado = cliente;
            break;
        }
    }

    if (clienteEncontrado == null) {
        System.out.println("Cliente não encontrado.");
        return;
    }

    // Procura o veículo do cliente com a placa fornecida
    System.out.println("Placa do Veículo: ");
    String placa = sc.nextLine();

    Veiculo veiculoEncontrado = null;
    for (Veiculo veiculo : clienteEncontrado.getListaVeiculos()) {
        if (veiculo.getPlaca().equals(placa)) {
            veiculoEncontrado = veiculo;
            break;
        }
    }

    if (veiculoEncontrado == null) {
        System.out.println("Veículo não encontrado.");
        return;
    }

    // Procura o sinistro na lista de sinistros da seguradora do veículo
    Sinistro sinistroEncontrado = null;
    for (Sinistro sinistro : seguradoraEncontrada.getListaSinistros()) {
        if (sinistro.getVeiculo().equals(veiculoEncontrado) && 
            sinistro.getCliente().equals(clienteEncontrado)) {
            sinistroEncontrado = sinistro;
            break;
        }
    }

    if (sinistroEncontrado == null) {
        System.out.println("Sinistro não encontrado.");
        return;
    }

    // Remove o sinistro da lista de sinistros da seguradora
    seguradoraEncontrada.getListaSinistros().remove(sinistroEncontrado);
    System.out.println("Sinistro excluído com sucesso.");
}


public static void listarVeiculosCliente(List<Cliente> listaClientes) {
	
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Listagem de Veículos por Cliente");
    System.out.println("Nome do Cliente: ");
    String nomeCliente = sc.nextLine();
    
    // Procura o cliente na lista de clientes
    Cliente clienteEncontrado = null;
    for (Cliente cliente : listaClientes) {
        if (cliente.getNome().equals(nomeCliente)) {
            clienteEncontrado = cliente;
            break;
        }
    }
    
    if (clienteEncontrado == null) {
        System.out.println("Cliente não encontrado.");
        return;
    }
    
  
    List<Veiculo> listaVeiculos = clienteEncontrado.getListaVeiculos();
    
    if (listaVeiculos.isEmpty()) {
        System.out.println("Nenhum veículo cadastrado.");
    } 
    
    else {
        for (Veiculo veiculo : listaVeiculos) {
            System.out.println(veiculo.toString());
        }
    }
}


public static void listarVeiculosSeguradora(List<Seguradora> listaSeguradoras) {
	
    Scanner sc = new Scanner(System.in);
    System.out.println("Listagem de Veículos por Seguradora");
    System.out.println("Nome da Seguradora: ");
    String nomeSeguradora = sc.nextLine();
    
    //procura a seguradora na lista de seguradoras
    Seguradora seguradoraEncontrada = null;
    for (Seguradora seguradora : listaSeguradoras) {
        if (seguradora.getNome().equals(nomeSeguradora)) {
            seguradoraEncontrada = seguradora;
            break;
        }
    }
    
    if (seguradoraEncontrada == null) {
        System.out.println("Seguradora não encontrada.");
        return;
    }
    
    //Para cada cliente na lista de seguradoras imprimimos os veiculos associados
    for (Cliente cliente : seguradoraEncontrada.getListaClientes()) {
        for (Veiculo veiculo : cliente.getListaVeiculos()) {
            System.out.println(veiculo.toString());
        }
    }
}


public static void listarSinistrosSeguradora(List<Seguradora> listaSeguradoras) {
	
    Scanner sc = new Scanner(System.in);
    System.out.println("Listagem de Sinistros por Seguradora");
    
    System.out.println("Nome da Seguradora: ");
    String nomeSeguradora = sc.nextLine();
    
    // Procura a seguradora na lista de seguradoras
    Seguradora seguradoraEncontrada = null;
    for (Seguradora seguradora : listaSeguradoras) {
        if (seguradora.getNome().equals(nomeSeguradora)) {
            seguradoraEncontrada = seguradora;
            break;
        }
    }
    
    if (seguradoraEncontrada == null) {
        System.out.println("Seguradora não encontrada.");
        return;
    }
    
    // Obtém a lista de sinistros da seguradora e imprime na tela
    seguradoraEncontrada.listarSinistros();
}


public static void listarSinistrosCliente(List<Seguradora> listaSeguradoras) {
	
    Scanner sc = new Scanner(System.in);
    System.out.println("Listar sinistros por cliente");
    
    
    System.out.println("Nome do cliente: ");
    String nomeCliente = sc.nextLine();
    
    // Busca o cliente na lista de clientes de todas as seguradoras
    Cliente clienteEncontrado = null;
    for (Seguradora seguradora : listaSeguradoras) {
        for (Cliente cliente : seguradora.getListaClientes()) {
            if (cliente.getNome().equals(nomeCliente)) {
                clienteEncontrado = cliente;
                break;
            }
        }
        if (clienteEncontrado != null) {
            break;
        }
    }
    
    // Verifica se o cliente foi encontrado
    if (clienteEncontrado == null) {
        System.out.println("Cliente não encontrado.");
        return;
    }
    
    // Lista os sinistros do cliente
    
    for (Seguradora seguradora : listaSeguradoras) {
        for (Sinistro sinistro : seguradora.getListaSinistros()) {
            if (sinistro.getCliente().equals(clienteEncontrado)) {
                System.out.println(sinistro.toString());
            }
        }
    }
}


public static void gerarSinistro(List<Seguradora> listaSeguradoras) {
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("Data do sinistro (AAAA-MM-DD): ");
	
	LocalDate dataSinistro = LocalDate.parse(scanner.nextLine());

	System.out.println("Endereço do sinistro: ");
	String endereco = scanner.nextLine();

	System.out.println("Nome da seguradora: ");
	String nomeSeguradora = scanner.nextLine();
	
	Seguradora seguradoraEncontrada = null;
	for (Seguradora seguradora : listaSeguradoras) {
	    if (seguradora.getNome().equals(nomeSeguradora)) {
	        seguradoraEncontrada = seguradora;
	        break;
	    }
	}
	if (seguradoraEncontrada == null) {
	    System.out.println("Seguradora não encontrada na lista.");
	    
	}

	System.out.println("Placa do veículo: ");
	String placa = scanner.nextLine();
	Veiculo veiculoEncontrado = null;
	Cliente clienteEncontrado = null;
	
	//procuro o veiculo do cliente
	for (Cliente cliente : seguradoraEncontrada.getListaClientes()) {
	    for (Veiculo veiculo : cliente.getListaVeiculos()) {
	        if (veiculo.getPlaca().equals(placa)) {
	            veiculoEncontrado = veiculo;
	            clienteEncontrado = cliente;
	            break;
	        }
	    }
	    if (veiculoEncontrado != null) {
	        break;
	    }
	}
	
	if (veiculoEncontrado == null) {
	    System.out.println("Veículo não encontrado na lista de clientes da seguradora.");

	}

	
	if (seguradoraEncontrada.gerarSinistro(dataSinistro, endereco, seguradoraEncontrada, veiculoEncontrado, clienteEncontrado)) {
	    System.out.println("Sinistro gerado com sucesso.");
	    
	} 
	else {
	    System.out.println("Erro ao gerar sinistro.");
	   
	}

}

public static void transferirSeguro(List<Seguradora> listaSeguradoras) {
	
    Scanner scanner = new Scanner(System.in);

    System.out.println("Nome do cliente que deseja transferir o seguro: ");
    
    String nomeClienteAntigo = scanner.nextLine();
    Cliente clienteAntigo = null;
    
    for (Seguradora seguradora : listaSeguradoras) {
        for (Cliente cliente : seguradora.getListaClientes()) {
            if (cliente.getNome().equals(nomeClienteAntigo)) {
                clienteAntigo = cliente;
                break;
            }
        }
        if (clienteAntigo != null) {
            break;
        }
    }
    if (clienteAntigo == null) {
        System.out.println("Cliente não encontrado");
        return;
    }

    System.out.println("Nome do cliente que receberá o seguro: ");
    String nomeClienteNovo = scanner.nextLine();
    Cliente clienteNovo = null;
    Seguradora nomeSeguradora = null;
    
    for (Seguradora seguradora : listaSeguradoras) {
        for (Cliente cliente : seguradora.getListaClientes()) {
            if (cliente.getNome().equals(nomeClienteNovo)) {
                clienteNovo = cliente;
                nomeSeguradora = seguradora;
                break;
            }
        }
        if (clienteNovo != null) {
            break;
        }
    }
    if (clienteNovo == null) {
        System.out.println("Cliente não encontrado");
        return;
    }

    if (clienteAntigo.getListaVeiculos().isEmpty()) {
        System.out.println("O cliente não possui veículos segurados");
        return;
    }

    List<Veiculo> listaVeiculos = new ArrayList<>(clienteAntigo.getListaVeiculos());
    clienteAntigo.getListaVeiculos().clear();
    clienteNovo.getListaVeiculos().addAll(listaVeiculos);

    //metodo calcularPrecoSeguroCliente calcula o novo preco e ja seta o novo valor pro cliente
    nomeSeguradora.calcularPrecoSeguroCliente(clienteNovo);
    

    System.out.println("Transferência de seguro realizada com sucesso.");
}

}
	

