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
        SLList<Integer> ls = new SLList<>();

        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> ops = new AList<>();


        for(int i=1; i<=128000; i++){
            double f = Math.log(i*0.001)/Math.log(2);
            if(f%1 == 0&&i>=1000){
                Ns.addLast(i);
            }
        }


        for(int i=1; i<=Ns.size(); i++){
            int n = Ns.get(i-1);
            for(int j = 0; j<n; j++){
                ls.addFirst(0);
            }
            Stopwatch sw = new Stopwatch();
            for(int j=0; j<10000; j++){
                ls.getLast();
            }
            times.addLast(sw.elapsedTime());
            ops.addLast(10000);
        }
        printTimingTable(Ns, times, ops);
    }

}
