package lab05;
import java.util.ArrayList;

public class Frota {
	
    private String code;
    private ArrayList<Veiculo> listaVeiculos;
    
    public Frota(String code) {
        this.code = code;
        this.listaVeiculos = new ArrayList<Veiculo>();
    }
    
    // Getters e setters
    
    public String getCode() {
        return code;
    }
    
   
    
    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }
    
    // Metodos implementados
    
    //Adiciona veiculo a lista de veiculos de uma frota
    public boolean addVeiculo(Veiculo veiculo) {
        return this.listaVeiculos.add(veiculo);
    }
    
    //Remove veiculo da lista de veiculos de uma frota
    public boolean removeVeiculo(Veiculo veiculo) {
        return this.listaVeiculos.remove(veiculo);
    }
    
    public String toString() {
        return "Frota{" +
                "code='" + code + '\'' +
                ", listaVeiculos='" + listaVeiculos + '\'' +
                '}';
    }
}
