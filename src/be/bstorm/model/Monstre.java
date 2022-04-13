package be.bstorm.model;

import be.bstorm.interfaces.ICuir;
import be.bstorm.interfaces.IOr;

public class Monstre extends Personnage {

    @Override
    public String toString() {
        return super.toString()
                + "\n  - Inventaire :"
                + ((this instanceof ICuir) ? "\n     - Cuir : " + ((ICuir) this).getCuir() : "")
                + ((this instanceof IOr) ? "\n     - Or : " + ((IOr) this).getOr() : "");
    }
}
