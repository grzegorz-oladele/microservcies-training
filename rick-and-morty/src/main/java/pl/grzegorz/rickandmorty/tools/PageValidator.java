package pl.grzegorz.rickandmorty.tools;

import org.springframework.stereotype.Component;

@Component
public class PageValidator {

    public void checkPageNumberValueIsLessOrEqualThanZeroAndMoreThanNumberOfPagesAndThrowExceptionIfIs(int pageNumber,
                                                                                                       int numberOfPages) {
        if (pageNumber <= 0 || pageNumber > numberOfPages) {
            throw new IllegalArgumentException("Page number isn't correct");
        }
    }
}