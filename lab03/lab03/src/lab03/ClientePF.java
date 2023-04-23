package lab03;
import java.time.LocalDate;
import java.util.List;

public class ClientePF extends Cliente {
	private final String cpf;
	private String genero;
	private LocalDate dataLicenca;
	private String educacao;
	private LocalDate dataNascimento;
	private String classeEconomica;
	
	public ClientePF(String nome, String endereco,
			String tipoCliente, String cpf, String genero, LocalDate dataLicenca,
			String educacao, LocalDate dataNascimento, String classeEconomica) {
		
		super(nome, endereco, tipoCliente);
		this.cpf = cpf;
		this.genero = genero;
		this.dataLicenca = dataLicenca;
		this.educacao = educacao;
		this.dataNascimento = dataNascimento;
		this.classeEconomica = classeEconomica;
}

	
	public String getCpf() {
	    return cpf;
	}
	      
	public String getGenero() {
		return genero;
	}
	
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
    public LocalDate getDataLicenca() {
		return dataLicenca;
	}
	
	
	public void setDataLicenca(LocalDate dataLicenca) {
		this.dataLicenca = dataLicenca;
	}
	
	public String getEducacao() {
		return educacao;
	}
	
	
	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getClasseEconomica() {
		return classeEconomica;
	}
	
	
	public void setClasseEconomica(String classeEconomica) {
		this.classeEconomica = classeEconomica;
	}
	
	@Override
	public String toString() {
		return "ClientePF [CPF = " + getCpf() + 
				", genero = " + getGenero() + ", "
				+ "dataLicenca = " + getDataLicenca() 
				+ ", educacao = " + getEducacao()
				+ ", dataNascimento = " + getDataNascimento() 
				+ ", classeEconomica = " + getClasseEconomica()
				+ ", nome=" + getNome()
				+ ", endereco = " + getEndereco() + "]";
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

