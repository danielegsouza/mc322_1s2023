package lab04;

import java.time.LocalDate;
import java.util.List;

public class ClientePJ extends Cliente{
	private final String cnpj;
	private LocalDate dataFundacao;
	private int qtdeFuncionarios;
	
	public ClientePJ(String nome, String endereco,
			String tipoCliente,double valorSeguro, String cnpj,LocalDate dataFundacao, int qtdeFuncionarios) {
		
		//Chama o construtor da superclasse
		super(nome,endereco, tipoCliente, valorSeguro);
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
		this.qtdeFuncionarios = qtdeFuncionarios;
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
    
    public int getQtdeFuncionarios() {
        return qtdeFuncionarios;
    }

    public void setQtdeFuncionarios(int qtdeFuncionarios) {
        this.qtdeFuncionarios = qtdeFuncionarios;
    }
    
    
  //Calcula o score de uma empresa como base na quantidade de funcionarios e carros
  	public double calculaScore(Cliente cliente) {
  	    
  	    double valorBase = CalcSeguro.VALOR_BASE.getValor();
  	    int quantidadeCarros = cliente.getListaVeiculos().size();
  	   
  	  return valorBase * (1+(qtdeFuncionarios)/100) * quantidadeCarros;
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

