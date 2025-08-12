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

    //adicionar um leitor
    public boolean cadastrarLeitor(Leitor leitor) {
        // Evita duplicatas
        if (consultarLeitor(leitor) != null) {
            return false;
        }
        return leitores.add(leitor);
    }
    // Atualizar leitor
    public boolean atualizarLeitor(Leitor leitor) {
        for (int i = 0; i < leitores.size(); i++) {
            if (leitores.get(i).getId() == leitor.getId()) { // ou equals se for String
                leitores.set(i, leitor);
                return true;
            }
        }
        return false; // Não encontrado
    }
    // Excluir leitor
    public Leitor excluirLeitor(Leitor leitor) {
        for (int i = 0; i < leitores.size(); i++) {
            if (leitores.get(i).getId() == leitor.getId()) {
                return leitores.remove(i);
            }
        }
        return null;
    }
    // Consultar leitor
    public Leitor consultarLeitor(Leitor leitor) {
        for (Leitor l : leitores) {
            if (l.getId() == leitor.getId()) {
                return l;
            }
        }
        return null;
    }
}
