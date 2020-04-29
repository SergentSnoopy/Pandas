import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Prat Gary
 * @version 1.0
 * Ceci est un debut d'adaptation en java de la librairie pyhton Pandas
 *
 */
public class Dataframe implements Comparable {
    HashMap<String,ArrayList> data=new HashMap<String, ArrayList>();

    /**
     *Constructeur vide de l'objet
     *
     */
    public Dataframe() {

    }


    /**
     * Constructeur prenant en parametre une hashmap
     *
     * @param data
     */
    public Dataframe(HashMap<String, ArrayList> data) {
        this.data = data;
    }

    /**
     * Constructeur prenant en parametre les colonnes du dataframe
     * Le dataframe produit a pour label le numero correspondant a l'emplacement de l'arraylist dans la list de parametre
     *
     * @param colonne (ArrayList...)
     */

    public Dataframe(ArrayList... colonne) {

        int colname=0;
        for(ArrayList col:colonne)
        {
            this.data.put(String.valueOf(colname), col);
            colname++;
        }


    }

    /**
     *
     *
     * @param col nom des labels a copier
     * @param ligne nombre de lignes, pour chaque colonne a copier
     * @return un sous-dataframe cree a partir de l'objet appelant avec les colonnes correspondant a col et avec le nombre de lignes correspondant a lignes
     * @throws Exception
     */

    public Dataframe extraire(String[] col,int[] ligne) throws Exception {
        if (col.length!=ligne.length)
            throw new Exception("Parametre incoherent");
        else {
            Dataframe nd = new Dataframe();
            for (int i = 0; i < col.length; i++) {
                if (ligne[i] > this.data.get(col[i]).size()) {
                    throw new Exception("Nombre de ligne incoherent");
                } else {
                    nd.data.put(col[i], new ArrayList(this.data.get(col[i]).subList(0,ligne[i])));
                }
            }
            return nd;
        }
    }

    /**
     * Affiche le dataframe
     *
     *
     */

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


    /**
     * Affiche les 5 premiere lignes du dataframe
     *
     */
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


    /**
     * Affiche les 5 dernieres lignes du dataframe
     *
     */
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


    /**
     * Fait la moyenne des valeurs d'une colonne
     *
     * @param nom Label de la colonne
     * @return La moyenne de la colonne de label nom
     */
    public double moyennecollone(String nom)
    {
        double moy=0;
        for (int i=0;i<this.data.get(nom).size();i++) {
            moy =moy + Double.valueOf(this.data.get(nom).get(i).toString());
        }
        moy=moy/this.data.get(nom).size();
        return moy;
    }

    /**
     * Trouve le minimum des valeurs d'une colonne
     *
     * @param nom Label de la colonne
     * @return Le minimum de la colonne de label nom
     */
    public double mincollone(String nom)
    {
        double min = Double.MAX_VALUE;
        for (int i=0;i<this.data.get(nom).size();i++) {
            if (min>Double.valueOf(this.data.get(nom).get(i).toString()))
                min=Double.valueOf(this.data.get(nom).get(i).toString());
        }

        return min;
    }


    /**
     * Trouve le maximun des valeurs d'une colonne
     *
     * @param nom Label de la colonne
     * @return Le maximun de la colonne de label nom
     */
    public double maxcollone(String nom)
    {
        double max = -Double.MAX_VALUE;
        for (int i=0;i<this.data.get(nom).size();i++) {
            if (max<Double.valueOf(this.data.get(nom).get(i).toString()))
                max=Double.valueOf(this.data.get(nom).get(i).toString());

        }

        return max;
    }


    /**
     * ToString
     * @return
     */
    @Override
    public String toString() {
        return "Dataframe{" +
                "data=" + data +
                '}';
    }


    /**
     * Comparaison de deux dataframe
     * @param o
     * @return 0 si leur contenue est different, 1 si ils sont identique
     */
    public int compareTo(Object o) {
        Dataframe d =(Dataframe) o;
        if(this.data.size()!=d.data.size())
        {
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
