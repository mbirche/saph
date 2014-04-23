package br.com.fatecmogidascruzes.saph.managedbeans;

import br.com.fatecmogidascruzes.saph.controller.FacadeFactory;
import br.com.fatecmogidascruzes.saph.facade.AbilityFacade;
import br.com.fatecmogidascruzes.saph.facade.AbstractFacade;
import br.com.fatecmogidascruzes.saph.facade.KnowledgeAreaFacade;
import br.com.fatecmogidascruzes.saph.model.Ability;
import br.com.fatecmogidascruzes.saph.model.KnowledgeArea;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.DualListModel;

/**
 * All fonts were produced for author's graduation project
 * @date 14/04/2014
 * @author Birche
 */
@ManagedBean(name="habilidadeAreaMB")
@SessionScoped
public class HabilidadeAreaMB {

    private KnowledgeAreaFacade kaFacade;
    private AbilityFacade abFacade;
    private DualListModel dualListModel;
    private List<String> source;
    private List<String> target;
    private KnowledgeArea knowledgeArea;
    private Ability ability;

    public HabilidadeAreaMB() {
        source = new ArrayList();
        source.add("Origem");
        target = new ArrayList();
        target.add("Destino");
        dualListModel = new DualListModel(source, target);
        
        kaFacade = (KnowledgeAreaFacade) FacadeFactory.getInstance().getFacade(KnowledgeArea.class);
        abFacade = (AbilityFacade) FacadeFactory.getInstance().getFacade(Ability.class);
        iniciarComponentes();
    }

    public void saveKArea(){
        
        AbstractFacade facade = (KnowledgeAreaFacade) FacadeFactory.getInstance().getFacade(KnowledgeArea.class);

        KnowledgeArea kArea = new KnowledgeArea();
        kArea.setName("Orientação a Objetos");

        facade.save(kArea);

        kArea.setName("Lógica de programação");

        facade.update(kArea);

        List kAreas = facade.getAll(KnowledgeArea.class);

        KnowledgeArea kArea1 = (KnowledgeArea) facade.get(10l, KnowledgeArea.class);

        facade.delete(kArea);

        List kAreas1 = facade.getAll(KnowledgeArea.class);
    }
    private void iniciarComponentes(){
        knowledgeArea = new KnowledgeArea();
        ability = new Ability();
    }
    public DualListModel getDualListModel() {
        return dualListModel;
    }

    public void setDualListModel(DualListModel dualListModel) {
        this.dualListModel = dualListModel;
    }  

    public KnowledgeArea getKnowledgeArea() {
        return knowledgeArea;
    }

    public void setKnowledgeArea(KnowledgeArea knowledgeArea) {
        this.knowledgeArea = knowledgeArea;
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }
}
