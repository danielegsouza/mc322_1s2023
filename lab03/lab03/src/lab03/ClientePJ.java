package lab03;

public class ClientePJ extends Cliente{
	private String cnpj;
	
	public ClientPJ(String nome, String cpf, String dataNascimento, int idade, String endereco, String cnpj) {
		super(nome,cpf, dataNascimento, idade, endereco);
		this.cnpj = cnpj;
	}

	public boolean validarCPF(String cpf) {
		
	}
}
