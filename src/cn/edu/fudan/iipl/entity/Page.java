package cn.edu.fudan.iipl.entity;

public class Page {
	private int page = 1;
	private int pageSize = 5;
	private int totalPage =1;
	
	public int getBegin(){
		return (page-1)*pageSize;
	}
	
	public int getEnd(){
		return page*pageSize+1;
	}
	
	public int getPage(){
		return page;
	}
	public void setPage(int page){
		this.page = page;
	}
	public int getPageSize(){
		return pageSize;
	}
	public void setPageSize(int pageSize){
		this.pageSize= pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	
}
