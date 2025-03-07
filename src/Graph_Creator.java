import org.fusesource.jansi.AnsiConsole;

public class Graph_Creator {
    private static int n = 101;
    private static char[][] arr;
    public static final String red = "\u001b[31;1m";

    public Graph_Creator() {
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
       // AnsiConsole.systemInstall();
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {

                        if(arr[i][j]=='*'){
                            System.out.print('*');
                        }
                        else{
                            System.out.print(arr[i][j] + " ");
                        }

            }
            System.out.println();
        }
        AnsiConsole.systemUninstall();
    }

    public static void plotdata(int n_data, int m_data, int constant,char  symbol) {
        for(int i = 6 + constant; i >= -6 - constant; i-=2) {
            int x = (constant + m_data * i) / n_data;
            arr[50 + i][50 + x] =symbol;
        }

    }
    static {
        arr = new char[n][n];
    }
}
