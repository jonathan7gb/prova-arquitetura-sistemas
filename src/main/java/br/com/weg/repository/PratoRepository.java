package br.com.weg.repository;

import br.com.weg.model.Funcionario;
import br.com.weg.model.Prato;

import java.util.ArrayList;
import java.util.List;

public class PratoRepository {

    List<Prato> cardapio = new ArrayList<>();

    public void AddPrato(Prato p){
        cardapio.add(p);
    }

    public List<Prato> listarPratos(){
        return cardapio;
    }

    public Prato buscarPratoPorCodigo(int codigo){
        for(Prato p : cardapio){
            if(p.getCodigo() == codigo){
                return p;
            }
        }
        return null;
    }

    public boolean excluirPrato(int codigo){
        for(Prato p : cardapio){
            if(p.getCodigo() == codigo){
                cardapio.remove(p);
                return true;
            }
        }
        return false;
    }

    public void editarPrato(int codigo, Prato pratoEditado){
        for(Prato f : cardapio){
            if(f.getCodigo() == codigo){
                f.setCodigo(pratoEditado.getCodigo());
                f.setNome(pratoEditado.getNome());
                f.setCategoria(pratoEditado.getCategoria());
                f.setPreco(pratoEditado.getPreco());
                f.setEstoque(pratoEditado.getEstoque());
            }
        }
    }

    public boolean adicionarEstoque(int codigo, int quantidade){
        for(Prato p : cardapio){
            if(p.getCodigo() == codigo){
                p.setEstoque(p.getEstoque() + quantidade);
                return true;
            }
        }
        return false;
    }


}
