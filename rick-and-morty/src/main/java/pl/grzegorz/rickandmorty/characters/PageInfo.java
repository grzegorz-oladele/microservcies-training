package pl.grzegorz.rickandmorty.characters;

import lombok.Getter;

@Getter
class PageInfo {

    private int count;
    private int pages;
    private String nextPage;
    private String previousPage;

    void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }

    void setPreviousPage(String previousPage) {
        this.previousPage = previousPage;
    }
}