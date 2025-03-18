package EquationClasses;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
public class FunctionTaker {
    String function;
    double value;
    public FunctionTaker() {}

    public void setFunction(String function) {
        this.function = function;
    }
    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public String getFunction() {
        return function;
    }

    public double f(double v) {
        Expression exp = new ExpressionBuilder(function).variable("x").build().setVariable("x",v);
        return exp.evaluate();
    }
}
