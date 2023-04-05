package codefun.experiment;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Dice simulation
 */
public class E1_1_35 {
    static final int SIDES = 6;

    static double[] calc()
    {
        double[] dist = new double[2*SIDES+1];
        for (int i = 1; i <= SIDES; i++)
            for (int j = 1; j <= SIDES; j++)
                dist[i+j] += 1.0;
        for (int k = 2; k <= 2*SIDES; k++)
            dist[k] /= 36.0;
        return dist;
    }

    static double[] test(int n)
    {
        double[] dist = new double[2*SIDES+1];
        for(int i=0; i<n; i++) {
            int sum = StdRandom.uniformInt(1,6);
            sum += StdRandom.uniformInt(1,6);
            dist[sum] += 1.0/n;
        }
        return dist;
    }

    public static void main(String[] args)
    {
//        int n = Integer.parseInt(args[0]);
        int n = 1000000;
        var dist1 = calc();
        var dist2 = test(n);
        for(int i=0; i<dist1.length; i++) {
            System.out.printf("%.4f\t%.4f\t%.4f\n", dist1[i], dist2[i], dist1[i]-dist2[i]);
        }
    }
}
