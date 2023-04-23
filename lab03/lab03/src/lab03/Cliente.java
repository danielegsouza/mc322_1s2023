package lab03;
import java.util.List;
import java.util.ArrayList;

public class Cliente {
	
	private String nome; 
	private String endereco;
	private List <Veiculo> listaVeiculos;
	private String tipoCliente;
	
	//Construtor
	
	public Cliente(String nome, String endereco,String tipoCliente){
		this.nome = nome;
		this.endereco = endereco;
		this.listaVeiculos = new ArrayList<Veiculo>();
		this.tipoCliente = tipoCliente;
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
}