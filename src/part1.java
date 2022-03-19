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

    public static int[] initialiser0 (int[] array) {
        for (int i=0; i<array.length; i++) {
            array[i] = 0;
        }

        return array;
    }

    public void initialiser1 () {
        array[0] = 1;
        for (int i=1; i<array.length; i++) {
            array[i] = 0;
        }
    }

    public static int[] initialiser1 (int[] array) {
        array[0] = 1;
        for (int i=1; i<array.length; i++) {
            array[i] = 0;
        }

        return array;
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

    public static boolean estPair (int[] arr) {
        return arr[0] == 0;
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

    public static int[] multiplierPar2 (int[] array) {

        if (array[array.length-1] == 1) {
            throw new IllegalArgumentException("augmenter taille tableau");
        }

        for (int i=array.length-1; i>0; i--) {
            array[i] = array[i-1];
        }
        array[0] = 0;

        return array;
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

        int[] result;

        if (array1.length > array2.length) {
            result = new int[array1.length*2];
        } else {
            result = new int[array2.length*2];
        }

        result[0] = 0;

        int[] temp = new int[array1.length*2];

        for (int i=0; i<array2.length; i++) {

            for (int k=0; k< temp.length; k++) {
                temp[k] = 0;
            }

            for (int k=0; k< array1.length; k++) {
                temp[k] = array1[k];
            }

            if (array2[i] == 1) {
                for (int j=0; j<i; j++) {
                    temp = multiplierPar2(temp);
                }
                result = ajouter(result, temp);
            }
        }

        return result;
    }

    // régler la mémoire
    public static int[] exponentiationRapideSansModulo (int[] array1, int[] array2) {

        int[] x = new int[(int) Math.pow(array1.length,2)];
        int[] base = new int[(int) Math.pow(array1.length,2)];

        x[0] = 1;
        for (int i=0; i< array1.length; i++) {
            base[i] = array1[i];
        }

        for (int i=0; i< array2.length; i++) {
            if (array2[i] == 1) {
                x = multiplier(x, base);
            }
            base = multiplier(base, base);
        }

        return x;
    }

    public static int[] soustraire(int[] array1, int[] array2) {

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
                return soustraire_calcul(array1, newArr);
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
                return soustraire_calcul(array2, newArr);
            } else {
                throw new IllegalArgumentException("problème taille");
            }
        }

        else {
            if (array1.length == array2.length) {
                return soustraire_calcul(array1, array2);
            } else {
                throw new IllegalArgumentException("problème taille");
            }
        }
    }

    private static int[] soustraire_calcul(int[] array1, int[] array2) {

        String s = "";
        int temp = 0;

        for (int i=0; i< array1.length; i++) {

            if (array1[i] - array2[i] == 0) {
                if (temp == 0) {
                    s += 0;
                } else {
                    s += 1;
                    temp = 1;
                }
            }
            else if (array1[i] - array2[i] == -1) {
                if (temp == 0) {
                    s += 1;
                    temp = 1;
                } else {
                    s += 0;
                    temp = 1;
                }
            }
            else if (array1[i] - array2[i] == 1) {
                if (temp == 0) {
                    s += 1;
                } else {
                    s += 0;
                    temp = 0;
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

    public static int[] modulo(int[] array1, int[] array2) {

        int[] finalArray = new int[array2.length];
        int[] arr1 = real_length(array1);
        int[] arr2 = real_length(array2);
        int diff;
        int arr1_diff;

        if (arr1.length < arr2.length) {
            for (int i=0; i<arr1.length; i++) {
                finalArray[i] = arr1[i];
            }
            for (int i=arr1.length; i< finalArray.length; i++) {
                finalArray[i] = 0;
            }

            return finalArray;
        }
        else if (arr1.length == arr2.length) {
            if(inferieur(arr1, arr2)) {
                for (int i=0; i<arr1.length; i++) {
                    finalArray[i] = arr1[i];
                }
                for (int i=arr1.length; i< finalArray.length; i++) {
                    finalArray[i] = 0;
                }

                return finalArray;
            }
        }
        else if (comparer(arr1, arr2)) {
            return arr2;
        }

        do {
            arr1 = real_length(arr1);
            diff = arr1.length - arr2.length;
            int[] sub = new int[arr1.length];

            for (int i=0; i<arr2.length; i++) {
                sub[i] = arr2[i];
            }

            arr1_diff = arr1.length-1;

            for (int i=0; i<diff-1; i++) {
                sub = multiplierPar2(sub);
            }

            while (arr1.length > arr1_diff) {
                arr1 = real_length(soustraire(arr1, sub));
            }
        } while (arr1.length > arr2.length);

        for (int i=0; i<arr1.length; i++) {
            finalArray[i] = arr1[i];
        }
        for (int i=arr1.length; i< finalArray.length; i++) {
            finalArray[i] = 0;
        }

        return finalArray;
    }

    private static boolean inferieur(int[] arr1, int[] arr2) {
        for (int i=arr1.length-1; i>=0; i--) {
            if (arr1[i] == 1 && arr2[i] != 1) {
                return false;
            }
            else if (arr1[i] != 1 && arr2[i] == 1) {
                return true;
            }
        }
        return false;
    }

    private static int[] real_length(int[] array) {

        int cpt = 0;

        for (int i= array.length-1; i>=0; i--) {
            if (array[i] != 0) {
                break;
            }
            cpt++;
        }

        cpt = array.length - cpt;
        int[] arr = new int[cpt];

        for (int i=0; i<cpt; i++) {
            arr[i] = array[i];
        }

        return arr;
    }

    public static int[] exponentiationRapide1(int[] base, int[] exp, int[] m) {

        int[] result = new int[m.length];

        initialiser1(result);

        while (!egale0(exp)) {
            if (!estPair(exp)) {
                result = modulo(multiplier(result, base), m);
            }

            exp = decalageDroite(exp);
            base = modulo(multiplier(base, base), m);
        }

        return result;
    }

    public static int[] exponentiationRapide2(int[] base, int[] exp, int[] m) {

        int[] c =  new int[m.length];
        int[] e2 = new int[exp.length];
        int[] Un = new int[1];

        c = initialiser1(c);
        e2 = initialiser1(e2);
        Un = initialiser1(Un);

        while (!comparer(exp, e2)) {
            c = modulo(multiplier(base, c), m);
            e2 = ajouter(e2, Un);
        }

        c = modulo(multiplier(base, c), m);

        return c;
    }

    public static int[] decalageDroite(int[] array) {
        for (int i=0; i< array.length-1; i++) {
            array[i] = array[i+1];
        }

        array[array.length-1] = 0;

        return array;
    }

    private static boolean egale0(int[] array) {
        for (int i=0; i< array.length; i++) {
            if (array[i] == 1) {
                return false;
            }
        }
        return true;
    }
}
