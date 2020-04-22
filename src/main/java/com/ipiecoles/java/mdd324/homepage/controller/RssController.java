package com.ipiecoles.java.mdd324.homepage.controller;

import com.ipiecoles.java.mdd324.homepage.model.Rss;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@RestController
@RequestMapping(value = "/horoscalope")
public class RssController {

    @PostMapping
    @ResponseBody
    public Rss sendRssReponse() throws Exception {
        Rss rssReponse = new Rss();

        // PARAMETRES DE LA REQUETE HTTP
        String signe = "belier";
        // URL
        String url = "https://www.asiaflash.com/horoscope/rss_horojour_" + signe + ".xml";

        JAXBContext jaxbContext = JAXBContext.newInstance(Rss.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Rss rss = (Rss) jaxbUnmarshaller.unmarshal(new StringReader(url));
        System.out.println(rss);

        return rssReponse;
    }
}

