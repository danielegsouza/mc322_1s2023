package lab05;
import java.util.ArrayList;

public abstract class Cliente {
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private String tipoCliente;
    
    public Cliente(String nome, String telefone, String endereco, String email,
    		String tipoCliente) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.tipoCliente = tipoCliente;
    }
    
    // Getters and setters
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getEndereco() {
        return endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTipoCliente() {
		return tipoCliente;
	}
	
	public void setTipoCliente(String tipoCliente) {

		this.tipoCliente = tipoCliente;
		
	}
    // Metodos abstratos
    public abstract ArrayList<Sinistro> getSinistros();
    
    public abstract ArrayList<Seguro> getSeguros();
}
