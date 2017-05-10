package se.hiq.hm.sorterapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.hiq.hm.sorterapp.dao.SortedListStatsRepository;
import se.hiq.hm.sorterapp.domain.SortedListStats;

@Service
public class ListSorterService {
	
	@Autowired
	SortedListStatsRepository sortedListStatsRepository;

	public List<SortedListStats> getSortedLists() {
		return sortedListStatsRepository.findAll();
	}
	
	public int addSortedList(int nbOfSwaps, long timeToSortInMillieSec){
		return sortedListStatsRepository.addSortedList(nbOfSwaps, timeToSortInMillieSec);
	}

	public SortedListStats getSortedList(int idSortedList) {
		return sortedListStatsRepository.find(idSortedList);
	}
	
}
