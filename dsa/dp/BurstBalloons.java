package dsa.dp;

public class BurstBalloons {
    public static int[] removeElement(int[] original, int index) {
        int[] newArray = new int[original.length - 1];
        System.arraycopy(original, 0, newArray, 0, index);
        System.arraycopy(original, index + 1, newArray, index, original.length - index - 1);
        return newArray;
    }
    public static void main(String[] args) {
        int[] arr = {3,1,5,8};
        int burstSum = 0;
        int count=1;
        int[] nums = removeElement(arr,count);
        for (int i = 1; i < nums.length; i++) {

            burstSum =burstSum + nums[i-1] * nums[i] * (i+1 > nums.length ? 1:nums[ i+1]);

            System.out.print(nums[i-1] +"*");
            System.out.print(nums[i]+"*");
            System.out.print(nums[Math.min(nums.length-1, i+1)]);
            System.out.println();

        }
        System.out.println(burstSum);

    }
}
