/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import des différentes bibliotheques
package projet_info2a_test2;
import java.util.ArrayList;
/**
 *
 * @author bast
 */
public class Case {//déclaration de la classe Case
    private String res;//chaine de caractère comprenant un chiffre et un symbole
    private boolean ok;//boolean permettant de savoir si la case est cachée ou pas
    private int mode;//mode de jeu attribuer au jeu
    
    public Case(String res){//constructeur avec en parametre une chaine de caractere
        this.res = res;//attribut res prend la chaine de caractere
    }
    
    public Case(int mode){//constructeur avec un mode de jeu en parametre
        this.mode = mode;//mode prend la valeur du parametre
        if(this.mode==1 || this.mode==2){//si le mode sélectionné est 1
            int aleat = (int)(Math.random()*(10-1)+1);//nombre aléatoire entre 1 & 10
            String num =""+aleat;//String num se vois ajouter le chiffre aléatoirement choisit
            Indice indice = new Indice(this.mode);//nouvelle instance de indice avec le mode en parametre
            this.res = num+indice.toString();//on ajouter à l'attribut res, num et la chaine de caracetre renvoyé par la fonction toString()
            this.ok = false;//on initialise cette case à false (donc pas découverte)
        }
    }
    
    public Case(ArrayList<String> lsc){//constructeur de Case avec une ArrayList en parametre
        int nbchar = lsc.size();//nbchar prend en parametre la longueur de la ArrayList
        int caract = (int)(Math.random()*nbchar);//nombre aleatoire entre 0 et nbchar
        String c = lsc.get(caract);//on récupére le signe enregisté dans la ArrayList avec la valeur aléatoirement tirée
        int aleat = (int)(Math.random()*(10-1)+1);////nombre aléatoire entre 1 & 10
        this.res = ""+aleat+c;//on ajoute l'attribut aleat et le signe de c dans res
        
    }
    
    public String toString(){//méthode pour récupérer la chaine de caractere res
        return this.res;
    }
    
    public boolean getOk(){//methode pour récupérer le boolean ok pour savoir si la case est découverte ou pas
        return this.ok;
    }
    
    public void setOk(){//methode pour affecter une valeur au boolean ok
        this.ok = true;
    }
}
