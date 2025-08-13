package SistemaDeBiblioteca;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class BibliotecaLivroFeliz {
    private CadLeitor cadLeitor;
    private CadFuncionario cadFuncionario;
    private CadItemAcervo cadItemAcervo;
    private ArrayList<Emprestimo> emprestimosAtivos;
    private ArrayList<Reserva> reservasAtivas;


    public BibliotecaLivroFeliz() {
        this.cadLeitor = new CadLeitor();
        this.cadFuncionario = new CadFuncionario();
        this.cadItemAcervo = new CadItemAcervo();
        this.emprestimosAtivos = new ArrayList<>();
        this.reservasAtivas = new ArrayList<>();

        cadFuncionario.cadastrarFuncionario(new Funcionario("Integral", 2500, 1, "000.000.000-00", "Admin", "4002-8922", "admin@livrofeliz.com", "admin123"));
    }

    // Metodos de gerenciamento via menu do funcionario:

    public void gerenciarUsuario(Scanner sc) {
        System.out.println("Menu para gerenciar os leitores da Biblioteca Feliz:");
        System.out.println("1. Cadastrar Leitor");
        System.out.println("2. Consultar Leitor");
        System.out.println("3. Excluir Leitor");
        System.out.print("Escolha uma opção acima: ");
        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao){
            case 1:
                System.out.println("Digite o ID do leitor ");
                sc.nextLine();
                System.out.print("Digite o CPF: ");
                String cpf = sc.nextLine();
                System.out.print("Digite o Nome: ");
                String nome = sc.nextLine();
                System.out.print("Digite o Telefone: ");
                String tel = sc.nextLine();
                System.out.print("Digite o Email: ");
                String email = sc.nextLine();
                System.out.print("Digite a Senha: ");
                String senha = sc.nextLine();
                Leitor novoLeitor = new Leitor(id, cpf, nome, tel, email, senha);

                if (cadLeitor.cadastrarLeitor(novoLeitor)) {
                    System.out.println("Leitor cadastrado com sucesso!");
                } else {
                    System.out.println("Erro: Leitor com este ID já existe.");
                }
                break;

            case 2:
                System.out.println("digite o ID do leitor para a consulta: ");
                int idConsulta = sc.nextInt();
                sc.nextLine();
                Leitor l = cadLeitor.consultarLeitorPorId(idConsulta);
                if (l != null) {
                    System.out.println("ID: " + l.getId() + ", Nome: " + l.getNome() + ", Status: " + l.getStatus());
                    consultarMultas(l);
                } else {
                    System.out.println("Leitor não encontrado.");
                }
                break;

            case 3:
                System.out.println("Digite o ID do leitor que deseja excluir:");
                int idExcluir = sc.nextInt();
                sc.nextLine();
                if (cadLeitor.excluirLeitor(idExcluir)){
                    System.out.println("O leitor foi excluido do sistema com sucesso.");
                }else {
                    System.out.println("Oops! Erro ao excluir o leitor: Leitor não encontrado no sistema :( ");
                }
                break;
            default:
                System.out.println("Você digitou uma opção inválida! Tente novamente :) ");

        }
    }

    // ---------------------GERENCIANDO O ACERVO DA BIBLIOTECA------------------------

    public void gerenciarItemAcervo(Scanner sc) {
        System.out.println("Gerenciar o Acervo Biblioteca Livro Feliz: adicione ou remova itens: ");
        System.out.println("Digite o codigo do livro: ");
        String codigo = sc.nextLine();
        ItemAcervo item = cadItemAcervo.consultarItemAcervoPorCodigo(codigo);
        if (item == null) {
            System.out.print("Título do livro: ");
            String titulo = sc.nextLine();
            System.out.print("Autor do livro: ");
            String autor = sc.nextLine();
            Livro novoLivro = new Livro();
            novoLivro.setTitulo(titulo);
            novoLivro.setAutor(autor);
            ItemAcervo novoItem = new ItemAcervo(novoLivro, codigo);
            cadItemAcervo.cadastrarItemAcervo(novoItem);
            System.out.println("Item '" + titulo + "' cadastrado com sucesso com o código " + codigo);
        } else{
            System.out.println("Este livro já está no acervo. Deseja removê-lo? (s/n): ");
            String resposta = sc.nextLine();
            if (resposta.equalsIgnoreCase("s")){
                if(isItemEmprestado (codigo)){
                    System.out.println("Não é possível remover do acervo livros que estão emprestados!!");]
                } else {
                    cadItemAcervo.excluirItemAcervo(codigo);
                    System.out.println("O livro foi removido do acervo da Biblioteca Livro Feliz!");
                }
            }
        }
    }

    //--------------------GERENCIANDO OS FUNCIONARIOS:---------------------------

    public void gerenciarFuncionarios(Scanner sc){
        System.out.println("\n--- Menu para gerenciar os funcionários da Biblioteca Livro Feliz ---");
        System.out.println("1. Cadastrar Funcionário");
        System.out.println("2. Consultar Funcionário");
        System.out.println("3. Excluir Funcionário");
        System.out.print("Escolha uma opção acima: ");
        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                System.out.print("Digite o ID do novo funcionário: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Digite o nome do novo funcionario: ");
                String nome = sc.nextLine();
                System.out.print("Digite o turno do novo funcionario: ");
                String turno = sc.nextLine();
                System.out.print("Digite uma senha para o acesso do funcionario: ");
                String senha = sc.nextLine();

                Funcionario novoFunc = new Funcionario();
                novoFunc.setId(id);
                novoFunc.setNome(nome);
                novoFunc.setTurno(turno);
                novoFunc.setSenha(senha);
                if (cadFuncionario.cadastrarFuncionario(novoFunc)) {
                    System.out.println("Funcionário cadastrado com sucesso!");
                } else {
                    System.out.println("Erro: Funcionário com este ID já existe.");
                }
                break;
            case 2:
                System.out.print("Digite o ID do funcionário para consulta: ");
                int idConsulta = sc.nextInt();
                sc.nextLine();
                Funcionario f = cadFuncionario.consultarFuncionarioPorId(idConsulta);
                if (f != null) {
                    System.out.println("ID: " + f.getId() + ", Nome: " + f.getNome());
                } else {
                    System.out.println("Funcionário não encontrado.");
                }
                break;
            case 3:
                System.out.print("Digite o ID do funcionário para excluir: ");
                int idExcluir = sc.nextInt();
                sc.nextLine();
                if (cadFuncionario.excluirFuncionario(idExcluir)) {
                    System.out.println("Funcionário excluído com sucesso.");
                } else {
                    System.out.println("Erro ao excluir. Funcionário não encontrado.");
                }
                break;
            default:
                System.out.println("Você digitou uma opção inválida! Tente novamente :)");
        }
    }

    //------------------VERIFICAÇÃO DE LIVROS EMPRESTADOS------------------------------------

    private boolean isItemEmprestado(String codigoItem){
        for(Emprestimo e : emprestimosAtivos){
            if(e.getItemAcervo().getCodigo().equals(codigoItem) && e.isEmprestado()){
                return true;
            }
        }
        return false;
    }
    //----------------------------------------------------------------------------------------


    //----------------METODOS PARA REALIZAR   EMPRESTIMO/DEVOLUÇÃO OU MULTA:---------------------------
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