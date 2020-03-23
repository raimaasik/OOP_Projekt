import java.util.Random;
import java.util.Scanner;

public class Game {

    public static int game() {
        Board board = Board.buildEmptyBoard();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Mark playerMark;
        Mark comMark;

        playerMark = getPlayerMark(random);
        comMark = getComMark(playerMark);

        System.out.println("player: " + playerMark);
        System.out.println("computer: " + comMark);

        for (int i = 0; i < 10; i++) {

            int playerPick = getPlayerPick(board, scanner);
            board.setSpaceMark(playerPick, playerMark);

            // kontroll kas võit

            int randomPick = getRandomPick(board, random);
            board.setSpaceMark(randomPick, comMark);

            System.out.println(board);

            //kontroll
            if (board.getSpaceMark(6) == Mark.CROSS)
                return 1;
        }
        return 2;
    }

    private static int getRandomPick(Board board, Random random) {
        while (true) {
            int randomPick = random.nextInt(9) + 1;
            if (board.checkSpace(randomPick)) {
                return randomPick;
            }
        }
    }

    private static int getPlayerPick(Board board, Scanner scanner) {
        while (true) {
            System.out.println("which field?");
            int playerPick = scanner.nextInt();
            if (board.checkSpace(playerPick)) {
                return playerPick;
            }
            System.out.println("filed already filled!");
        }
    }

    private static Mark getPlayerMark(Random random) {
        Mark playerMark;

        if (random.nextInt(2) == 0) {
            playerMark = Mark.CROSS;
        } else {
            playerMark = Mark.NOUGHT;
        }
        return playerMark;
    }

    private static Mark getComMark(Mark playerMark) {
        if (playerMark == Mark.CROSS) {
            return Mark.NOUGHT;
        } else {
            return Mark.CROSS;
        }
    }
}
