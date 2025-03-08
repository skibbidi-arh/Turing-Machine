public class Graph_Creator {
    public int axis;
    static char arr[][];
    double x_index;
    double y_index;
    double constant;


    public Graph_Creator(double x_index, double y_index,double constant) {
        this.x_index = x_index;
        this.y_index = y_index;
        this.constant = constant;
        System.out.println(x_index+" "+y_index+" "+constant);
        this.findrange(x_index, y_index, constant);

    }
    public  void findrange(double x_cof,double y_cof,double constant) {
        int range = 20;
        for(double i=-16;i<=0;i++) {
            double x = (constant + x_cof * i) / y_cof;
            //   System.out.println(x+" "+i);
            if(x<0) {x*=-1;}
            range = Math.max(range, (int) (x*10));
            range = Math.max(range, (int)((i < 0) ? i * -1 : i));
        }
        this.axis=range+1;
        System.out.println(axis);
        this.create_Empty_graph();
    }
    public  void create_Empty_graph(){
        Graph_Creator.arr = new char[axis+1][axis+1];
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
        this.plot_points(x_index,y_index,constant);
    }
    public void plot_points(double x_index,double y_index,double constant) {
        double i;
        int d=0;
        for( i=-8;i<=8;i++) {
            double x = (-constant + x_index * i) / y_index;
            int center = axis/2;
            if(x<0){x*=-1;if(x*10>center){ x=center-1; }else{x*=10;}x*=-1;}
            else{if(x*10>center){x=center-1;}else{x*=10;}}
            System.out.println((x+center)+" "+(i+center));
            arr[center+(int)x][center+(int)i]='*';
        }

    }
    public  void Display_graph(){
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[i].length;j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }





















}