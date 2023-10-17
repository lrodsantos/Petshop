package estudo.de.caso.amigofiel;

import java.util.Scanner;

class Produto {
    private String nome;
    private String categoria;
    private double preco;
    private int quantidadeEmEstoque;

    public Produto(String nome, String categoria, double preco, int quantidadeEmEstoque) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public Produto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome do produto: ");
        this.nome = scanner.nextLine();
        System.out.println("Informe a categoria do produto: ");
        this.categoria = scanner.nextLine();
        System.out.println("Informe o preço do produto: ");
        this.preco = scanner.nextDouble();
        System.out.println("Informe a quantidade em estoque: ");
        this.quantidadeEmEstoque = scanner.nextInt();
    }

    public void vender(int quantidade) {
        if (quantidade <= quantidadeEmEstoque) {
            quantidadeEmEstoque -= quantidade;
        } else {
            System.out.println("Estoque insuficiente.");
        }
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
}