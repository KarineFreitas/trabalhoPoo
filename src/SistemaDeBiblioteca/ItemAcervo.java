package SistemaDeBiblioteca;

public class ItemAcervo {
    private Livro livro;
    private String codigo;

    public ItemAcervo(Livro livro, String codigo){
        this.livro = livro;
        this.codigo = codigo;
    }
    public ItemAcervo(){

    }
    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
