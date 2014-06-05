/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.saph.service;

import br.com.fatecmogidascruzes.saph.model.Ability;

/**
 *
 * @author marcelo
 */
public class TestAnalysisDetail {

    private Ability ability;

    private Integer numberOfUses;

    private Integer numberOfHits;

    private Double probRandom;

    public TestAnalysisDetail(Ability ability, Integer numberOfUses, Integer numberOfHits, Double probRandom) {
        this.ability = ability;
        this.numberOfUses = numberOfUses;
        this.numberOfHits = numberOfHits;
        this.probRandom = probRandom;
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    public Integer getNumberOfUses() {
        return numberOfUses;
    }

    public void setNumberOfUses(Integer numberOfUses) {
        this.numberOfUses = numberOfUses;
    }

    public Integer getNumberOfHits() {
        return numberOfHits;
    }

    public void setNumberOfHits(Integer numberOfHits) {
        this.numberOfHits = numberOfHits;
    }

    public Double getProbRandom() {
        return probRandom;
    }

    public void setProbRandom(Double probRandom) {
        this.probRandom = probRandom;
    }

}
