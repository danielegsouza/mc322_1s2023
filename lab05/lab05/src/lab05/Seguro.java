package lab05;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Random;

public abstract class Seguro {
	
    private final int id;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Seguradora seguradora;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Condutor> listaCondutores;
    private int valorMensal;
    
    public Seguro(LocalDate dataInicio,LocalDate dataFim, Seguradora seguradora, int valorMensal) {
    	Random random = new Random(); 
		this.id = random.nextInt(10000);
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguradora = seguradora;
        this.listaSinistros = new ArrayList<Sinistro>();
        this.listaCondutores = new ArrayList<Condutor>();
        this.valorMensal = valorMensal;
    }
    
    // Getters and setters
    public int getId() {
        return id;
    }
    
    public LocalDate getDataInicio() {
        return dataInicio;
    }
    
    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }
    
    public LocalDate getDataFim() {
        return dataFim;
    }
    
    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
    
    public Seguradora getSeguradora() {
        return seguradora;
    }
    
    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }
    
    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }
    
    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }
    
    public ArrayList<Condutor> getListaCondutores() {
        return listaCondutores;
    }
    
    public void setListaCondutores(ArrayList<Condutor> listaCondutores) {
        this.listaCondutores = listaCondutores;
    }
    
    public int getValorMensal() {
        return valorMensal;
    }
    
    public void setValorMensal(int valorMensal) {
        this.valorMensal = valorMensal;
    }
    
    //Metodos abstratos 
    public abstract boolean desautorizarCondutor(Condutor condutor);
    public abstract boolean autorizarCondutor(Condutor condutor);
    public abstract int calcularValor();
    public abstract boolean gerarSinistro(LocalDate data, String endereco, Condutor condutor);

   
}
