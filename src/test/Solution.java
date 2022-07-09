package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{        
 // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
 List<List<String> > threeProductSuggestions(int numProducts, 
                                             List<String> repository, 
                                             String customerQuery)
 {
        // WRITE YOUR CODE HERE
	 	List<List<String>> output = new ArrayList();
	 	Collections.sort(repository); 
	 	String currentQueryString;
	 	for (int i = 1; i < customerQuery.length(); i++){
	 		currentQueryString = customerQuery.substring(0, i);
		 	int j = 0;
		 	List<String> temp = new ArrayList();
		 	for(String item : repository){
		 		if (j< 3 && item.startsWith(currentQueryString)) {
		 			temp.add(item);
		 		}
		 		j++;
			}
		 	output.add(temp);
	 	}
    return output;
 }
 // METHOD SIGNATURE ENDS
}