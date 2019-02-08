package sample;

public class Neuron {
    double weight1;
    double weight2;

    public Neuron(double weight1, double weight2){
        this.weight1 = weight1;
        this.weight2 = weight2;
    }

    private double calculate_sum(double x1, double x2){
        double sum = (x1*weight1) + (x2*weight2);
        return sum;
    }

    public double activation_function(int x1, int x2){
        double sum = calculate_sum(x1,x2);
        return 0;
    }
}
