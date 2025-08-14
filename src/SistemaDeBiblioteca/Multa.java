package SistemaDeBiblioteca;

import java.time.LocalDate;

public class Multa {
    private double valor;
    private String status;
    private LocalDate data;

    public Multa(double valor, LocalDate data){
        this.valor = valor;
        this.data = data;
        this.status = "PENDENTE";
    }

    public double getValor() {
        return valor;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getData() {
        return data;
    }

    public void pagar() {
        this.status = "Paga";
        System.out.println("Multa no valor de R$ " + this.valor + "paga com sucesso");
    }

}
