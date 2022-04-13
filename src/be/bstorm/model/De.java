package be.bstorm.model;

import java.util.Random;

public class De {
    private final int minimum;
    private final int maximum;
    private final Random random;

    /*
        Constructeur
     */

    public De(int maximum) {
        this.minimum = 1;
        this.maximum = maximum;
        this.random = new Random(System.currentTimeMillis());
    }

    /*
        Accesseurs & Mutateurs
     */

    public int getMinimum() {
        return minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    /*
        Méthodes
     */

    public int lance() {
        return random.nextInt(maximum) + 1;
    }

    public static int getNouvelleCaracteristique() {
        final int nbDes = 4;
        int[] des = new int[nbDes];
        De d = new De(6);

        for (int i = 0; i < nbDes; i++) {
            des[i] = d.lance();
        }

        for (int i = 0; i < nbDes - 1; i++) {
            for (int j = i + 1; j < nbDes; j++) {
                if (des[i] < des[j]) {
                    int temp = des[i];
                    des[i] = des[j];
                    des[j] = temp;
                }
            }
        }

        return des[0] + des[1] + des[2];
    }
}
