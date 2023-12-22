struct Solution;
impl Solution {

    pub fn transpose(matrix: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        let mut result =  vec![vec![0;matrix.len()];matrix[0].len()];
        for i in 0..matrix.len() {
            for j in 0..matrix[i].len() {
                result[j][i] = matrix[i][j];
            }
        }

        result
    }
}


#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_transpose() {

    }
}

