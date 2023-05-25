package lab05;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class SeguroPJ extends Seguro {

    private Frota frota;
    private ClientePJ cliente;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Condutor> listaCondutores;

    public SeguroPJ(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, 
    		double valorMensal, Frota frota, ClientePJ cliente) {
        super(dataInicio, dataFim, seguradora, valorMensal);
        this.listaSinistros = new ArrayList<Sinistro>();
        this.listaCondutores = new ArrayList<Condutor>();
        this.frota = frota;
        this.cliente = cliente;
    }

    // Getters and setters
    public Frota getFrota() {
        return frota;
    }

    public void setFrota(Frota frota) {
        this.frota = frota;
    }

    public ClientePJ getCliente() {
        return cliente;
    }

    public void setCliente(ClientePJ cliente) {
        this.cliente = cliente;
    }

    //Metodos implementados
    public int obterQuantidadeSinistros(String cliente) {
        int quantidade_de_sinistros = 0;
        
        for (int i = 0; i < listaSinistros.size(); i++) {
        	
        	Sinistro sinistro = listaSinistros.get(i);
        	
            if (sinistro.getCliente().getNome().equals(cliente)) {
                quantidade_de_sinistros++;
            }
        }
        
        return quantidade_de_sinistros;
    }
    
    //Para cada condutor da lista somamos o numero de sinistros vinculados a ele
    public int quantidadeSinistrosCondutor() {
        int totalSinistros = 0;

        for (Condutor condutor : listaCondutores) {
            totalSinistros += condutor.getListaSinistros().size();
        }

        return totalSinistros;
    }

    // Métodos abstratos implementados
    
    @Override
    //desautoriza o condutor removendo o da lista de condutores
    public boolean desautorizarCondutor(Condutor condutor) {
  
        for (Condutor c : listaCondutores) {
            if (c.equals(condutor)) {
                listaCondutores.remove(c);
                System.out.println("Condutor removido com sucesso");
                return true;
            }
            
        }

        System.out.println("Condutor não encontrado na lista.");
        return false;
    }


    @Override
    //autoriza o condutor adicionando-o na lista de condutores
    public boolean autorizarCondutor(Condutor condutor) {
        if(listaCondutores.add(condutor)) {
        	System.out.println("Condutor autorizado com sucesso");
        	return true;
        }
        
        System.out.println("Condutor não pode ser autorizado");
        return false;
    }

    @Override
    public double calcularValor() {
    	double valorBase = CalcSeguro.VALOR_BASE.getValor();
    	int quantidadeFunc = cliente.getQtdeFuncionarios();
    	int quantidadeVeiculos = frota.getListaVeiculos().size();
    	
    	LocalDate dataAtual = LocalDate.now();
        Period periodo = Period.between(cliente.getDataFundacao(), dataAtual);
        int AnosPosFundacao = periodo.getYears();
    	
        int quantidadeSinistrosCliente = obterQuantidadeSinistros(cliente.getNome());
 	    int quantidadeSinistrosCondutor = quantidadeSinistrosCondutor();
 	    
 	    double valorSeguro = (valorBase * (10+ (quantidadeFunc)/10) *
    			(1+ 1/(quantidadeVeiculos+2)) *
    			(1 + 1 /(AnosPosFundacao+2)) *
    			(2 + quantidadeSinistrosCliente/10) *
    			(5 + quantidadeSinistrosCondutor/10)
    			);
 	    setValorMensal(valorSeguro);
 	    
    	return valorSeguro;
    	
    }

    @Override
    public boolean gerarSinistro(LocalDate data, String endereco,Seguradora seguradora, 
			Veiculo veiculo, Cliente cliente, Condutor condutor,
			Seguro seguro) {
       
        Sinistro sinistro = new Sinistro(data, endereco, seguradora, veiculo,cliente,
        		condutor,seguro);
        
        
        return getListaSinistros().add(sinistro);
    }
    
    
    @Override
    public String toString() {
        return "SeguroPJ{" +
                "frota='" + frota + '\'' +
                ", cliente='" + cliente + '\'' +
                ", listaSinistros='" + listaSinistros + '\'' +
                ", listaCondutores=" + listaCondutores +
                '}';
    }
}
