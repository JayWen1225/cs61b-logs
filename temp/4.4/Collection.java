import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Collection{

    public Collection(){

    }
    
    public static List<String> getWords(String inputFile){
        List<String> lst = new ArrayList<String>();
        In in = new In(inputFile);
        while(!in.isEmpty()){
            lst.add(in.readString());
        }
        return lst;
    }

    public static int countUniqueWords(List<String> lst){
        Set<String> ss = new HashSet<String>();
        for ( String s : lst){
            ss.add(s);
        }

        return ss.size();
    }

    public static List<String> getTarget(List<String> lst){
        List<String> target = new ArrayList<String>();
        Set<String> ss = new HashSet<String>();
        for ( String s : lst){
            ss.add(s);
        }
        for (String s2: ss){
            target.add(s2);
        }
        return target;

    }

    public static Map<String, Integer> countWordCount(List<String> targets, List<String> lst){
        Map<String, Integer> map1 = new HashMap<String, Integer>();
        for (String s: targets){
            map1.put(s, 0);
        }

        for (String s2: lst){
            if( map1.containsKey(s2)){
                map1.put(s2, map1.get(s2) + 1);
            }
        }

        return map1;

    }

    public static void main(String args[]){
        String file1 = "../../library-sp19/data/words.txt";
        String file2 = "./words.txt";
        List<String> lst1 = Collection.getWords(file2);
        int size1 = Collection.countUniqueWords(lst1);
        List<String> target = Collection.getTarget(lst1);
        System.out.println(target);
        System.out.println(size1);

        Map<String, Integer> count = new HashMap<String, Integer>();
        count = Collection.countWordCount(target, lst1);
        System.out.println(count);

        

    }

}