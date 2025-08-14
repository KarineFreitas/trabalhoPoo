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

    public boolean cadastrarFuncionario(Funcionario funcionario) {
        if (consultarFuncionarioPorId(funcionario.getId()) != null) {
            return false;
        }
        return funcionarios.add(funcionario);
    }

    public boolean excluirFuncionario(int id) {
        Funcionario funcParaExcluir = consultarFuncionarioPorId(id);
        if (funcParaExcluir != null){
            return funcionarios.remove(funcParaExcluir);
        }
        return false;
    }

    public Funcionario consultarFuncionarioPorId(int id) {
        for (Funcionario f : funcionarios) {
            if (f.getId() == id) {
                return f;
            }
        }
        return null;
    }
}
