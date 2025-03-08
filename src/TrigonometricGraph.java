import org.fusesource.jansi.AnsiConsole;

public class TrigonometricGraph {
    private static int n =101;
    private static char[][] arr;
    public static final String red = "\u001b[31;1m";

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
        for(int i = 6; i >= -6; i--) {
            int x = (constant-m_data*i*i)/n_data;
            System.out.println((x) +" "+(i));
            x = TrigonometricGraph.checkvalidity(x);
            i=TrigonometricGraph.checkvalidity(i);
            arr[50 + i][50 + x] =symbol;
        }

    }
    static {
        arr = new char[n][n];
    }
    public static int checkvalidity(int x){
                if(x>0){
                    if(x+50>100){
                        int rem = (x+50)-100;
                        x-=rem;
                    }
                }
                else{
                    x*=-1;
                    if(x+50>100){
                        int rem = (x+50)-100;
                        x-=rem;
                    }
                    x*=-1;

                }

        return x;
    }
}
//x = (-(by + d) ± √((by + d)² - 4a(cy² + ey + f))) / (2a)
