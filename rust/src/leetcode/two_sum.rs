use std::{collections::HashMap, vec};

struct Solution;

impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let mut map = HashMap::new();
        for (i, val) in nums.iter().enumerate() {
            if let Some(&entry) = map.get(&(target - val)) {
                return vec![entry, i as i32];
            }
            map.insert(*val, i as i32);
        }
        vec![]
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_two_sum() {
        println!("{:?}", Solution::two_sum(vec![3,3], 6));
    }
}
