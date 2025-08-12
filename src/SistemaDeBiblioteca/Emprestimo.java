package SistemaDeBiblioteca;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Emprestimo {
    private ItemAcervo itemAcervo;
    private Leitor leitor;
    private boolean emprestado;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoReal;

    public static final int prazo_emprestimo_dias = 14;
    public static final double valor_multa_por_dia = 1.00;

    public Emprestimo (ItemAcervo itemAcervo, Leitor leitor){
        this.itemAcervo = itemAcervo;
        this.leitor = leitor;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucaoPrevista = this.dataEmprestimo.plusDays(prazo_emprestimo_dias);
        this.emprestado = true;
    }

    public ItemAcervo getItemAcervo() {
        return itemAcervo;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void devolver(){
        this.emprestado = false;
        this.dataDevolucaoReal = LocalDate.now();
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public LocalDate getDataDevolucaoReal(){
        return dataDevolucaoReal;
    }

    public Multa calcularMulta() {
        //se a devolução ocorrer apos data prrevista
        if (LocalDate.now().isAfter(dataDevolucaoPrevista)){
            long diasAtraso = ChronoUnit.DAYS.between(dataDevolucaoPrevista,LocalDate.now());
            if(diasAtraso > 0){
                double valorMulta = diasAtraso * valor_multa_por_dia;
                return new Multa(valorMulta, LocalDate.now());
            }
        }
        return null; //nenhuma multa
    }

}