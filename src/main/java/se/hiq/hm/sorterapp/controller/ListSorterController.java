package se.hiq.hm.sorterapp.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import se.hiq.hm.sorterapp.domain.SortedListStats;
import se.hiq.hm.sorterapp.service.ListSorterService;

@Controller
public class ListSorterController {

	@Autowired
	private ListSorterService listSorterService;
	
    @RequestMapping("/sort")
    public String sort(@RequestParam(value="size", required=false, defaultValue="10") int sizeOfList, Model model) {
    	
    	
    	SortedListStats sortedList = getSortedList(sizeOfList);
    	
    	listSorterService.addSortedList(sortedList.getNbOfSwaps(), sortedList.getTimeToSortInMillieSec());
    	
    	model.addAttribute("nbOfSwaps", sortedList.getNbOfSwaps());
    	model.addAttribute("timeOfSortingInMillieSec", sortedList.getTimeToSortInMillieSec());
        
    	return "sorting";
    }
    
    @RequestMapping("/sortedlists")
    public String sortedlists(Model model) {
    		
    	model.addAttribute("sortedlists", listSorterService.getSortedLists());
        
    	return "sortedlist";
    }
    
    private Integer[] createListToSort(int numberOfValues) {
		Integer listToSort[] = new Integer [numberOfValues] ;
		for(int number = 0; number < numberOfValues; number++){
			  listToSort[number] = number;
		}
		
		Collections.shuffle(Arrays.asList(listToSort));
		
		return listToSort;
	}
	
	public boolean isSorted(Integer listToSort[]){  
	    boolean isSorted = true;
		if(listToSort != null && listToSort.length != 0){
	    	for(int value=0; value< listToSort.length-1; value++){
		        if(listToSort[value] > listToSort[value+1]){
		        	isSorted = false;
		        	break;
		        }
		    }
	    }
		
	    return isSorted;
	}

	public SortedListStats getSortedList(int numberOfValues) {
		
		SortedListStats sortedList = new SortedListStats() ;
		  	
        long startTime = System.nanoTime();

        Integer listToSort[] = createListToSort(numberOfValues);
        
        sortedList.setNbOfSwaps(getNbOfSwapRandomValuesUntilSorted(listToSort));
        
        long endTime = System.nanoTime();
        
		sortedList.setTimeToSortInMillieSec((endTime-startTime)/1000000);
		
	    return sortedList;
    }

	private int getNbOfSwapRandomValuesUntilSorted(Integer listToSort[]) {
		int nbOfSwaps = 0;
		do{
        	int firstValue = new Random().nextInt(listToSort.length);
        	int secondValue = new Random().nextInt(listToSort.length); 
        	nbOfSwaps = nbOfSwaps + swapValues(firstValue, secondValue, listToSort);
		}
		while(!isSorted(listToSort));
		
		return nbOfSwaps;
	}

	private int swapValues(int firstRandomNumber, int secondRandomNumber, Integer listToSort[]) {
		int temp = 0;
		int nbOfSwaps = 0;
		if(listToSort[firstRandomNumber] > listToSort[secondRandomNumber]){
			temp = listToSort[firstRandomNumber];
			listToSort[firstRandomNumber] = listToSort[secondRandomNumber];
			listToSort[secondRandomNumber] = temp;
			nbOfSwaps++;
		}
		return nbOfSwaps;
	}
	
}
