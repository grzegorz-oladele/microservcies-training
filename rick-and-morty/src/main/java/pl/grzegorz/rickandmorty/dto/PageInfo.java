package pl.grzegorz.rickandmorty.dto;

import lombok.Getter;

@Getter
public class PageInfo {

    private int count;
    private int pages;
    private String nextPage;
    private String previousPage;

    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }

    public void setPreviousPage(String previousPage) {
        this.previousPage = previousPage;
    }
}