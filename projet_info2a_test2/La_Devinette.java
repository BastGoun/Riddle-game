/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_info2a_test2;
import java.util.ArrayList;
/**
 *
 * @author bast
 */
public class La_Devinette {
    public static void main(String[] args) {
        ArrayList<Joueur> lst= new ArrayList<Joueur>();//ArayList des joueurs
        int joueurcourant=0;//indice du joueur courant
        int mode;//mode de jeu
        char choix;//choix entre o/n
        int joueur = 0;//initialisation de joueur à 0
        
        //affichage du titre du jeu
        System.out.print(getBleuTurquoise());//affichage avec une couleur particulière
        System.out.println(" __      __      ____  ____  _  _  ____  _  _  ____  ____  ____  ____ ");
        System.out.print(getBleuTurquoise());
        System.out.println("(  )    /__\\    (  _ \\( ___)( \\/ )(_  _)( \\( )( ___)(_  _)(_  _)( ___)");
        System.out.print(getBleuTurquoise());
        System.out.println(" )(__  /(__)\\    )(_) ))__)  \\  /  _)(_  )  (  )__)   )(    )(   )__) ");
        System.out.print(getBleuTurquoise());
        System.out.println("(____)(__)(__)  (____/(____)  \\/  (____)(_)\\_)(____) (__)  (__) (____)");
        System.out.print(getBleuTurquoise());
        System.out.println("                               - Le Jeu-                                ");
        System.out.println();
        
        System.out.println(getVert());//lorsqu'un joueur va rentrer des infoamtions, celles-ci seront vertes pour avoir un belle affichage
        System.out.println("Voulez vous voir les règles?(o/n)");
        char regles = Lire.c();
        if(regles=='o'){//affichage sur la console des règles
            Regles regle = new Regles();//nouvelle instance de regle
            System.out.println(regle.toString());//affichage avec la méthode toString() des regles
            System.out.println();
        }
        System.out.println("Choisissez le mode que vous voulez?(1/2/3/4)");
        mode = Lire.i();//choix du mode de jeu
        Plateau pc = new Plateau(mode);//initialisation du plateau en fonction des choix
        System.out.println("--- --- --- --- --- --- ---");
        do{
            do{
                System.out.println("Voulez vous rentrer un nouveau joueur?(o/n)");
                choix = Lire.c();//choix oui ou non
                if(choix=='o'){
                    Joueur j = new Joueur();//instanciation d'un nouveau joueur
                    System.out.print("Rentrer le pseudo du joueur à ajouter : ");
                    String nom = Lire.S();
                    if(nom.equals("konami")){//Easter-Egg qui va permettre d'avoir un personnage particulier
                        System.out.println(getViolet());//Couleur des entrées devient violet
                        System.out.println("Vous venez de découvrir l'Easter-Egg");  
                    }
                    j.setPseudo(nom);//le joueur se voit accorder nom en pseudo            
                    lst.add(j);//ajout du joueur à la ArrayList des joueurs
                    System.out.println();//saut de ligne
                    joueur++;//joueur augmente de 1
                }
                else if(joueur==0 && choix=='n'){//si joueur est à 0 et choix 'n' est choisit il n'est pas possible 
                    System.out.print(getBleuTurquoise());//affichage du message en bleu turquoise
                    System.out.println("Vous devez rentrer un minimum de 1 joueur pour jouer !");
                    System.out.print(getVert());
                }
                for(int i =0;i<lst.size();i++){//affichage des joueurs déjà présent dans la partie
                    System.out.println("Joueur n°"+(i+1)+": "+lst.get(i).getPseudo());
                }
                System.out.println();//saut de ligne
            }
            while(choix == 'o' || choix=='n' && joueur<1);//tant que le mode est choisit mais que il n'y aucun joueur
            if(lst.size()<2 && mode==2){//tant le deuxieme mode est choisit mais qu'il y moins de 2 joueurs
                System.out.print(getBleuTurquoise());//demande au joueur de rentrer d'autre joueurs
                System.out.println("Impossible de jouer au deuxième mode sans un minimum de deux joueurs");
            }
        }while(mode==2 && lst.size()<2);
        //si toutes les conditions liées aux joueurs sont remplies
        System.out.println("----- ---- --- -- - -- --- ---- -----");
        System.out.println();
        System.out.println(lst.get(joueurcourant).getPseudo()+" à toi de jouer!");//affcihage d'un message pour le joueur courant
        System.out.println();
        
        do{
            pc.Gagne();//test du jeu si toutes les cases sont découvertes ou pas
            if(pc.getGagne()==false){//si toutes las cases ne sont pas trouvées
                System.out.println("Voulez vous faire des hypothèse?(o/n)");
                int choix2 = Lire.c();//choix de pouvoir faire des hypotheses
                if(choix2=='o'){
                    pc.Validation(mode);//si oui appel de la métode validation avec en parametre le mode de jeu
                    lst.get(joueurcourant).setScore(lst.get(joueurcourant).getScore()+pc.AjoutScore());//ajout de la récompense au solde du joueur
                    pc.RScore();//La récompense revient à 0
                    System.out.println("Score "+lst.get(joueurcourant).getPseudo()+":"+lst.get(joueurcourant).getScore());//affichage du score du joueur courant
                    
                    joueurcourant++;//joueur suivant !
                    if(joueurcourant>=lst.size()){//si le dernier joueur de la liste à jouer, on retourne au premier
                        joueurcourant=0;
                    }
                }
                else if(choix2=='n'){//si le choix de l'hypothese est non
                    System.out.println("Le joueur passe son tour !");
                    joueurcourant++;//le joueur décide de passer son tour
                    if(joueurcourant>=lst.size()){
                        joueurcourant=0;
                    }
                }
            }
            pc.Gagne();//test si le jeu est gagné ou pas
            if(pc.getGagne()!=true){//si il n'est pas gagné
                System.out.println();
                System.out.println("----- ---- --- -- - -- --- ---- -----");
                System.out.println(lst.get(joueurcourant).getPseudo()+" à toi de jouer!");//affcihage d'un message pour que le joueur suivant joue 
                System.out.println();
            }
        }while(pc.getGagne()!=true);//tant que le jeu n'est pas gagné
        
        System.out.print(getVert());//affichage du message jeu terminé
        System.out.println("\n-- -- -- -- -- --! - - Fin du jeu - - !-- -- -- -- -- --\n");
        Joueur best = lst.get(0);//le meilleur joueur est le premier joueur de base
        for(int i=0;i<lst.size()-1;i++){//recherche du joueur qui à le score le plus important
            if(lst.get(i).getScore()<lst.get(i+1).getScore())//si le joueur d'apres a plus de score
                best = lst.get(i+1);//le meilleur joueur est le joueur suivant
        }
        System.out.println("La Devinette était: ");
        System.out.println(pc.toString());//affichage de la solution de la devinette
        
        System.out.print(getBleuTurquoise());
        System.out.println("Le gagnant est "+best.getPseudo()+", félicitations à toi!");//affcihage du pseudo du gagnant
        for(int i=0;i<lst.size();i++){
            System.out.println("Score de "+lst.get(i).getPseudo()+":"+lst.get(i).getScore());//affichage du tableau des scores
        }
        System.out.println();
        System.out.println("All Rights Reserved - TM ® & COPYRIGHT © 2020-2021 ");//affichage seulement esthétique
    }
    
    //Partie esthétique
    public static String getVert() {//seulement de l'hestéthique pour donner de la couleur à la console
      return "\033[32m";
    }
    
    public static String getBleuTurquoise() {//seulement de l'hestéthique pour donner de la couleur à la console
        return "\033[36m";
    }
    
    public static String getViolet(){//seulement de l'hestétique pour donner de la couleur à la console lors d'un easter-egg
        return "\033[1;35m";
    }
}
