package be.bstorm.model;

import be.bstorm.interfaces.IOr;

public class Orque extends Monstre implements IOr {

    /*
        Attributes
     */

    private int or;

    /*
        Constructeurs
     */

    public Orque() {
        or = getDe6().lance();
    }

    /*
        Accesseurs & Mutateurs
     */

    @Override
    public int getForce() {
        return super.getForce() + 1;
    }

    @Override
    public int getOr() {
        return or;
    }

    @Override
    public void setOr(int or) {
        this.or = or;
    }

}
