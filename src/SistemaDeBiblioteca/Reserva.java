package SistemaDeBiblioteca;

public class Reserva {
    private ItemAcervo itemAcervo;
    private Usuario usuario;
    private boolean reservado;

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