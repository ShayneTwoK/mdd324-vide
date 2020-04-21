package com.ipiecoles.java.mdd324.homepage.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Item {

    String titre;
    String description;

    public String getTitre() {
        return titre;
    }

    @XmlElement(name="titre")
    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    @XmlElement(name="description")
    public void setDescription(String description) {
        this.description = description;
    }
}
