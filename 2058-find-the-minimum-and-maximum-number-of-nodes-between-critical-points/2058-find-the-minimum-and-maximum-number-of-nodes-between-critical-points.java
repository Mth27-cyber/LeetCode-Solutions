/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
import java.util.ArrayList;

class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        
        temp = head;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < size - 2 ; i++){
            if(temp.val < temp.next.val && temp.next.val > temp.next.next.val){
                list.add(i);
            }
            else if(temp.val > temp.next.val && temp.next.val < temp.next.next.val){
                list.add(i);
            }
            temp = temp.next;
        }
        
        if (list.size() < 2) {
            return new int[]{-1, -1};
        }
        
        int min = Integer.MAX_VALUE;
        int max = list.get(list.size() - 1) - list.get(0);
        for (int i = 0; i < list.size() - 1; i++) {
            int distance = list.get(i + 1) - list.get(i);
            if (distance < min) {
                min = distance;
            }
        }

        return new int[]{min, max};
    }
}