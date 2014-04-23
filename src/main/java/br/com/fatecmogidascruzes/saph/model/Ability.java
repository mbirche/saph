package br.com.fatecmogidascruzes.saph.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * All fonts were produced for author's graduation project
 *
 * @date 13/02/2014
 * @author Birche
 */
@javax.persistence.Entity
public class Ability extends Entity {

    @Cascade(CascadeType.ALL)
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<KnowledgeArea> knowledgeAreas;
    private String name;
    private String description;

    public Boolean addKnowledgeArea(KnowledgeArea kArea) {
        return knowledgeAreas.add(kArea);
    }

    public Ability() {
        knowledgeAreas = new HashSet();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<KnowledgeArea> getKnowledgeAreas() {
        return knowledgeAreas;
    }

    public void setKnowledgeAreas(Set<KnowledgeArea> knowledgeAreas) {
        this.knowledgeAreas = knowledgeAreas;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
