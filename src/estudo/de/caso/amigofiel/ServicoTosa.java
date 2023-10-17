package estudo.de.caso.amigofiel;

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
