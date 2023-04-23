package lab03;

import java.util.Random;
import java.time.LocalDate;

public class Sinistro {
	
	private final int id;
	private LocalDate data;
	private String endereco;
	private Seguradora seguradora;
	private Veiculo veiculo;
	private Cliente cliente;
	
	
	//Construtor que gera um ID aleatorio para o sinistro
	
	public Sinistro(LocalDate data, String endereco, Seguradora seguradora,
			Veiculo veiculo, Cliente cliente) {
		Random random = new Random(); 
		this.id = random.nextInt(10000);
		this.data = data;
		this.endereco = endereco;
		this.seguradora = seguradora;
		this.veiculo = veiculo;
		this.cliente = cliente;
		
	}
	
	public int getId(){
		return id;
	}
	
	public LocalDate getData(){
		return data;
	}
	
	public void setData(LocalDate data){
		this.data = data;
	}
	
	
	public String getEndereco(){
		return endereco;
	}

	public void setEndereco(String endereco){
		this.endereco =  endereco;
	}
	
	public Seguradora getSeguradora() {
		return seguradora;
	}
	
	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}
	
    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

   
    public String toString() {
        return "Sinistro{" +
                "ID=" + getId() +
                ", data='" + getData() + '\'' +
                ", endereco='" + getEndereco() + '\'' +
                ", seguradora=" + getSeguradora() +
                ", veiculo=" + getVeiculo() +
                ", cliente=" + getCliente() +
                '}';
    }

}
	
	
