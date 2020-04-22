package com.ipiecoles.java.mdd324.homepage.controller;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Horoscope {

    String horoscope;

    public String getHoroscope() {
        return horoscope;
    }

    @XmlElement(name="horoscope")
    public void setHoroscope(String horoscope) {
        this.horoscope = horoscope;
    }
}
