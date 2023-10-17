package petshop.estudo.de.caso;

import java.util.Scanner;

class Agenda {
    private Animal animal;
    private ServicoAbstrato servico;
    private String data;
    private String horario;

    public Agenda(Animal animal, ServicoAbstrato servico, String data, String horario) {
        this.animal = animal;
        this.servico = servico;
        this.data = data;
        this.horario = horario;
    }

    public Agenda() {
        Scanner scanner = new Scanner(System.in);
        animal = new Animal();
        System.out.println("Informe a data do agendamento: ");
        data = scanner.nextLine();
        System.out.println("Informe o horário do agendamento: ");
        horario = scanner.nextLine();
        // Escolher o serviço
        System.out.println("Escolha o serviço (1 - Banho, 2 - Tosa, 3 - Consulta Veterinária): ");
        int escolhaServico = scanner.nextInt();
        switch (escolhaServico) {
            case 1:
                servico = new ServicoBanho();
                break;
            case 2:
                servico = new ServicoTosa();
                break;
            case 3:
                servico = new ServicoConsultaVeterinaria();
                break;
            default:
                System.out.println("Opção de serviço inválida.");
        }
    }

    // Getters e Setters
    public Animal getAnimal() {
        return animal;
    }

    public ServicoAbstrato getServico() {
        return servico;
    }

    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public void setServico(ServicoAbstrato servico) {
        this.servico = servico;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
