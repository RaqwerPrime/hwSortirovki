import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        int[][] teams = {
                {45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
                {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},
                {51, 30, 10, 9, 8, 7, 6, 5, 2, 1}
        };

        int[] nationalTeam = mergeAll(teams);
        System.out.println(Arrays.toString(nationalTeam)); // [51, 45, 31, 31, 30, 24, 22, 20, 18, 17]
    }

    /**
     * Метод для слияния всех команд в одну национальную
     */
    public static int[] mergeAll(int[][] teams) {
        if (teams.length == 0) {
            return new int[0];
        }
        int[] nationalTeam = teams[0];
        for (int i = 1; i < teams.length; i++) {
            nationalTeam = merge(nationalTeam, teams[i]);
        }
        return nationalTeam;

    }

    /**
     * Метод для слияния двух команд в одну
     */
    public static int[] merge(int[] teamA, int[] teamB) {
        int[] topRank = new int[10];
        int iA = 0;
        int iB = 0;
        int iR = 0;

        while (iR < 10) {
            if (iA < 10 && (iB >= 10 || teamA[iA] >= teamB[iB])) {
                topRank[iR++] = teamA[iA++];
            } else {
                topRank[iR++] = teamB[iB++];
            }
        }
        return topRank;
    }
}