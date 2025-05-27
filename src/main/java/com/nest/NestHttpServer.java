package src.main.java.com.nest;
// Java Program to Set up a Basic HTTP Server
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import src.main.java.com.nest.lib.Router;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class NestHttpServer 
{
    public static void main(String[] args) throws IOException 
    {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        
        server.createContext("/", (req) -> Router.mainApiHandler(req));
        server.createContext("/health", new HealthCheckHandler());
        server.createContext("/spotify/", (req) -> Router.spotifyApiHandler(req));

        server.setExecutor(null); // Use the default executor
        server.start();
        System.out.println("Server is running on port 8080");
    }

    // define a custom HttpHandler
    static class HealthCheckHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException 
        {
            // handle the request
            String response = "Hello, this is a simple HTTP server response!";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}