package lt.lukpaz.tournament;

import java.util.Arrays;

public class Tournament {
    public static void main(String[] args) {
        Player[] players = {
                new Player("Aa"),
                new Player("Bb"),
                new Player("Cc"),
                new Player("Dd"),
                new Player("Ee"),
                new Player("Ff"),
                new Player("Gg"),
                new Player("Hh"),
                new Player("Ii"),

        };


        generateTournamentBracket(players);
//        playTournament(players, 1);
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

    public static void generateTournamentBracket(Player[] players) {
        printAllPlayers(players);
        Player[] currPlayers = Arrays.copyOf(players, players.length);
        int round = 1;
        if(!isPowerOfTwo(players.length)) {
            Player[] newPlayers = equalizePlayerArray(currPlayers);
            generateTournamentBracket(newPlayers, round+1);
        }
        generateTournamentBracket(currPlayers, round);
    }

    private static void generateTournamentBracket(Player[] players, int round) {
        if(players.length == 1) {
            return;
        }
        System.out.println("Round " + round);
        Pair[] pairs = generatePairs(players);
        printPairMatchups(pairs);
        Player[] nextRoundPlayers = generateNextRoundPlayers(pairs);
        generateTournamentBracket(nextRoundPlayers, round+1);

    }

    static Pair[] generatePairs(Player[] players) {
        int numberOfPairs = players.length / 2;
        Pair[] pairs = new Pair[numberOfPairs];
        for(int i = 0; i<numberOfPairs; i++) {
            int ind = 2 * i;
            pairs[i] = new Pair(players[i], players[i+1]);
        }
        return pairs;
    }

    static Player[] generateNextRoundPlayers(Pair[] pairs) {
        Player[] players = new Player[pairs.length];
        for(int i = 0; i<pairs.length; i++) {
            players[i] = new Player(pairs[i].getWinner());
        }
        return players;
    }

    static Player[] equalizePlayerArray(Player[] players) {
        int nextRoundPlayers = closestLowerPowOfTwo(players.length);
        int noOfPlayerToPlay = players.length - nextRoundPlayers;
        Player[] newPlayers = new Player[nextRoundPlayers];
        Player[] currRoundPlayers = Arrays.copyOfRange(players,players.length - nextRoundPlayers *2, players.length);
        Player[] remainingPlayers = generateNextRoundPlayers(generatePairs(currRoundPlayers));
        for(int i=0; i<nextRoundPlayers-remainingPlayers.length; i++) {
            newPlayers[i] = players[i];
        }
        for(int i=nextRoundPlayers-remainingPlayers.length; i<nextRoundPlayers; i++ ) {
            int ind = 0;
            newPlayers[i] = remainingPlayers[ind];
            ind++;
        }

        return newPlayers;
    }

    static void printAllPlayers(Player[] players) {
        System.out.println("All Tournament Players:");
        for(Player p : players) {
            System.out.printf("%d) %s, ", p.getId(), p.getName());
        }
        System.out.println();
    }

    static void printPairMatchups(Pair[] pairs) {
        for (Pair p : pairs) {
            p.printPair();
        }
    }

    static boolean isPowerOfTwo(int number) {
        while (number != 2) {
            if(number %2 != 0) {
                return false;
            }
            number /=2;
        }
        return true;
    }

    private static int closestLowerPowOfTwo(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("No negative numbers!");
        }
        if(number == 1) return 0;
        int count = 0;

        while(number > Math.pow(2,count)) {
            ++count;
        }

        return (int)Math.pow(2, count-1);
    }

}
