/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.Color;
import java.util.Calendar;
import javax.swing.JLabel;
import pillulier.utils.Codes;
import pillulier.utils.Moment;

/**
 *
 * @author fabien
 */
public class Case {

    private String moment;
    private String code;
    private int day;
    private JLabel label;
    private boolean medicamentPris = false;
    private boolean medicamentAPrendre = false;
    private boolean medicamentPrisErreur = false;
    private String description = "";

    public Case(String code, JLabel label) {
        this.code = code;
        this.label = label;
        this.moment = Codes.getMomentFromCode(code);
        this.day = Codes.getDayFromCode(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMoment() {
        return moment;
    }

    public void setMoment(String moment) {
        this.moment = moment;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public void setMedicamentPri(boolean medicamentPri) {
        this.medicamentPris = medicamentPri;

        Calendar rightNow = Calendar.getInstance();
        int hourNow = rightNow.get(Calendar.HOUR_OF_DAY);
        int dayNow = (rightNow.get(Calendar.DAY_OF_WEEK) - 1);
        if (dayNow < 0) {
            dayNow = 7;
        }

        // Si le médicament est pris avant le jour prévu
        if (dayNow < this.day) {
            this.medicamentPrisErreur = true;
        } else if (dayNow == this.day) {
            switch (this.moment) {
                case Moment.MIDI:
                    if (hourNow < 11) {
                        this.medicamentPrisErreur = true;
                    }
                    break;
                case Moment.SOIR:
                    if (hourNow < 18) {
                        this.medicamentPrisErreur = true;
                    }
                default:
                    break;
            }
        }

    }

    public boolean getMedicamentPri() {
        return this.medicamentPris;
    }

    public void setMedicamentAPrendre(boolean medicamentAPrendre) {
        this.medicamentAPrendre = medicamentAPrendre;
    }
    
    public boolean getMedicamentAPrendre(){
        return this.medicamentAPrendre;
    }

    /*
     retourne -1 si le medicament n'a pas était pris
     retourne 1 si le medicament doit être pris maintenant
     retourne 0 si le medicament ne doit être pris maintenant
     retourne -2 si le medicament a était pris par erreur
     */
    public int updateCouleur() {

        int res = 0;
        Calendar rightNow = Calendar.getInstance();
        int hourNow = rightNow.get(Calendar.HOUR_OF_DAY);
        int dayNow = (rightNow.get(Calendar.DAY_OF_WEEK) - 1);
        if (dayNow < 0) {
            dayNow = 7;
        }

        if (medicamentPrisErreur) {
            label.setForeground(Color.ORANGE);
            return -2;
        }

        if (dayNow < this.day && !medicamentPris) {
            if (this.medicamentAPrendre) {
                label.setForeground(Color.BLUE);
            } else {
                label.setForeground(Color.WHITE);
            }
        } else if (dayNow == this.day) {
            switch (this.moment) {
                case Moment.MATIN:
                    if (hourNow < 11 && !medicamentPris) {
                        label.setForeground(Color.GREEN);
                        res = 1;
                    } else if (hourNow >= 11) {
                        if (medicamentPris) {
                            label.setForeground(Color.GRAY);
                        } else if(medicamentAPrendre){
                            label.setForeground(Color.RED);
                            res = -1;
                        }
                        else{
                            label.setForeground(Color.WHITE);
                        }
                    }
                    break;
                case Moment.MIDI:
                    if (hourNow >= 11 && hourNow <= 13 && !medicamentPris) {
                        label.setForeground(Color.GREEN);
                        res = 1;
                    } else if (hourNow > 13) {
                        if (medicamentPris) {
                            label.setForeground(Color.GRAY);
                        } else if(medicamentAPrendre){
                            label.setForeground(Color.RED);
                            res = -1;
                        }
                        else{
                            label.setForeground(Color.WHITE);
                        }
                    }
                    break;
                case Moment.SOIR:
                    if (hourNow >= 18 && !medicamentPris) {
                        label.setForeground(Color.GREEN);
                        res = 1;
                    } else if (hourNow >= 18 && medicamentPris) {
                        label.setForeground(Color.GRAY);
                        res = 1;
                    }

                    break;
                default:
                    if (medicamentAPrendre) {
                        label.setForeground(Color.BLUE);
                    } else {
                        label.setForeground(Color.WHITE);
                    }
            }
        } else {
            if (medicamentPris) {
                label.setForeground(Color.GRAY);
            } else if(medicamentAPrendre) {
                label.setForeground(Color.RED);
                res = -1;
            }
            else{
                label.setForeground(Color.WHITE);
            }

        }

        return res;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
