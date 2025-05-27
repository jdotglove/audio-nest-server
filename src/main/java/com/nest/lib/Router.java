package src.main.java.com.nest.lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.net.httpserver.HttpExchange;

import src.main.java.com.nest.lib.helpers.HttpMethod;
import src.main.java.com.nest.lib.helpers.HttpStatusCode;
import src.main.java.com.nest.lib.http.HttpHandler;


public class Router {
    public static void mainApiHandler(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod();

        if (method.equals(HttpMethod.GET.toString())) {
            int responseStatusCode = HttpStatusCode.OK.getCode();
            HttpHandler.sendResponse(exchange, responseStatusCode, "Successful Get Request");
        } else if (method.equals(HttpMethod.PUT.toString())) {
            int responseStatusCode = HttpStatusCode.OK.getCode();
            HttpHandler.sendResponse(exchange, responseStatusCode, "Successful Put Request");
        } else if (method.equals(HttpMethod.POST.toString())) {
            int responseStatusCode = HttpStatusCode.CREATED.getCode();
            HttpHandler.sendResponse(exchange, responseStatusCode, "Successful Post Request");
        } else if (method.equals(HttpMethod.PATCH.toString())) {
            int responseStatusCode = HttpStatusCode.OK.getCode();
            HttpHandler.sendResponse(exchange, responseStatusCode, "Successful Patch Request");
        } else if (method.equals(HttpMethod.DELETE.toString())) {
            int responseStatusCode = HttpStatusCode.OK.getCode();
            HttpHandler.sendResponse(exchange, responseStatusCode, "Successful Delete Request");
        } else {
            int responseStatusCode = HttpStatusCode.BAD_REQUEST.getCode();
            HttpHandler.sendResponse(exchange, responseStatusCode, "Method Not Allowed");
        }
    }

    public static void spotifyApiHandler(HttpExchange exchange) throws IOException {
        String method = exchange.getRequestMethod();
        String path = exchange.getRequestURI().getPath();

        Matcher albumRouteMatch = Pattern.compile("/album/").matcher(path);
        Matcher artistRouteMatch = Pattern.compile("/artist/").matcher(path);
        Matcher trackRouteMatch = Pattern.compile("/track/").matcher(path);
        Matcher playlistRouteMatch = Pattern.compile("/playlist/").matcher(path);
        Matcher usersRouteMatch = Pattern.compile("/users/").matcher(path);
        Matcher recommendationRouteMatch = Pattern.compile("/recommendations/").matcher(path);

        if (albumRouteMatch.find()) {
            if (method.equals(HttpMethod.GET.toString())) {
                int responseStatusCode = HttpStatusCode.OK.getCode();
                HttpHandler.sendResponse(exchange, responseStatusCode, "Spotify ALBUM API Get Request");
            } else if (method.equals(HttpMethod.POST.toString())) {
                int responseStatusCode = HttpStatusCode.CREATED.getCode();
                HttpHandler.sendResponse(exchange, responseStatusCode, "Spotify ALBUM API Post Request");
            } else {
                int responseStatusCode = HttpStatusCode.BAD_REQUEST.getCode();
                HttpHandler.sendResponse(exchange, responseStatusCode, "Spotify ALBUM API Method Not Allowed");
            }
        } 

        
        if (artistRouteMatch.find()) {
            if (method.equals(HttpMethod.GET.toString())) {
                int responseStatusCode = HttpStatusCode.OK.getCode();
                HttpHandler.sendResponse(exchange, responseStatusCode, "Spotify ARTIST API Get Request");
            } else if (method.equals(HttpMethod.POST.toString())) {
                int responseStatusCode = HttpStatusCode.CREATED.getCode();
                HttpHandler.sendResponse(exchange, responseStatusCode, "Spotify ARTIST API Post Request");
            } else {
                int responseStatusCode = HttpStatusCode.BAD_REQUEST.getCode();
                HttpHandler.sendResponse(exchange, responseStatusCode, "Spotify ARTIST API Method Not Allowed");
            }
        }

        
        if (trackRouteMatch.find()) {
            if (method.equals(HttpMethod.GET.toString())) {
                int responseStatusCode = HttpStatusCode.OK.getCode();
                HttpHandler.sendResponse(exchange, responseStatusCode, "Spotify TRACK API Get Request");
            } else if (method.equals(HttpMethod.POST.toString())) {
                int responseStatusCode = HttpStatusCode.CREATED.getCode();
                HttpHandler.sendResponse(exchange, responseStatusCode, "Spotify TRACK API Post Request");
            } else {
                int responseStatusCode = HttpStatusCode.BAD_REQUEST.getCode();
                HttpHandler.sendResponse(exchange, responseStatusCode, "Spotify TRACK API Method Not Allowed");
            }
        }

        
        if (playlistRouteMatch.find()) {
            if (method.equals(HttpMethod.GET.toString())) {
                int responseStatusCode = HttpStatusCode.OK.getCode();
                HttpHandler.sendResponse(exchange, responseStatusCode, "Spotify PLAYLIST API Get Request");
            } else if (method.equals(HttpMethod.POST.toString())) {
                int responseStatusCode = HttpStatusCode.CREATED.getCode();
                HttpHandler.sendResponse(exchange, responseStatusCode, "Spotify PLAYLIST API Post Request");
            } else {
                int responseStatusCode = HttpStatusCode.BAD_REQUEST.getCode();
                HttpHandler.sendResponse(exchange, responseStatusCode, "Spotify PLAYLIST API Method Not Allowed");
            }
        }

        
        if (usersRouteMatch.find()) {
            if (method.equals(HttpMethod.GET.toString())) {
                int responseStatusCode = HttpStatusCode.OK.getCode();
                HttpHandler.sendResponse(exchange, responseStatusCode, "Spotify USER API Get Request");
            } else if (method.equals(HttpMethod.POST.toString())) {
                int responseStatusCode = HttpStatusCode.CREATED.getCode();
                HttpHandler.sendResponse(exchange, responseStatusCode, "Spotify USER API Post Request");
            } else {
                int responseStatusCode = HttpStatusCode.BAD_REQUEST.getCode();
                HttpHandler.sendResponse(exchange, responseStatusCode, "Spotify USER API Method Not Allowed");
            }
        }


        if (recommendationRouteMatch.find()) {
            if (method.equals(HttpMethod.GET.toString())) {
                int responseStatusCode = HttpStatusCode.OK.getCode();
                HttpHandler.sendResponse(exchange, responseStatusCode, "Spotify RECOMMENDATION API Get Request");
            } else if (method.equals(HttpMethod.POST.toString())) {
                int responseStatusCode = HttpStatusCode.CREATED.getCode();
                HttpHandler.sendResponse(exchange, responseStatusCode, "Spotify RECOMMENDATION API Post Request");
            } else {
                int responseStatusCode = HttpStatusCode.BAD_REQUEST.getCode();
                HttpHandler.sendResponse(exchange, responseStatusCode, "Spotify RECOMMENDATION API Method Not Allowed");
            }
        }
    }
}
