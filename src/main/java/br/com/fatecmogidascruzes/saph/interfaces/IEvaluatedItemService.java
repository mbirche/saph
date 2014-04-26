/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.interfaces;

import br.com.fatecmogidascruzes.saph.model.Ability;
import br.com.fatecmogidascruzes.saph.model.EvaluatedItem;
import java.util.List;

/**
 *
 * @author marcelo
 */
public interface IEvaluatedItemService extends IAbstractService{
    public List<EvaluatedItem> getEvaluatedItemsByAbility(Ability ability);
}
