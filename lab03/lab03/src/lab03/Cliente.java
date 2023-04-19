package lab03;
import java.util.List;


public class Cliente {
	
	private String nome; 
	private String endereco;
	private List <Veiculo> listaVeiculos;
	private String tipoCliente;
	
	//Construtor
	
	public Cliente(String nome, String endereco, List<Veiculo> listaVeiculos,String tipoCliente){
		this.nome = nome;
		this.endereco = endereco;
		this.listaVeiculos = listaVeiculos;
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
	
	public List<Veiculo> getListaVeiculos() {
	     return listaVeiculos;
	}
	
	public void setListaVeiculos(List<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

	public String getTipoCliente() {
		return tipoCliente;
	}
	
	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
		
	}
	
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", listaVeiculos=" + listaVeiculos +
                 ", tipoCliente=" + tipoCliente +
                '}';
    }
}