package lab04;

public enum MenuOperacoes {
    CADASTRAR_CLIENTE_PF_PJ(1),
    CADASTRAR_VEICULO(2),
    CADASTRAR_SEGURADORA(3),
    LISTAR_CLIENTE_POR_SEGURADORA(4),
    LISTAR_SINISTROS_POR_SEGURADORA(5),
    LISTAR_SINISTRO_CLIENTE(6),
    LISTAR_VEICULO_CLIENTE(7),
    LISTAR_VEICULO_SEGURADORA(8),
    EXCLUIR_CLIENTE(9),
    EXCLUIR_VEICULO(10),
    EXCLUIR_SINISTRO(11),
    GERAR_SINISTRO(12),
    TRANSFERIR_SEGURO(13),
    CALCULAR_RECEITA_SEGURADORA(14),
    SAIR(0);
    
    public final int operacao;
    
    MenuOperacoes(int operacao) {
        this.operacao = operacao;
    }
    
    public int getOperacao() {
        return this.operacao;
    }
}

