package mc322_lab02;

public class Veiculo {
	private String placa; 
	private String marca;
	private String modelo;
	
	
	//Construtor
	public Veiculo(String placa, String marca, String modelo) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
	}
	
	public String getPlaca() {
		return placa;
	}
	

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	}
