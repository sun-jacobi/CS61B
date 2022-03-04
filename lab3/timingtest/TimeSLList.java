package timingtest;
import edu.princeton.cs.algs4.Stopwatch;
import net.sf.saxon.om.Item;

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
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        AList<Integer> Ns = new AList<>();
        int j = 1;
        for (int i = 0; i <= 7; i++) {
            SLList<Integer> lst = new SLList<>();
            for (int k = 1; k <= 1000 * j; k++) {
                lst.addLast(1);
            }
            Stopwatch sw = new Stopwatch();
            for (int k = 1; k <= 10000; k++) {
                int a = lst.getLast();
            }
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
            opCounts.addLast(10000);
            Ns.addLast(1000 * j);
            j *= 2;
        }
        printTimingTable(Ns,times,opCounts);
    }
}
