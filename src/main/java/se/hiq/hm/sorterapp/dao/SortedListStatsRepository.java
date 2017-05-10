package se.hiq.hm.sorterapp.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import se.hiq.hm.sorterapp.domain.SortedListStats;

@Repository
public class SortedListStatsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<SortedListStats> findAll() {

        List<SortedListStats> result = jdbcTemplate.query(
                "SELECT id, nbofswaps, timetosortinmilliesec, created_date FROM sortedliststats",
                (rs, rowNum) -> new SortedListStats(rs.getInt("id"),
                		 rs.getInt("nbOfSwaps"), rs.getLong("timeToSortInMillieSec"), rs.getDate("created_date"))
        );

        return result;

    }

    public int addSortedList(int nbOfSwaps, long timeToSortInMillieSec) {

        return jdbcTemplate.update("INSERT INTO sortedliststats(nbofswaps, timetosortinmilliesec, created_date) VALUES (?,?,?)", 
        		nbOfSwaps, timeToSortInMillieSec, new Date());

    }

	public SortedListStats find(int idSortedList) {
		SortedListStats sortedList = jdbcTemplate.queryForObject(
				"SELECT nbofswaps, timetosortinmilliesec, created_date FROM sortedlist where id = ?", 
			    new Object[]{idSortedList},
			    (rs, rowNum) -> new SortedListStats(rs.getInt("id"),
               		 rs.getInt("nbOfSwaps"), rs.getLong("timeToSortInMillieSec"), rs.getDate("created_date"))
		        );
		return sortedList;
		 
	}
}
