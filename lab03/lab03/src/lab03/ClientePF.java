package lab03;
import java.time.LocalDate;
import java.util.List;

public class ClientePF extends Cliente {
	private String cpf;
	private LocalDate dataNascimento;
	
	public ClientePF(String nome, String endereco, LocalDate dataLicenca,
			String educacao, String genero, String classeEconomica,
			List <Veiculo> listaVeiculos,String cpf, LocalDate dataNascimento){
		
		//chama o construtor da superclasse
		super(nome,endereco,dataLicenca,educacao,genero,classeEconomica,
				listaVeiculos);
		
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}
	
	//oque é o retorno
	public String toString() {
		return cpf;
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

