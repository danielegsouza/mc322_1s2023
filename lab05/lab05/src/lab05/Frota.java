package lab05;
import java.util.ArrayList;

public class Frota {
	
    private String code;
    private ArrayList<Veiculo> listaVeiculos;
    
    public Frota(String code) {
        this.code = code;
        this.listaVeiculos = new ArrayList<Veiculo>();
    }
    
    // Getters and setters
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }
    
    // Metodos implementados
    
    public boolean addVeiculo(Veiculo veiculo) {
        return this.listaVeiculos.add(veiculo);
    }
    
    public boolean removeVeiculo(Veiculo veiculo) {
        return this.listaVeiculos.remove(veiculo);
    }
}
