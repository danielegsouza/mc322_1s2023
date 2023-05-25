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
	public Seguradora(String cnpj, String nome, String telefone, String email, String endereco) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.listaClientes = new ArrayList<Cliente>(); 
		this.listaSeguros = new ArrayList<Seguro>();
		this.listaSinistros = new ArrayList<Sinistro>();
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
    
    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }

    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
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
    
    public boolean gerarSeguro(String tipoCliente, LocalDate dataInicio, LocalDate dataFim, 
    		Seguradora seguradora, double valorMensal, Frota frota, Veiculo veiculo, Cliente cliente) {
        Seguro seguro = null;
        
        if (tipoCliente.equalsIgnoreCase("PF")) {
            seguro = new SeguroPF(dataInicio, dataFim,seguradora,valorMensal,
            		veiculo,(ClientePF) cliente);
        } else if (tipoCliente.equalsIgnoreCase("PJ")) {
            seguro = new SeguroPJ(dataInicio, dataFim,seguradora, valorMensal,
            		frota,(ClientePJ) cliente );
        }
        
        if (seguro != null) {
            listaSeguros.add(seguro);
            return true; 
        }
        
        else {
        	return false;
        }
    }

    //metodo que procura um seguro associado aquele cliente na lista de seguros e verifica o id 
    public boolean cancelarSeguro(Cliente cliente, int idSeguro) {
        Seguro seguroParaCancelar = null;

        
        for (Seguro seguro : listaSeguros) {
            if (seguro.getListaCondutores().contains(cliente) && seguro.getId() == idSeguro) {
                seguroParaCancelar = seguro;
                break;
            }
        }

        
        if (seguroParaCancelar != null) {
            listaSeguros.remove(seguroParaCancelar);
            return true; 
        } 
        
        else {
            return false; 
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
	
	//metodo que retorna um array contendo os seguros associados a esse cliente
	public ArrayList<Seguro> getSegurosPorCliente(Cliente cliente) {
	    ArrayList<Seguro> segurosPorCliente = new ArrayList<>();

	    for (Seguro seguro : listaSeguros) {
	        if (seguro.getListaCondutores().contains(cliente)) {
	            segurosPorCliente.add(seguro);
	        }
	    }

	    return segurosPorCliente;
	}

	//percorre a lista de sinistros de cada seguro para o cliente em questao
	public ArrayList<Sinistro> getSinistrosPorCliente(String nomeCliente) {
	    ArrayList<Sinistro> sinistrosPorCliente = new ArrayList<>();

	    for (Seguro seguro : listaSeguros) {
	        for (Sinistro sinistro : seguro.getListaSinistros()) {
	            if (sinistro.getCliente().getNome().equals(nomeCliente)) {
	                sinistrosPorCliente.add(sinistro);
	            }
	        }
	    }

	    return sinistrosPorCliente;
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
    
 
    //Percorre a lista de seguros e vai acumulando o valor de cada um na variavel
    public double calcularReceita() {
        double receitaTotal = 0.0;
        
        for (Seguro seguro : listaSeguros) {
            double precoSeguro = seguro.getValorMensal();
            receitaTotal += precoSeguro;
        }
        
        return receitaTotal;
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