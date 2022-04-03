package com.example.centennialsiqtest;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void check_test(){

    }

    @Test
    public void numbers_test(){
        assertEquals(Helper.pattern.length,Helper.numbers().length);
    }

    @Test
    public void getScore_test(){
        Helper.score = 5;
        assertEquals(5,Helper.getScore());
    }

    @Test
    public void getOrder(){
        Helper.order = 5;
        assertEquals(5,Helper.getOrder());
    }

    @Test
    public void getfinalpatternlength_test(){
        assertEquals(Helper.pattern.length,Helper.getfinalpatternlength());
    }

    @Test
    public void getpatternlength_test(){
        assertEquals(Helper.checkpattern.length,Helper.getpatternlength());
    }

    @Test
    public void getLives_test(){
        Helper.hearts = 5;
        assertEquals(5,Helper.getLives());
    }

    @Test
    public void getHIghScore_test(){
        Helper.highscore = 5;
        assertEquals(5,Helper.getHighScore());
    }

    @Test
    public void getSpeed_test(){
        Helper.ms = 500;
        assertEquals(500,Helper.getSpeed());
    }

    @Test
    public void reset_test(){
        Helper.score = 5;
        Helper.reset();
        assertEquals(0,Helper.score);
    }

    @Test
    public void StringToStock_test(){
        assertEquals("$174.31 ",Helper.StringToStock("79 TSX 21,952.95 0.29% AAPL • NASDAQ Apple Inc Follow Share $174.31 After Hours: $174.00( 0.18%)-0.31 Closed: Apr 1, 7:59:58 PM"));
    }
}