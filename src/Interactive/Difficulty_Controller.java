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
                variable_number = this.rand.nextInt(5);
                if (variable_number <= 3)
                    variable_number = variable_number + 2;
                break;
            case 3:
                variable_number = this.rand.nextInt(6);
                if (variable_number <= 4)
                    variable_number = variable_number + 2;
                break;
            default:
                variable_number = this.rand.nextInt(6);
                break;
        }
        return variable_number;
        }

    }

