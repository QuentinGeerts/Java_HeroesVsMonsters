package be.bstorm.model;

public class Humain extends Heros {
    @Override
    public int getEndurance() {
        return super.getEndurance() + 1;
    }

    @Override
    public int getForce() {
        return super.getForce() + 1;
    }
}
