package lab02;

import java.util.Random;

public class Sinistro {
	
	private int id;
	private String data;
	private String endereco;
	
	
	//Construtor que gera um ID aleatorio para o sinistro
	
	public Sinistro(String data, String endereco) {
		Random random = new Random(); 
		this.id = random.nextInt(10000);
		this.data = data;
		this.endereco = endereco;
	
	}
	
	public int getId(){
		return id;
	}
	
	public String getData(){
		return data;
	}
	
	public void setData(String data){
		this.data = data;
	}
	
	
	public String getEndereco(){
		return endereco;
	}

	public void setEndereco(String endereco){
		this.endereco =  endereco;
	}
	
}
	
	
