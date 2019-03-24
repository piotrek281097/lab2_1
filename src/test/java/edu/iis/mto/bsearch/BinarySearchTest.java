package edu.iis.mto.bsearch;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    private static final int WANTED_ELEMENT = 8;
    private static final int[] SEQ_TEST1 = {8};
    private static final int[] SEQ_TEST2 = {1};
    private static final int[] SEQ_TEST3 = {8,9,10,15,20};
    private static final int[] SEQ_TEST4 = {1,3,5,6,7,8};
    private static final int[] SEQ_TEST5 = {6,7,8,9,10};
    private static final int[] SEQ_TEST6 = {1,2,3,4,5};

    private SearchResult searchResult;

    @Before
    public void setup() {
        searchResult = new SearchResult();
    }

    @Test
    public void binarySearchShouldReturnThatElementIsFoundInSequenceOf1() {
        searchResult = BinarySearch.search(WANTED_ELEMENT, SEQ_TEST1);
        assertThat(searchResult.isFound(), Matchers.is(true));
    }

    @Test
    public void binarySearchShouldReturnThatElementIsNotFoundInSequenceOf1() {
        searchResult = BinarySearch.search(WANTED_ELEMENT, SEQ_TEST2);
        assertThat(searchResult.isFound(), Matchers.is(false));
    }

    @Test
    public void binarySearchShouldReturnWantedElementAsFirstElementInSequenceOfLengthGraterThan1() {
        searchResult = BinarySearch.search(WANTED_ELEMENT, SEQ_TEST3);
        assertThat(searchResult.getPosition(), Matchers.is(0));
    }

    @Test
    public void binarySearchShouldReturnWantedElementAsLastElementInSequenceOfLengthGraterThan1() {
        searchResult = BinarySearch.search(WANTED_ELEMENT, SEQ_TEST4);
        assertThat(searchResult.getPosition(), Matchers.is(SEQ_TEST4.length - 1));
    }

    @Test
    public void binarySearchShouldReturnWantedElementAsMiddleElementInSequenceOfLengthGraterThan1() {
        searchResult = BinarySearch.search(WANTED_ELEMENT, SEQ_TEST5);
        assertThat(searchResult.getPosition(), Matchers.is(SEQ_TEST5.length / 2));
    }

    @Test
    public void binarySearchShouldReturnThatElementIsNotFoundInSequenceOfLengthGraterThan1() {
        searchResult = BinarySearch.search(WANTED_ELEMENT, SEQ_TEST6);
        assertThat(searchResult.isFound(), Matchers.is(false));
    }

    @Test (expected = IllegalArgumentException.class)
    public void binarySearchShouldThrowIllegalArgumentExceptionIfSequenceIsEmpty () {
        searchResult = BinarySearch.search(WANTED_ELEMENT, new int[0]);
    }


}
