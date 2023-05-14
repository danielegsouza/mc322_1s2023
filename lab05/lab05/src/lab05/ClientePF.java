package lab05;

import java.time.LocalDate;
import java.util.ArrayList;

public class ClientePF extends Cliente {

    private final String cpf;
    private String genero;
    private String educacao;
    private LocalDate dataNasc;
    private ArrayList<Veiculo> listaVeiculos;

    public ClientePF(String nome, String telefone, String endereco, String email,
    		String tipoCliente, String cpf, String genero, 
    		String educacao, LocalDate dataNasc) {
    	
        super(nome, telefone, endereco, email,tipoCliente);
        this.cpf = cpf;
        this.genero = genero;
        this.educacao = educacao;
        this.dataNasc = dataNasc;
        this.listaVeiculos = new ArrayList<Veiculo>();
    }

    public String getCpf() {
        return cpf;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEducacao() {
        return educacao;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    //Metodos implementados
    
    //Adiciona um veiculo a lista de veiculos do cliente
    public boolean cadastrarVeiculo(Veiculo veiculo) {
        return this.listaVeiculos.add(veiculo);
    }

    //Atualiza lista de veiculos do cliente
    public boolean atualizarVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos.clear(); // Limpa a lista atual
        return this.listaVeiculos.addAll(listaVeiculos); // Adiciona os novos veículos
    }


    //Percorre todos os seguros e adiciona os sinistros de cada um deles em uma lista geral
    @Override
    public ArrayList<Sinistro> getSinistros() {
        ArrayList<Sinistro> sinistros = new ArrayList<>();
        
        for (Veiculo veiculo : this.listaVeiculos) {
            sinistros.addAll(veiculo.getSinistros());
        }
        return sinistros;
    }
}

    //duvida aqui
    @Override
    public ArrayList<Seguro> getSeguros() {
        ArrayList<Seguro> seguros = new ArrayList<Seguro>();
        for (Seguradora seguradora : listaSeguradoras) {
            seguros.addAll(seguros.getSeguros());
        }
        return seguros;
    }
}
