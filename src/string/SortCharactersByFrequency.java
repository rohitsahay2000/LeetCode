/*

Sort Characters By Frequency
Solution
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

 */

package com.rohit.strings;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

    public String frequencySort(String s) {

        HashMap<Character,Pair> mMap = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.count.compareTo(o1.count);
            }
        });

        for(int i=0; i<s.length(); i++) {
            if(!mMap.containsKey(s.charAt(i))) {
                mMap.put(s.charAt(i),new Pair(s.charAt(i),1));
            }
            else {
                Pair pair = mMap.get(s.charAt(i));
                pair.count++;
                mMap.put(s.charAt(i), pair);
            }
        }

        for(Map.Entry<Character,Pair> entry : mMap.entrySet()) {
            pq.add(entry.getValue());
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Pair pair = pq.poll();
            int count =pair.count;

            while(count >0) {
                sb.append(pair.c);
                count--;
            }
        }

        return sb.toString();
    }
}

class Pair {
    Character c;
    Integer count;

    Pair(Character c, int count) {
        this.c=c;
        this.count=count;
    }
}


