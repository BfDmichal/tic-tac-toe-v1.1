package logic;

import org.junit.Assert;
import org.junit.Test;

public class GameStatusTest {
    @Test
    public void EmptyListTest(){
        //Given
        //When
        Player[][] list= BoardOperator.startBoard();
        //Then
        Assert.assertEquals(3,list.length);
//        Assert.assertEquals(3,list.get(0).size());
//        Assert.assertEquals(3,list.get(1).size());
//        Assert.assertEquals(3,list.get(2).size());
    }
}