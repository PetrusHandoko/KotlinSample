//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main2(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        int [] numbers = {1,0,-1,0,-2,2};
        Solution sol = new Solution();
        var result = sol.maxSumTwoNoOverlap(new int[] {0,6,5,2,2,5,1,9,4}, 1, 2, true);
        System.out.println("Result " + result);
        result = sol.maxSumTwoNoOverlap(new int[] {3,8,1,3,2,1,8,9,0}, 3, 2, false);
        System.out.println("Result " + result);
        result = sol.maxSumTwoNoOverlap(new int[] {2,1,5,6,0,9,5,0,3,8}, 4, 3, false);
        System.out.println("Result " + result);
        result = sol.maxSumTwoNoOverlap(new int[] {53,86,11,35,1,41,34,52,64,90,54,84,99,67,8,80,100,51,66,37,31,13,13,22,31,81,96,81,96,21,16,67,2,88,58,53,23,21,76,60,15,46,21,94,49,29,45,6,32,21},
                33, 9, false);
        System.out.println("Result " + result);

/*
[53,86,11,35,1,41,34,52,64,90,54,84,99,67,8,80,100,51,66,37,31,13,13,22,31,81,96,81,96,21,16,67,2,88,58,53,23,21,76,60,15,46,21,94,49,29,45,6,32,21]
33, 9
2175

        [0,6,5,2,2,5,1,9,4], firstLen = 1, secondLen = 2
        Output: 20
        Explanation: One choice of subarrays is [9] with length 1, and [6,5] with length 2.
        Example 2:

        Input: nums = [3,8,1,3,2,1,8,9,0], firstLen = 3, secondLen = 2
        Output: 29
        Explanation: One choice of subarrays is [3,8,1] with length 3, and [8,9] with length 2.
        Example 3:

        Input: nums = [2,1,5,6,0,9,5,0,3,8], firstLen = 4, secondLen = 3

*/

    }

    public static void main(String[] args) {
//        var s = new Solution2<Integer>();
//        var r = s.build("1-2--3--4-5--6--7");
        //var r1 = s.build("1-2--3---4-5--6---7");
        var  m = new ZeroMatrix();
        int t1 [][] = {
                { 1, 0, 1},
                { 2, 3, 4},
                { 0, 3, 9}
        };
        var r = m.Solution(t1);

    }

}