public class mergeSortPractice {
    public static void mergeSort(int[] array) {

        // before we waste any time, lets see if there's only one index in this array OR
        // an empty array
        if (array.length < 2) {
            return;
        }

        int midpoint = array.length / 2;

        // make two arrays
        int[] leftHalf = new int[midpoint];
        // right half starts at one higher than midpoint
        int[] rightHalf = new int[array.length - midpoint];

        // now to fill left handed array
        for (int i = 0; i < midpoint; i++) {
            leftHalf[i] = array[i];
        }

        // same for the right
        for (int i = midpoint; i < array.length; i++) {
            rightHalf[i - midpoint] = array[i];
        }

        // now we continue to divide
        mergeSort(leftHalf);
        mergeSort(rightHalf);

        // merge

    }

    // function to merge them together
    public static void merge(int[] array, int[] left, int[] right) {
        // need three counters because we have three arrays and can't tell when they'll
        // be empty
        int i = 0;
        int j = 0, k = 0;

        // ensures we don't end up with an array out of bounds error while iterating
        // through both of our arrays
        while (i < left.length && j < right.length) {

            // we get lower value on the left so we put that number first
            if (left[i] < right[j]) {
                array[k] = left[i];
                // increments to next array index since we used left[i] already
                i++;
            }
            // we get lower value on the right so we put that number first
            else {
                array[k] = right[j];
                // increments to next array index since we used right[j] already
                j++;
            }
            // increment main array index no matter where we get the value from
            k++;
        }
        // all of this is conditional that only runs IF there are any leftovers
        // we may have something left over, lets find out IF there's anything
        while (i < left.length) {
            array[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            array[k] = right[j];
            j++;
            k++;
        }
    }
}
