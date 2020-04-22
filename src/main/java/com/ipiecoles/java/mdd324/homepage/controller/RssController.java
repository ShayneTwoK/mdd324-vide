package com.ipiecoles.java.mdd324.homepage.controller;

import com.ipiecoles.java.mdd324.homepage.model.Item;
import com.ipiecoles.java.mdd324.homepage.model.Rss;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.net.URL;

@RestController
@RequestMapping(value = "/{signeAstro}/horoscalope")
public class RssController {

    @PostMapping
    public Horoscope sendRssReponse(@PathVariable String signeAstro) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Rss.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        Rss horoscopeApiResponse = (Rss) jaxbUnmarshaller.unmarshal(new URL("https://www.asiaflash.com/horoscope/rss_horojour_"+ signeAstro +".xml"));

        Item i = horoscopeApiResponse.getChannel().getItem();
        String desc = i.getDescription();
        String titre = "<h1>" + i.getTitre() + "</h1>";

        Horoscope horoscope = new Horoscope();
        horoscope.setHoroscope(desc + titre);

        return horoscope;
    }
}