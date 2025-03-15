package Graph;

import java.util.Arrays;

public class LinearGraph {

    public int axis;
    static char arr[][];
    int x_index;
    int y_index;
    int constant;
    int range_map[];


    public LinearGraph(int x_index, int y_index, int constant) {
        System.out.println("Enter the constant values :");
        this.x_index = x_index;
        this.y_index = y_index;
        this.constant = constant;
        this.findrange(x_index,y_index,constant);
        this.create_Empty_graph();
        this.create_axis();
       // System.out.println(x_index+" "+y_index+" "+constant);
        this.findrange(x_index, y_index, constant);

    }
    public  void findrange(int x_cof,int y_cof,int constant) {
        int range = 60;
        for(int i=-7;i<=7;i+=1) {
            int x = (constant + y_cof * i) / x_cof;
            if(x<0) {x*=-1;}
            range = Math.max(range,x);
            System.out.print(x+" ");
            //range = Math.max(range, (int)((i < 0) ? i * -1 : i));
        }
        this.axis=(int)range+10;
        System.out.println(axis);
        this.create_Empty_graph();
    }
    public  void create_Empty_graph(){
        LinearGraph.arr = new char[axis+1][axis+1];
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[i].length;j++) {
                arr[i][j] = ' ';
            }
        }
        this.create_axis();
    }
    public void create_axis() {
        int i;
        for(i = axis - 1; i >= 0; --i) {
            arr[axis/2][i] = '.';
        }

        for(i = axis - 1; i >= 0; --i) {
            arr[i][axis/2] = '.';
        }
        //this.plot_points(x_index,y_index,constant);
    }
    public void plot_points(int x_index,int y_index,int constant) {
        this.range_map = new int[axis+1];
        Arrays.fill(range_map,-1);
        int center=axis/2;
        System.out.println("Center: "+center);
        for(int i=-7;i<=7;i+=1) {
            int x = (constant + y_index * i) / x_index;
            int row_data;
            int col_data;
            col_data=center+x;
            row_data=center+i;
            if(x_index>0 && col_data<axis && col_data>0) {
                while (col_data >0 && col_data < axis && range_map[col_data] != -1) {
                    col_data = col_data + 1;
                }
                range_map[col_data] = 1;
            }
            else if(x_index<0 && col_data<axis && col_data>0){
                while (range_map[col_data] != -1 && col_data >0 && col_data < axis) {
                    col_data = col_data - 1;
                }
                range_map[col_data] = 1;
            }
            if(col_data>0 && col_data<axis && row_data>0 && row_data<axis) {
                arr[row_data][col_data]='*';
            }
            System.out.println(col_data+" "+row_data);


        }

    }
    public  void Display_graph(){
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[i].length;j++) {
                if(arr[i][j]=='*') {System.out.print("\033[31m"+arr[i][j]+"\033[0m"+" ");}
                 else if(arr[i][j]=='#') {System.out.print("\033[32m"+arr[i][j]+"\033[0m"+" ");}
                 else if(arr[i][j]=='.') {System.out.print("\033[38m"+arr[i][j]+"\033[0m"+" ");}
                 else{System.out.print(arr[i][j]+" ");}
            }
            System.out.println();
        }
    }





















}