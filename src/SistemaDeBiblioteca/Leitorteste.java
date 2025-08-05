package SistemaDeBiblioteca;

public class Leitorteste extends Usuario {

    public Leitorteste(int id, String cpf, String nome, String telefone, String email, String senha) {
        super(id, cpf, nome, telefone, email, senha);
    }

    public void algo() {
        System.out.println(getNome() + " está falando");
    }
}
