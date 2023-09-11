package ib;

public class marginal_tax {
    public double marginal_tax(double[] cutoff, double[] rate, double tax) {
        
        double[] marginal_cutoff = new double[cutoff.length];
        double running_tax = tax;

        for(int i=0;i<cutoff.length;i++) {
            marginal_cutoff[i] = (i+1 >= cutoff.length) ? Double.MAX_VALUE : cutoff[i+1] - cutoff[i];
            if (running_tax < marginal_cutoff[i]) marginal_cutoff[i] = running_tax;
            running_tax -= marginal_cutoff[i];
            if (running_tax < 0) break;
        }

        double tax_amount = 0.0;

        for(int i=0;i<marginal_cutoff.length;i++) {
            tax_amount += rate[i] * marginal_cutoff[i];
        }

        return tax_amount;
    }

    public double marginal_tax_chatgpt(double[] cutoff, double[] rate, double tax) {
        if (cutoff == null || rate == null || cutoff.length != rate.length || cutoff.length == 0) {
            throw new IllegalArgumentException("Invalid input parameters");
        }

        double taxAmount = 0;
        int n = cutoff.length;

        for (int i = 0; i < n; i++) {
            if (i == n - 1 || tax <= cutoff[i + 1]) {
                taxAmount += (tax - cutoff[i]) * rate[i];
                break;
            } else {
                taxAmount += (cutoff[i + 1] - cutoff[i]) * rate[i];
            }
        }

        return taxAmount;
    }

    public static void main(String[] args) {

        double[] cutoff = { 0.0, 1000, 2000 };
        double[] rate = { 0.10, 0.5, 0.20 };
        double tax = 1500;

        marginal_tax app = new marginal_tax();
        System.out.println(app.marginal_tax(new double[]{0, 300.0}, new double[]{0.1, 0.2}, 2000.0) );
        System.out.println(app.marginal_tax(new double[]{0, 1000.0, 2000.0, 4000.0}, new double[]{0.1, 0.5, 0.2, 0.7}, 25000.0) );
        System.out.println(app.marginal_tax(new double[]{0, 1000.0, 2000.0}, new double[]{0.1, 0.5, 0.2}, 1500.0) );
        System.out.println(app.marginal_tax(cutoff, rate, tax) );
    }
}
