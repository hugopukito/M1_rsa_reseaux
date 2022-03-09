public class part1 {

    // exemple pour 1 avec x=3
    // 100 (affiché 001)
    private int[] array;

    public part1 (int x) {
        array = new int[x];
    }

    public int[] getArray() {
        return array;
    }

    // prend un nombre, rajoute les 0 selon la taille allouée
    // et l'injecte dans notre array.
    public void convert (int nb) {
        String s = Integer.toBinaryString(nb);
        String size = "%" + array.length + "s";
        s = String.format(size, s).replaceAll(" ", "0");
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        s = sb.toString();
        char[] cArray =  s.toCharArray();
        for (int i=0; i<array.length; i++) {
            if (cArray[i] == '0') {
                array[i] = 0;
            } else {
                array[i] = 1;
            }
        }
    }

    public void initialiser0 () {
        for (int i=0; i<array.length; i++) {
            array[i] = 0;
        }
    }

    public void initialiser1 () {
        array[0] = 1;
        for (int i=1; i<array.length; i++) {
            array[i] = 0;
        }
    }

    public void libererNombre () {
        array = null;
    }

    public String afficher () {
        String s = "";
        for (int i=array.length-1; i>=0; i--) {
            s += String.valueOf(array[i]);
        }

        return s;
    }

    public static boolean comparer (int[] array1, int[] array2) {

        boolean bool = true;

        if (array1.length == array2.length) {
            for (int i=0; i<array1.length; i++) {
                if (array1[i] != array2[i]) {
                    bool = false;
                }
            }
        }

        else if (array1.length > array2.length) {
            int diff = array2.length;

            for (int i=diff; i<array1.length; i++) {
                if (array1[i] == 1) {
                    return bool = false;
                }
            }

            for (int i=0; i<array2.length; i++) {
                if (array1[i] != array2[i]) {
                    return bool = false;
                }
            }
        }

        else if (array2.length > array1.length) {
            int diff = array1.length;

            for (int i=diff; i<array2.length; i++) {
                if (array2[i] == 1) {
                    return bool = false;
                }
            }

            for (int i=0; i<array1.length; i++) {
                if (array1[i] != array2[i]) {
                    return bool = false;
                }
            }
        }

        return bool;
    }

    public boolean estPair () {
         return array[0] == 0;
    }

    public void diviserPar2 () {
        for (int i=0; i<array.length-1; i++) {
            array[i] = array[i+1];
        }
    }
}
