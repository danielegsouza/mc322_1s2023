package lab05;

import java.util.ArrayList;
import java.time.LocalDate;

public class ClientePJ extends Cliente {
    private final String cnpj;
    private LocalDate dataFundacao;
    private ArrayList<Frota> listaFrota;
    
    public ClientePJ(String nome, String telefone, String endereco,
    		String email,String tipocliente, String cnpj, LocalDate dataFundacao) {
    	super(nome, telefone, endereco, email,tipoCliente);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
        this.listaFrota = new ArrayList<Frota>();
    }
    
    
    // Getters and setters
    public String getCnpj() {
        return cnpj;
    }
    
    public LocalDate getDataFundacao() {
        return dataFundacao;
    }
    
    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }
    
    public ArrayList<Frota> getListaFrota() {
        return listaFrota;
    }
    
    public void setListaFrota(ArrayList<Frota> listaFrota) {
        this.listaFrota = listaFrota;
    }
    
    // Metodos
    public boolean cadastrarFrota(Frota frota) {
        return this.listaFrota.add(frota);
    }
    
    //atualiza lista de veiculos de uma frota
    //duvida aqui
    public boolean atualizarFrota(Frota frota) {
        for (int i = 0; i < listaFrota.size(); i++) {
            if (listaFrota.get(i).getCode() == frota.getCode()) {
                listaFrota.set(i, frota);
                return true;
            }
        }
        return false;
    }
    
    //Procura uma frota na lista de frotas com o mesmo Code, se encontrado retorna os veiculos daquela frota
    public ArrayList<Veiculo> getVeiculosPorFrota(Frota frota) {
        for (int i = 0; i < listaFrota.size(); i++) {
            if (listaFrota.get(i).getCode() == frota.getCode()) {
                return listaFrota.get(i).getListaVeiculos();
            }
        }
        return null;
    }
}
