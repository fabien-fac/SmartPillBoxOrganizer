/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pillulier.utils;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author fabien
 */
public class IdToCode {
    
    private Map<String, String> mapIdFiducial = new HashMap<String, String>();
    
    public IdToCode(){
        mapIdFiducial.put("1", Codes.LUNDIMATIN);
        mapIdFiducial.put("11", Codes.LUNDIMIDI);
        mapIdFiducial.put("9", Codes.LUNDISOIR);
        
        mapIdFiducial.put("5", Codes.MARDIMATIN);
        mapIdFiducial.put("6", Codes.MARDIMIDI);
        mapIdFiducial.put("10", Codes.MARDISOIR);
        
        mapIdFiducial.put("2", Codes.MERCREDIMATIN);
        mapIdFiducial.put("7", Codes.MERCREDIMIDI);
        mapIdFiducial.put("8", Codes.MERCREDISOIR);
        
        mapIdFiducial.put("0", Codes.JEUDIMATIN);
        mapIdFiducial.put("4", Codes.JEUDIMIDI);
        mapIdFiducial.put("14", Codes.JEUDISOIR);
        
        mapIdFiducial.put("19", Codes.VENDREDIMATIN);
        mapIdFiducial.put("17", Codes.VENDREDIMIDI);
        mapIdFiducial.put("20", Codes.VENDREDISOIR);
        
        mapIdFiducial.put("16", Codes.SAMEDIMATIN);
        mapIdFiducial.put("12", Codes.SAMEDIMIDI);
        mapIdFiducial.put("18", Codes.SAMEDISOIR);
        
        mapIdFiducial.put("13", Codes.DIMANCHEMATIN);
        mapIdFiducial.put("15", Codes.DIMANCHEMIDI);
        mapIdFiducial.put("3", Codes.DIMANCHESOIR);       
    }
    
    public String getCodeCase(String idFiducial){
        if(mapIdFiducial.containsKey(idFiducial)){
            return mapIdFiducial.get(idFiducial);
        }
        
        return "";
    }
    
}
