    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.interfaces;

import br.com.fatecmogidascruzes.saph.model.Ability;
import br.com.fatecmogidascruzes.saph.model.Alternative;
import br.com.fatecmogidascruzes.saph.model.EvaluatedItem;
import br.com.fatecmogidascruzes.saph.model.KnowledgeArea;
import br.com.fatecmogidascruzes.saph.model.Performance;
import java.util.List;

/**
 *
 * @author marcelo
 */
public interface IAlternativeFacade extends IAbstractFacade {

    public List<EvaluatedItem> getEvaluatedItemsByAbility(Alternative anternative, Ability ability);

    public List<EvaluatedItem> getEvaluatedItemsByPerformance(Alternative alernative, Performance performance);

    public List<Alternative> getAlternativesByAbility(Ability ability);

    public List<Alternative> getAlternativesByKnowledgeArea(KnowledgeArea kArea);
}
