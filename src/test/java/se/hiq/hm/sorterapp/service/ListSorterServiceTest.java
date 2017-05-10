package se.hiq.hm.sorterapp.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import se.hiq.hm.sorterapp.dao.SortedListStatsRepository;
import se.hiq.hm.sorterapp.domain.SortedListStats;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ListSorterServiceTest {

	private static final int ID = 0;
	
	@MockBean
	SortedListStatsRepository sortedListStatsRepository;
	
	@Autowired
	ListSorterService listSorterService;
	
	@Test
	public void test() {
		SortedListStats sortedListStats = new SortedListStats();
		Mockito.when(sortedListStatsRepository.find(ID)).thenReturn(sortedListStats);
		SortedListStats stats = listSorterService.getSortedList(ID);
		assertEquals(stats, sortedListStats);
	}

}
