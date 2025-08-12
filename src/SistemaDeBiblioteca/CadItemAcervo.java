package SistemaDeBiblioteca;

import java.util.ArrayList;

public class CadItemAcervo {
    private ArrayList<ItemAcervo> itensAcervo;

    public ArrayList<ItemAcervo> getItensAcervo() {
        return itensAcervo;
    }

    public void setItensAcervo(ArrayList<ItemAcervo> itensAcervo) {
        this.itensAcervo = itensAcervo;
    }

    public boolean cadastrarItemAcervo(ItemAcervo itemAcervo) {
        return itensAcervo.add(itemAcervo);
    }

    public boolean atualizarItemAcervo(ItemAcervo itemAcervo) {

        return true;
    }

    public ItemAcervo excluirItemAcervo(ItemAcervo itemAcervo) {
        itensAcervo.remove(itemAcervo);
        return itemAcervo;
    }

    public ItemAcervo consultarItemAcervo(ItemAcervo itemAcervo) {

        return itemAcervo;
    }
}