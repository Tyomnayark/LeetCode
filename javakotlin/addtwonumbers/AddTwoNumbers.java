package tasks.addtwonumbers;

public class AddTwoNumbers {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(2,null);
        ListNode l2 = new ListNode(4,l1);
        ListNode l3 = new ListNode(3,l2);

        ListNode l4 = new ListNode(5,null);
        ListNode l5 = new ListNode(6,l4);
        ListNode l6 = new ListNode(4,l5);

        ListNode node = addTwoNumbers(l3,l6);
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
    static public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode currentNodeFirst = l1;
        ListNode currentNodeSecond = l2;
        ListNode lastNode = null;

        int remainder = 0;

        while (currentNodeFirst != null || currentNodeSecond != null || remainder != 0) {
            int firstNum = (currentNodeFirst != null) ? currentNodeFirst.val : 0;
            int secondNum = (currentNodeSecond != null) ? currentNodeSecond.val : 0;

            int num = firstNum + secondNum + remainder;

            if (num >= 10) {
                num = num % 10;
                remainder = 1;
            } else {
                remainder = 0;
            }

            ListNode node = new ListNode(num);
            node.next = lastNode;
            lastNode = node;

            if (currentNodeFirst != null) {
                currentNodeFirst = currentNodeFirst.next;
            }

            if (currentNodeSecond != null) {
                currentNodeSecond = currentNodeSecond.next;
            }
        }

        return reverseList(lastNode);
    }

    static public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }

        return prev;
    }

}
