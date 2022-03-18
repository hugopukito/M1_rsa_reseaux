public class main {
    public static void main (String[] args) {
        part1 nb1 = new part1(9);
        //nb1.initialiser0();
        //nb1.initialiser1();
        //System.out.println(nb1.afficher());

        part1 nb2 = new part1(9);
        part1 nb3 = new part1(9);
        nb2.initialiser1();

        //System.out.println(nb2.afficher());

        //System.out.println(part1.comparer(nb1.getArray(), nb2.getArray()));

        //System.out.println(nb1.estPair());

        nb1.convert(4);
        nb2.convert(13);
        nb3.convert(497);
        /*nb1.afficher();
        nb2.afficher();*/

        //nb2.diviserPar2();

        //nb2.reduireDe1();

        //nb2.multiplierPar2();

        /*nb1.afficher();
        part1.afficher(part1.decalageDroite(nb1.getArray()));*/

        //part1.afficher(part1.ajouter(nb1.getArray(), nb2.getArray()));
        //part1.afficher(part1.multiplier(nb1.getArray(), nb2.getArray()));
        //part1.afficher(part1.exponentiationRapideSansModulo(nb1.getArray(), nb2.getArray()));
        //part1.afficher(part1.soustraire(nb1.getArray(), nb2.getArray()));
        //part1.afficher(part1.modulo(nb1.getArray(), nb2.getArray()));
        part1.afficher(part1.exponentiationRapide(nb1.getArray(), nb2.getArray(), nb3.getArray()));
    }
}
