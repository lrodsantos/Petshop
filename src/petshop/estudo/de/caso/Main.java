package petshop.estudo.de.caso;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Main {
    
	private static final Logger logger = (Logger) LogManager.getLogger(Main.class);
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();
        ArrayList<Agenda> agendamentos = new ArrayList<>();
        ArrayList<Venda> vendas = new ArrayList<>();
        
        logger.info("SUCESS");
        logger.error("erro");
        
        
        while (true) {
        	System.out.println("#####-SISTEMA PETSHOP-#####");
            System.out.println("###########-MENU-##########");
            System.out.println("1. Cadastrar Animal");
            System.out.println("2. Cadastrar Produto");
            System.out.println("3. Agendar Serviço");
            System.out.println("4. Listar cadastros de animais e serviços Agendados");
            System.out.println("5. Registrar Venda de Produto");
            System.out.println("6. Listar Estoque dos Produtos");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine(); 

            switch (escolha) {
                case 1:
                	System.out.println("Escolha o tipo de animal (1 - Cachorro, 2 - Gato) ");
                    int escolhaTipoAnimal = scanner.nextInt();
                    scanner.nextLine();
                    

                    Animal animal = criarAnimal(escolhaTipoAnimal);
                    agendamentos.add(new Agenda(animal, null, "", ""));
                    break;
                case 2:
                    Produto produto = new Produto();
                    produtos.add(produto);
                    break;
                case 3:
                    System.out.println("Escolha o animal para agendar o serviço:");
                    for (int i = 0; i < agendamentos.size(); i++) {
                        System.out.println((i + 1) + ". " + agendamentos.get(i).getAnimal().getNome());
                    }
                    int escolhaAnimal = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.println("Escolha o serviço (1 - Banho, 2 - Tosa, 3 - Consulta Veterinária): ");
                    int escolhaServico = scanner.nextInt();
                    scanner.nextLine(); 

                    ServicoAbstrato servico = null;
                    if (escolhaServico == 1) {
                        servico = new ServicoBanho();
                    } else if (escolhaServico == 2) {
                        servico = new ServicoTosa();
                    } else if (escolhaServico == 3) {
                        servico = new ServicoConsultaVeterinaria();
                    } else {
                        System.out.println("Opção de serviço inválida.");
                        break;
                    }

                    System.out.println("Informe a data do agendamento: ");
                    String data = scanner.nextLine();
                    System.out.println("Informe o horário do agendamento: ");
                    String horario = scanner.nextLine();

                    // Verifica se o horário está ocupado
                    boolean horarioOcupado = false;
                    for (Agenda agendamento : agendamentos) {
                        if (agendamento.getData().equals(data) && agendamento.getHorario().equals(horario)) {
                            System.out.println("Horário já está ocupado. Escolha outro horário.");
                            horarioOcupado = true;
                            break;
                        }
                    }

                    if (horarioOcupado) {
                        break;
                    }

                    Agenda agendamento = agendamentos.get(escolhaAnimal - 1);
                    agendamento.setServico(servico);
                    agendamento.setData(data);
                    agendamento.setHorario(horario);
                    break;
                case 4:
                    for (Agenda agendamentoServico : agendamentos) {
                        Animal animal1 = agendamentoServico.getAnimal();
                        System.out.println("Animal: " + animal1.getNome());

                        if (animal1 instanceof Cachorro) {
                            System.out.println("Tipo de Animal: Cachorro");
                        } else if (animal1 instanceof Gato) {
                            System.out.println("Tipo de Animal: Gato");
                        } else {
                            System.out.println("Tipo de Animal: Desconhecido");
                        }

                        System.out.println("Data e Horário: " + agendamentoServico.getData() + " " + agendamentoServico.getHorario());

                        if (agendamentoServico.getServico() != null) {
                            System.out.println("Serviço: " + agendamentoServico.getServico().descricao());
                        } else {
                            System.out.println("Nenhum serviço agendado.");
                        }

                        System.out.println();
                    }
                    break;
                case 5:
                    System.out.println("Informe o nome do cliente: ");
                    String nomeProprietario = scanner.nextLine();
                    System.out.println("Escolha o produto para venda:");
                    for (int i = 0; i < produtos.size(); i++) {
                        System.out.println((i + 1) + ". " + produtos.get(i).getNome());
                    }
                    int escolhaProduto = scanner.nextInt();
                    scanner.nextLine(); 

                    Produto produtoVenda = produtos.get(escolhaProduto - 1);
                    System.out.println("Informe a quantidade para venda: ");
                    int quantidadeVenda = scanner.nextInt();
                    scanner.nextLine(); 

                    // Verificar se há estoque suficiente
                    if (quantidadeVenda <= produtoVenda.getQuantidadeEmEstoque()) {
                        produtoVenda.vender(quantidadeVenda);
                        vendas.add(new Venda(produtoVenda, nomeProprietario, quantidadeVenda));
                        System.out.println("Venda registrada com sucesso.");
                    } else {
                        System.out.println("Estoque insuficiente.");
                        break;
                    }
                    break;
                case 6:
                    System.out.println("Estoque de Produtos:");
                    for (Produto produto1 : produtos) {
                        System.out.println("Produto: " + produto1.getNome());
                        System.out.println("Categoria: " + produto1.getCategoria());
                        System.out.println("Preço: " + produto1.getPreco());
                        System.out.println("Quantidade em Estoque: " + produto1.getQuantidadeEmEstoque());
                        System.out.println();
                    }
                    break;
                case 7:
                    System.out.println("Saindo do sistema.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Escolha uma opção válida.");
            }
        }
    }

	private static Animal criarAnimal(int escolhaTipoAnimal) {
        switch (escolhaTipoAnimal) {
            case 1:
                return new Cachorro();
            case 2:
                return new Gato();
            default:
                System.out.println("Opção de tipo de animal é inválida,Reinicie o Sistema.");
                System.exit(0);
                return new Animal();
	}
}
}