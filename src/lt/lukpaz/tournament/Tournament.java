package lt.lukpaz.tournament;

public class Tournament {
    public static void main(String[] args) {
        Player[] players = {
              new Player("Jurgis"),
              new Player("Antanas"),
              new Player("Aluizas"),
              new Player("Martynas"),
              new Player("Jonas"),
                new Player("Alvydas"),
                new Player("Bronius"),
                new Player("Kazimieras"),
                new Player("Saulius"),
                new Player("Lukas"),
                new Player("Tomas")
        };

        playTournament(players, 1);
    }

    static Player duel(Player p1, Player p2) {
        Player winner = Math.random() > 0.5 ? p1 : p2;
        System.out.printf("%10s vs %-10s -----> %-10s\n", p1.name, p2.name, winner.name);
        return winner;
    }

    static void playTournament(Player[] players, int round) {
        int numberOfPlayers = players.length;
        int numberOfPairs = numberOfPlayers/2;
        int playersRemaining = numberOfPlayers - numberOfPairs*2;
        int proceedsToNextRound = numberOfPairs + playersRemaining;
        Player[] winners = new Player[proceedsToNextRound];

        System.out.printf("\n%s Round %d %s\n","-".repeat(15), round, "-".repeat(15));
        for(int i = 0; i<numberOfPairs*2; i+=2) {
            winners[i/2] = duel(players[i], players[i+1]);
        }
        if(playersRemaining == 1) {
            winners[proceedsToNextRound-1] = players[numberOfPlayers-1];
        }
        if(winners.length == 1) {
            System.out.printf("\n***** The Winner Is: %s *****\n", winners[0].name);
            return;
        }
        playTournament(winners, round + 1);
    }
}
