import com.javarush.engine.cell.*;

public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    private void createGame(){
        createNewNumber();
        createNewNumber();
    }

    private void drawScene(){
        for(int i=0; i<SIDE; i++) {
            for(int j=0; j<SIDE;j++)
            setCellColoredNumber(i,j, gameField[j][i]);
        }

    }

    private void createNewNumber() {
        boolean isCreated = false;

        do {
            int x = getRandomNumber(SIDE);
            int y = getRandomNumber(SIDE);
            if (gameField[x][y] == 0) {
                gameField[x][y] = getRandomNumber(10) < 9 ? 2 : 4;
                isCreated = true;
            }
        }
        while (!isCreated);
    }

    private Color getColorByValue(int value){
        switch (value){
            case 0:
                return Color.PINK;
            case 2:
                return Color.SALMON;
            case 4:
                return Color.DARKSALMON;
            case 8:
                return Color.VIOLET;
            case 16:
                return Color.AQUAMARINE;
            case 32:
                return Color.ALICEBLUE;
            case 64:
                return Color.SKYBLUE;
            case 128:
                return Color.SLATEBLUE;
            case 256:
                return Color.CORNSILK;
            case 512:
                return Color.ORANGERED;
            case 1024:
                return Color.DEEPPINK;
            case 2048:
                return Color.MEDIUMVIOLETRED;
            default:
                return Color.NONE;
        }
    }

    private void setCellColoredNumber(int x, int y, int value){
      Color color = getColorByValue(value);
      String str = value > 0 ? "" + value : "";
      setCellValueEx(x,y, color, str);
    }
}
