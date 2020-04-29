import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
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
        s.add("String4");
        s.add("String5");
        s.add("String6");
        ArrayList<Integer> i =new ArrayList<Integer>();
        i.add(1);
        i.add(2);
        i.add(3);
        i.add(4);
        i.add(5);
        i.add(6);
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
        s.add("String4");
        s.add("String5");
        s.add("String6");
        ArrayList<Integer> i =new ArrayList<Integer>();
        i.add(1);
        i.add(2);
        i.add(3);
        i.add(4);
        i.add(5);
        i.add(6);
        HashMap<String,ArrayList> h= new HashMap<String, ArrayList>();
        h.put("0",s);
        h.put("1",i);
        Dataframe d2 = new Dataframe(s,i);
        Assertions.assertEquals(1,d.compareTo(d2));



    }

    @Test
    void MinTest() {
        Assertions.assertEquals(1,d.mincollone("1"));
    }

    @Test
    void MaxTest() {
        Assertions.assertEquals(6,d.maxcollone("1"));
    }

    @Test
    void name() throws IOException {

        d.afficher();
        d.affichertete();
        d.afficherqueue();
        Assertions.assertEquals(0,0);
    }

    @Test
    void MoyenneTest() {
        Assertions.assertEquals(3.5,d.moyennecollone("1"));
    }

    @Test
    void CompareToTrue() {
        ArrayList<String> s =new ArrayList<String>();
        s.add("String1");
        s.add("String2");
        s.add("String3");
        s.add("String4");
        s.add("String5");
        s.add("String6");
        ArrayList<Integer> i =new ArrayList<Integer>();
        i.add(1);
        i.add(2);
        i.add(3);
        i.add(4);
        i.add(5);
        i.add(6);
        HashMap<String,ArrayList> h= new HashMap<String, ArrayList>();
        h.put("0",s);
        h.put("1",i);
        Dataframe d2 =new Dataframe(s,i);
        Assertions.assertEquals(1,d.compareTo(d2));


    }
}