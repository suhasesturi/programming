use std::cmp::max;
use std::collections::HashMap;

struct Solution;
impl Solution {
    pub fn length_of_longest_substring(s: String) -> i32 {
        let mut visited = HashMap::new();
        let mut ans = 0;
        let mut start = 0;
        for (i, char) in s.chars().enumerate() {
            if let Some(&index) = visited.get(&char) {
                if index >= start {
                    ans = ans.max(i as i32 - start);
                    start = index + 1;
                }
            }
            visited.insert(char, i as i32);
        }
        max(ans, s.len() as i32 - start)
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_length_of_longest_substring() {
        println!("{}", Solution::length_of_longest_substring(String::from("abcabcbb")));
        println!("{}", Solution::length_of_longest_substring(String::from("abba")));
        println!("{}", Solution::length_of_longest_substring(String::from(" ")));
    }
}
