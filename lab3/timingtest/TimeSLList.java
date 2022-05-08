package timingtest;

import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        SLList<Integer> slList = new SLList<>();
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        int k = 0;
        int ops = 1000;
        for (int i = 0; i < 128000; i++) {
            slList.addLast(i);
            if (slList.size() == Math.pow(2, k) * 1000) {
                Stopwatch sto = new Stopwatch();
                for (int j = 0; j < ops; j++) {
                    slList.getLast();
                }
                times.addLast(sto.elapsedTime());
                Ns.addLast(slList.size());
                opCounts.addLast(ops);
                k++;
            }
        }
        printTimingTable(Ns, times, opCounts);
    }

}
