/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.fatecmogidascruzes.saph.teste;

/**
 *
 * @author marcelo
 */
public class TestProbability {
    
    private Double hitProbability;
    private Double missProbability;

    public Double getHitProbability() {
        return hitProbability;
    }

    public void setHitProbability(Double hitProbability) {
        this.hitProbability = hitProbability;
        this.missProbability = 1 - hitProbability;
    }

    public Double getMissProbability() {
        return missProbability;
    }

}
