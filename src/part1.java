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

    // prend un nombre, le transforme en binaire, ajoute les 0
    // selon la taille alloué et l'injecte dans le tableau.
    public void convert (int nb) {
        String s = Integer.toBinaryString(nb);

        if (s.length() > array.length) {
            throw new IllegalArgumentException("augmenter taille tableau");
        }

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

    public void afficher () {
        String s = "";
        for (int i=array.length-1; i>=0; i--) {
            s += String.valueOf(array[i]);
        }
        System.out.println(s);
    }

    public static void afficher (int[] arr) {
        String s = "";
        for (int i=arr.length-1; i>=0; i--) {
            s += String.valueOf(arr[i]);
        }
        System.out.println(s);
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

    public void reduireDe1 () {
        if (!estPair()) {
            array[0] = 0;
        } else {
            for (int i=0; i<array.length; i++) {
                if (array[i] == 0) {
                    array[i] = 1;
                } else {
                    array[i] = 0;
                    break;
                }
            }
        }
    }

    public void multiplierPar2 () {

        if (array[array.length-1] == 1) {
            throw new IllegalArgumentException("augmenter taille tableau");
        }

        for (int i=array.length-1; i>0; i--) {
            array[i] = array[i-1];
        }
        array[0] = 0;
    }

    public static int[] ajouter(int[] array1, int[] array2) {

        int[] newArr;

        if (array1.length > array2.length) {
            newArr = new int [array1.length];
            for (int i=0; i< array2.length; i++) {
                newArr[i] = array2[i];
            }
            for (int i= array2.length; i< array1.length; i++) {
                newArr[i] = 0;
            }

            if (array1.length == newArr.length) {
                return ajouter_calcul(array1, newArr);
            } else {
                throw new IllegalArgumentException("problème taille");
            }
        }

        else if (array2.length > array1.length) {
            newArr = new int [array2.length];
            for (int i=0; i< array1.length; i++) {
                newArr[i] = array1[i];
            }
            for (int i= array1.length; i< array2.length; i++) {
                newArr[i] = 0;
            }

            if (array2.length == newArr.length) {
                return ajouter_calcul(array2, newArr);
            } else {
                throw new IllegalArgumentException("problème taille");
            }
        }

        else {
            if (array1.length == array2.length) {
                return ajouter_calcul(array1, array2);
            } else {
                throw new IllegalArgumentException("problème taille");
            }
        }
    }

    private static int[] ajouter_calcul(int[] array1, int[] array2) {

        String s = "";
        int temp = 0;

        for (int i=0; i< array1.length; i++) {

            if (array1[i] + array2[i] == 0) {
                if (temp == 0) {
                    s += 0;
                } else {
                    s += 1;
                    temp = 0;
                }
            }
            else if (array1[i] + array2[i] == 1) {
                if (temp == 0) {
                    s += 1;
                } else {
                    s += 0;
                    temp = 1;
                }
            }
            else if (array1[i] + array2[i] == 2) {
                if (temp == 0) {
                    s += 0;
                    temp = 1;
                } else {
                    s += 1;
                    temp = 1;
                }
            }
        }

        int[] finalArr = new int[s.length()];
        char[] cArray =  s.toCharArray();
        for (int i=0; i<finalArr.length; i++) {
            if (cArray[i] == '0') {
                finalArr[i] = 0;
            } else {
                finalArr[i] = 1;
            }
        }

        return finalArr;
    }

    public static int[] multiplier(int[] array1, int[] array2) {



        return null;
    }
}
