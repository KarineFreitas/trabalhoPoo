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
        if (consultarFuncionarioPorId(funcionario.getId()) != null) {
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
    public boolean excluirFuncionario(int id) {
        Funcionario funcParaExcluir = consultarFuncionarioPorId(id);
        if (funcParaExcluir != null){
            return funcionarios.remove(funcParaExcluir);
        }
        return false;
    }
    // Consultar func
    public Funcionario consultarFuncionarioPorId(int id) {
        for (Funcionario f : funcionarios) {
            if (f.getId() == id) {
                return f;
            }
        }
        return null;
    }
}
