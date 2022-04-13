package be.bstorm.main;

import be.bstorm.model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice = "";

        System.out.println("~~ Heroes vs Monsters ~~");

        /*
         * Création du personnage
         */

        System.out.println("Sélection de la classe :");

        while (!(choice.equals("1") || choice.equals("2"))) {
            System.out.println("1. Humain\n2. Nain");
            System.out.print("Choix : ");
            choice = sc.nextLine();
            if (!(choice.equals("1") || choice.equals("2"))) System.out.println("Erreur.");
        }

        Heros heros = (choice.equals("1")) ? new Humain() : new Nain();

        System.out.println(heros);

        /*
            Création de la forêt
         */

        Foret shorewood = new Foret("Shorewood", heros);
        shorewood.lancer();

        System.out.println("~~ Fin de partie ~~");

    }
}
