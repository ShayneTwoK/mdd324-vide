package com.ipiecoles.java.mdd324.homepage.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class Channel {
        String titre;
        String link;
        String description;
        String language;
        String copyright;
        Date datePublication;
        Item item;

    public String getTitre() {
        return titre;
    }

    @XmlElement(name="titre")
    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getLink() {
        return link;
    }

    @XmlElement
    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    @XmlElement(name="description")
    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    @XmlElement
    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCopyright() {
        return copyright;
    }

    @XmlElement
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    @XmlElement
    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public Item getItem() {
        return item;
    }

    @XmlElement(name="item")
    public void setItem(Item item) {
        this.item = item;
    }
}
