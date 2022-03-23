package programmers.highscorekit.hash;

import java.util.*;

class HashTable {
    class Node{
        String key;
        int value;
        public Node(String key, int value)
        {
            this.key= key;
            this.value = value;

        }
        int value()
        {
            return value;
        }
        void value(int value)
        {
            this.value= value;
        }
    }
    LinkedList<Node>[] data;
    HashTable(int size)
    {
        this.data = new LinkedList[size];
    }
    int getHashCode(String key)
    {
        int hashcode = 0;
        for(char c: key.toCharArray())
        {
            hashcode += c;
        }
        return hashcode;
    }
    int convertToIndex(int hashcode)
    {
       return hashcode%data.length; // hash코드를 배열방의 크기로 나눈 나머지가 index가 된다.
    }

    Node searchKey(LinkedList<Node> list , String key)
    {
        if(list == null) return null;
        for(Node node : list)
        {
            if(node.key.equals(key))
            {
                return node;
            }
        }
        return null;
    }

    void put (String key, int value)
    {
        int hashcode = getHashCode(key);
        int index = convertToIndex(hashcode);
        LinkedList<Node> list = data[index];
        if(list == null)
        {
            list = new LinkedList<Node>();
            data[index]= list;
        }
        Node node = searchKey(list,key);
        if(node == null)
        {
            list.addLast(new Node(key,value));
        }else {
            node.value(value);
        }

    }
    int get(String key)
    {
        int hashcode=  getHashCode(key);
        int index = convertToIndex(hashcode);
        LinkedList<Node> list =data[index];
        Node node = searchKey(list,key);
        return node == null?   -1 : node.value();
    }


}
public class hash1 {
    public static void main(String args[]) {
        String[] parti = {"leo","kiki","eden"};
        String[] comp = {"eden","kiki"};
        String result = solution(parti,comp);
        System.out.println(result);

    }

    public static String solution(String[] participant, String[] completion) {
        String result = "";
        Set<String> set = new HashSet<>(Arrays.asList(participant));
        int size = set.size();
        HashTable hashTable  = new HashTable(size);
        for (int i = 0; i < participant.length; i++) {
            if(hashTable.get(participant[i]) == -1)
            {
                hashTable.put(participant[i],1);
            }else {
                int count =hashTable.get(participant[i]);
                hashTable.put(participant[i], count +1);
            }
        }
        for(int i = 0; i< completion.length; i++)
        {
            int count = hashTable.get(completion[i]);
            count -= 1;
            if(count == 0)
            {
                set.remove(completion[i]);
            }else {
                hashTable.put(completion[i], count);
            }
        }

        Iterator<String> iter = set.iterator();
        result = iter.next();
        return result;

    }

    public static String solution2(String[] participant, String[] completion) {
        String result = "";
        Set<String> set = new HashSet<>(Arrays.asList(participant));
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int size = set.size();
        for (String str : participant)
        {
            if(map.containsKey(str))
            {
                int count = map.get(str);
                map.put(str, count + 1);
            }
            else {
                map.put(str,1);
            }
        }
        for(String str : completion)
        {
            if(map.containsKey(str))
            {
                int count = map.get(str) -1 ;
                if(count ==0 )
                {
                    set.remove(str);
                }else {
                    map.put(str,count);
                }

            }
        }

        Iterator<String> iter = set.iterator();
        result = iter.next();
        return result;

    }

}
