class DiningPhilosophers {
    Semaphore[] s = new Semaphore[5];
    public DiningPhilosophers() {
        for(int i=0;i<s.length;i++){
            s[i] = new Semaphore(0);
        }
        s[0].release();
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        s[philosopher].acquire();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        s[(philosopher + 1)%5].release();
    }
}