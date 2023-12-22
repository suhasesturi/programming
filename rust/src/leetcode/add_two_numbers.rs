// Definition for singly-linked list.
#[derive(PartialEq, Eq, Clone, Debug)]
pub struct ListNode {
    pub val: i32,
    pub next: Option<Box<ListNode>>,
}

impl ListNode {
    #[inline]
    fn new(val: i32) -> Self {
        ListNode {
            next: None,
            val,
        }
    }
}

struct Solution;

impl Solution {
    pub fn add_two_numbers(l1: Option<Box<ListNode>>, l2: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        let mut temp = Some(Box::new(ListNode::new(0)));
        let mut current = temp.as_mut();
        let mut sum;
        let mut carry = 0;

        let mut l1_current = l1;
        let mut l2_current = l2;

        while carry != 0 || l1_current.is_some() || l2_current.is_some() {
            sum = carry;
            if let Some(node) = l1_current {
                sum += node.val;
                l1_current = node.next;
            }
            if let Some(node) = l2_current {
                sum += node.val;
                l2_current = node.next;
            }
            carry = sum / 10;

            if let Some(node) = current {
                node.next = Some(Box::new(ListNode::new(sum % 10)));
                current = node.next.as_mut();
            }
        }
        temp.unwrap().next
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_add_two_numbers() {
        Solution::add_two_numbers(None, None);
    }
}
