package src.Interactive;
import java.util.Random;

public class Difficulty_Controller {
    private int difficulty;
    Random rand = new Random();

    Difficulty_Controller(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getDifficulty() {
        return this.difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int variable_number() {
        int variable_number = 0;
        int i=0;
        switch (this.difficulty) {
            case 1:
                variable_number = this.rand.nextInt(3);
                break;
            case 2:
                i=0;
                while(true) {
                    variable_number = this.rand.nextInt(6);
                    if (variable_number > 3) {
                        return variable_number;
                    }

                    ++i;
                }
            case 3:
                 i = 0;

                while(true) {
                    variable_number = this.rand.nextInt(8);
                    if (variable_number > 5) {
                        return variable_number;
                    }

                    ++i;
                }
            default:
                variable_number = this.rand.nextInt(8);
        }

        return variable_number;
    }
}

