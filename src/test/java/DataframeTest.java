import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class DataframeTest {

    Dataframe d;
    @BeforeEach
    void setUp() {
        ArrayList<String> s =new ArrayList<String>();
        s.add("String1");
        s.add("String2");
        s.add("String3");
        ArrayList<Integer> i =new ArrayList<Integer>();
        i.add(1);
        i.add(2);
        i.add(3);
        HashMap<String,ArrayList> h= new HashMap<String, ArrayList>();
        h.put("0",s);
        h.put("1",i);
        d = new Dataframe(h);
    }

    @AfterEach
    void tearDown() {
        d=null;
    }

    @Test
    void constructeurTableau() {


        ArrayList<String> s =new ArrayList<String>();
        s.add("String1");
        s.add("String2");
        s.add("String3");
        ArrayList<Integer> i =new ArrayList<Integer>();
        i.add(1);
        i.add(2);
        i.add(3);
        HashMap<String,ArrayList> h= new HashMap<String, ArrayList>();
        h.put("0",s);
        h.put("1",i);
        Dataframe d2 = new Dataframe(s,i);
        Assertions.assertEquals(1,d.compareTo(d2));



    }


    @Test
    void CompareToTrue() {
        ArrayList<String> s =new ArrayList<String>();
        s.add("String1");
        s.add("String2");
        s.add("String3");
        ArrayList<Integer> i =new ArrayList<Integer>();
        i.add(1);
        i.add(2);
        i.add(3);
        HashMap<String,ArrayList> h= new HashMap<String, ArrayList>();
        h.put("0",s);
        h.put("1",i);
        Dataframe d2 =new Dataframe(s,i);
        Assertions.assertEquals(1,d.compareTo(d2));


    }
}