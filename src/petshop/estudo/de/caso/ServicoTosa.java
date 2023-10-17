package petshop.estudo.de.caso;

class ServicoTosa extends ServicoAbstrato {
    @Override
    public String descricao() {
        return "Tosa para o animal";
    }

    @Override
    public double preco() {
        return 25.0;
    }
}
