import java.util.Comparator;

public class ProcessorComparator implements Comparator{//find which processor has higher priority using compareTo from class Processor
	
	@Override
	public int compare(Object a, Object b) {
		Processor pa = (Processor) a;
		Processor pb = (Processor) b;
		if (pa.compareTo(pb)) {
			return -1;
		}
		return 1;
	}
}