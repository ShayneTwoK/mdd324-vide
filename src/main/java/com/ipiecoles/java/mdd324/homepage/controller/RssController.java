package com.ipiecoles.java.mdd324.homepage.controller;

import com.ipiecoles.java.mdd324.homepage.model.Rss;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

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
//        String url = "https://www.asiaflash.com/horoscope/rss_horojour_" + signe + ".xml";


        return rssReponse;
    }
}