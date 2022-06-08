package First;

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
/*-----------求和---------*/
//        int arr[]=new int[]{1,4,6,8};int sum=0;
//        for(int i=0;i<arr.length;i++)
//        {
//            sum+=arr[i];
//        }
//        System.out.println(sum);
/*----------倒着打印-------------*/
//        int arr[]=new int[]{1,4,6,8};
//        for(int i= arr.length-1;i>=0;i--)
//        {
//            System.out.println(arr[i]);
//        }
/*--------------求数组元素中的最大值和所在下标地址----------------*/
//        int arr[]=new int[]{14,23,36,52,12,3,88,16};int max=0;
//        for(int i=0;i<arr.length;i++)
//        {
//            if(arr[i]>arr[max])
//            {
//                max=i;
//            }
//        }
//        System.out.println(max+","+arr[max]);
/*--------------将数组每个位置的值变为原来的平方-------------------*/
//        int arr[]=new int[]{14,23,36,52,12,3,88,16};
//        for(int i=0;i<arr.length;i++)
//        {
//            arr[i]*=arr[i];
//        }
//        System.out.println(Arrays.toString(arr));
/*----------------反转数组---------------------*/
//        int arr[]=new int[]{14,23,36,52,12,3,88,16};int temp=0;
//        for(int i=0;i<arr.length/2;i++)
//        {
//            temp=arr[i];
//            arr[i]=arr[arr.length-i-1];
//            arr[arr.length-i-1]=temp;
//        }
//        System.out.println(Arrays.toString(arr));
/*------有序的数组，二分搜索一个数，如果存在，返回其索引，否则返回 -1------*/
        int nums[]=new int[]{1,2,3,4,5,6,7,8};
        Scanner sc=new Scanner(System.in);
        int target=sc.nextInt();
        int left = 0;
        int right = nums.length - 1;
        int ans=-1;
        while(left <= right)
        {
            int mid = (left+right)/2;
            if(nums[mid] == target)
            {
                ans = mid;
                break;
            }
            else if(nums[mid] < target)
            {
                left = mid+1;
            }
            else if(nums[mid] > target)
            {
                right = mid-1;
            }
        }
        System.out.println(ans);
        /*----------Arrays类的binarySearch()方法，可使用二分搜索法来搜索指定数组，以获得指定对象---------*/
        //1.  Arrays.binarySearch(Object[]a,Object key)  a:要搜索的数组； key：要搜索的值
        //如果key包含在数组内，返回索引值；否则返回-1或者“-”插入点。
        //如果数组内的值都比目标值大或者在数组范围内的，返回 -（第一个小于/大于目标值的元素的下标+1）
        //如果数组内的值都比目标值小，则是返回-（数组长度+1）
        //如果数组包含多个具有指定值的元素，则无法保证将找到哪一个元素
//        int[] nums=new int[]{3,4,10,8,9,6};
//        Arrays.sort(nums);//将数组进行排序
//        int index=Arrays.binarySearch(nums, 5);
//        System.out.println(index);//输出索引

        //2.binarySearch(object[]a, int fromIndex, int endIndex, object key)
        //a:要搜索的数组； key：要搜索的值；fromIndex指定范围内索引开始搜索处（包含）;endIndex:指定范围内索引搜索结束处（不包含）;
        //当如果区内的值都比目标值小，则是返回-（toindex+1），如果区间内的值都比目标值大，则返回-（fromindex+1）
        //如果key值在区间内，-（返回第一个大于目标值的原数组元素的下标+1）
//        int[] nums=new int[]{3,4,10,8,9,6};
//        Arrays.sort(nums);
//        int index=Arrays.binarySearch(nums,1, 3,5);
//        System.out.println(index);
    }
    }
