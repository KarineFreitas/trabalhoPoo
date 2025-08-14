package SistemaDeBiblioteca;

import java.time.LocalDate;

public class Multa {
    private double valor;
    private boolean status;
    private LocalDate data;

    public Multa(double valor, LocalDate data){
        this.valor = valor;
        this.data = data;
        this.status = false;
    }

    public double getValor() {
        return valor;
    }

    public boolean getStatus() {
        return status;
    }

    public LocalDate getData() {
        return data;
    }

    public void pagar() {
        this.status = true;
        System.out.println("Multa no valor de R$ " + this.valor + " paga com sucesso");
    }
    public String getStatusString() {
        if (this.status) {
            return "pago";
        } else {
            return "pendente";
        }
    }

}
