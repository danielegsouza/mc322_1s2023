package lab05;

import java.util.ArrayList;
import java.time.LocalDate;

public class Seguradora {
	private final String cnpj;
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private ArrayList<Cliente> listaClientes;
	private ArrayList<Seguro> listaSeguros;
	private ArrayList<Sinistro> listaSinistros;
	
	
	//Construtor
	public Seguradora(String cnpj, String nome, String telefone, String email, String endereco,
			ArrayList<Cliente> listaClientes,ArrayList<Seguro> listaSeguros,
			ArrayList<Sinistro> listaSinistros) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.listaClientes = listaClientes;
		this.listaSeguros = listaSeguros;
		this.listaSinistros = listaSinistros;
	}
	
	//Getters e setters
	
	public String getCnpj() {
        return cnpj;
    }

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
	
	public ArrayList<Seguro> getListaSeguros() {
        return listaSeguros;
    }

    public void setListaSeguros(ArrayList<Seguro> listaSeguros) {
        this.listaSeguros = listaSeguros;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
    //Metodos implementados
    
    //Lista cliente por tipo PJ ou PF
    public void listarClientes(String tipoCliente) {
		for (int i = 0; i < listaClientes.size(); i++) {
			Cliente cliente = listaClientes.get(i);
			
			if (cliente.getTipoCliente().equals(tipoCliente)) {
				System.out.println(cliente.getNome());
			}
		}
	}
    
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
	
	//Gera um sinistro e adiciona na lista de seguros da seguradora
	public boolean gerarSinistro(LocalDate data, String endereco, Seguradora seguradora, 
			Veiculo veiculo, Cliente cliente, Condutor condutor, Seguro seguro) {
		
	    Sinistro novoSinistro = new Sinistro(data, endereco,seguradora, veiculo,cliente, condutor, seguro);
	    
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

	 //lista os sinistros dessa seguradora
    public void listarSinistros() {
    	for (int i = 0; i < listaSinistros.size(); i++) {
        	Sinistro sinistro = listaSinistros.get(i);
        	System.out.println(sinistro.toString());
    }
    }
    
   
// verificar aqui dps 
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

    public boolean gerarSeguro(String tipoCliente, LocalDate dataInicio, LocalDate dataFim, 
            Seguradora seguradora, int valorMensal, Frota frota, Cliente cliente) {
		
		Seguro seguro;
		if (tipoCliente.equalsIgnoreCase("PF")) {
			seguro = new SeguroPF(dataInicio, dataFim, seguradora, 
					valorMensal,frota,cliente);
		} 
		else if (tipoCliente.equalsIgnoreCase("PJ")) {
			seguro = new SeguroPJ(dataInicio, dataFim, seguradora,
					valorMensal,frota,cliente);
		} 
		else {
			System.out.println("Tipo de cliente inválido");
			return false;
		}
		
		listaSeguros.add(seguro);
		
		return true;
}


    public String toString() {
        return "Seguradora{" +
                "nome='" + nome + '\'' +
                ", cnpj ='" + cnpj + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", endereco=" + endereco +
                '}';
	    }
	        
	
}