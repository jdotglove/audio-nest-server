package src.main.java.nest;
// Java Program to Set up a Basic HTTP Server
import com.sun.net.httpserver.HttpServer;

import src.main.java.nest.lib.Router;

import java.io.IOException;
import java.net.InetSocketAddress;

public class NestHttpServer 
{
    public static void main(String[] args) throws IOException 
    {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/", (req) -> Router.mainApiHandler(req));
        server.createContext("/spotify/", (req) -> Router.spotifyApiHandler(req));

        server.setExecutor(null); // Use the default executor
        server.start();
        System.out.println("Server is running on port 8000");
    }
}