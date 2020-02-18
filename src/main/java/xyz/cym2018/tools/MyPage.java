package xyz.cym2018.tools;

import java.util.ArrayList;
import java.util.List;

public class MyPage<T> {
    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    //return objectMapper.writeValueAsString(new MyPage<Table1>(list, pageSize, pageNumber));
    public MyPage(List<T> list, int pageSize, int pageNumber, T statistics, T counts) {
        setPageSize(pageSize);
        totalElements = list.size();
        // 计算总页数
        totalPages = totalElements / pageSize + (totalElements % pageSize == 0 ? 0 : 1);
        // 分页
        content = new ArrayList<T>();
        for (int i = pageSize * pageNumber; i < pageSize * (pageNumber + 1) && i < list.size(); i++) {
            content.add(list.get(i));
        }
        // 统计
        setStatistics(statistics);
        setCounts(counts);
    }

    private List<T> content;
    private int totalPages;
    private int totalElements;
    private T statistics;
    private int pageSize;

    public T getStatistics() {
        return statistics;
    }

    public void setStatistics(T statistics) {
        this.statistics = statistics;
    }

    public T getCounts() {
        return counts;
    }

    public void setCounts(T counts) {
        this.counts = counts;
    }

    private T counts;
}
