package mc322_lab02;

public class Cliente {
	
	private String nome; 
	private String cpf;
	private String dataNascimento;
	private int idade;
	private String endereco;
	
	
	//Construtor
	
	public Cliente(String nome, String cpf, String dataNascimento, int idade, String endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.idade = idade;
		this.endereco = endereco;
	}
		
	public String getNome() {
		return nome;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}
	
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public int getIdade() {
		return idade;
	}
	
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public boolean validarCPF(String cpf) {
		
		//Remove todos os caracteres não numericos
		cpf = cpf.replaceAll("\\D", "");
		
		//Verifica se o cpf tem 11 digitos
		
		if(cpf.length() != 11) {
			return false;
		}
		
		//Verifica se os digitos sao iguais
		
		char digitoUm = cpf.charAt(0);
		boolean digitosIguais = true;
		
		for (int i = 1; i < cpf.length(); i++) {
			if (cpf.charAt(i) != digitoUm) {
				digitosIguais = false; 
			}
			
		}
		
		if (digitosIguais == true) {
			return false; 
		}
		
		//Verificar se digitos verificadores estão corretos
		
		int primeiroDigito = 0;
		int segundoDigito = 0;
		
		//Verifica o primeiro digito
		
		for (int i = 0; i < 9; i++) {
			primeiroDigito += Character.getNumericValue(cpf.charAt(i)) *(10-i);
		}
		
		primeiroDigito = primeiroDigito % 11;
		
		if(primeiroDigito < 2) {
			primeiroDigito = 0;
			
		}
		
		else {
			primeiroDigito = 11 - primeiroDigito;
			
		}
		
		//Verifica o segundo digito
		
		for (int i = 0; i < 10; i++) {
			segundoDigito += Character.getNumericValue(cpf.charAt(i)) *(11-i);
		}
		
		segundoDigito = segundoDigito % 11;
		
		if(segundoDigito < 2) {
			segundoDigito = 0;
			
		}
		
		else {
			segundoDigito = 11 - segundoDigito;
			
		}
		
		
		if(primeiroDigito != Character.getNumericValue(cpf.charAt(9))) {
			return false;
		}
		
		if(segundoDigito != Character.getNumericValue(cpf.charAt(10))) {
			return false;
		}
		
		return  true;
	}
}
