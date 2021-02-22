package com.example.demo.model.request;

public class Pagination {
	private int page;
	private int limit;
	private long totalRows;
	
	
	
	
	public Pagination() {
		super();
	}
	public Pagination(int page, int limit, long totalRows) {
		super();
		this.page = page;
		this.limit = limit;
		this.totalRows = totalRows;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public long getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(long totalRows) {
		this.totalRows = totalRows;
	}
	

}
