package Radix;

import Radix.StringUtil;

public class RadixSortEjerc {

    public static int[] radixSort(int []arr)
    {
        var strArray = StringUtil.toStringArray(arr);
        StringUtil.lNormalize(strArray,'0');
        var sortedArray = StringUtil.Sort(strArray);
        return StringUtil.toIntArray(sortedArray);
    }

    public static void main(String[] args)
    {
        int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
        int[] sortedArray = radixSort(arr);

        for(int i=0; i<sortedArray.length;i++)
        {
            System.out.print(sortedArray[i]+(i<sortedArray.length-1?",":""));
        }
    }
}
