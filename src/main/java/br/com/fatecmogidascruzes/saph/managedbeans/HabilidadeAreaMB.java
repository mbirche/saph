package br.com.fatecmogidascruzes.saph.managedbeans;

import br.com.fatecmogidascruzes.saph.controller.FacadeFactory;
import br.com.fatecmogidascruzes.saph.facade.AbilityFacade;
import br.com.fatecmogidascruzes.saph.facade.KnowledgeAreaFacade;
import br.com.fatecmogidascruzes.saph.model.Ability;
import br.com.fatecmogidascruzes.saph.model.KnowledgeArea;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.TransferEvent;
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
    private DualListModel<KnowledgeArea> dualListModel;
    private KnowledgeArea knowledgeArea;
    private List knowledgeAreas;
    private List knowledgeAreasAux;
    private Ability ability;

    public HabilidadeAreaMB() {
        
        kaFacade = (KnowledgeAreaFacade) FacadeFactory.getInstance().getFacade(KnowledgeArea.class);
        abFacade = (AbilityFacade) FacadeFactory.getInstance().getFacade(Ability.class);
        atualizarHabilidade();
        atualizarKArea();
        atualizarListas();

    }

    
    public void saveHabilidade(){
        abFacade.save(ability);
        atualizarHabilidade();
        atualizarListas();
    }
    public void saveKArea(){
        
        kaFacade.save(knowledgeArea);
        atualizarKArea();
        atualizarListas();
    }
    private void atualizarListas(){
        knowledgeAreas = (List<KnowledgeArea>)(List)kaFacade.getAll(KnowledgeArea.class);
        knowledgeAreasAux = new ArrayList<KnowledgeArea>(knowledgeAreas);
        knowledgeAreasAux.removeAll(ability.getKnowledgeAreas());
        dualListModel = new DualListModel<KnowledgeArea> (knowledgeAreasAux, ability.getKnowledgeAreas());
    }
    private void atualizarKArea(){
        knowledgeArea = new KnowledgeArea();           
    }
    private void atualizarHabilidade(){
        ability = new Ability();
    }

    public void onTransfer(TransferEvent event){
        if(event.isAdd()){
            for(Object o : event.getItems()){
                ability.getKnowledgeAreas().add((KnowledgeArea)o);
            }
            
        }else{
            for(Object o : event.getItems()){
                ability.getKnowledgeAreas().remove((KnowledgeArea)o);
            }
        }
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

    public List getKnowledgeAreas() {
        return knowledgeAreas;
    }

    public void setKnowledgeAreas(List knowledgeAreas) {
        this.knowledgeAreas = knowledgeAreas;
    }
}
