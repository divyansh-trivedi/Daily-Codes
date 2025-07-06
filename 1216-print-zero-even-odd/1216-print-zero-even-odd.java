class ZeroEvenOdd {
    private int n;
    private Semaphore s0; 
    private Semaphore s1; 
    private Semaphore s2; 
    public ZeroEvenOdd(int n) {
        this.n = n;
        s0 = new Semaphore(1);
        s1 = new Semaphore(0);
        s2 = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        boolean flag = true;
        for(int i=0; i<n ; i++){
            s0.acquire();
            printNumber.accept(0);
            flag = !flag;
            if(!flag)
            s1.release();
            else  
            s2.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i = 2; i <= n; i += 2){
            s2.acquire();
            printNumber.accept(i);
            s0.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1;i <= n; i += 2){
            s1.acquire();
            printNumber.accept(i);
            s0.release();
        }
    }
}