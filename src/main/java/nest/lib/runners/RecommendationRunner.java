package nest.lib.runners;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;

import nest.lib.helpers.HttpMethod;
import nest.lib.http.HttpDecoder;
import nest.lib.http.HttpHandler;
import nest.lib.pojos.HttpRequest;

public class RecommendationRunner {
    public static void generateRecommendations(HttpRequest request) {
        System.out.println("--generateRecommendations--");
        System.out.println("--REQUEST--");
        System.out.println(request);

    }
    public static void getSeedGenres(HttpExchange exchange) throws IOException {
        Map<String, String> queryParams = HttpDecoder.parseQueryParams(exchange.getRequestURI().getQuery());
        String token = queryParams.get("token");


        StringBuffer content = new StringBuffer();
        int responseStatusCode = 200;
        String responseBody = "";
        try {
            HttpURLConnection con = HttpRequest.sendRequest(HttpMethod.GET.toString(), "https://api.spotify.com/v1/recommendations/available-genre-seeds", token);

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            responseStatusCode = con.getResponseCode();
            responseBody = content.toString();
            in.close();
            con.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpHandler.sendResponse(exchange, responseStatusCode, responseBody);
    }
}