package lab05;

import java.time.LocalDate;
import java.util.ArrayList;
import java.time.Period;

public class SeguroPF extends Seguro {

    private Veiculo veiculo;
    private ClientePF cliente;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Condutor> listaCondutores;
    
    public SeguroPF(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, 
    		double valorMensal, Veiculo veiculo, ClientePF cliente) {
        super(dataInicio, dataFim, seguradora, valorMensal);
        this.listaSinistros = new ArrayList<Sinistro>();
        this.listaCondutores = new ArrayList<Condutor>();
        this.veiculo = veiculo;
        this.cliente = cliente;
   
        
    }

    // Getters e setters
    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public ClientePF getCliente() {
        return cliente;
    }

    public void setCliente(ClientePF cliente) {
        this.cliente = cliente;
    }

    
    //Metodos implementados
    
    //Procura na lista de sinistros quantos sinistros tem aquele cliente associado 
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
    //Calcula valor do seguro de um cliente PJ
    public double calcularValor() {
	 CalcSeguro fatorIdade;
	 
	 //Calcula idade com base na data de nascimento
	 LocalDate dataAtual = LocalDate.now();
     Period periodo = Period.between(cliente.getDataNasc(), dataAtual);
     int idade = periodo.getYears();
    	 
    
    if (idade <= 30) {
        fatorIdade = CalcSeguro.FATOR_18_30;
    } 
    
    else if (idade > 30 && idade <= 60) {
        fatorIdade = CalcSeguro.FATOR_30_60;
    } 
    
    else {
        fatorIdade = CalcSeguro.FATOR_60_90;
    }
    
    double valorBase = CalcSeguro.VALOR_BASE.getValor();
    double fator = fatorIdade.getValor();
    
    int quantidadeCarros = cliente.getListaVeiculos().size();
    int quantidadeSinistrosCliente = obterQuantidadeSinistros(cliente.getNome());
    int quantidadeSinistrosCondutor = quantidadeSinistrosCondutor();
    
    double valorSeguro = valorBase * fator * (1+1/(quantidadeCarros + 2)) *
    		(2+ quantidadeSinistrosCliente/10) *
    		(5 + quantidadeSinistrosCondutor/10);
    
    setValorMensal(valorSeguro); //atualiza valor do atributo valorSeguro
    
    
    return valorSeguro;
 	}
    

    //Metodo responsavel por gerar(instanciar) um seguro 
    @Override
    public boolean gerarSinistro(LocalDate data, String endereco,Seguradora seguradora, 
			Veiculo veiculo, Cliente cliente, Condutor condutor,
			Seguro seguro) {
       
        Sinistro sinistro = new Sinistro(data, endereco, seguradora, veiculo,cliente,
        		condutor,seguro);
        
        //atualiza listaSinistros da seguradora
        seguradora.getListaSinistros().add(sinistro);  
        
        return getListaSinistros().add(sinistro);
    }
    
    @Override
    public String toString() {
        return "SeguroPF{" +
                "veiculo='" + veiculo + '\'' +
                ", cliente='" + cliente + '\'' +
                ", listaSinistros='" + listaSinistros + '\'' +
                ", listaCondutores=" + listaCondutores +
                '}';
    }
}

