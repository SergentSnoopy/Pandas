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


    public void afficher(){
        String result="";
        Object[] index= this.data.keySet().toArray();
        for (Object o:index)
        {
            result+=o.toString()+",";
        }
        result=result.substring(0,result.length()-1);
        result+="\n";
        for (int i=0;i<this.data.get(index[0].toString()).size();i++)
        {
            for (int j=0;j<this.data.size();j++)
            {
                result+=this.data.get(index[j]).get(i)+",";
            }
            result=result.substring(0,result.length()-1);
            result+="\n";

        }
        System.out.println(result);
    }

    public void affichertete(){
        String result="";
        int nbligne;
        Object[] index= this.data.keySet().toArray();
        for (Object o:index)
        {
            result+=o.toString()+",";
        }
        result=result.substring(0,result.length()-1);
        result+="\n";
        if (this.data.get(index[0].toString()).size()<5)
            nbligne=this.data.get(index[0].toString()).size();
        else nbligne=5;
        for (int i=0;i<nbligne;i++)
        {
            for (int j=0;j<this.data.size();j++)
            {
                result+=this.data.get(index[j]).get(i)+",";
            }
            result=result.substring(0,result.length()-1);
            result+="\n";

        }
        System.out.println(result);
    }

    public void afficherqueue(){
        String result="";
        int nbligne;
        Object[] index= this.data.keySet().toArray();
        for (Object o:index)
        {
            result+=o.toString()+",";
        }
        result=result.substring(0,result.length()-1);
        result+="\n";
        if (this.data.get(index[0].toString()).size()<5)
            nbligne=this.data.get(index[0].toString()).size();
        else nbligne=5;
        for (int i=this.data.get(index[0].toString()).size()-nbligne;i<this.data.get(index[0].toString()).size();i++)
        {
            for (int j=0;j<this.data.size();j++)
            {
                result+=this.data.get(index[j]).get(i)+",";
            }
            result=result.substring(0,result.length()-1);
            result+="\n";

        }
        System.out.println(result);
    }


    public double moyennecollone(String nom)
    {
        double moy=0;
        for (int i=0;i<this.data.get(nom).size();i++) {
            moy =moy + Double.valueOf(this.data.get(nom).get(i).toString());
        }
        moy=moy/this.data.get(nom).size();
        return moy;
    }

    public double mincollone(String nom)
    {
        double min = Double.MAX_VALUE;
        for (int i=0;i<this.data.get(nom).size();i++) {
            if (min>Double.valueOf(this.data.get(nom).get(i).toString()))
                min=Double.valueOf(this.data.get(nom).get(i).toString());
        }

        return min;
    }

    public double maxcollone(String nom)
    {
        double max = -Double.MAX_VALUE;
        for (int i=0;i<this.data.get(nom).size();i++) {
            if (max<Double.valueOf(this.data.get(nom).get(i).toString()))
                max=Double.valueOf(this.data.get(nom).get(i).toString());

        }

        return max;
    }

    @Override
    public String toString() {
        return "Dataframe{" +
                "data=" + data +
                '}';
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
                for(int i=0;i<this.data.get(s).size();i++) {
                    if(this.data.get(s).size() != d.data.get(s).size())
                    {
                        return 0;
                    }
                    if (this.data.get(s).get(i) != d.data.get(s).get(i)) {
                        return 0;
                    }
                }
            }
            return 1;
        }
    }
}
