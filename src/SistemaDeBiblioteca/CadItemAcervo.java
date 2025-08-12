package SistemaDeBiblioteca;

import java.util.ArrayList;

public class CadItemAcervo {
    private ArrayList<ItemAcervo> itensAcervo;

    public CadItemAcervo(){
        this.itensAcervo = new ArrayList<>();
    }


    public ArrayList<ItemAcervo> getItensAcervo() {
        return itensAcervo;
    }

    public void setItensAcervo(ArrayList<ItemAcervo> itensAcervo) {
        this.itensAcervo = itensAcervo;
    }

    public boolean cadastrarItemAcervo(ItemAcervo itemAcervo) {

        if(consultarItemAcervoPorCodigo(itemAcervo.getCodigo()) != null){
            return false; //para evitar duplicatas de codigo
        }
        return itensAcervo.add(itemAcervo);
    }

    public boolean atualizarItemAcervo(String codigo, ItemAcervo novoItemAcervo) {
        for (int i = 0; i < itensAcervo.size(); i++){
            if(itensAcervo.get(i).getCodigo().equals(codigo)){
                itensAcervo.set(i, novoItemAcervo);
            }return true;
        }
        return true; //nao achou :(
    }

    public boolean excluirItemAcervo(String codigo) {
        ItemAcervo itemParaExcluir = consultarItemAcervoPorCodigo(codigo);
        if(itemParaExcluir != null){
            return itensAcervo.remove(itemParaExcluir);
        }
        return false;
    }

    public ItemAcervo consultarItemAcervoPorCodigo(String codigo) {
        for (ItemAcervo item : itensAcervo){
            if(item.getCodigo().equals(codigo)){
                return item;
            }
        }
        return null;
    }
}