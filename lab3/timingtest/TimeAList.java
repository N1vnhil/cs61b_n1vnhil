package timingtest;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.Stopwatch;

import java.sql.Time;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        AList<Integer> timer = new AList<>();

        Stopwatch sw = new Stopwatch();
        for(int i=1; i<=128000; i++){
            timer.addLast(i);
            double f = Math.log(i*0.001)/Math.log(2);
            double timeInSeconds = sw.elapsedTime();
            if(f%1 == 0&&i>=1000){
                Ns.addLast(timer.size());
                times.addLast(timeInSeconds);
                opCounts.addLast(i);
            }
        }
        printTimingTable(Ns, times, opCounts);
    }
}
