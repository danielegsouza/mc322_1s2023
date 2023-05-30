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

    //Remove um veiculo da lista de veiculos do cliente
    public boolean removerVeiculos(Veiculo veiculo) {
        return this.listaVeiculos.remove(veiculo);
    }
    
    @Override
    public String toString() {
        return "ClientePF{" +
        		"Nome ='" + cpf + '\'' +
                "cpf ='" + cpf + '\'' +
                ", genero ='" + genero + '\'' +
                ", educacao ='" + educacao + '\'' +
                ", dataNascimento=" + dataNasc +
                '}';
    }


}
  

