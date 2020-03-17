/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    ListNode resultHead = null;
    
    public ListNode swapPairs(ListNode head) {
        
        if(resultHead==null) {
            resultHead = head;
        }
        
        if(head!=null && head.next!=null) 
        {          
        swapNodes(head,head.next);
        swapPairs(head.next.next);
        }
        
        return resultHead;
        
    }
    
    private void swapNodes(ListNode a, ListNode b) {
        
        int temp = a.val;
        a.val=b.val;
        b.val=temp;
        
    }
    
}