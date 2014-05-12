/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.dao;

import br.com.fatecmogidascruzes.saph.interfaces.IDisciplineFacade;

/**
 *
 * @author marcelo
 */
public class DisciplineDAO extends AbstractDAO implements IDisciplineFacade{
    
    private static DisciplineDAO dao;

    public static DisciplineDAO getInstance() {
        if (dao == null) {
            dao = new DisciplineDAO();
            return dao;
        } else {
            return dao;
        }
    }
    
}
