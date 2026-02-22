import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {
        try{
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("https://api.github.com/users/Ram27052000/events"))
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            JSONParser parser = new JSONParser();
            JSONArray events = (JSONArray) parser.parse(response.body());
            for(Object obj : events){
                JSONObject event =  (JSONObject) obj;
                String type = event.get("type").toString();
                JSONObject repo =  (JSONObject) event.get("repo");
                String repoName = repo.get("name").toString();
                switch (type){
                    case "PushEvent":
                        System.out.println("Pushed to: " +repoName);
                        break;
                    case "CreateEvent":
                        System.out.println("Created to: " +repoName);
                        break;
                }
            }

        }
        catch (IOException | InterruptedException e){
            System.out.println("Error " +e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("program came here ");
    }
}
