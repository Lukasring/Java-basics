package lt.lukpaz.tournament;

public class Pair {
    private Player p1;
    private Player p2;
    private static int count;
    private final int pairId;

    Pair(Player player1, Player player2) {
        this.p1 = player1;
        this.p2 = player2;
        ++count;
        pairId = count;
    }

    void printPair() {
        System.out.printf("%d) %s - %s\n",pairId, p1.getName(), p2.getName());
    }

    String getWinner() {
        return "Pair "+this.pairId+" winner";
    }
}
