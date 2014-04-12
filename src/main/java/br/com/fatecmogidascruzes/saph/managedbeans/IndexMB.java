package br.com.fatecmogidascruzes.saph.managedbeans;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * All fonts were produced for author's graduation project
 * @date 07/04/2014
 * @author Birche
 */

@ManagedBean(name="indexMB")
@SessionScoped
public class IndexMB {

    private String paginaAtual;

    public IndexMB() {
        
        paginaAtual = "login.xhtml";
//        paginaAtual = "habilidade_area_conhecimento.xhtml";
        //paginaAtual = "cursos.xhtml";
    }

    public String getPaginaAtual() {
        return paginaAtual;
    }
    public void fazNada(){
        System.out.println("Fazendo nada!");
    }
    public String setPaginaAtual(String paginaAtual) {
        this.paginaAtual = paginaAtual;
        return paginaAtual;
    }
}
