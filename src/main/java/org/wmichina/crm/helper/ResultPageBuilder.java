package org.wmichina.crm.helper;

import java.util.List;

public class ResultPageBuilder<T> implements java.io.Serializable {

	private static final long serialVersionUID = 8282626220698708152L;

	private List<T> resultSet;
	
	private int allRows;
	private int pageSize=20;
	private int pageCount;
	private int currentPage;
	private int start;
	private int end;
	
	public ResultPageBuilder(int allRows, int pageSize, int currentPage){
		this.allRows = allRows;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.pageCount =(int) Math.ceil((double)allRows/pageSize);

		if(currentPage == 1){
			this.start = 0;
			this.end = pageSize;
		}else {
			this.start = (currentPage - 1) * pageSize;
			this.end = pageSize;
		}
	}
	
	public int getAllRows() {
		return allRows;
	}

	public void setAllRows(int allRows) {
		this.allRows = allRows;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<T> getResultSet() {
		return resultSet;
	}

	public void setResultSet(List<T> resultSet) {
		this.resultSet = resultSet;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}


}
