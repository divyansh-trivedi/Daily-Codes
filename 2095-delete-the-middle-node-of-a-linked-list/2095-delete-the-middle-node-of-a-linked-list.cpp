/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    int len(ListNode* head){
        int l = 0;
        ListNode* temp = head;
        while(temp != nullptr){
            l++;
            temp = temp -> next;
        }
        return l/2;
    }
    ListNode* deleteMiddle(ListNode* head) {
        int n = len(head);
        if(n == 0) return NULL;
        ListNode* curr = head;
        ListNode* prev;
        while(n > 0){
            prev = curr;
            curr = curr -> next;
            n--;
        }
        prev -> next = curr -> next;
        curr -> next = NULL;
        return head;

    }
};