package lab05;

import java.time.LocalDate;
import java.util.ArrayList;

public class SeguroPJ extends Seguro {

    private Frota frota;
    private ClientePJ cliente;

    public SeguroPJ(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora,
    		ArrayList<Sinistro> listaSinistros, ArrayList<Condutor>listaCondutores, 
    		int valorMensal, Frota frota, ClientePJ cliente) {
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

    public ClientePJ getCliente() {
        return cliente;
    }

    public void setCliente(ClientePJ cliente) {
        this.cliente = cliente;
    }

    // Métodos abstratos
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
