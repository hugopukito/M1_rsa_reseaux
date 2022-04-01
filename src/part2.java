public class part2 {
    private char[] m;
    private part1 mB;
    private part1 exp;
    private char[] n;
    private part1 nB;

    public part2 (String m, int tailleClef, int exp, String n) {
        this.exp = objectToBinary(exp);
        this.nB = objectToBinary(n);

        this.n = n.toCharArray();

        this.m = m.toCharArray();
        messageToBinary();

        if (mB.getArray().length >= tailleClef) {
            throw new IllegalArgumentException("message trop long: " + mB.getArray().length +
                    " doit être inférieur à: " +
                    tailleClef);
        }
    }

    private void messageToBinary () {

        part1[] tempArray = new part1[m.length];
        String s = "";

        for (int i=0; i< m.length; i++) {
            part1 temp = new part1(7);
            temp.convert(m[i]);
            tempArray[i] = temp;
        }

        for (int i=0; i< tempArray.length; i++) {
            s += tempArray[i].getAfficher();
        }

        mB = new part1(m.length*7);
        mB.convert(s);
    }

    private part1 objectToBinary (int nb) {
        int log = (int) (Math.log(nb) / Math.log(2));
        part1 temp = new part1(log+1);
        temp.convert(nb);

        return temp;
    }

    private part1 objectToBinary (String nb) {
        part1 temp = new part1(nb.length());
        temp.convert(nb);

        return temp;
    }

    public int[] exponRapide () {
        return part1.exponentiationRapide1(mB.getArray(), exp.getArray(), nB.getArray());
    }

    public void affichage() {

        System.out.print("message: ");
        for (char c : m) {
            System.out.print(c);
        }
        System.out.println();

        System.out.print("en binaire: ");
        mB.afficher();
        System.out.println();

        System.out.print("taille bits message: ");
        System.out.println(mB.getArray().length);

        System.out.print("exp: ");
        exp.afficher();
        System.out.println();

        System.out.print("n: ");
        nB.afficher();
        System.out.println();
    }
}
