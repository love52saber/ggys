package net.seocoo.ggys.module.merchant.dto;

import java.util.List;

/**
 * @author ZengXiaoLiang
 * @date 2018/6/19 11:41
 **/
public class H5CMerchantBaseDTO<T> {
  private Long count;
  private Integer pageNum;
  private Integer pageSize;
  private Integer totalPage;
  private List<T> list;

  public Long getCount() {
    return count;
  }

  public void setCount(Long count) {
    this.count = count;
  }

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

  public Integer getTotalPage() {
    if (getCount() > 0) {
      if (getCount() % getPageSize() == 0) {
        this.totalPage = getCount().intValue() / getPageSize();
      }

      if (getCount() % getPageSize() != 0) {
        this.totalPage = (getCount().intValue() / getPageSize()) + 1;
      }
    }
    return this.totalPage!=null?this.totalPage:0;
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
}
