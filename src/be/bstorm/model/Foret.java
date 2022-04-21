package be.bstorm.model;

import java.util.Scanner;

public class Foret {

    private final Heros heros;

    /*
        Attributes
     */
    private final De deMonstre;
    Scanner sc = new Scanner(System.in);
    private String nom;
    private Monstre monstre;
    private boolean gameOver;
    private int nbCombatsGagnes;

    /*
        Constructeur
     */

    public Foret(String nom, Heros heros) {
        this.nom = nom;
        this.heros = heros;

        deMonstre = new De(3);
        nbCombatsGagnes = 0;
    }

    /*
        Accesseurs & Mutateurs
     */

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Heros getHeros() {
        return heros;
    }

    public Monstre getMonstre() {
        return monstre;
    }

    public void setMonstre(Monstre monstre) {
        this.monstre = monstre;
    }

    public De getDeMonstre() {
        return deMonstre;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public int getNbCombatsGagnes() {
        return nbCombatsGagnes;
    }

    public void setNbCombatsGagnes(int nbCombatsGagnes) {
        this.nbCombatsGagnes = nbCombatsGagnes;
    }

    /*
        Méthodes
     */

    public void lancer() {
        monstre = this.genererMonstre();
        boolean tourPersonnage = true;

        while (!gameOver) {
            if (tourPersonnage) heros.frapper(monstre);
            else monstre.frapper(heros);

            if (heros.getPv() <= 0) personnageMeurt(heros);
            if (monstre.getPv() <= 0) personnageMeurt(monstre);

            tourPersonnage = !tourPersonnage;

            /*
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            */

        }
    }

    private void personnageMeurt(Personnage p) {
        if (p instanceof Heros) {
            gameOver = true;

            System.out.println("\n" + p.getClass().getSimpleName() + " est mort.");
            System.out.println("Le heros a gagne " + nbCombatsGagnes + " combat" + (nbCombatsGagnes > 1 ? "s" : "") + ".");
            System.out.println("Le heros a accumule " + ((Heros) p).getOr() + " or" + (((Heros) p).getOr() > 1 ? "s" : "") + ".");
            System.out.println("Le heros a accumule " + ((Heros) p).getCuir() + " cuir" + (((Heros) p).getCuir() > 1 ? "s" : "") + ".");
        } else {
            nbCombatsGagnes++;
            System.out.println("\n" + p.getClass().getSimpleName() + " est mort.");
            heros.seReposer();
            heros.depouiller((Monstre) p);
            System.out.println("Lancer le prochain combat...");
            // sc.nextLine();

            monstre = genererMonstre();
        }
    }

    private Monstre genererMonstre() {
        Monstre m = switch (deMonstre.lance()) {
            case 1 -> new Loup();
            case 2 -> new Orque();
            case 3 -> new Dragonnet();
            default -> null;
        };

        System.out.println("Nous rencontrons un monstre : ");
        System.out.println(m);

        return m;
    }
}
