package be.bstorm.model;

public class Personnage {

    /*
        Attributes
     */

    protected int endurance, force, pv;
    private final De de4, de6;

    /*
        Constructeur
     */

    public Personnage() {
        this.de4 = new De(4);
        this.de6 = new De(6);

        this.endurance = De.getNouvelleCaracteristique();
        this.force = De.getNouvelleCaracteristique();
        resetPv();
    }

    /*
        Accesseurs & Mutateurs
     */

    public int getEndurance() {
        return endurance;
    }

    private void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getForce() {
        return force;
    }

    private void setForce(int force) {
        this.force = force;
    }

    public int getPv() {
        return pv;
    }

    private void setPv(int pv) {
        this.pv = pv;
    }

    public De getDe4() {
        return de4;
    }

    public De getDe6() {
        return de6;
    }

    /*
        Méthodes
     */

    public void resetPv() {
        this.pv = getEndurance() + getModificateur(getEndurance());
    }

    private int getModificateur(int caracteristique) {
        return (caracteristique < 5) ? -1
                : (caracteristique < 10) ? 0
                : (caracteristique < 15) ? 1
                : 2;
    }

    @Override
    public String toString() {
        return "\n" + this.getClass().getSimpleName() + "" +
                "\n  - Endurance : " + getEndurance() +
                "\n  - Force : " + getForce() +
                "\n  - Vie : " + getPv() +
                "\n";
    }

    public void frapper(Personnage personnage) {
        int degats = getDe4().lance() + getModificateur(getForce());

        System.out.println(
                this.getClass().getSimpleName() + " frappe " + personnage.getClass().getSimpleName()
                + " et lui inflige " + degats + " point" + (degats > 1 ? "s" : "") + " de degats."
        );

        personnage.setPv(personnage.getPv() - degats);
    }
}
