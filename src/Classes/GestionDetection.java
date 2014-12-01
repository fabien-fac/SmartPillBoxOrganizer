/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import pillulier.Main;

/**
 *
 * @author fabien
 */
public class GestionDetection {
    
    private static Map<String, Integer> mapCompteur = null;
    private static Map<String, Boolean> mapDisparu = null;
    private final int SECONDES = 10;
    private static final int NB_CASES = 21;
    
    public GestionDetection(){
        if(mapCompteur == null){
            mapCompteur = new HashMap<String, Integer>();
            initMapCompteur();
            
        }
        if(mapDisparu == null){
            mapDisparu = new HashMap<String, Boolean>();
            initMapDisparu();
        }
    }
    
    public void setListCasesDisparues(Set<String> listCasesDisparues){
        
        // Parcours la liste des compteurs
        for (Map.Entry<String, Integer> entry : mapCompteur.entrySet())
        {
            if(listCasesDisparues.contains(entry.getKey())){
                int newValue = entry.getValue()+1;
                mapCompteur.put(entry.getKey(), entry.getValue()+1);
                if(newValue == SECONDES){
                    mapDisparu.put(entry.getKey(), Boolean.TRUE);
                    Main.notificationChangementEtat(entry.getKey());
                }
            }
            else{
                mapCompteur.put(entry.getKey(), 0);
            }
        }
    }

    private void initMapCompteur() {
        for(int i=0; i<NB_CASES; i++){
            mapCompteur.put(String.valueOf(i), 0);  
        }
    }

    private void initMapDisparu() {
        for(int i=0; i<NB_CASES; i++){
            mapDisparu.put(String.valueOf(i), false);
        }
    }
}
