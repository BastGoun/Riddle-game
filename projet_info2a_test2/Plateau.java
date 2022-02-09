/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_info2a_test2;
import java.util.ArrayList;
//classe mère
/**
 *
 * @author bast
 */
public class Plateau{
    private int mode; //1 pour le mode avec un plateau de (3,4) et 2 pour le mode avec plateau de (4,6) et le mode 3 pour un plateau de (n,m)
    private int y; //valeur max du nombre de lignes
    private int x; //valeur max du nombre de colonne
    private int indice; //valeur de l'indice 1
    private Case[][] Case; //tableau contenant des Cases
    private int recompense = 0; //entier qui va permettre d'avoir une récompense (point)
    private boolean gagne = true;//boolean gagne qui passe à true si toutes les cases sont découvertes
    private ArrayList<String> listchar = new ArrayList<String>();//ArrayList de la chaine de caractères
    
    public Plateau(int mode){//constructeur de Plateau avec en parametre un mode de jeu(entier)
        this.mode = mode;//mode de jeu est associer à l'attribut mode
        if(this.mode==1){//si le mode est 1
            this.y = 3;//nombre de ligne  = 3
            this.x = 4;//nombre de colonne  = 4
            this.Case = new Case[this.y][this.x];//nouveau tableau de Case initialiser à x,y
                for(int a=0; a<y;a++){//initialisation du tableau avec le nombre de ligne et le nombre de colonne
                    for(int b=0; b<x; b++){
                    Case[a][b] = new Case(this.mode);//création d'un nouvelle instance de Case pour chaque case du tableau avec le mode de jeu en parametre
                    }
                } 
        }
        
        else if(this.mode==2){//si le mode de jeu est 2
            this.y = 4;//nombre de ligne = 4
            this.x = 6;//nombre de colonne  = 6
            this.Case = new Case[this.y][this.x];//nouveau tableau de Case initialiser à x,y
            for(int a=0; a<y;a++){//initialisation du tableau avec le nombre de ligne et le nombre de colonne
                for(int b=0; b<x; b++){
                    Case[a][b] = new Case(this.mode);//création d'un nouvelle instance de Case pour chaque case du tableau avec le mode de jeu en parametre
                }
            } 
        }
        else if(this.mode==3){//si le mode de jeu est 3
            System.out.println("Indices disponibles : 'x','+','-','>','<'");//affichage des indices disponibles
            System.out.println("Rentrer l'indice que vous voulez :");
            String carac = ""+Lire.c();//carac prend la valeur de l'indice choisit
            listchar.add(carac);//ajout de carac à la liste des caracteres
            System.out.println("Rentrer un autre indice ?(o/n)");
            char c = Lire.c();//choix de rentrer un nouvel indice (o/n)
            do{//tant que le joueur choisit oui, il va pouvoir choisir un nouvel indice à ajouter à la liste
                if(c=='o'){
                    System.out.println("Indices disponibles : 'x','+','-','>','<'");
                    carac = ""+Lire.c();
                    listchar.add(carac);
                    System.out.println("Rentrer un autre indice ?(o/n)");
                    c = Lire.c();
                }
            }while(c=='o');//fin du tant que lorsque le joueur entre 'n'
            System.out.println("Rentrer le nombre de lignes : ");
            this.y = Lire.i();//le nombre de ligne est choisit par le joueur
            System.out.println("Rentrer le nombre de colonnes : ");
            this.x = Lire.i();//le nombre de colonne est choist par le joueur
            this.Case = new Case[this.y][this.x];//création d'un nouveau tableau de Case avec x et y
            for(int a=0; a<y;a++){
                for(int b=0; b<x; b++){
                    Case[a][b] = new Case(this.listchar);//chaque case dispose d'une instance de Case avec en parametre la ArrayList listchar
                }
            }
        }
        else if(mode==4){//si le mode de jeu est 4
            int nbCase=0;//nombre de case initialisé à 0
            System.out.print("Rentrer le nombre de Cases de votre plateau: ");
            nbCase = Lire.i();//choix du nombre de case
            do{
                if(nbCase%2!=0){//si ce n'est pas paire
                    System.out.println("Rentrer un nombre paire obligatoirement");
                    System.out.print("Rentrer le nombre de Cases de votre plateau: ");
                    nbCase = Lire.i();
                }
            }while(nbCase%2!=0);//si il est paire
            
            if(nbCase==10){//ne marche pas avec 10
                this.x = 5;//5 pour le nombre de colonne
                this.y = 2;//2 pour le nombre de ligne
            }
            else{
                this.y = (int)Math.abs(Math.sqrt(nbCase));//on calcul le nombre de ligne
                this.x = nbCase/this.y;//on calcul le nombre de colonne
            }
            this.Case = new Case[this.y][this.x];//création d'un nouveau tableau de Case avec x et y
            for(int a=0; a<y;a++){
                for(int b=0; b<x; b++){
                    Case[a][b] = new Case(1);//chaque case dispose d'une instance de Case avec en parametre le mode 1
                }
            }
        }
        else{
            System.out.println("Le mode de jeu n'est pas disponible, retour au démarage");
            System.exit(0);//si le joueur ne rentre pas un mode valide, fin de l'exécution du jeu
        }
    }
    
    public void getIndice(int y1, int x1, int y2, int x2){//récpérer les deux indices par avec les cases que le joueur à renter
        char c = Case[y1][x1].toString().charAt(1);//récupère l'indice de la premiere case
        switch(c){//comparasion de cet indice avec plusieurs type de caractère
            case 'x':{//si il s'agit d'une multiplication
                char indc1 = Case[y1][x1].toString().charAt(0);//on récupère le caractere qui est un chiffre de la premire case
                int ind1 = indc1-48;//on convertit ce caractere en entier

                char indc2 = Case[y2][x2].toString().charAt(0);//on récupère le caractere qui est un chiffre de la deuxieme case
                int ind2 = indc2-48;//on convertit ce caractere en entier
                
                this.indice = ind1*ind2;//l'indice est donc le produit des deux cases
                        
            break;}
            
            case '+':{
                char indc1 = Case[y1][x1].toString().charAt(0);//on récupère le caractere qui est un chiffre de la premire case
                int ind1 = indc1-48;//on convertit ce caractere en entier

                char indc2 = Case[y2][x2].toString().charAt(0);
                int ind2 = indc2-48;//on convertit ce caractere en entier
                
                this.indice = ind1+ind2;//l'indice est donc la somme des deux cases
            break;}
            
            case '-':{
                char indc1 = Case[y1][x1].toString().charAt(0);//on récupère le caractere qui est un chiffre de la premire case
                int ind1 = indc1-48;//on convertit ce caractere en entier

                char indc2 = Case[y2][x2].toString().charAt(0);
                int ind2 = indc2-48;//on convertit ce caractere en entier
                
                this.indice = ind1-ind2;//l'indice est donc la différence entre les deux cases
                        
            break;}
            
            case '>':{
                char indc1 = Case[y1][x1].toString().charAt(0);//on récupère le caractere qui est un chiffre de la premire case
                int ind1 = indc1-48;//on convertit ce caractere en entier

                char indc2 = Case[y2][x2].toString().charAt(0);
                int ind2 = indc2-48;//on convertit ce caractere en entier
                
                this.indice = Math.max(ind1,ind2);//l'indice est donc le maximum des deux cases
                        
            break;}
            
            case '<':{
                char indc1 = Case[y1][x1].toString().charAt(0);//on récupère le caractere qui est un chiffre de la premire case
                int ind1 = indc1-48;//on convertit ce caractere en entier

                char indc2 = Case[y2][x2].toString().charAt(0);
                int ind2 = indc2-48;//on convertit ce caractere en entier
                
                this.indice = Math.min(ind1,ind2);//l'indice est donc le minimum des deux cases
                        
            break;}
        }
    }
    
    public void Validation(int mode){ //En fonction du modèle, des indices vont etre révélés et le joueur va pouvoir faire des choix
        int col1=0, lig1=0;//initialisation de col1 et lig1 à 0
        int col2=0, lig2=0;//initialisation de col2 et lig2 à 0
        int choix1=0, choix2=0;//choix initialiser à 0
        int indice1, indice2;//indices des cases
        
        if(mode==1){//si le mode 1 est choisit, construction du tableau avec l'ensemble des cases
                for(int a=0; a<y;a++){
                    for(int b=0; b<x; b++){
                        if(Case[a][b].getOk()==false)//si la case n'est pas découverte
                            System.out.print("## ");//on affiche seulement 
                        else if(Case[a][b].getOk()==true)//si la case est découverte
                            System.out.print(Case[a][b].toString()+" ");//on affiche le contenu de la case avec la méthode toString()
                        }
                    System.out.println();//on saute une ligne
                } 
                System.out.println();//on saute une deuxieme ligne

            do{//début de la boucle (recherche des coordonnées de la premiere case
                System.out.println("Choix de la première case : ");
                System.out.print("Numéro de ligne entre 1 et 3 : ");
                int val1 = Lire.i();//on rentre la valeur de la premiere ligne
                System.out.println();
                System.out.print("Numéro de colonne entre 1 et 4 :");
                int val2 = Lire.i();//on rentre la valeur de la colonne
                System.out.println();
                if(val1<1 || val1>3 || val2<1 ||val2>4){//si la valeur de la colonne ou la valeur de la ligne ne rentre pas dans les critères demandés
                    System.out.println("Valeur hors limites; recommencez");//affichage d'un message d'erreur
                }
                else{
                    lig1 = val1;//sinon les valeurs sont accordées
                    col1 = val2;
                }
            }while(lig1<1 || lig1>3 || col1<1 || col1>4);//lorsque les valeurs rentées sont corrects, fin de la boucle
            System.out.println();
            do{//même systeme que auparavant sauf qu'ici nous renrons les coodronnées de la deuxieme case
                System.out.println("Choix de la deuxième case:");
                System.out.print("Numéro de ligne entre 1 et 3 : ");
                int val1 = Lire.i();//choix de la ligne de la deuxieme case
                System.out.println();
                System.out.print("Numéro de colonne entre 1 et 4 : ");
                int val2 = Lire.i();//choix de la colonne de la deuxieme case
                System.out.println();
                if(val1<1 || val1>3 || val2<1 || val2>4){//si les valeurs rentrées ne sont pas dans les clous
                    System.out.println("Valeur hors limites; recommencez");//affichage message d'erreur
                }
                else{
                    lig2 = val1;//sinon affectation des valeurs corrects pour trouver les Indices
                    col2 = val2;
                }
            }while(lig2<1 || lig2>3 || col2<1 || col2>4);//on sort de la boucle quand les valeurs rentrées sont corrects
        }
        
        if(mode==2){//pour le mode numéro deux, il s'agit du meme principe que pour le prmier mode
                    //hors ici, nous avons un tableau plus grand et que les cases sont à moitierr découvertes
                    //donc l'indice est apparant mais les chiffre sont toujours dissimulés
            for(int a=0; a<y;a++){
                    for(int b=0; b<x; b++){
                        if(Case[a][b].getOk()==false)
                            System.out.print("#"+Case[a][b].toString().charAt(1)+" ");//si la case n'est pas découverte, on affiche que le deuxieme caractere de la chaine de caracetre des Case
                        else if(Case[a][b].getOk()==true)
                            System.out.print(Case[a][b].toString()+" ");//si elle est découverte, on affiche l'intégralité de Case avec la méthode toString()
                        }
                    System.out.println();
                } 
                System.out.println();
            do{
                //meme systeme que pour le premier mode, on choisit les coordonnées des cases que nous voulons découvrir
                System.out.println("Choix de la première case:");
                System.out.print("Numéro de ligne entre 1 et 4 : ");
                int val1 = Lire.i();
                System.out.println();
                System.out.print("Numéro de colonne entre 1 et 6 : ");
                int val2 = Lire.i();
                System.out.println();
                if(val1<1 || val1>4 || val2<1 || val2>6){
                    System.out.println("Valeur hors limites; recommencez");
                }
                else{
                    lig1 = val1;//sinon affectation des valeurs corrects pour trouver les Indices
                    col1 = val2;
                }
                System.out.println();
            }while(lig1<1 || lig1>4 || col1<1 || col1>6);
            System.out.println();
            do{
                System.out.println("Choix de la deuxième case:");
                System.out.print("Numéro de ligne entre 1 et 4 : ");
                int val3 = Lire.i();
                System.out.println();
                System.out.print("Numéro de colonne entre 1 et 6 : ");
                int val4 = Lire.i();
                System.out.println();
                if(val3<1 || val3>4 || val4<1 || val4>4){
                    System.out.println("Valeur hors limites; recommencez");
                }
                else{
                    lig2 = val3;//sinon affectation des valeurs corrects pour trouver les Indices
                    col2 = val4;
                }
            }while(lig2<1 || lig2>4 || col2<1 || col2>6);
            System.out.println();
        }
        //fin du mode numéro deux qui est du meme principe que le mode numéro 1(détaillé en haut)
        if(mode==3){//si le mode choisit est le mode numéro 3
                    //aucune différence par rapport au mode numéro 1 mise à part l'instanciation des cases quyi n'est pas la meme
                    //et le tableau va etre de dimension variable en fonction des parametres que les joueurs auront initialiser au début
                for(int a=0; a<y;a++){
                    for(int b=0; b<x; b++){
                        if(Case[a][b].getOk()==false)
                            System.out.print("## ");
                        else if(Case[a][b].getOk()==true)
                            System.out.print(Case[a][b].toString()+" ");//les Cases sont totalement couvertes, les signes ne sont pas disponibles
                        }
                    System.out.println();
                } 
                System.out.println();

            do{
                System.out.println("Choix de la première case :");
                System.out.print("Numéro de ligne entre 1 et "+this.y+" : ");//choix d'un chiffre entre 1 et le nombre de ligne max
                int val1 = Lire.i();
                System.out.println();
                System.out.print("Numéro de colonne entre 1 et "+this.x+" : ");//choix entre 1 et le nombre de colonnes max
                int val2 = Lire.i();
                System.out.println();
                if(val1<1 || val1>this.y || val2<1 ||val2>this.x){
                    System.out.println("Valeur hors limites; recommencez");
                }
                else{
                    lig1 = val1;
                    col1 = val2;
                }
            }while(lig1<1 || lig1>this.y || col1<1 || col1>this.x);
            System.out.println();
            do{
                System.out.println("Choix de la deuxième case:");
                System.out.print("Numéro de ligne entre 1 et "+this.y+" : ");
                int val1 = Lire.i();
                System.out.println();
                System.out.print("Numéro de colonne entre 1 et "+this.x+" : ");
                int val2 = Lire.i();
                System.out.println();
                if(val1<1 || val1>this.y || val2<1 || val2>this.x){
                    System.out.println("Valeur hors limites; recommencez");
                }
                else{
                    lig2 = val1;
                    col2 = val2;
                }
            }while(lig2<1 || lig2>this.y || col2<1 || col2>this.x);   
        }//fin du mode numéro 3
        
        if(mode==4){//si le mode choisit est le mode numéro 3
                    //aucune différence par rapport au mode numéro 1 mise à part l'instanciation des cases quyi n'est pas la meme
                    //et le tableau va etre de dimension variable en fonction des parametres que les joueurs auront initialiser au début
                for(int a=0; a<y;a++){
                    for(int b=0; b<x; b++){
                        if(Case[a][b].getOk()==false)
                            System.out.print("## ");
                        else if(Case[a][b].getOk()==true)
                            System.out.print(Case[a][b].toString()+" ");//les Cases sont totalement couvertes, les signes ne sont pas disponibles
                        }
                    System.out.println();
                } 
                System.out.println();

            do{
                System.out.println("Choix de la première case :");
                System.out.print("Numéro de ligne entre 1 et "+this.y+" : ");//choix d'un chiffre entre 1 et le nombre de ligne max
                int val1 = Lire.i();
                System.out.println();
                System.out.print("Numéro de colonne entre 1 et "+this.x+" : ");//choix entre 1 et le nombre de colonnes max
                int val2 = Lire.i();
                System.out.println();
                if(val1<1 || val1>this.y || val2<1 ||val2>this.x){
                    System.out.println("Valeur hors limites; recommencez");
                }
                else{
                    lig1 = val1;
                    col1 = val2;
                }
            }while(lig1<1 || lig1>this.y || col1<1 || col1>this.x);
            System.out.println();
            do{
                System.out.println("Choix de la deuxième case:");
                System.out.print("Numéro de ligne entre 1 et "+this.y+" : ");
                int val1 = Lire.i();
                System.out.println();
                System.out.print("Numéro de colonne entre 1 et "+this.x+" : ");
                int val2 = Lire.i();
                System.out.println();
                if(val1<1 || val1>this.y || val2<1 || val2>this.x){
                    System.out.println("Valeur hors limites; recommencez");
                }
                else{
                    lig2 = val1;
                    col2 = val2;
                }
            }while(lig2<1 || lig2>this.y || col2<1 || col2>this.x);   
        }//fin du mode 4
        
        lig1 = lig1-1;//on diminue de 1 chaques valeurs car car les tableaux sont initialiser à 0
        col1 = col1-1;//donc nous sommes obligés d'avoir des valeurs diminuer de 1 sinon la valeur ne pourront pas etre placés dans le tableau
        
        lig2 = lig2-1;//meme chose que pour les coordonnées de la deuxieme case, on est obligé d'enlever 1
        col2 = col2-1;//(un choix entre 0 et le nombre de maximum de ligne ou de colonne n'aurait pas été tres esthetique (et comprehensible) pour le joueur
        
        if(Case[lig1][col1].getOk()==true||Case[lig2][col2].getOk()==true){
            System.out.println("L'une des deux cases à déja été trouver! Joueur suivant!");
        }//si le joueur rentre maloncontreusement les coordonnées d'une carte qui est déja trouver, le joueur se voit son tour passer
        else{
            getIndice(lig1,col1,lig2,col2);//on appel la méthode getIndice() pour pouvoir trouver l'indice 1 entre Case1 et Case2
                indice1 = this.indice;//l'attribut indice donne à indice 1 sa valeur
                System.out.println("Indice première case :"+indice1);//affichage du premier indice
            getIndice(lig2,col2,lig1,col1);//on appel la méthode getIndice() pour pouvoir trouver l'indice 1 entre Case2 et Case1
                indice2 = this.indice;//l'attribut indice donne à indice 2 sa valeur
                System.out.println("Indice deuxième case :"+indice2);//affichage du deuxieme indice
        
            System.out.println("Renter vos hypothèses: ");//le joueur va pouvoir rentrer ses hypotheses
            System.out.println();
            System.out.print("Hypothèse numéro 1 :");choix1=Lire.i();//choix1 recupere l'hypothese pour la case 1
            System.out.print("Hypothèse numéro 2 :");choix2=Lire.i();//choix2 recupere l'hypothese pour la case 2
            System.out.println();
        
            char res1 = Case[lig1][col1].toString().charAt(0);//on récupere la valeur de la premier case (le chiffre) qui est un caractere
            int resu1 = res1 - 48;//le caractere est transformer en entier(voir code ASCII)
        
            char res2 = Case[lig2][col2].toString().charAt(0);//on récupere la valeur de la deuxieme case (le chiffre) qui est un caractere
            int resu2 = res2 - 48;//le caractere est transformer en entier(voir code ASCII)
        
            if(choix1==resu1 && choix2==resu2){//si le joueur à trouver les valeurs des cases cachés
                System.out.println("Bravo le contenu des cases ont été trouvé !");
                if(Case[lig1][col1]!=Case[lig2][col2]){//si les cases sont différentes (effectivement le joueur peut décider de rentrer deux fois les coordonnées d'une case)
                    this.recompense = resu1+resu2;//la récompense sera donc la somme des deux cases
                }
                else{
                    this.recompense = resu1;//si le joueur a donc rentrer deux fois la meme case, il se verra donc ajouter que la valeur de la case et non pas deux fois la valeur de la case
                }
                Case[lig1][col1].setOk();//les cases sont donc placées avec le boolean à true donc les cases sont découvertes
                Case[lig2][col2].setOk();
            }
            else if(choix1==resu1 ^ choix2==resu2){//si une seule des cases est trouvée(OU exclusif)
                System.out.println("Au moins l'une des deux hypothèse est fausse");//affichage d'un message
                this.recompense=0;//le joueur ne se voit pas donner une récompense
            }
            else{
                System.out.println("Aucune des valeurs n'est correct");
                this.recompense=0;//si aucune des cases n'est trouvée, affichage d'une message et récompense à 0
            }
        }
    }
    
    
    public int getMode(){//permet de récupérer le mode de jeu
        return this.mode;
    }
    
    
    public boolean getGagne(){//permet de savoir si toutes les cases sont découvertes
        return this.gagne;
    }
    
    public void setGagne(){//l'attribut gagne prend la valeur true
        this.gagne = true;
    }
    
    public void Gagne(){//méthode permettant de savoir si les cases ont été découvertes
        this.gagne=true;//attribut à true
        for(int a=0; a<y;a++){
                for(int b=0; b<x; b++){
                    if(Case[a][b].getOk()==false){
                        this.gagne=false;//si une case au moins n'est pas trouvée, attribut gagne à false
                    }
            }
        } 
    }
    
    public int AjoutScore(){//permet d'ajouter le score à un joueur
        return this.recompense;
    }
    
    public void RScore(){//permet de réinitilaiser le score à 0
        this.recompense = 0;
    }
    
    public String toString(){//permet l'affichage de l'ensemble des cartes qui sont découvertes
        String res="";
        for(int a=0; a<this.y;a++){
            for(int b=0; b<this.x; b++){
                    res+=Case[a][b].toString()+" ";
            }
            res+="\n";
        }
        return res;
    }
}
