package mc322_lab02;

public class Main {

	public static void main(String[] args) {
		
		//Instanciando um objeto seguradora
		
		Seguradora seguradora1 = new Seguradora("Seguradora do IC", "123456", 
				"seguradora@email.com","Avenida 1");
		
		System.out.println("Dados da seguradora");
		System.out.println("Nome da seguradora: " + seguradora1.getNome());
        System.out.println("Telefone da seguradora: " + seguradora1.getTelefone());
        System.out.println("Email da seguradora: " + seguradora1.getEmail());
        System.out.println("Endereço da seguradora: " + seguradora1.getEndereco());
        
        //Instanciando um objeto veiculo
        
        Veiculo veiculo1 = new Veiculo("ABC123", "Hyundai", "HB20");
        
        System.out.println();
        System.out.println("Dados do veiculo");
        System.out.println("Placa: " + veiculo1.getPlaca());
        System.out.println("Marca: " + veiculo1.getMarca());
        System.out.println("Modelo: " + veiculo1.getModelo());
        
        //Instanciando um objeto cliente
        
        String cpf = "123.456.789-10";
        		
        Cliente cliente = new Cliente("João",cpf,"26/05/2000", 22, "Avenida 2");
        
        System.out.println();
        System.out.println("Dados do cliente");
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
        System.out.println("Data de Nascimento: " + cliente.getDataNascimento());
        System.out.println("Endereço: " + cliente.getEndereco());
        
        if (cliente.validarCPF(cpf)) {
            System.out.println("O CPF informado é válido");
        } else {
            System.out.println("O CPF informado é inválido");
            
        }
        
        //Instanciando a classe sinistro
        
        Sinistro sinistro1 = new Sinistro("26/03/2000","Avenida 3");
        
        System.out.println();
        System.out.println("Dados no sinistro");
        System.out.println("ID: " + sinistro1.getId());
        System.out.println("Data: " + sinistro1.getData());
        System.out.println("Endereço: " + sinistro1.getEndereco());


	}

}
