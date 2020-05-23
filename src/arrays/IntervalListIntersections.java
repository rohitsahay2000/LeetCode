/*
Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)



Example 1:



Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.


Note:

0 <= A.length < 1000
0 <= B.length < 1000
0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.

 */

package com.rohit.arrays;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {

    List<Pair> result= new ArrayList<Pair>();

    public static void main(String[] args) {

        int A[][] = {{0,2},{5,10},{13,23},{24,25}};
        int B[][] = {{1,5},{8,12},{15,24},{25,26}};

        new IntervalListIntersections().intervalIntersection(A,B);

    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {

        int i=0;
        int j=0;

        while(i<A.length && j<B.length) {

            getIntersectionList(A[i], B[j]);
            if(A[i][1]<=B[j][1]) {
                i++;
            }
            else
                j++;

        }

        int[][] finalResult = new int [result.size()][2];
        int k=0;
        for(Pair pair : result) {
            finalResult[k][0]=pair.start;
            finalResult[k][1]=pair.end;
            k++;
        }
        return finalResult;
    }

    private void getIntersectionList(int arr1[], int arr2[]) {

        int start1 = arr1[0];
        int start2 = arr2[0];

        int end1 = arr1[1];
        int end2 = arr2[1];

        //[[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]

        int arr[] = new int[2];

        if((end1<start2) || (end2<start1))
            return ;

        else {
            int start =start2>start1?start2:start1;
            int end =end1<end2?end1:end2;
            Pair pair= new Pair(start,end);
            result.add(pair);
        }
    }
}
class Pair {
    int start;
    int end;
    Pair (int start, int end) {
        this.start=start;
        this.end=end;
    }
}
