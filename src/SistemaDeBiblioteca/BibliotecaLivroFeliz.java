package SistemaDeBiblioteca;

import java.util.ArrayList;

public class BibliotecaLivroFeliz {
    private CadLeitor cadLeitor;
    private CadFuncionario cadFuncionario;
    private CadItemAcervo cadItemAcervo;
    private ArrayList<Emprestimo> itensEmprestados;
    private ArrayList<Reserva> itensReservados;
    private ArrayList<Multa> multasRegistradas;

    public BibliotecaLivroFeliz() {
        this.cadLeitor = new CadLeitor();
        this.cadFuncionario = new CadFuncionario();
        this.cadItemAcervo = new CadItemAcervo();
        this.itensEmprestados = new ArrayList<>();
        this.itensReservados = new ArrayList<>();
        this.multasRegistradas = new ArrayList<>();
    }

    public void gerenciarUsuario() {
    }

    public void gerenciarItemAcervo() {
    }

    public Emprestimo realizarEmprestimo() {
        return null;
    }

    public Emprestimo realizarDevolucao() {
        return null;
    }

    public Reserva realizarReserva() {
        return null;
    }

    public Reserva cancelarReserva() {
        return null;
    }

    public boolean verificarMulta(Leitor leitor) {
        return false;
    }

    public Multa calcularMulta(Emprestimo emprestimo) {

        return emprestimo.calcularMulta();
    }

    public void registrarMulta(Leitor leitor, Multa multa) {

        multasRegistradas.add(multa);
    }

    public ArrayList<Multa> consultarMultas(Leitor leitor) {

        return new ArrayList<>();
    }

    public void bloquearLeitor(Leitor leitor) {
    }

    public void desbloquearLeitor(Leitor leitor) {
    }


    public static void main(String[] args) {
        BibliotecaLivroFeliz teste = new BibliotecaLivroFeliz();

    }
}