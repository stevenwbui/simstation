package simstation;

import java.io.Serializable;

public abstract class Agent implements Runnable, Serializable {

    protected String name;
    protected Thread myThread;
    private boolean suspended, stopped;
    protected Simulation world;
    private int xc, yc;
    public Heading heading;

    public Agent(String name) {
        this.name = name;
        suspended = false;
        stopped = false;
        myThread = null;
    }

    public void setWorld(Simulation s) { world = s; }
    public String getName() { return name; }

    public synchronized String toString() {
        String result = name;
        if (stopped) result += " (stopped)";
        else if (suspended) result += " (suspended)";
        else result += " (running)";
        return result;
    }
    // thread stuff:
    public synchronized void stop() { stopped = true; }
    public synchronized boolean isStopped() { return stopped; }
    public synchronized void suspend() { suspended = true; }
    public synchronized boolean isSuspended() { return suspended;  }
    public synchronized void resume() { notify(); }
    public synchronized void join() {
        try {
            if (myThread != null) myThread.join();
        } catch(InterruptedException e) {
            //world.println(e.getMessage());
        }
    }
    private synchronized void checkSuspended() {
        try {
            while(!stopped && suspended) {
                wait();
                suspended = false;
            }
        } catch (InterruptedException e) {
            //world.println(e.getMessage());
        }
    }

    public void run() {
        myThread = Thread.currentThread();
        while (!isStopped()) {
            try {
                update();
                Thread.sleep(1000);
                checkSuspended();
            } catch(InterruptedException e) {
                //world.println(e.getMessage());
            }
        }
        //world.stdout.println(name + " stopped");
    }

    public void start() {}
    public void move(int n) {}

    public abstract void update();
}
