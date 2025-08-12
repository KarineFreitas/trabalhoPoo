package SistemaDeBiblioteca;

import java.util.ArrayList;
import java.util.List;

public class CadLeitor {
    private List<Leitor> leitores;

    public CadLeitor() {
        this.leitores = new ArrayList<>();
    }

    public ArrayList<Leitor> getLeitores() {
        return leitores;
    }

    public void setLeitores(ArrayList<Leitor> leitores) {
        this.leitores = leitores;
    }

}
