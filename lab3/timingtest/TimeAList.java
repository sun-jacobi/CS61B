package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

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
        AList<Integer> lst = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        AList<Integer> Ns = new AList<>();
        int j = 1 ;
        Stopwatch sw = new Stopwatch();
        for (int i = 1 ; i <= 1000000; i++){
            lst.addLast(1);
            if(i == 1000* j){
                times.addLast(sw.elapsedTime());
                opCounts.addLast(1000*j);
                Ns.addLast(1000*j);
                j *= 2;
            }
        }
        printTimingTable(Ns, times,opCounts);

    }
}
