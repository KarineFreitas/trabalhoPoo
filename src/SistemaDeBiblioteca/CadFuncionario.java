package SistemaDeBiblioteca;

import java.util.ArrayList;

public class CadFuncionario {
    private ArrayList<Funcionario> funcionarios;

    public CadFuncionario() {
        this.funcionarios = new ArrayList<>();
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    //adicionar func
    public boolean cadastrarFuncionario(Funcionario funcionario) {
        // Evita duplicatas
        if (consultarFuncionario(funcionario) != null) {
            return false;
        }
        return funcionarios.add(funcionario);
    }
    // Atualizar func
    public boolean atualizarFuncionario(Funcionario funcionario) {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getId() == funcionario.getId()) { // ou equals se for String
                funcionarios.set(i, funcionario);
                return true;
            }
        }
        return false; // Não encontrado
    }
    // Excluir func
    public Funcionario excluirFuncionario(Funcionario funcionario) {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getId() == funcionario.getId()) {
                return funcionarios.remove(i);
            }
        }
        return null;
    }
    // Consultar func
    public Funcionario consultarFuncionario(Funcionario funcionario) {
        for (Funcionario f : funcionarios) {
            if (f.getId() == funcionario.getId()) {
                return f;
            }
        }
        return null;
    }
}
