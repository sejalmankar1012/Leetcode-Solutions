class Solution {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    // Merge the two sorted arrays into a single array.
    int[] mergedArray = new int[nums1.length + nums2.length];
    int i = 0, j = 0, k = 0;
    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] <= nums2[j]) {
        mergedArray[k++] = nums1[i++];
      } else {
        mergedArray[k++] = nums2[j++];
      }
    }

    // Copy the remaining elements from the first array.
    while (i < nums1.length) {
      mergedArray[k++] = nums1[i++];
    }

    // Copy the remaining elements from the second array.
    while (j < nums2.length) {
      mergedArray[k++] = nums2[j++];
    }

    // Find the median of the merged array.
    int middle = mergedArray.length / 2;
    if (mergedArray.length % 2 == 1) {
      return mergedArray[middle];
    } else {
      return (mergedArray[middle] + mergedArray[middle - 1]) / 2.0;
    }
  }

}
