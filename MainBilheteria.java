import java.util.Scanner;

public class MainBilheteria {

    public static void main(String[] args) {
        Bilheteria bilheteria = new Bilheteria();
        Scanner sc = new Scanner(System.in);
        int opc;

        do {
            System.out.println("\nMenu Bilheteria:");
            System.out.println("1 - Cadastrar ingresso");
            System.out.println("2 - Remover ingresso");
            System.out.println("3 - Buscar ingresso por código");
            System.out.println("4 - Listar todos os ingressos");
            System.out.println("5 - Calcular arrecadação total");
            System.out.println("6 - Listar benefícios dos ingressos");
            System.out.println("7 - Finalizar");
            System.out.print("Opção: ");
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    System.out.println("Escolha tipo de ingresso:");
                    System.out.println("1 - Comum");
                    System.out.println("2 - Estudante");
                    System.out.println("3 - VIP");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Código: ");
                    int codigo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nome do Evento: ");
                    String nomeEvento = sc.nextLine();

                    System.out.print("Setor: ");
                    String setor = sc.nextLine();

                    System.out.print("Valor base: ");
                    double valorBase = sc.nextDouble();
                    sc.nextLine();

                    if (tipo == 1) {
                        bilheteria.adicionarIngresso(new IngressoComum(codigo, nomeEvento, setor, valorBase));
                    } else if (tipo == 2) {
                        System.out.print("Instituição de Ensino: ");
                        String instituicao = sc.nextLine();
                        bilheteria.adicionarIngresso(new IngressoEstudante(codigo, nomeEvento, setor, valorBase, instituicao));
                    } else if (tipo == 3) {
                        System.out.print("Possui acesso ao backstage (true/false): ");
                        boolean backstage = sc.nextBoolean();
                        sc.nextLine();
                        System.out.print("Número do lounge: ");
                        int lounge = sc.nextInt();
                        sc.nextLine();
                        bilheteria.adicionarIngresso(new IngressoVIP(codigo, nomeEvento, setor, valorBase, backstage, lounge));
                    } else {
                        System.out.println("Tipo inválido.");
                    }
                    break;

                case 2:
                    System.out.print("Código do ingresso para remover: ");
                    int codRemover = sc.nextInt();
                    sc.nextLine();
                    boolean removido = bilheteria.removerIngresso(codRemover);
                    if (removido) {
                        System.out.println("Ingresso removido.");
                    } else {
                        System.out.println("Ingresso não encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Código do ingresso para buscar: ");
                    int codBuscar = sc.nextInt();
                    sc.nextLine();
                    Ingresso ingBuscado = bilheteria.buscarIngresso(codBuscar);
                    if (ingBuscado != null) {
                        ingBuscado.exibirInformacoes();
                        System.out.println("Valor final: " + ingBuscado.calcularValorFinal());
                        System.out.println("Benefícios: " + ingBuscado.obterBeneficios());
                    } else {
                        System.out.println("Ingresso não encontrado.");
                    }
                    break;

                case 4:
                    bilheteria.listarIngressos();
                    break;

                case 5:
                    double arrecadacao = bilheteria.calcularArrecadacaoTotal();
                    System.out.println("Arrecadação total: " + arrecadacao);
                    break;

                case 6:
                    bilheteria.listarBeneficios();
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
