/*
 * Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * 
 */


package com.rohit.extras;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public static void main(String[] args) {

        int nums[] = {2, 2, 3, 1, 1, 1, 4, 4, 4};

        System.out.println(new TopKFrequentElements().topKFrequent(nums, 2));
    }


    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> resultList = new ArrayList<Integer>();

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.frequency.compareTo(o2.frequency);
            }
        });

        Map<Integer, Integer> mMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (mMap.containsKey(nums[i])) {
                mMap.put(nums[i], mMap.get(nums[i]) + 1);
            } else {
                mMap.put(nums[i], 1);
            }

        }


        for (Entry<Integer, Integer> entry : mMap.entrySet()) {
            if (pq.size() >= k) {
                if (entry.getValue() > pq.peek().frequency) {
                    pq.poll();
                    pq.add(new Pair(entry.getKey(), entry.getValue()));
                }
            } else {
                pq.add(new Pair(entry.getKey(), entry.getValue()));
            }
        }

        for (Pair pair : pq) {
            resultList.add(pair.num);
        }

        return resultList;
    }


    class Pair {

        Integer num;
        Integer frequency;

        public Pair(int num, int frequency) {
            this.num = num;
            this.frequency = frequency;
        }
    }

}
