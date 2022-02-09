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
public class Indice{//déclaration de la classe Indice
    private String indice="";//attribut indice déclaré à ""
    
    
    public Indice(int mode){//constructeur de Indice avec en parametre un mode de jeu
        if(mode==1){//si le mode de jeu est 1
        int aleat = (int)(Math.random()*2);//nombre aléatoire entre 0 et 1 stocké dans aleat
            if(0==aleat){//si aleat=0
                this.indice = "+";//l'indice est donc +
            }
            if(1==aleat){//si aleat=1
                this.indice ="x";//l'indice est donc x
            }
            
        }
        else if(mode==2){//si le mode de jeu est 2
            int aleat2 = (int)(Math.random()*5);//nombre aléatoire entre 0 et 5 stocké dans aleat2
            if(0==aleat2){//si aleat2=0
                this.indice = "+";//l'indice est donc +
            }
            if(1==aleat2){//si aleat2=1
                this.indice ="x";//l'indice est donc x
            }
            if(2==aleat2){//si aleat2=2
                this.indice = "-";//l'indice est donc -
            }
            if(3==aleat2){//si aleat2=3
                this.indice = ">";//l'indice est donc >
            }
            if(4==aleat2){//si aleat2=4
                this.indice = "<";//l'indice est donc <
            }
        }
    }
    
    public String toString(){//retourne l'indice qui à été affecter à indice
        return this.indice;
    }
}
