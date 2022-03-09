public class main {
    public static void main (String[] args) {
        part1 nb1 = new part1(100);
        nb1.initialiser0();
        nb1.initialiser1();
        //System.out.println(nb1.afficher());

        part1 nb2 = new part1(5);
        nb2.initialiser1();
        //System.out.println(nb2.afficher());

        //System.out.println(part1.comparer(nb1.getArray(), nb2.getArray()));

        //System.out.println(nb1.estPair());

        nb2.convert(15);
        System.out.println(nb2.afficher());
    }
}
