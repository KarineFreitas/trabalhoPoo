package SistemaDeBiblioteca;

import java.util.ArrayList;

public class CadLeitor {
    private ArrayList<Leitor> leitores;

    public CadLeitor() {
        this.leitores = new ArrayList<>();
    }

    public ArrayList<Leitor> getLeitores() {
        return leitores;
    }

    public void setLeitores(ArrayList<Leitor> leitores) {
        this.leitores = leitores;
    }


    public boolean cadastrarLeitor(Leitor leitor) {
        if (consultarLeitorPorId(leitor.getId()) != null) {
            return false;
        }
        return leitores.add(leitor);
    }

    public boolean excluirLeitor(int id) {
        Leitor leitorParaExcluir = consultarLeitorPorId(id);
        if (leitorParaExcluir != null){
            return leitores.remove(leitorParaExcluir);
        }
        return false;
    }

    public Leitor consultarLeitorPorId(int id) {
        for (Leitor l : leitores) {
            if (l.getId() == id) {
                return l;
            }
        }
        return null;
    }
}
