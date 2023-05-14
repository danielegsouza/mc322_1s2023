package lab05;

public class Veiculo {
	
	private String placa; 
	private String marca;
	private String modelo;
	private String email;
	
	
	//Construtor
	public Veiculo(String placa, String marca, String modelo, String email) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.email = email;
	}
	
	
	//Getters e Setters 
	public String getPlaca() {
		return placa;
	}
	

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getMarca() {
		return marca;
	}
	

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	
	public String getModelo() {
		return modelo;
	}
	

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
	

    public String toString() {
        return "Veiculo{" +
                "placa='" + placa+ '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", email=" + email +
                '}';
    }
}
