package Radix;

import Radix.StringUtil;

public class RadixSortEjerc {

    public static void radixSort(int []arr)
    {
        var strArray = StringUtil.toStringArray(arr);
        StringUtil.lNormalize(strArray,'0');
    }

    public static void main(String[] args)
    {
        int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
        radixSort(arr);

        for(int i=0; i<arr.length;i++)
        {
            System.out.print(arr[i]+(i<arr.length-1?",":""));
        }
    }
}