package lab03;
import java.time.LocalDate;
import java.util.List;

public class ClientePJ extends Cliente{
	private final String cnpj;
	private LocalDate dataFundacao;
	
	public ClientePJ(String nome, String endereco, List<Veiculo> listaVeiculos, String cnpj,
			LocalDate dataFundacao) {
		//Chama o construtor da superclasse
		
		super(nome,endereco,listaVeiculos);
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
    
    public static boolean validarCNPJ(String cnpj) {
      
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

		
        // Verifica se os digitos verificadoes estao corretos
		
		int primeiroDigito = 0;
		int segundoDigito = 0;
		
		
	
    }

	
	    public String toString() {
	        return "ClientePJ{" +
	                "nome='" + getNome() + '\'' +
	                ", endereco='" + getEndereco() + '\'' +
	                ", cnpj='" + cnpj + '\'' +
	                ", dataFundacao=" + dataFundacao +
	                '}';
	    }
}
