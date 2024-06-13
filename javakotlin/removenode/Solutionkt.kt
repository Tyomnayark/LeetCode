package tasks.removenode

class Solutionkt {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var currentNode : ListNode? = head?.next
        var lastNode : ListNode?= head
        var prev: ListNode? =  ListNode()

        var counter = 1

        while (currentNode != null) {
            counter++
            currentNode = currentNode?.next
        }


        if (n < counter){
            var nth = counter - n
            currentNode = lastNode?.next
            prev = currentNode?.next
            while (nth!= 1){
                lastNode = currentNode
                currentNode = prev
                prev = currentNode?.next
                nth--
            }
            lastNode?.next = prev
        }else if (n == counter){
            return head?.next
        }

        return head
    }
}