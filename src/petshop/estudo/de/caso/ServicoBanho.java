package petshop.estudo.de.caso;

class ServicoBanho extends ServicoAbstrato {
    @Override
    public String descricao() {
        return "Banho para o animal";
    }

    @Override
    public double preco() {
        return 30.0;
    }
}
