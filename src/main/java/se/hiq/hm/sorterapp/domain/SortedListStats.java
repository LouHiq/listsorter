package se.hiq.hm.sorterapp.domain;

import java.util.Date;

public class SortedListStats {
	
	private int id;
	
	private int nbOfSwaps;
	
	private long timeToSortInMillieSec;

	private Date createDate;
	
	public SortedListStats(int id, int nbOfSwaps, long timeToSortInMillieSec, Date createDate) {
		this.id = id;
		this.nbOfSwaps = nbOfSwaps;
		this.timeToSortInMillieSec = timeToSortInMillieSec;
		this.createDate = createDate;
	}
	
	public SortedListStats() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getNbOfSwaps() {
		return nbOfSwaps;
	}

	public void setNbOfSwaps(int nbOfSwaps) {
		this.nbOfSwaps = nbOfSwaps;
	}

	public long getTimeToSortInMillieSec() {
		return timeToSortInMillieSec;
	}

	public void setTimeToSortInMillieSec(long timeToSortInMillieSec) {
		this.timeToSortInMillieSec = timeToSortInMillieSec;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
