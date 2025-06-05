import java.util.Scanner;

public class ListNode {
        int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) 
         {
             this.val = val; 
            }
         ListNode(int val, ListNode next) 
         { 
            this.val = val; this.next = next; 
        }


    }
    class Solution {
        public ListNode reverseList(ListNode head) {
            
            ListNode prev = null;
            ListNode curr = head;
            ListNode temp;
            while(curr!=null){
                temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            return prev;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the number of nodes in the linked list:");
            int n = sc.nextInt();
            ListNode head = null;
            ListNode tail = null;
            System.out.println("Enter the values of the nodes:");
            int i =1;
            while(i<=n){
                int val = sc.nextInt();
                ListNode node = new ListNode(val);
                if(head==null){
                    head = node;
                    tail = node;
                }
                else{
                    tail.next = node;
                    tail = tail.next;
                }
                
                i++;
            }

            System.out.println("Original Linked List:");
            ListNode ptr = head;
            while(ptr!=null){
                System.out.print(ptr.val + " ");
                ptr = ptr.next;
            }
            System.out.println();
            
            Solution obj = new Solution();
            ListNode reversedHead = obj.reverseList(head);
            System.out.println("Reversed Linked List:");
            ListNode ptr1 = reversedHead;
            while(ptr1!=null){
                System.out.print(ptr1.val + " ");
                ptr1 = ptr1.next;
            }
            System.out.println();
            sc.close();
        }
    }
