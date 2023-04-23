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
	
	
	//Cadastrando primeiro cliente PF
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
	

	seguradora.cadastrarCliente(novoclientePF);
	seguradora.removerCliente(nome);
	
	//Cadastrando primeiro cliente PJ
	String nome2 = "Unicamp";
	String endereco2 = "Avenida 2";
	String tipoCliente2 = "PJ";
	String cnpj = "46.068.425/0001-33";
	LocalDate dataFundacao = LocalDate.parse("1990-05-18");
	
	ClientePJ novoclientePJ = new ClientePJ(nome2,endereco2,tipoCliente2,cnpj,dataFundacao);
	
	
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

	novoclientePF.adicionarVeiculo(veiculo1);
	novoclientePJ.adicionarVeiculo(veiculo2);
	
	
	//Cadastrando clientes na seguradora 

	seguradora.cadastrarCliente(novoclientePF);
	seguradora.cadastrarCliente(novoclientePJ);
	
	//gerando sinistro
	LocalDate data = LocalDate.parse("2023-07-18");
	seguradora.gerarSinistro(data,endereco,seguradora,veiculo1,novoclientePF);
	

	//Chamando metodo toString de cada classe
	System.out.println(seguradora.toString());
	System.out.println(novoclientePF.toString());
	System.out.println(novoclientePJ.toString());
	System.out.println(veiculo1.toString());
	System.out.println(veiculo2.toString());
	
	seguradora.listarClientes(tipoCliente2);
	seguradora.visualizarSinistro(nome);
	seguradora.listarSinistros();
	
	}
	
	//public static void menu() {
	//	Scanner scanner = new Scanner(System.in);
	//	String input = scanner.nextLine();
}