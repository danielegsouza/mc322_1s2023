package lab05;

import java.time.LocalDate;
import java.util.ArrayList;

public class SeguroPF extends Seguro {

    private Frota frota;
    private ClientePF cliente;

    public SeguroPF(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, 
    		ArrayList<Sinistro> listaSinistros, ArrayList<Condutor>listaCondutores,
    		int valorMensal, Frota frota, ClientePF cliente) {
        super(dataInicio, dataFim, seguradora, valorMensal);
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

    public ClientePF getCliente() {
        return cliente;
    }

    public void setCliente(ClientePF cliente) {
        this.cliente = cliente;
    }

    // Métodos abstratos
    
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
    
    public void calcularPrecoSeguroCliente(Cliente cliente) {
    	
        int quantidade_de_sinistros = obterQuantidadeSinistros(cliente.getNome());
        String tipoCliente = cliente.getTipoCliente();
        double precoSeguro;

        if (tipoCliente.equals("PF")) {
            precoSeguro = ((ClientePF) cliente).calculaScore(cliente) * (1 + quantidade_de_sinistros);
        } 
        
        else {
            precoSeguro = ((ClientePJ) cliente).calculaScore(cliente) * (1 + quantidade_de_sinistros);
        }

        cliente.setValorSeguro(precoSeguro);
    }

    @Override
    public boolean desautorizarCondutor(Condutor condutor) {
        return cliente.desautorizarCondutor(condutor);
    }

    @Override
    public boolean autorizarCondutor(Condutor condutor) {
        return cliente.autorizarCondutor(condutor);
    }

    @Override
    public int calcularValor() {
        return cliente.getQuantidadeVeiculos() * getValorMensal();
    }

    @Override
    public boolean gerarSinistro(LocalDate data, String endereco, Condutor condutor) {
        Veiculo veiculo = frota.buscarVeiculoPorCondutor(condutor);
        if (veiculo == null) {
            return false;
        }
        Sinistro sinistro = new Sinistro(data, endereco, condutor, this, veiculo);
        getListaSinistros().add(sinistro);
        veiculo.getListaSinistros().add(sinistro);
        return true;
    }
}

