package lab05;

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
	Veiculo veiculo2 = new Veiculo("DEF-5678", "Chevrolet", "Onix", 2022);
	Veiculo veiculo3 = new Veiculo("GHI-1012", "Bmw", "Bmw x1", 2023);
	
    //Instanciando primeiro cliente PF
	String nome = "Daniele";
	String telefone = "3551-4626";
	String endereco = "Avenida 1";
	String email = "daniele@ic.unicamp.br";
	String tipoCliente = "PF";
	String cpf = "123.456.789-10";
	String genero = "feminimo";
	String educacao = "superior";
	LocalDate dataNascimento = LocalDate.parse("2000-07-18");
	
	if(!Validacao.validarCPF(cpf) || !Validacao.validaNome(nome)) {
		System.out.println("Nome ou CPF inserido inválido");
	}
	
	ClientePF novoclientePF = new ClientePF(nome,telefone,endereco, email, tipoCliente, 
			cpf,genero, educacao, dataNascimento);

	//Instanciando primeiro cliente PJ
	String nome2 = "Unicamp";
	String endereco2 = "Avenida 2";
	String telefone2 = "123456789";
	String email2 = "unicamp@unicamp.br";
	String tipoCliente2 = "PJ";
	double valorSeguro2 = 50000.00;
	String cnpj = "46.068.425/0001-33";
	LocalDate dataFundacao = LocalDate.parse("1990-05-18");
	int qtdeFuncionarios = 50;
	
	if(!Validacao.validarCNPJ(cnpj) || !Validacao.validaNome(nome2)) {
		System.out.println("Nome ou CNPJ inserido inválido");
	}
	
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
	
	//Instanciando um seguro na seguradora Unicamp para o cliente PF
	LocalDate dataInicio = LocalDate.parse("2023-05-24");
	LocalDate dataFim = LocalDate.parse("2024-05-23");
	
	seguradora.gerarSeguro(tipoCliente, dataInicio, dataFim, seguradora, 0.0, null, 
			veiculo1, novoclientePF);
	
	//Adiciona o cliente na lista de clientes da seguradora
	seguradora.cadastrarCliente(novoclientePF);
	
	
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
	
	//Instanciando um seguro na seguradora Unicamp para o cliente PJ
	LocalDate dataInicioPJ = LocalDate.parse("2023-05-24");
	LocalDate dataFimPJ = LocalDate.parse("2024-05-23");
	
	 
	
	seguradora.gerarSeguro(tipoCliente2,dataInicioPJ, dataFimPJ,seguradora, 0.0,
    		frota,null,novoclientePJ);
	
	
	//Adiciona o clientePJ na lista de clientes da seguradora
	seguradora.cadastrarCliente(novoclientePJ);
	
	// Obter a lista de seguros da seguradora
	ArrayList<Seguro> listaSeguros = seguradora.getListaSeguros();

	// Verificar se a lista de seguros não está vazia
	if (!listaSeguros.isEmpty()) {
	    // Obter o último seguro da lista (assumindo que o último seguro é o mais recente)
	    Seguro ultimoSeguro = listaSeguros.get(listaSeguros.size() - 1);

	    // Chamar o método autorizarCondutor no último seguro, passando o condutor como parâmetro
	    ultimoSeguro.autorizarCondutor(condutor);
	}

}
}
