class MovingAverage {
    
    int size;
    double sum;
    Queue<Integer> q;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        sum = 0;
        q = new LinkedList<>();
    }
    
    public double next(int val) {
        if (q.size() == size) {
            sum -= q.remove();
        }
        
        sum += val;
        q.offer(val);
        
        return sum / q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
