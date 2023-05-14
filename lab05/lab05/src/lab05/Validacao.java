package lab05;

public class Validacao {
    
	public static boolean validarCPF(String cpf) {
		
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
    
	public static boolean validarCNPJ(String cnpj) {
	    	
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
			     
			     if (peso == 9) {
			    	 peso = 2;
			     }
			     
			     else {
			    	 peso++;
			     }
			}
			
			resto = soma % 11 ; 
			
			if (resto < 2) {
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
		    }
		    
		    else {
		        segundoDigito = 11 - resto;
		    }
	
		    // Verifica o segundo dígito verificador
		    if (segundoDigito != Character.getNumericValue(cnpj.charAt(13))) {
		        return false;
		    }
	
		    return true;
		
	    }
	    
	public static boolean validaNome(String nome) {
	    for (int i = 0; i < nome.length(); i++) {
	        if (!Character.isLetter(nome.charAt(i))) {
	            return false;
	        }
	    }
	    return true;
	}

 
}

