package net.seocoo.ggys.core.base;

import java.util.List;

/**
 * @Author xieheng
 * @Data 2018/5/24
 * @Email xieheng91@163.com
 * @Desc 分页封装
 */
public class PageBean<T> {
  private Integer pageNum;//当前页
  private Integer pageSize;//页大小
  private Integer count;//总条数
  private Integer totalPage;//总页数
  private List<T> list;//分页结果


  public Integer getPageNum() {
    return pageNum;
  }

  public void setPageNum(Integer pageNum) {
    this.pageNum = pageNum;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public Integer getTotalPage() {
    return totalPage;
  }

  public void setTotalPage(Integer totalPage) {
    this.totalPage = totalPage;
  }

  public List<T> getList() {
    return list;
  }

  public void setList(List<T> list) {
    this.list = list;
  }

  public PageBean(Integer pageNum, Integer pageSize, Integer count, List<T> list) {
    this.pageNum = pageNum;
    this.pageSize = pageSize;
    this.count = count;
    this.totalPage = (this.count + this.pageSize - 1) / this.pageSize;
    this.list = list;
  }
  public PageBean(List<T> list,Integer pageNum, Integer pageSize, Integer count) {
    this.list = list;
    this.pageNum = pageNum;
    this.pageSize = pageSize;
    this.count = count;
    this.totalPage = (this.count + this.pageSize - 1) / this.pageSize;
  }
}
