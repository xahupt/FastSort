public class FastSort {
    static int count = 10;
    static long[] longs = new long[count];
    private void FastSort_(int low,int high){

        if (low<high){
            int pivot = Paritition1(low, high);
            FastSort_( low, pivot - 1);
            FastSort_(pivot + 1, high);
        }
    }

    private int Paritition1( int low, int high) {
        long pivot = longs[low];
        while (low < high) {
            while (low < high && longs[high] >= pivot) {
                --high;
            }
            longs[low] = longs[high];
            while (low < high && longs[low] <= pivot) {
                ++low;
            }
            longs[high] = longs[low];
        }
        longs[low] = pivot;
        return low;
    }


    public static void main(String[] args) {

        for (int i = 0; i < count; i++) {
            longs[i] = Math.round(Math.random() * 1000);
            System.out.print(longs[i] + " ");
        }
        System.out.println("\n");
        System.out.println("------快速排序之后的序列------");
        new FastSort().FastSort_(0,longs.length-1);
        for (int i = 0; i < count; i++) {

            System.out.print(longs[i] + " ");
        }
    }
}
