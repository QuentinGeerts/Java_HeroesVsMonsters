package be.bstorm.model;

import be.bstorm.interfaces.ICuir;
import be.bstorm.interfaces.IOr;

public class Heros extends Personnage {

    private int or;
    private int cuir;

    /*
        Accesseurs & Mutateurs
     */

    public int getOr() {
        return or;
    }

    public void setOr(int or) {
        this.or = or;
    }

    public int getCuir() {
        return cuir;
    }

    public void setCuir(int cuir) {
        this.cuir = cuir;
    }

    /*
        Méthodes
     */

    public void seReposer() {
        resetPv();
    }

    public void depouiller(Monstre monstre) {

        if (monstre instanceof IOr) {
            System.out.println("[Dépouille] " + ((IOr) monstre).getOr() + " or" + (((IOr) monstre).getOr() > 1 ? "s" : ""));
            this.setOr(getOr() + ((IOr) monstre).getOr());
        }

        if (monstre instanceof ICuir) {
            System.out.println("[Dépouille] " + ((ICuir) monstre).getCuir() + " cuir" + (((ICuir) monstre).getCuir() > 1 ? "s" : ""));
            this.setCuir(getCuir() + ((ICuir) monstre).getCuir());
        }

    }
}
