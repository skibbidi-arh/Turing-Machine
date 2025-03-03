import static java.lang.Math.sqrt;

public class TrigonometricGraph {
    private static int n = 101;
    private static char[][] arr;

    public TrigonometricGraph() {
        this.EmptyGraphCreator();
    }

    public void EmptyGraphCreator() {
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                arr[i][j] = ' ';
            }
        }

        this.createaxis();
    }

    public void createaxis() {
        int i;
        for(i = n - 1; i >= 0; --i) {
            arr[50][i] = '.';
        }

        for(i = n - 1; i >= 0; --i) {
            arr[i][50] = '.';
        }

    }

    public static void showgraph() {
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                System.out.print(arr[i][j] + " ");
            }

            System.out.println();
        }

    }

    public static void plotdata(int n_data, int m_data, int constant) {
        for(int i = 6 + constant; i >= -6 - constant; --i) {
            int x = (int)sqrt((1-m_data*i*i)/n_data);
            arr[50 + i][50 + x] = '*';
        }

    }
    static {
        arr = new char[n][n];
    }
}
