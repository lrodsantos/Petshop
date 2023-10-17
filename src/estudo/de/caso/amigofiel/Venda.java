package estudo.de.caso.amigofiel;

class Venda {
    private Produto produto;
    private String nomeProprietario;
    private int quantidade;

    public Venda(Produto produto, String nomeProprietario, int quantidade) {
        this.produto = produto;
        this.nomeProprietario = nomeProprietario;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
