package estudo.de.caso.amigofiel;

import java.util.Scanner;

class Animal {
    private String nome;
    private String especie;
    private String raca;
    private String dataNascimento;
    private String proprietario;

    public Animal(String nome, String especie, String raca, String dataNascimento, String proprietario) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.dataNascimento = dataNascimento;
        this.proprietario = proprietario;
    }

    public Animal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome do animal: ");
        this.nome = scanner.nextLine();
        System.out.println("Informe a espécie do animal: ");
        this.especie = scanner.nextLine();
        System.out.println("Informe a raça do animal: ");
        this.raca = scanner.nextLine();
        System.out.println("Informe a data de nascimento do animal: ");
        this.dataNascimento = scanner.nextLine();
        System.out.println("Informe o nome do proprietário: ");
        this.proprietario = scanner.nextLine();
    }

    // Getters e Setters para todos os atributos
    public String getNome() {
        return nome;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaca() {
        return raca;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
        
    }

    
    
}