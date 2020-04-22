package com.ipiecoles.java.mdd324.homepage;

import com.ipiecoles.java.mdd324.homepage.model.Rss;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import static jdk.nashorn.internal.objects.Global.println;

@SpringBootApplication
public class HomepageApplication {

	public static void main(String[] args) throws JAXBException, IOException {
		SpringApplication.run(HomepageApplication.class, args);

        // PARAMETRES DE LA REQUETE HTTP
        String signe = "belier";
        // URL
        String url = "https://www.asiaflash.com/horoscope/rss_horojour_" + signe + ".xml";
        URL objURL = new URL(url);

        // CONNEXION API
        HttpURLConnection connexionAPI = (HttpURLConnection) objURL.openConnection();
        // XML to String
        BufferedReader in = new BufferedReader(
                new InputStreamReader(connexionAPI.getInputStream()));

        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JAXBContext jaxbContext = JAXBContext.newInstance(Rss.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Rss rss = (Rss) jaxbUnmarshaller.unmarshal(new StringReader(url));

        System.out.println(rss);
	}

}
