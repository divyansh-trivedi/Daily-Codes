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
    ListNode* modifiedList(vector<int>& nums, ListNode* head) {
        ListNode* prev = NULL;
        ListNode* after = NULL;
        ListNode* curr = head;
        unordered_set<int> st;
        for(int i:nums)st.insert(i);

        while(curr != NULL){
            if(st.find(curr->val) != st.end()){
                after = curr->next;
                if(prev != NULL)prev->next = after;
                else head = after;
            }else{
                prev = curr;
            }
            curr = curr->next;
        }
        return head;
    }
};