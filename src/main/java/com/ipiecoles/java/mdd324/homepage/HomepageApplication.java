package com.ipiecoles.java.mdd324.homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootApplication
public class HomepageApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomepageApplication.class, args);
		Horoscope test = new Horoscope();
		test.getReponseAPI();
	}

}

class Horoscope {

    public void getReponseAPI() {
        try {
            // PARAMETRES DE LA REQUETE HTTP
            String signe = "belier";
            String format = "xml";
            // URL
            String url = "https://www.asiaflash.com/horoscope/rss_horojour_" + signe + "." + format;
            System.out.println(url);
            URL objURL = new URL(url);
            // CONNEXION API
            HttpURLConnection connexionAPI = (HttpURLConnection) objURL.openConnection();
            int responseCode = connexionAPI.getResponseCode();
            System.out.println("Code d'erreur : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connexionAPI.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            //print in String
            // System.out.println(response.toString());
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                    .parse(new InputSource(new StringReader(response.toString())));

            System.out.println(response);
            System.out.println(doc);
            NodeList errNodes = doc.getElementsByTagName("channel");
            // SI LA REQUETE NOUS RETOURNE UNE REPONSE
            if (errNodes.getLength() > 0) {
                Element err = (Element) errNodes.item(0);
                System.out.println("signe -" + err.getElementsByTagName("signe").item(0).getTextContent());
            } else {
                // success
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
