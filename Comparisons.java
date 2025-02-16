
public class Comparisons {
    public static void main(String[] args){
    	String filename = args[0];//read the filename
    	int make1,make2;
        int makespan1= MGreedy.get_makespan(filename);//call MGreedy for the txt 
        make1 = makespan1;//store the makespan
        System.out.println("");
        int makespan2= MSortGreedy.get_makespan(filename);//call MSortGreedy for the txt
        make2 = makespan2;//store the makespan
        System.out.println("\nMakespan for the " + filename + " is:\n" + make1 + " using Greedy\n" + make2 + " using SortGreedy");//print analytically the results
        if (make1>make2) {
        	System.out.println("\nGreedy-Decreasing is better");
        }else if (make1<make2){
        	System.out.println("\nGreedy is better");
        }else {
        	System.out.println("\nBoth of them are the same");
        }
    }
}