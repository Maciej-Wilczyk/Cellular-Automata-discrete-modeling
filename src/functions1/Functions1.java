package functions1;


public class Functions1 {

    public int[] makeFirstTable(int size) {
        int[] tab = new int[size];
        for (int i = 0; i < size; i++) {
            if (i == size / 2) {
                tab[i] = 1;
                continue;
            } else
                tab[i] = 0;
        }
        return tab;
    }


    public int[] makeTable(int rules, int[] tab, String ch) {
        int[] newTab = new int[tab.length];
        String binary = Integer.toBinaryString(rules);

        String help;
        int a = 0;
        int b;
        while (binary.length() < 8) {
            binary = 0 + binary;
        }

        if (ch.equals("Ones at the ends")) {
            help = Integer.toString(1) + Integer.toString(tab[0]) + Integer.toString(tab[1]);
            a = Integer.parseInt(help, 2);
            b = Character.getNumericValue(binary.charAt(binary.length() - 1 - a));
            if (b == 1) {
                newTab[0] = 1;
            } else {
                newTab[0] = 0;
            }

            help = "";
            help = Integer.toString(tab[tab.length - 2]) + Integer.toString(tab[tab.length - 1]) + Integer.toString(1);
            a = Integer.parseInt(help, 2);
            b = Character.getNumericValue(binary.charAt(binary.length() - 1 - a));

            if (b == 1) {
                newTab[tab.length - 1] = 1;
            } else {
                newTab[tab.length - 1] = 0;
            }
            a = 0;
            b = 0;
            help = "";
        }

        for (int i = 1; i < tab.length - 1; i++) {
            help = Integer.toString(tab[i - 1]) + Integer.toString(tab[i]) + Integer.toString(tab[i + 1]);

            a = Integer.parseInt(help, 2);
            b = Character.getNumericValue(binary.charAt(binary.length() - 1 - a));

            if (b == 1) {
                newTab[i] = 1;
            } else {
                newTab[i] = 0;
            }
            help = "";
            a = 0;
        }

        if (ch.equals("Periodic")) {
            help = Integer.toString(tab[tab.length - 1]) + Integer.toString(tab[0]) + Integer.toString(tab[1]);
            a = Integer.parseInt(help, 2);
            b = Character.getNumericValue(binary.charAt(binary.length() - 1 - a));


            if (b == 1) {
                newTab[0] = 1;
            } else {
                newTab[0] = 0;
            }

            help = Integer.toString(tab[tab.length - 2]) + Integer.toString(tab[tab.length - 1]) + Integer.toString(tab[0]);
            a = Integer.parseInt(help, 2);
            b = Character.getNumericValue(binary.charAt(binary.length() - 1 - a));

            if (b == 1) {
                newTab[tab.length - 1] = 1;
            } else {
                newTab[tab.length - 1] = 0;
            }
            a = 0;
            b = 0;
        }

        return newTab;
    }
}