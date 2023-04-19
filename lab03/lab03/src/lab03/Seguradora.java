package lab03;
import java.util.List;
//import java.util.ArrayList;

public class Seguradora {
	
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private List<Sinistro> listaSinistros;
	private List<Cliente> listaClientes;
	
	
	
	//Construtor
	public Seguradora(String nome, String telefone, String email, String endereco,
			List<Sinistro> listaSinistros,List<Cliente> listaClientes) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.listaSinistros = listaSinistros;
		this.listaClientes = listaClientes;
	}
	
	//Getters e setters
	
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco =  endereco;
	}
	
	public List<Sinistro> getListaSinistros() {
        return listaSinistros;
    }

    public void setListaSinistros(List<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
    //Metodos implementados
    
	public boolean cadastrarCliente(Cliente cliente) {
		return this.listaClientes.add(cliente);
	}
	
	public boolean removerCliente(String cliente) {
		for(int i= 0; i < listaClientes.size(); i++) {
			Cliente nomeCliente = listaClientes.get(i);
			if(nomeCliente.getNome().equals(cliente)) {
				listaClientes.remove(i);
				return true;
			}
		}
		return false;
		
	}
	
	//ver se funciona
	public void listarClientes(String tipoCliente) {
		
		for (int i = 0; i < listaClientes.size(); i++) {
			Cliente cliente = listaClientes.get(i);
			if(cliente.getTipoCliente().equals(tipoCliente)) {
				System.out.println(cliente.getNome());
			}
		}
	}
	
	//falta implementar
	public boolean gerarSinistro(String cliente) {
		return false;
	}
	
	
	 public boolean visualizarSinistro(String cliente) {
        for (int i = 0; i < listaSinistros.size(); i++) {
        	Sinistro sinistro = listaSinistros.get(i);
        	//tipos diferentes
            if (sinistro.getCliente().equals(cliente)) {
                System.out.println(sinistro.toString());
                return true;
            }
        }
        return false;
    }

	    public void listarSinistros() {
	    	for (int i = 0; i < listaSinistros.size(); i++) {
	        	Sinistro sinistro = listaSinistros.get(i);
	        	System.out.println(sinistro.toString());
	    }
	    }
	        
	
}