package SistemaDeBiblioteca;

import java.util.List;
import java.util.ArrayList;

public class Leitor extends Usuario {
    private String status;
    private List<Multa> multas;
    private List<Emprestimo> emprestimos; // NOVO: Histórico de empréstimos do leitor

    public Leitor(int id, String cpf, String nome, String telefone, String email, String senha) {
        super(id, cpf, nome, telefone, email, senha);
        this.status = "ativo";
        this.multas = new ArrayList<>();
        this.emprestimos = new ArrayList<>(); // NOVO: Inicializa a lista
    }
    public Leitor(){
        this.multas = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    // Métodos existentes (get/set status, multas) sem alteração
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Multa> getMultas() {
        return multas;
    }

    public void adicionarMulta(Multa m) {
        multas.add(m);
    }

    // NOVO: Métodos para gerenciar o histórico de empréstimos
    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        this.emprestimos.add(emprestimo);
    }

    public boolean temMultaPendente() {
        for (Multa multa : multas) {
            if (multa.getStatus().equals("Pendente")) {
                return true;
            }
        }
        return false;
    }

    public boolean podeEmprestar() {
        return status.equals("ativo") && !temMultaPendente();
    }
}