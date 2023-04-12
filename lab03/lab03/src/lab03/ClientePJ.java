package lab03;
import java.time.LocalDate;
import java.util.List;

public class ClientePJ extends Cliente{
	private String cnpj;
	private LocalDate dataFundacao;
	
	public ClientePJ(String nome, String endereco, LocalDate dataLicenca,
			String educacao, String genero, String classeEconomica,
			List <Veiculo> listaVeiculos, String cnpj, LocalDate dataNascimento) {
		
		//chama o construtor da superclasse
		super(nome,endereco, dataLicenca, educacao, genero, classeEconomica, listaVeiculos);
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
	}

	public boolean validarCNPJ(String cnpj) {
		return;
	}
}
