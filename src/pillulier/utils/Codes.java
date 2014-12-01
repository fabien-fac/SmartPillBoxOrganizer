/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pillulier.utils;

/**
 *
 * @author fabien
 */
public class Codes {
    public final static String LUNDIMATIN = "LunMa";
    public final static String MARDIMATIN = "MarMa";
    public final static String MERCREDIMATIN = "MerMa";
    public final static String JEUDIMATIN = "JeuMa";
    public final static String VENDREDIMATIN = "VenMa";
    public final static String SAMEDIMATIN = "SamMa";
    public final static String DIMANCHEMATIN = "DimMa";
    
    public final static String LUNDIMIDI = "LunMi";
    public final static String MARDIMIDI = "MarMi";
    public final static String MERCREDIMIDI = "MerMi";
    public final static String JEUDIMIDI = "JeuMi";
    public final static String VENDREDIMIDI = "VenMi";
    public final static String SAMEDIMIDI = "SamMi";
    public final static String DIMANCHEMIDI = "DimMi";
    
    public final static String LUNDISOIR = "LunSo";
    public final static String MARDISOIR = "MarSo";
    public final static String MERCREDISOIR = "MerSo";
    public final static String JEUDISOIR = "JeuSo";
    public final static String VENDREDISOIR = "VenSo";
    public final static String SAMEDISOIR = "SamSo";
    public final static String DIMANCHESOIR = "DimSo";
    
    public final static String getMomentFromCode(String code){
        
        String res = "";
        switch(code){
            case LUNDIMATIN:
            case MARDIMATIN:
            case MERCREDIMATIN:
            case JEUDIMATIN:
            case VENDREDIMATIN:
            case SAMEDIMATIN:
            case DIMANCHEMATIN:
                res = Moment.MATIN;
                break;
            case LUNDIMIDI:
            case MARDIMIDI:
            case MERCREDIMIDI:
            case JEUDIMIDI:
            case VENDREDIMIDI:
            case SAMEDIMIDI:
            case DIMANCHEMIDI:
                res = Moment.MIDI;
                break;
            case LUNDISOIR:
            case MARDISOIR:
            case MERCREDISOIR:
            case JEUDISOIR:
            case VENDREDISOIR:
            case SAMEDISOIR:
            case DIMANCHESOIR:
                res = Moment.SOIR;
                break;
        }
        
        return res;
    }
    
    public static int getDayFromCode(String code){
        int day = 0;
        
        switch(code){
            case DIMANCHEMATIN:
            case DIMANCHEMIDI:
            case DIMANCHESOIR:
                day = 7;
                break;
            case LUNDIMATIN:
            case LUNDIMIDI:
            case LUNDISOIR:
                day = 1;
                break;
            case MARDIMATIN:
            case MARDIMIDI:
            case MARDISOIR:
                day = 2;
                break;
            case MERCREDIMATIN:
            case MERCREDIMIDI:
            case MERCREDISOIR:
                day = 3;
                break;
            case JEUDIMATIN:
            case JEUDIMIDI:
            case JEUDISOIR:
                day = 4;
                break;
            case VENDREDIMATIN:
            case VENDREDIMIDI:
            case VENDREDISOIR:
                day = 5;
                break; 
            case SAMEDIMATIN:
            case SAMEDIMIDI:
            case SAMEDISOIR:
                day = 6;
                break; 
        }
        return  day;
    }
}
