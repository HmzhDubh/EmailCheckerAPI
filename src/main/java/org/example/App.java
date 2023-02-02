package org.example;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.core5.net.URIBuilder;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;

public class App {
    private final static String API_URL = "https://api.mailcheck.ai/email/meezo@gmail.com";

    public static void main(String[] args) {
        URIBuilder uriBuilder = null;
        try {
            uriBuilder = new URIBuilder(API_URL);

            URI uri = uriBuilder.build();
            HttpResponse<String> response = HTTPHelper.sendGet(uri);
            if (response != null) {
                System.out.println(response.body());
                EmailChecker checkEmail = parseEmailCheckerResponse(response.body(), EmailChecker.class);
                System.out.println(checkEmail);
            }

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static EmailChecker parseEmailCheckerResponse(String responseString, Class<?> elementClass){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode emailCheckerNode = objectMapper.readTree(responseString);
            EmailChecker emailChecker = new EmailChecker();
            String status = emailCheckerNode.get("main").get("status").textValue();
            String email = emailCheckerNode.get("main").get("email").textValue();
            String domain = emailCheckerNode.get("main").get("domain").textValue();
            boolean MX = emailCheckerNode.get("main").get("MX").booleanValue();
            boolean disposable = emailCheckerNode.get("main").get("disposable").booleanValue();
            boolean alias = emailCheckerNode.get("main").get("alias").booleanValue();
            String did_you_mean = emailCheckerNode.get("main").get("did_you_mean").textValue();

            emailChecker.setStatus(status);
            emailChecker.setEmail(email);
            emailChecker.setDomain(domain);
            emailChecker.setMX(MX);
            emailChecker.setDisposable(disposable);
            emailChecker.setAlias(alias);
            emailChecker.setDid_you_mean(did_you_mean);


            return emailChecker;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

}