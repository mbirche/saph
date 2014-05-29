package br.com.fatecmogidascruzes.saph.managedbeans;


import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * All fonts were produced for author's graduation project
 * @date 07/04/2014
 * @author Birche
 */

@ManagedBean(name="indexMB")
@SessionScoped
public class IndexMB implements Serializable{

    private String paginaAtual;

    public IndexMB() {        
        paginaAtual = "login.xhtml";
    }

    public String getPaginaAtual() {
        return paginaAtual;
    }
    public void fazNada(){
        System.out.println("Fazendo nada!");
    }
    public String setPaginaAtual(String paginaAtual) {
        if(!paginaAtual.equals("null")){
            this.paginaAtual = paginaAtual;
        }
        return paginaAtual;
    }
}
