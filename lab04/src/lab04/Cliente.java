package lab04;

import java.util.List;
import java.util.ArrayList;

public abstract class Cliente {
	
	private String nome; 
	private String endereco;
	private List <Veiculo> listaVeiculos;
	private String tipoCliente;
	private double valorSeguro;
	
	//Construtor
	
	public Cliente(String nome, String endereco,String tipoCliente, double valorSeguro){
		this.nome = nome;
		this.endereco = endereco;
		this.listaVeiculos = new ArrayList<Veiculo>();
		this.tipoCliente = tipoCliente;
		this.valorSeguro = valorSeguro;
	}
		
	//Getters e Setters 
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}
	
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	

	public String getTipoCliente() {
		return tipoCliente;
	}
	
	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
		
	}
	
	public double getValorSeguro () {
		return valorSeguro;
	}
	
	public void setValorSeguro (double valorSeguro) {
		this.valorSeguro = valorSeguro;
	}
	
	
	public List<Veiculo> getListaVeiculos() {
	    return listaVeiculos;
	}
	
	//Metodos implementados
	public void adicionarVeiculo(Veiculo veiculo) {
		this.listaVeiculos.add(veiculo);
	}
	
	
	public void removerVeiculo(Veiculo veiculo) {
		this.listaVeiculos.remove(veiculo);
	}
	

	
    public String toString() {
        return "Cliente{" +
                "nome='" + getNome() + '\'' +
                ", endereco='" + getEndereco() + '\'' +
                ", listaVeiculos=" + listaVeiculos +
                 ", tipoCliente=" + getTipoCliente() +
                '}';
    }
    
    public abstract double calculaScore(Cliente cliente);
}