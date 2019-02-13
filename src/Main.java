import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import structures.Heap;

/**
 *
 * @author David
 */
public class Main {
    public static void main(String[] args) throws IOException{  
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n;
        Heap heap = new Heap(true);
        while((n = Integer.parseInt(in.readLine())) != 0) {
            heap.insert(n);
        }
        while(!heap.isEmpty()) {
            System.out.printf("%d ", heap.remove());
        }
    }
}
