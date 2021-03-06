package datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Ajinkya Patil
 * @see datastructures.APriorityQueue
 */
public class APriorityQueueDemo {
	public static void main(String[] args) throws IOException {
		APriorityQueue queue = new APriorityQueue();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("\nQueue Operations");
			System.out.println(
					"(1) Insert (2) Find max (3) Extract max (4) Print (5) Exit");
			int option = Integer.parseInt(in.readLine());
			switch (option) {
			case 1:
				System.out.print("Insert? ");
				int value = Integer.parseInt(in.readLine());
				System.out.print("Priority? ");
				int priority = Integer.parseInt(in.readLine());
				queue.add(value, priority);
				break;
			case 2:
				System.out.println("Found: " + queue.peek());
				break;
			case 3:
				System.out.println("Removed: " + queue.remove());
				break;
			case 4:
				queue.print();
				break;
			case 5:
				return;
			default:
				System.out.println("ERROR: Invalid option!");
			}
		}
	}
}