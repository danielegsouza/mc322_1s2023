package lab04;

import java.util.List;
import java.time.LocalDate;

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
		for (int i= 0; i < listaClientes.size(); i++) {
			Cliente nomeCliente = listaClientes.get(i);
			
			if (nomeCliente.getNome().equals(cliente)) {
				listaClientes.remove(i);
				return true;
			}
		}
		return false;
		
	}
	
	
	public void listarClientes(String tipoCliente) {
		for (int i = 0; i < listaClientes.size(); i++) {
			Cliente cliente = listaClientes.get(i);
			
			if (cliente.getTipoCliente().equals(tipoCliente)) {
				System.out.println(cliente.getNome());
			}
		}
	}
	
	public boolean gerarSinistro(LocalDate data, String endereco,
			Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
		
	    Sinistro novoSinistro = new Sinistro(data, endereco, seguradora, veiculo, cliente);
	    
	    if (listaSinistros.add(novoSinistro)) {
	        return true;
	    }
	    return false;
	}

	
	
	 public boolean visualizarSinistro(String cliente) {
		 
        for (int i = 0; i < listaSinistros.size(); i++) {
        	Sinistro sinistro = listaSinistros.get(i);
        	
            if (sinistro.getCliente().getNome().equals(cliente)) {
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
	    
	    
	    public int obterQuantidadeSinistros(String cliente) {
	        int quantidade_de_sinistros = 0;
	        
	        for (int i = 0; i < listaSinistros.size(); i++) {
	        	
	        	Sinistro sinistro = listaSinistros.get(i);
	        	
	            if (sinistro.getCliente().getNome().equals(cliente)) {
	                System.out.println(sinistro.toString());
	                quantidade_de_sinistros++;
	            }
	        }
	        
	        return quantidade_de_sinistros;
	    }

	  

	    
	    public void calcularPrecoSeguroCliente(Cliente cliente) {
	    	
	        int quantidade_de_sinistros = obterQuantidadeSinistros(cliente.getNome());
	        String tipoCliente = cliente.getTipoCliente();
	        double precoSeguro;

	        if (tipoCliente.equals("PF")) {
	            precoSeguro = ((ClientePF) cliente).calculaScore(cliente) * (1 + quantidade_de_sinistros);
	        } else {
	            precoSeguro = ((ClientePJ) cliente).calculaScore(cliente) * (1 + quantidade_de_sinistros);
	        }

	        cliente.setValorSeguro(precoSeguro);
	    }

	    
	    //Percorre a lista de clientes e para cada cliente pega o valor do seguro associado
	    public double calcularReceita() {
	        double receitaTotal = 0.0;
	        
	        for (int i = 0; i < listaClientes.size(); i++) {
	        	Cliente cliente = listaClientes.get(i);
	            double precoSeguro = cliente.getValorSeguro();
	            receitaTotal += precoSeguro;
	        }
	        
	        return receitaTotal;
	    }

	
	    public String toString() {
	        return "Seguradora{" +
	                "nome='" + getNome() + '\'' +
	                ", telefone='" + getTelefone() + '\'' +
	                ", email='" + getEmail() + '\'' +
	                ", endereco=" + getEndereco() +
	                '}';
	    }
	        
	
}