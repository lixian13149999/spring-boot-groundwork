//package com.bcdbook.common.util;
//
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * Created by wuyifeng
// * 分页
// */
//public class GridPaging {
//    private int page=1;
//
//    private int pageSize=15;
//
//    private Sort sort;
//
//    public Pageable genPageable(){
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        page = request.getParameter("page")!=null?Integer.parseInt(request.getParameter("page")):page;
//        pageSize = request.getParameter("pageSize")!=null?Integer.parseInt(request.getParameter("pageSize")):pageSize;
//        return new PageRequest(page-1, pageSize , sort);
//    }
//
//    public int getPage() {
//        return page;
//    }
//
//    public void setPage(int page) {
//        this.page = page;
//    }
//
//    public int getPageSize() {
//        return pageSize;
//    }
//
//    public void setPageSize(int pageSize) {
//        this.pageSize = pageSize;
//    }
//
//	public Sort getSort() {
//		return sort;
//	}
//
//	public void setSort(Sort sort) {
//		this.sort = sort;
//	}
//
//}
