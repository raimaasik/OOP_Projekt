import java.util.Arrays;

public class Board {
    private Space[][] spaces;

    private Board(Space[][] spaces) {
        this.spaces = spaces;
    }

    //see on ehitaja mis teeb tühja mänguvälja, ehk ei kutsu constructori vaid selle.
    // kasutatud siis kahe kordinaadiga süsteemi ehk 1 väli on spaces[0][0] jne lihtsam kontrollida kui ühte jada
    public static Board buildEmptyBoard() {
        Space[][] spaces = new Space[3][3];
        for ( int i = 0; i<spaces.length; i++) {
            for (int j = 0; j < spaces[i].length; j++) {
                spaces[i][j] = Space.buildEmptySpace();
            }
        }
        return new Board(spaces);
    }

    // vajab eelkontrolli et antud number on vahemikus 1-12
    public Mark getSpaceMark(int spaceNumber) {
        if (spaceNumber <= 3){
            return this.spaces[0][spaceNumber-1].getMark();
        } else if (spaceNumber <= 6){
            return this.spaces[1][spaceNumber-4].getMark();
        } else{
            return this.spaces[2][spaceNumber-7].getMark();
        }
    }

    // vajab eelkontrolli et antud number on vahemikus 1-12
    public void setSpaceMark(int spaceNumber, Mark mark) {
        if (spaceNumber <= 3){
            this.spaces[0][spaceNumber-1].setMark(mark);
        } else if (spaceNumber <= 6){
            this.spaces[1][spaceNumber-4].setMark(mark);
        } else{
            this.spaces[2][spaceNumber-7].setMark(mark);
        }
    }

    public boolean checkSpace(int spaceNumber) {
        if (spaceNumber <= 3){
            return this.spaces[0][spaceNumber - 1].getMark() == Mark.EMPTY;
        } else if (spaceNumber <= 6){
            return this.spaces[1][spaceNumber - 4].getMark() == Mark.EMPTY;
        } else {
            return this.spaces[2][spaceNumber - 7].getMark() == Mark.EMPTY;
        }
    }

    //raidole kontrolliks, graafika jaoks tuleb natuke rohkem kirjutada ja seda meetodit päriselt ei kasuta
    @Override
    public String toString() {
        return "Board{" +
                "spaces=" + Arrays.toString(spaces[1]) +Arrays.toString(spaces[0]) +Arrays.toString(spaces[2]) +
                '}';
    }
}
