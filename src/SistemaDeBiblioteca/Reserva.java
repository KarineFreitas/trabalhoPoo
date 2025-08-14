package SistemaDeBiblioteca;

public class Reserva {
    private ItemAcervo itemAcervo;
    private Usuario usuario;
    private boolean reservado;

    public Reserva (ItemAcervo itemAcervo, Usuario usuario){
        this.itemAcervo = itemAcervo;
        this.usuario = usuario;
<<<<<<< HEAD
        this.reservado = true; //iniciando como reservado
=======
        this.reservado = true;
>>>>>>> 77e118c6e5937d67ca4971534dffa8ec5bf21a04
    }
    public Reserva(){
    }

    public void setItemAcervo(ItemAcervo itemAcervo) {
        this.itemAcervo = itemAcervo;
    }

    public ItemAcervo getItemAcervo() {
        return this.itemAcervo;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    public boolean getReservado() {
        return this.reservado;
    }
}