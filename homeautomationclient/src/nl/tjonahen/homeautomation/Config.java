/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.tjonahen.homeautomation;

/**
 *
 * @author Philippe Tjon-A-Hen philippe@tjonahen.nl
 */
public class Config {
    private String baseUrl;
    
    public static final String BASE_URL = "baseUrl";

    private static Config _instance = null;
    public static synchronized Config getInstance() {
        if (_instance == null) {
           _instance = new Config(); 
        }
        return _instance;
        
    }
    private Config() {
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
    
    
}
