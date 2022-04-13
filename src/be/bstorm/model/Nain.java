package be.bstorm.model;

public class Nain extends Heros {

    @Override
    public int getEndurance() {
        return super.getEndurance() + 2;
    }
}
