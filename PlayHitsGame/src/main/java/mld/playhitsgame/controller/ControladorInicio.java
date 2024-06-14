/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mld.playhitsgame.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import mld.playhitsgame.spotify.SpotifyController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


/**
 *
 * @author miguel
 */
@Controller
public class ControladorInicio {
    
    @Value("${custom.server.ip}")
    private String customIp;
    
    @GetMapping("/")
    public String inicio(Model modelo){
        
        return "Inicio";
        
    }
    
    @GetMapping("/spotify")
    public String spotify(Model modelo){
                
        String urlLogin = null;
        try {
            URL url = new URL(customIp + "/api/spotify/login");
            BufferedReader urlLectura = new BufferedReader(new InputStreamReader(url.openStream()));
            urlLogin = urlLectura.readLine();
        } catch (MalformedURLException ex) {
            Logger.getLogger(ControladorInicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {        
            Logger.getLogger(ControladorInicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        modelo.addAttribute("url", urlLogin);
        
        return "SpotifyLogin";
        
    }
    
    @GetMapping("/spotifyServicios")
    public String spotifyServicios(Model modelo){      
       
        
        return "Spotify";
        
    }
    
    @PostMapping("/spotifyServicios")
    public String respuestaServicios(String idplaylist , String anyoplaylist, Model modelo){
        
        String info;
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(customIp+ "/api/spotify/playList?idPlayList=" +
                        idplaylist + "&anyoPlayList=" + anyoplaylist))
 		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
            
        HttpResponse<String> response = null;   
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(SpotifyController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (response != null)
            info = response.body();
        else
            info = "ERROR EN LA PETICION";
        
        modelo.addAttribute("info", info);
        
        return "Spotify";
    }
    
}
