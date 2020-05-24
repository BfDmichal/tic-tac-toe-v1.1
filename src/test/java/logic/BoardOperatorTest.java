package logic;

import org.junit.Test;

public class BoardOperatorTest {
    @Test
    public void copyListTest(){
        //Given
        Player[][] list = new Player[3][3];
        Player[] list2 = new Player[3];
        list2[0]= Player.x;
        list[0]=list2;
        //When
        Player[][] list1 = BoardOperator.deepCopy(list);
//        list1.get(0).add(0,Player.EMPTY);
//        //Then
//        //list1.remove(0);
//        System.out.println(list1.get(0).get(0));
//        System.out.println(list2.get(0));
//        System.out.println(list1.size());
//        System.out.println(list.size());
//        Assert.assertEquals(1,list.size());
//        Assert.assertEquals(0,list1.);
    }

}