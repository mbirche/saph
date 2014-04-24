package br.com.fatecmogidascruzes.saph.model;

import java.util.ArrayList;
import java.util.List;
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
    private List<KnowledgeArea> knowledgeAreas;
    private String name;
    private String description;

    public Boolean addKnowledgeArea(KnowledgeArea kArea) {
        return knowledgeAreas.add(kArea);
    }

    public Ability() {
        knowledgeAreas = new ArrayList<KnowledgeArea>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<KnowledgeArea> getKnowledgeAreas() {
        return knowledgeAreas;
    }

    public void setKnowledgeAreas(List<KnowledgeArea> knowledgeAreas) {
        this.knowledgeAreas = knowledgeAreas;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.knowledgeAreas != null ? this.knowledgeAreas.hashCode() : 0);
        hash = 37 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 37 * hash + (this.description != null ? this.description.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ability other = (Ability) obj;
        if (this.knowledgeAreas != other.knowledgeAreas && (this.knowledgeAreas == null || !this.knowledgeAreas.equals(other.knowledgeAreas))) {
            return false;
        }
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.description == null) ? (other.description != null) : !this.description.equals(other.description)) {
            return false;
        }
        return true;
    }
    
}
