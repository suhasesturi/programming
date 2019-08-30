package topcoder;

public class FairWorkload {
    public int getMostWork(int[] folders, int workers) {
        int high = 0, low = 0;
        for (int folder : folders) {
            high += folder;
            low = Math.max(low, folder);
        }

        while (low < high) {
            int max = low + (high - low) / 2;
            int required = 1, currentLoad = 0;
            for (int folder : folders) {
                if (currentLoad + folder <= max) {
                    currentLoad += folder;
                } else {
                    required++;
                    currentLoad = folder;
                }
            }

            if (required <= workers) high = max;
            else low = max + 1;
        }

        return low;
    }
}
