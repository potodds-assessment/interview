package ib;

public class marginal_tax {
    public double tax_calc(double[] input1, double[] input2, double input3) {
        double tax_amount = 0.0;
        double current_income = input3;

        for(int i=1; i<input1.length; i++) {
            double marginal = input1[i] - input1[i-1];
            double rate = input2[i-1];
            current_income -= marginal;

            System.out.println("current_income[" + current_income + "], marignal[" + marginal + "], rate[" + rate + "]");

            tax_amount +=  (current_income < marginal ? current_income : marginal) * rate;
        }
        return tax_amount;
    }


    public static void main(String[] args) {
        marginal_tax app = new marginal_tax();
        System.out.println(app.tax_calc(new double[] {0.0, 1000.0,2000.0}, new double[]{0.1, 0.5,0.2}, 4000.0));
        System.out.println(app.tax_calc(new double[] {0.0, 1000.0}, new double[]{0.1, 0.5}, 2000.0));
    }
    
}
