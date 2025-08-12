package SistemaDeBiblioteca;

import java.util.ArrayList;
import java.util.Scanner;

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
        CadLeitor cadastro = new CadLeitor();

        Scanner sc = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("==== MENU BIBLIOTECA ====");
            System.out.println("1. Gerenciar Usuário");
            System.out.println("2. Gerenciar Item do Acervo");
            System.out.println("3. Realizar Empréstimo");
            System.out.println("4. Realizar Devolução");
            System.out.println("5. Realizar Reserva");
            System.out.println("6. Cancelar Reserva");
            System.out.println("7. Verificar Multa");
            System.out.println("8. Calcular Multa");
            System.out.println("9. Registrar Multa");
            System.out.println("10. Consultar Multas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    //BibliotecaLivroFeliz.gerenciarUsuario();
                    break;
                case 2:
                    //biblioteca.gerenciarItemAcervo();
                    break;
                case 3:
                    //biblioteca.realizarEmprestimo();
                    break;
                case 4:
                    //biblioteca.realizarDevolucao();
                    break;
                case 5:
                    //biblioteca.realizarReserva();
                    break;
                case 6:
                    // biblioteca.cancelarReserva();
                    break;
                case 7:
                    // Aqui você poderia pedir o leitor e chamar verificarMulta()
                    break;
                case 8:
                    // Chamar calcularMulta()
                    break;
                case 9:
                    // Chamar registrarMulta()
                    break;
                case 10:
                    // Chamar consultarMultas()
                    break;
                case 11:
                    // Chamar bloquearLeitor()
                    break;
                case 12:
                    // Chamar desbloquearLeitor()
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}