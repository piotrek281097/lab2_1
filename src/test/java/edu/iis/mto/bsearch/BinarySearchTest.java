package edu.iis.mto.bsearch;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.empty;
import static org.junit.Assert.*;

public class BinarySearchTest {

    private static final int wantedElement = 8;
    private static final int[] seqTest1 = {8};
    private static final int[] seqTest2 = {1};
    private static final int[] seqTest3 = {8,9,10,15,20};
    private static final int[] seqTest4 = {1,3,5,6,7,8};

    private SearchResult searchResult;

    @Before
    public void setup() {
        searchResult = new SearchResult();
    }

    @Test
    public void binarySearchShouldReturnThatElementIsFoundInSequenceOf1() {
        searchResult = BinarySearch.search(wantedElement, seqTest1);
        assertTrue(searchResult.isFound());
    }

    @Test
    public void binarySearchShouldReturnThatElementIsNotFoundInSequenceOf1() {
        searchResult = BinarySearch.search(wantedElement, seqTest2);
        assertFalse(searchResult.isFound());
    }

    @Test
    public void binarySearchShouldReturnWantedElementAsFirstElementInSequenceOfLengthGraterThan1() {
        searchResult = BinarySearch.search(wantedElement, seqTest3);
        assertEquals(0, searchResult.getPosition());
    }

    @Test
    public void binarySearchShouldReturnWantedElementAsLastElementInSequenceOfLengthGraterThan1() {
        searchResult = BinarySearch.search(wantedElement, seqTest4);
        assertEquals(seqTest4.length - 1, searchResult.getPosition());
    }





}
