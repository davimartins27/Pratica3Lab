public class IngressoEstudante extends Ingresso {
    private String instituicaoEnsino;

    public IngressoEstudante(int codigo, String nomeEvento, String setor, double valorBase, String instituicao) {
        super(codigo, nomeEvento, setor, valorBase);
        this.instituicaoEnsino = instituicao;
    }

    public String getInstituicaoEnsino() { return instituicaoEnsino; }
    public void setInstituicaoEnsino(String instituicaoEnsino) { this.instituicaoEnsino = instituicaoEnsino; }

    @Override
    public double calcularValorFinal() {
        return getValorBase() * 0.5; // 50% de desconto
    }

    @Override
    public String obterBeneficios() {
        return "Direito à meia-entrada.";
    }
}
