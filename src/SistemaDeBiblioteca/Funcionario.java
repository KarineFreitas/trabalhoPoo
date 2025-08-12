package SistemaDeBiblioteca;

public class Funcionario extends Usuario {
    private String turno;
    private double salario;


    public Funcionario(String turno, double salario, int id, String cpf, String nome, String telefone, String email, String senha) {
        super(id, cpf, nome, telefone, email, senha);
        this.turno = turno;
        this.salario = salario;
    }
    public Funcionario(){

    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
