/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_info2a_test2;

/**
 *
 * @author bast
 */
public class Joueur {//déclaration de la classe joueur
    private String Pseudo;//attribut Pseudo de type Chaine de caractere
    private int Solde;//attribut Solde de type entier
    
    public Joueur(){//constructeur par défaut de Joueur
        this.Pseudo = "";//Pseudo initialiser à ""
        this.Solde = 0;//Solde initialiser à 0
    }
    
    public String getPseudo(){//retourne le pseudo d'un joueur
        return this.Pseudo;
    }
    
    public void setPseudo(String pseudo){//permet de fixer un pseudo à un joueur
        this.Pseudo = pseudo;
    }
    
    public void setScore(int solde){//permet de fixer un solde à un joueur
        this.Solde = solde;
    }
    
    public int getScore(){//permet de récupérer le solde d'un joueur
        return this.Solde;
    }
}
