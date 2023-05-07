package lab04;

import java.time.LocalDate;
import java.util.List;

public class ClientePF extends Cliente {
	private final String cpf;
	private String genero;
	private LocalDate dataLicenca;
	private String educacao;
	private LocalDate dataNascimento;
	private String classeEconomica;
	private int idade;
	
	public ClientePF(String nome, String endereco,
			String tipoCliente, double valorSeguro, String cpf, String genero, LocalDate dataLicenca,
			String educacao, LocalDate dataNascimento, String classeEconomica, int idade) {
		
		super(nome, endereco, tipoCliente,valorSeguro);
		this.cpf = cpf;
		this.genero = genero;
		this.dataLicenca = dataLicenca;
		this.educacao = educacao;
		this.dataNascimento = dataNascimento;
		this.classeEconomica = classeEconomica;
		this.idade = idade;
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
	
	public int getIdade() {
		return idade;
	}
	
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	//Metodos implementados 
	
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
	
	//Calcula o score de um cliente como base na idade 
	public double calculaScore(Cliente cliente) {
	    CalcSeguro fatorIdade;
	    int idade = this.idade;
	    
	    if (idade >= 18 && idade <= 30) {
	        fatorIdade = CalcSeguro.FATOR_18_30;
	    } 
	    
	    else if (idade > 30 && idade <= 60) {
	        fatorIdade = CalcSeguro.FATOR_30_60;
	    } 
	    
	    else {
	        fatorIdade = CalcSeguro.FATOR_60_90;
	    }
	    
	    double valorBase = CalcSeguro.VALOR_BASE.getValor();
	    double fator = fatorIdade.getValor();
	    int quantidadeCarros = cliente.getListaVeiculos().size();
	   
	    
	    return valorBase * fator * quantidadeCarros;
	}

	
	
}