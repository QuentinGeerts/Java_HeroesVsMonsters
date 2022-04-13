package be.bstorm.model;

import be.bstorm.interfaces.ICuir;

public class Loup extends Monstre implements ICuir {

    /*
        Attributes
     */

    private int cuir;

    /*
        Constructeurs
     */

    public Loup() {
        cuir = getDe4().lance();
    }

    /*
        Accesseurs & Mutateurs
     */

    @Override
    public int getCuir() {
        return cuir;
    }

    @Override
    public void setCuir(int cuir) {
        this.cuir = cuir;
    }

}
