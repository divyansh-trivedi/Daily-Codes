class FooBar {
    private int n;
    private Semaphore f;
    private Semaphore b;

    public FooBar(int n) {
        this.n = n;
        f = new Semaphore(1);
        b = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            f.acquire();
        	printFoo.run();
            b.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            b.acquire();
        	printBar.run();
            f.release();
        }
    }
}