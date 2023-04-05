package lab03;

public class Cliente {
	
	private String nome; 
	private String endereco;
	private Date dataLicenca;
	private String educacao;
	private String genero;
	private String classeEconomica;
	private List <Veiculo> listaVeiculos;
	
	
	
	//Construtor
	
	public Cliente(String nome, String endereco, Date dataLicenca, String  educacao, String genero, String classeEconomica, List <Veiculo> listaVeiculos)  {
		this.nome = nome;
		this.endereco = endereco;
		this.dataLicenca = dataLicenca;
		this.educacao= educacao;
		this.genero = genero;
		this.classeEconomica = classeEconomica;
		this.listaVeiculos = listaVeiculos;
	}
		
	public String getNome() {
		return nome;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}
	
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	public String getDataLicenca() {
		return dataLicenca;
	}
	
	
	public void setDataLicenca(String dataLicenca) {
		this.dataLicenca = dataLicenca;
	}
	
	public int getEducacao() {
		return educacao;
	}
	
	
	public void setEducacao(int educacao) {
		this.educacao = educacao;
	}
	
	public String getGenero() {
		return genero;
	}
	
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getClasseEconomica() {
		return classeEconomica;
	}
	
	
	public void setClasseEconomica(String classeEconomica) {
		this.classeEconomica = classeEconomica;
	}
	
	//Getter e setter pra listas?
	
	
}