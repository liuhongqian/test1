// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
package test;

import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution2
{        
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int minimumDays(int rows, int columns, List<List<Integer> > grid)
    {
        // WRITE YOUR CODE HERE
    	// First convert list of list to 2d array so it's easier to find and operate
        Integer[][] gridArray = new Integer[grid.size()][];
        Integer[] blankArray = new Integer[0];
        for(int i=0; i < grid.size(); i++) {
            gridArray[i] = grid.get(i).toArray(blankArray);
        }
        
        //use breadth first search algorithm
        //use Queue to help travel through the grid
		Queue<int[]> queue = new LinkedList<>();
		int numberOfTotalElement = gridArray.length * gridArray[0].length;
		int counter = 0, minimumDays = 0;
		
		//first, store all updated servers to the queue, and update counter
		for (int i = 0; i < gridArray.length; i++) {
			for (int j = 0; j < gridArray[0].length; j++) {
				if (gridArray[i][j] == 1) {
					// this server is updated, add its location to the queue
					queue.offer(new int[] { i, j });
					counter++;
				}
			}
		}
		
		
		int[][] adjacentServers = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		
		// loop through all elements in queue (updated servers)
		while (!queue.isEmpty()) {
			int size = queue.size();
			if (counter == numberOfTotalElement) {
				// we have traveled through all nodes in the grid, let's return
				return minimumDays;
			}
			
			for (int i = 0; i < size; i++) {
				// Retrieves and removes the head in queue
				int[] currentUpdatedServer = queue.poll();
				
				// check up, down, left and right adjacent servers, and update them if not updated.
				for (int[] currentAdjacent : adjacentServers) {
					int column = currentUpdatedServer[0] + currentAdjacent[0];
					int row = currentUpdatedServer[1] + currentAdjacent[1];
					if (column >= 0 && column < gridArray.length && row >= 0 && row < gridArray[0].length && gridArray[column][row] == 0) {
						// add newly updated server to queue, update counter, and mark this server as updated in gridArray
						counter++;
						queue.offer(new int[] { column, row });
						gridArray[column][row] = 1;
					}
				}
			}
			// increase minimumDays by one day
			minimumDays++;
		}
		// if none of servers are not updated initially, return -1 since it's mission impossible to update servers
		return -1;
	}
    // METHOD SIGNATURE ENDS
}