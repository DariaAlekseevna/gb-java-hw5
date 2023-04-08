package hw.hw5;

/*
 * На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
 */
/**
 * task4
 */
public class task4 {

    public static void main(String[] args) {
        int[][] arr = new int[8][8]; // 

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%d", arr[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[0][0] = 1;
                arr[6][1] = 1;
                arr[3][2] = 1;
                arr[5][3] = 1;
                arr[7][4] = 1;
                arr[1][5] = 1;
                arr[4][6] = 1;
                arr[2][7] = 1;
            }
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%d", arr[i][j]);
            }
            System.out.println();
        }

    }

    
}