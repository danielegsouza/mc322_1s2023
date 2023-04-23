package lab03;
import java.time.LocalDate;
import java.util.List;

public class ClientePJ extends Cliente{
	private final String cnpj;
	private LocalDate dataFundacao;
	
	public ClientePJ(String nome, String endereco,
			String tipoCliente,String cnpj,LocalDate dataFundacao) {
		
		//Chama o construtor da superclasse
		super(nome,endereco, tipoCliente);
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
	}

	
	//Getters e Setters
	public String getCnpj() {
        return cnpj;
    }
    
    public LocalDate getDataFundacao() {
        return dataFundacao;
    }
    
    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }
    
    public boolean validarCNPJ(String cnpj) {
    	
    	int primeiroDigito = 0;
		int segundoDigito = 0;
		int soma = 0;
		int peso = 2;
		int resto = 0;
		
		
        cnpj = cnpj.replaceAll("[^0-9]", "");

        if (cnpj.length() != 14) {
            return false;
        }

        // Verifica se todos os dígitos são iguais
        char digitoUm = cnpj.charAt(0);
		boolean digitosIguais = true;
		
		for (int i = 1; i < cnpj.length(); i++) {
			if (cnpj.charAt(i) != digitoUm) {
				digitosIguais = false; 
			}
		}
		
		if (digitosIguais == true) {
			return false; 
		}

		
        // Verifica se os digitos verificadores estao corretos
		
		for (int i = 11; i >= 0; i--) {
			 int valor = Character.getNumericValue(cnpj.charAt(i));
		     soma += valor * peso;
		     
		     if(peso == 9) {
		    	 peso = 2;
		     }
		     
		     else {
		    	 peso++;
		     }
		}
		
		resto = soma % 11 ; 
		
		if(resto < 2) {
			primeiroDigito =0;
		}
		
		else {
			primeiroDigito = 11 - resto;
		}
		

	    if (primeiroDigito != Character.getNumericValue(cnpj.charAt(12))) {
	        return false;
	    }

	    // Verifica o segundo dígito verificador
	    soma = 0;
	    peso = 2;
	    for (int i = 12; i >= 0; i--) {
	        int valor = Character.getNumericValue(cnpj.charAt(i));
	        soma += valor * peso;

		     if(peso == 9) {
		    	 peso = 2;
		     }
		     
		     else {
		    	 peso++;
		     }
	    }

	    resto = soma % 11;
	  

	    if (resto < 2) {
	        segundoDigito = 0;
	    } else {
	        segundoDigito = 11 - resto;
	    }

	    // Verifica o segundo dígito verificador
	    if (segundoDigito != Character.getNumericValue(cnpj.charAt(13))) {
	        return false;
	    }

	    return true;
	
    }

		@Override
	    public String toString() {
	        return "ClientePJ{" +
	                "nome='" + getNome() + '\'' +
	                ", endereco='" + getEndereco() + '\'' +
	                ", cnpj='" + getCnpj() + '\'' +
	                ", dataFundacao=" + getDataFundacao() +
	                '}';
	    }
}
