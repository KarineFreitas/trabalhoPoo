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
}