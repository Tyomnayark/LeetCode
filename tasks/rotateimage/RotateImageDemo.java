package tasks.rotateimage;

public class RotateImageDemo {
    public static void main (String[] args){
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};

        Solution solution = new Solution();

        solution.printMatrix(matrix);
        solution.rotate(matrix);
        solution.printMatrix(matrix);

    }
}
