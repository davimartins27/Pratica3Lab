import java.util.ArrayList;

public class Bilheteria {
    private ArrayList<Ingresso> ingressos;

    public Bilheteria() {
        ingressos = new ArrayList<>();
    }

    public void adicionarIngresso(Ingresso ingresso) {
        ingressos.add(ingresso);
    }

    public boolean removerIngresso(int codigo) {
        for (Ingresso ing : ingressos) {
            if (ing.getCodigo() == codigo) {
                ingressos.remove(ing);
                return true;
            }
        }
        return false;
    }

    public Ingresso buscarIngresso(int codigo) {
        for (Ingresso ing : ingressos) {
            if (ing.getCodigo() == codigo) {
                return ing;
            }
        }
        return null;
    }

    public void listarIngressos() {
        if (ingressos.isEmpty()) {
            System.out.println("Nenhum ingresso cadastrado.");
            return;
        }
        for (Ingresso ing : ingressos) {
            ing.exibirInformacoes();
            System.out.println("Valor final: " + ing.calcularValorFinal());
            System.out.println("Benefícios: " + ing.obterBeneficios());
            System.out.println("---------------------------------");
        }
    }

    public double calcularArrecadacaoTotal() {
        double total = 0;
        for (Ingresso ing : ingressos) {
            total += ing.calcularValorFinal();
        }
        return total;
    }

    public void listarBeneficios() {
        if (ingressos.isEmpty()) {
            System.out.println("Nenhum ingresso cadastrado.");
            return;
        }
        for (Ingresso ing : ingressos) {
            System.out.println("Ingresso código " + ing.getCodigo() + ": " + ing.obterBeneficios());
        }
    }
}
