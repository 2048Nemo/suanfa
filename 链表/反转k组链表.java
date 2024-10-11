package 链表;

/**
 * @BelongsProject: suanfa
 * @BelongsPackage: 链表
 * @Author: nemo2048
 * @CreateTime: 2024-10-09  14:53
 * @Description: TODO
 * @Version: 1.0
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class 反转k组链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode a,b ;
        a = b  = head ;
        for (int i = 0  ; i <k ;i++){
            if (b == null) {
                //没有k个元素反转不了
                return head;
            }
            b = b.next;
        }

        //开始反转
        ListNode reverse =  nodeReverse(a,b);

        //递归继续遍历
        //这里的细节是 反转后的链表头节点是反转前的尾节点
        a.next = reverseKGroup(b,k);

        return reverse;
    }
    // 一个左闭区间右开的链表反转，实际上b的指针并不改变指向[a,b)
    ListNode nodeReverse(ListNode a, ListNode b ){
        ListNode pre ,cur, next;
        pre=null;
        cur  = a;
        next = a;

        while (cur != b){
            next =  cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
