import java.util.ArrayList;

public class Agenda {
    private ArrayList<Contato> contatos;
    private int tamanho;

    public Agenda() {
        contatos = new ArrayList<>();
        tamanho = 0;
    }

    public void adicionarContato(Contato c) {
        contatos.add(c);
        tamanho++;
    }

    public boolean removerContato(String nome) {
        for (Contato c : contatos) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                contatos.remove(c);
                tamanho--;
                return true;
            }
        }
        return false;
    }

    public Contato buscarPorNome(String nome) {
        for (Contato c : contatos) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        return null;
    }

    public Contato buscarPorEmail(String email) {
        for (Contato c : contatos) {
            if (c.getEmail().equalsIgnoreCase(email)) {
                return c;
            }
        }
        return null;
    }

    public Contato buscarPorTelefone(String telefone) {
        for (Contato c : contatos) {
            if (c.getTelefone().equals(telefone)) {
                return c;
            }
        }
        return null;
    }

    public int getTamanho() {
        return tamanho;
    }
}
