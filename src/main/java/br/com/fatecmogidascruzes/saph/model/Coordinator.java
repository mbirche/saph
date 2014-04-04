/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.model;

import br.com.fatecmogidascruzes.saph.interfaces.ICoordinable;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author Birche
 */
@javax.persistence.Entity
@PrimaryKeyJoinColumn(name = "id")
public class Coordinator extends User implements ICoordinable{
 
}
 
