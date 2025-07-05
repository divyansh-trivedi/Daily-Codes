class FizzBuzz {
    private int n;
    private int cnt;

    public FizzBuzz(int n) {
        this.n = n+1;
        this.cnt = 1;

    }

    // printFizz.run() outputs "fizz".
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while(cnt < n){
            boolean flag  = (cnt % 3 == 0 && cnt % 5 != 0);
            if(!flag){
                wait();
            }else{
                printFizz.run();
                cnt++;
                notifyAll();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while (cnt < n){
            boolean flag = (cnt % 5 == 0 && cnt % 3 != 0);
            if(!flag){
                wait();
            }else{
                printBuzz.run();
                cnt++;
                notifyAll();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(cnt < n){
            boolean flag = (cnt % 5 == 0 && cnt % 3 == 0);
            if(!flag){
                wait();
            }else{
                printFizzBuzz.run();
                cnt++;
                notifyAll();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while(cnt < n){
            boolean flag = (cnt % 3 !=0 && cnt % 5 != 0);
            if(!flag)
            wait();
            else{
                printNumber.accept(cnt);
                cnt++;
                notifyAll();
            }
        }
    }
}