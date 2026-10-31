package ApiCalls;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Main {

    public static String getJSONFromFile(String filename){
        String jsonText = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                jsonText += line + "\n";
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonText;
    }

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        String createUserJSON = getJSONFromFile(Constants.USER_RCO);
        //System.out.println(createUserJSON);

        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI("https://latest-qa-966.platform-qa.mykoerber.dev/platform/bff-web/UserModels"))
                .header("cookie", Constants.COOKIE)
                .POST(HttpRequest.BodyPublishers.ofString(createUserJSON))
                .setHeader("Content-Type", "application/json")
                .setHeader("User-Agent", "Mozilla/5.0")
                .build();

//        HttpRequest postRequest2 = HttpRequest.newBuilder()
//                .uri(new URI("https://latest-qa-966.platform-qa.mykoerber.dev/platform/bff-web/UserModels"))
//                .header("cookie", Constants.COOKIE)
//                .GET()
//                .build();
//
//        String id = "6fcaf3ce-1637-48c9-9041-2966addda2e1";
//        HttpRequest getUserById = HttpRequest.newBuilder()
//                .uri(new URI("https://latest-qa-966.platform-qa.mykoerber.dev/platform/bff-web/UserModels(guid'" + id + "')"))
//                .setHeader("cookie", Constants.COOKIE)
//                .GET()
//                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> postResponse = httpClient.send(postRequest, BodyHandlers.ofString());

        System.out.println("Response code: " + postResponse.statusCode());
        System.out.println("Response body: " + postResponse.body());

        Transcript transcripto = new Transcript();
        Gson gson = new Gson();
        transcripto = gson.fromJson(postResponse.body(), Transcript.class);


        System.out.println("Id: " + transcripto.getId());
        System.out.println("Logon name: " + transcripto.getLogOnName());
    }
}
