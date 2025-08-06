package SistemaDeBiblioteca;

public class Emprestimo {
    private ItemAcervo itemAcervo;
    private Usuario usuario;
    private boolean emprestado;
    private String dataEmprestimo;
    private String dataDevolucao;


    public ItemAcervo getItemAcervo() {
        return ItemAcervo;
    }
    public void setItemAcervo(ItemAcervo itemAcervo){
        this.itemAcervo = itemAcervo;
    }
    public Usuario getUsuario(){
        return usuario;
    }
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    public getEmprestado(){
        return emprestado;
    }
    public void setEmprestado(boolean emprestado){
        this.emprestado = emprestado;
    }
    public String getDataEmprestimo() {
        return dataEmprestimo;
    }
    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
    public String getDataDevolucao() {
        return dataDevolucao;
    }
    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Multa calcularMulta(Emprestimo emprestimo){
        LocalData hoje = LocalDate.now();
        LocalData dataDevolucao = emprestimo.getDataPrevistaDevolucao();

        long diasAtraso = ChronoUnit.DAYS.between(dataDevolucao, hoje);

        if (diasAtraso > 0){
            double valor = diasAtraso * 2.50;
            return new multa();
        } else {
            return null;
        }
    }
}