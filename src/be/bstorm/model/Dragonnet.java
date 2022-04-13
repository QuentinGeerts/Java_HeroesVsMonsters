package be.bstorm.model;

import be.bstorm.interfaces.ICuir;
import be.bstorm.interfaces.IOr;

public class Dragonnet extends Monstre implements IOr, ICuir {

    /*
        Attributes
     */

    private int or;
    private int cuir;

    /*
        Constructeurs
     */

    public Dragonnet() {
        or = getDe6().lance();
        cuir = getDe4().lance();
    }

    /*
        Accesseurs & Mutateurs
     */

    @Override
    public int getEndurance() {
        return super.getEndurance() + 1;
    }

    @Override
    public int getOr() {
        return or;
    }

    @Override
    public void setOr(int or) {
        this.or = or;
    }

    @Override
    public int getCuir() {
        return cuir;
    }

    @Override
    public void setCuir(int cuir) {
        this.cuir = cuir;
    }
}
