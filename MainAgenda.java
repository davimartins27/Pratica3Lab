import java.util.Scanner;

public class MainAgenda {

    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner sc = new Scanner(System.in);
        int opc;

        do {
            System.out.println("\nMenu Agenda:");
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Remover contato");
            System.out.println("3 - Buscar contato por nome");
            System.out.println("4 - Buscar contato por email");
            System.out.println("5 - Buscar contato por telefone");
            System.out.println("6 - Consultar tamanho da agenda");
            System.out.println("7 - Finalizar");
            System.out.print("Opção: ");
            opc = sc.nextInt();
            sc.nextLine();

            switch(opc) {
                case 1:
                    System.out.println("Escolha tipo de contato:");
                    System.out.println("1 - Pessoal");
                    System.out.println("2 - Profissional");
                    System.out.println("3 - Emergência");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();

                    if (tipo == 1) {
                        System.out.print("Data aniversário: ");
                        String aniversario = sc.nextLine();
                        System.out.print("Parentesco: ");
                        String parentesco = sc.nextLine();

                        agenda.adicionarContato(new ContatoPessoal(nome,email,telefone, aniversario, parentesco));

                    } else if (tipo == 2) {
                        System.out.print("Empresa: ");
                        String empresa = sc.nextLine();
                        System.out.print("Cargo: ");
                        String cargo = sc.nextLine();

                        agenda.adicionarContato(new ContatoProfissional(nome,email,telefone, empresa, cargo));

                    } else if (tipo == 3) {
                        System.out.print("Grau de prioridade (1 a 5): ");
                        int grau = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Observação: ");
                        String obs = sc.nextLine();

                        agenda.adicionarContato(new ContatoEmergencia(nome,email,telefone, grau, obs));

                    } else {
                        System.out.println("Tipo inválido");
                    }
                    break;

                case 2:
                    System.out.print("Nome do contato para remover: ");
                    String nomeRem = sc.nextLine();
                    boolean removido = agenda.removerContato(nomeRem);
                    if (removido) {
                        System.out.println("Remoção realizada.");
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Nome para busca: ");
                    String nomeBusca = sc.nextLine();
                    Contato contatoNome = agenda.buscarPorNome(nomeBusca);
                    if (contatoNome != null) {
                        contatoNome.exibirDados();
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Email para busca: ");
                    String emailBusca = sc.nextLine();
                    Contato contatoEmail = agenda.buscarPorEmail(emailBusca);
                    if (contatoEmail != null) {
                        contatoEmail.exibirDados();
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("Telefone para busca: ");
                    String telefoneBusca = sc.nextLine();
                    Contato contatoTel = agenda.buscarPorTelefone(telefoneBusca);
                    if (contatoTel != null) {
                        contatoTel.exibirDados();
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;

                case 6:
                    System.out.println("Tamanho da agenda: " + agenda.getTamanho());
                    break;

                case 7:
                    System.out.println("Encerrando programa...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opc != 7);

        sc.close();
    }
}
