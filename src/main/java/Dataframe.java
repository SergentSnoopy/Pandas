import java.util.ArrayList;
import java.util.HashMap;

public class Dataframe implements Comparable {
    HashMap<String,ArrayList> data=new HashMap<String, ArrayList>();

    public Dataframe() {

    }

    public Dataframe(HashMap<String, ArrayList> data) {
        this.data = data;
    }

    public Dataframe(ArrayList... colonne) {

        int colname=0;
        for(ArrayList col:colonne)
        {
            this.data.put(String.valueOf(colname), col);
            colname++;
        }


    }

    public int compareTo(Object o) {
        Dataframe d =(Dataframe) o;
        if(this.data.size()!=d.data.size())
        {
            System.out.println("0");
            return 0;
        }
        else{
            for(String s:this.data.keySet())
            {
                for(int i=0;i<this.data.get(s).size();i++)
                if(this.data.get(s).get(i)!=d.data.get(s).get(i))
                {
                    return 0;
                }

            }
            return 1;
        }
    }
}
