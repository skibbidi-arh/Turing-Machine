package Display;

import Graph.DisplayMainForLinear;
import Graph.DisplayMainForPolynomial;
import Graph.TrigonometricGraph;

public class GraphDisplay {
    public GraphDisplay() {

    }
    public void display(int option){
            switch (option) {
                case 1:
                    DisplayMainForLinear dl = new DisplayMainForLinear();
                    dl.graphDisplay();

                    break;
                case 2:
                    DisplayMainForPolynomial dp = new DisplayMainForPolynomial();
                    dp.graphDisplay();
                    break;
                case 3:
                    TrigonometricGraph tg = new TrigonometricGraph();
                    tg.draw();
                    break;
            }
    }
}
