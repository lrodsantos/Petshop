package petshop.estudo.de.caso;

class ServicoConsultaVeterinaria extends ServicoAbstrato {
    @Override
    public String descricao() {
        return "Consulta veterinária para o animal";
    }

    @Override
    public double preco() {
        return 50.0;
    }
}
