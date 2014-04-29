package br.com.fatecmogidascruzes.saph.managedbeans;

import br.com.fatecmogidascruzes.saph.controller.FacadeFactory;
import br.com.fatecmogidascruzes.saph.facade.AbilityFacade;
import br.com.fatecmogidascruzes.saph.facade.AlternativeFacade;
import br.com.fatecmogidascruzes.saph.facade.EvaluatedItemFacade;
import br.com.fatecmogidascruzes.saph.facade.KnowledgeAreaFacade;
import br.com.fatecmogidascruzes.saph.facade.QuestionFacade;
import br.com.fatecmogidascruzes.saph.model.Ability;
import br.com.fatecmogidascruzes.saph.model.Alternative;
import br.com.fatecmogidascruzes.saph.model.EvaluatedItem;
import br.com.fatecmogidascruzes.saph.model.KnowledgeArea;
import br.com.fatecmogidascruzes.saph.model.Question;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

/**
 * All fonts were produced for author's graduation project
 *
 * @date 14/04/2014
 * @author Birche
 */
@ManagedBean(name = "habilidadeAreaMB")
@SessionScoped
public class HabilidadeAreaMB {

    private KnowledgeAreaFacade kaFacade;
    private AbilityFacade abFacade;
    private EvaluatedItemFacade evFacade;
    private AlternativeFacade altFacade;
    private QuestionFacade qFacade;
    private DualListModel<KnowledgeArea> dualListModel;
    private DualListModel<KnowledgeArea> dualListModelEdit;
    private KnowledgeArea knowledgeArea;
    private KnowledgeArea deletingKA;
    private KnowledgeArea updatingKA;
    private List knowledgeAreas;
    private List knowledgeAreasAux;
    private List knowledgeAreasAuxEdit;
    private List abilities;
    private Ability ability;
    private Ability deletingAbility;
    private Ability updatingAbility;

    public HabilidadeAreaMB() {

        kaFacade = (KnowledgeAreaFacade) FacadeFactory.getInstance().getFacade(KnowledgeArea.class);
        abFacade = (AbilityFacade) FacadeFactory.getInstance().getFacade(Ability.class);
        evFacade = (EvaluatedItemFacade) FacadeFactory.getInstance().getFacade(EvaluatedItem.class);
        qFacade = (QuestionFacade) FacadeFactory.getInstance().getFacade(Question.class);
        altFacade = (AlternativeFacade) FacadeFactory.getInstance().getFacade(Alternative.class);
        atualizarHabilidade();
        atualizarKArea();
        atualizarListas();

    }

    public void deleteAbility() {
        abFacade.delete(deletingAbility);
        atualizarHabilidade();
        atualizarListas();
    }

    public void updateKArea() {
        kaFacade.update(updatingKA);
        atualizarKArea();
        atualizarListas();
    }

    public void updateAbility() {
        abFacade.update(updatingAbility);
        atualizarListas();
    }

    public void deleteKArea() {
        kaFacade.delete(deletingKA);
        atualizarKArea();
        atualizarListas();
    }

    public void saveHabilidade() {
        abFacade.save(ability);
        atualizarHabilidade();
        atualizarListas();
    }

    public void saveKArea() {

        kaFacade.save(knowledgeArea);
        atualizarKArea();
        atualizarListas();
    }

    private void atualizarListas() {
        knowledgeAreas = (List<KnowledgeArea>) (List) kaFacade.getAll(KnowledgeArea.class);
        knowledgeAreasAux = new ArrayList<KnowledgeArea>(knowledgeAreas);
        knowledgeAreasAux.removeAll(ability.getKnowledgeAreas());
        abilities = (List<KnowledgeArea>) (List) abFacade.getAll(Ability.class);
        dualListModel = new DualListModel<KnowledgeArea>(knowledgeAreasAux, ability.getKnowledgeAreas());
    }

    public void atualizarListEdit() {

        knowledgeAreas = (List<KnowledgeArea>) (List) kaFacade.getAll(KnowledgeArea.class);
        knowledgeAreasAuxEdit = new ArrayList<KnowledgeArea>(knowledgeAreas);
        knowledgeAreasAuxEdit.removeAll(updatingAbility.getKnowledgeAreas());
        dualListModelEdit = new DualListModel<KnowledgeArea>(knowledgeAreasAuxEdit, updatingAbility.getKnowledgeAreas());

    }

    private void atualizarKArea() {
        knowledgeArea = new KnowledgeArea();
    }

    private void atualizarHabilidade() {
        ability = new Ability();
    }

    public void onTransfer(TransferEvent event) {
        if (event.isAdd()) {
            for (Object o : event.getItems()) {
                KnowledgeArea ka = (KnowledgeArea) o;
                ability.getKnowledgeAreas().add(ka);
            }

        } else {
            for (Object o : event.getItems()) {
                ability.getKnowledgeAreas().remove((KnowledgeArea) o);
            }
        }
    }

    public void onTransferEdit(TransferEvent event) {
        if (event.isAdd()) {
            for (Object o : event.getItems()) {
                KnowledgeArea ka = (KnowledgeArea) o;
                updatingAbility.getKnowledgeAreas().add(ka);
            }

        } else {
            for (Object o : event.getItems()) {
                updatingAbility.getKnowledgeAreas().remove((KnowledgeArea) o);
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

    public List getAbilities() {
        return abilities;
    }

    public void setAbilities(List abilities) {
        this.abilities = abilities;
    }

    public KnowledgeArea getDeletingKA() {
        return deletingKA;
    }

    public void setDeletingKA(KnowledgeArea deletingKA) {
        this.deletingKA = deletingKA;
    }

    public KnowledgeArea getUpdatingKA() {
        return updatingKA;
    }

    public void setUpdatingKA(KnowledgeArea updatingKA) {
        this.updatingKA = updatingKA;
    }

    public Ability getDeletingAbility() {
        return deletingAbility;
    }

    public void setDeletingAbility(Ability deletingAbility) {
        this.deletingAbility = deletingAbility;
    }

    public Ability getUpdatingAbility() {
        return updatingAbility;
    }

    public void setUpdatingAbility(Ability updatingAbility) {
        this.updatingAbility = updatingAbility;
        atualizarListEdit();
    }

    public DualListModel<KnowledgeArea> getDualListModelEdit() {
        return dualListModelEdit;
    }

    public void setDualListModelEdit(DualListModel<KnowledgeArea> dualListModelEdit) {
        this.dualListModelEdit = dualListModelEdit;
    }
}
