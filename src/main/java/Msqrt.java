public class Msqrt {
    public int mySqrt(int x) {
        int head = 0;
        int tail = x - 1;
        int center = (head + tail) / 2;
        int val = 0;
        while (head < tail){
            if ((long)center * center < x){
                head = center;
                if (tail - center <= 1){
                    if ((long) tail * tail <= x){
                        val = tail;
                        break;
                    }else {
                        val = center;
                        break;
                    }
                }
            }else if ((long)center * center > x){
                tail = center;
                if (center - head <= 1){
                    val = head;
                    break;
                }
            }else {
                val = center;
                break;
            }
            center = (head + tail) / 2;
        }
        return val;
    }
}
