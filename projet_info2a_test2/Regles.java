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
public class Regles {//déclaration de la classe Regles avec un attribut txt initialiser à null
    private String txt="";
    
    public Regles(){//constructeur de Regles avec l'appel d'une méthode pour initialiser res
        initRegles();
    }
    
    public void initRegles(){//méthodes permettant d'ajouter des chaines de caractères à txt pour former les règles du jeu
        this.txt ="                                  Les Règles                                         \n";
        this.txt+="- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n";
        this.txt+="                                     ****                                            \n";
        this.txt+="\n";
        this.txt+="           Le but du jeu va etre de deviner toutes les cases cachées.                \n";
        this.txt+="               Pour se faire, trois modes sont à votre dispositions.                 \n";
        this.txt+="             Le premier mode peut se jouer à un ou plusieurs joueurs.                \n";
        this.txt+="           Le deuxième mode peut se jouer avec un minimum de 2 joueurs.              \n";
        this.txt+="  Le troisième mode est 100% customisable, avec les parametres que vous voulez       \n";
        this.txt+="Pour chaque mode vous disposerez d'indices pour vous permettres de trouver les cases \n";
        this.txt+="       Les scores sont ajoutés en fonctions des cases que vous avez trouvées         \n";
        this.txt+="\n";
        this.txt+="                                     ****                                            \n";
        this.txt+="\n";
        this.txt+="   Mode 1 : Vous disposez de 12 cases à trouver, les cases ne sont pas afficher tant \n";
        this.txt+=" que celles-ci ne sont pas découvertes. Si un joueur fait une proposition et se trom-\n";
        this.txt+=" -pe, ça sera au joueur suivant de chercher. La partie se termine lorsque l'ensemble \n";
        this.txt+=" des cartes sont trouvés. Vous disposerez des signe suivant 'x' et '+'. Les Indices -\n";
        this.txt+="  qui vous seront donnés seront calculer en fonction des case que vous avez sélecti- \n";
        this.txt+="                                   -onners                                           \n";
        this.txt+="\n";
        this.txt+="                                     ****                                            \n";
        this.txt+="\n";
        this.txt+="   Mode 2 : Vous disposez de 24 cases à trouver, les cases ne sont pas afficher tant \n";
        this.txt+=" que celles-ci ne sont pas découvertes. Si un joueur fait une proposition et se trom-\n";
        this.txt+=" -pe, ça sera au joueur suivant de chercher. La partie se termine lorsque l'ensemble \n";
        this.txt+="des cartes sont trouvés. Vous disposerez des signe suivant 'x', '+', '<', '>', et '-'\n";
        this.txt+="             Les Indices qui vous seront donnés seront calculer en                   \n";
        this.txt+="                  fonction des case que vous avez sélectionners                      \n";
        this.txt+="\n";
        this.txt+="                                     ****                                            \n";
        this.txt+="\n";
        this.txt+="   Mode 3 : Tout dépend de vous ! Vous disposez d'une collection de signes que vous  \n";
        this.txt+="pouvez ajouter en fonction de vos envies! Vous avez aussi la possibilité de choisir  \n";
        this.txt+="          le nombre de ligne et le nombre de colonne de votre jeu!                   \n";
        this.txt+="\n";
        this.txt+="                                     ****                                            \n";
        this.txt+="\n";
        this.txt+="          Mode 4 : Tout dépend de vous ! Vous choisissez le nombre de Cases          \n";
        this.txt+=" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - \n";
    }
    
    public String toString(){
        return this.txt;
    }
}
