package simstation;

import mvc.Utilities;

import java.awt.*;
import java.io.Serializable;

import static mvc.AppPanel.VIEW_WIDTH;

public abstract class Agent implements Runnable, Serializable {
    protected String name;
    transient protected Thread myThread;
    private boolean suspended, stopped;
    protected Simulation world;
    private int xc, yc;
    public Heading heading;
    private Color color;

    public Agent(String name) {
        this.name = name;
        suspended = false;
        stopped = false;
        xc = Utilities.rng.nextInt(VIEW_WIDTH);
        yc = Utilities.rng.nextInt(VIEW_WIDTH);
        myThread = new Thread(this);
        this.color = Color.WHITE;
    }

    public void setWorld(Simulation s) { world = s; }
    // thread stuff:
    public synchronized void stop() { stopped = true; }
    public synchronized boolean isStopped() { return stopped; }
    public synchronized void suspend() { suspended = true; }
    //public synchronized boolean isSuspended() { return suspended;  }
    public synchronized void resume() { notify(); }
    private synchronized void checkSuspended() {
        try {
            while(!stopped && suspended) {
                wait();
                suspended = false;
            }
        } catch (InterruptedException e) {
        }
    }

    public void run() {
        onStart();
        myThread = Thread.currentThread();
        while (!isStopped()) {
            try {
                update();
                Thread.sleep(20);
                checkSuspended();
            } catch(InterruptedException e) {

            }

            if (suspended) {
                onInterrupted();
            }
        }
        onExit();
    }

    public void start() {
        myThread.start();
    }

    public void move(int n) {
        switch (heading) {
            case NORTH -> {
                for (int i = n; i > 0; i--) {
                    yc--;
                    if (yc < 0) {
                        yc = VIEW_WIDTH;
                    }
                    world.changed();
                }
            }
            case NORTHEAST -> {
                for (int i = n; i > 0; i--) {
                    yc--;
                    if (yc < 0) {
                        yc = VIEW_WIDTH;
                    }
                    xc++;
                    if (xc > VIEW_WIDTH) {
                        xc = 0;
                    }
                    world.changed();
                }
            }
            case NORTHWEST -> {
                for (int i = n; i > 0; i--) {
                    yc--;
                    if (yc < 0) {
                        yc = VIEW_WIDTH;
                    }
                    xc--;
                    if (xc < 0) {
                        xc = VIEW_WIDTH;
                    }
                    world.changed();
                }
            }
            case EAST -> {
                for (int i = n; i > 0; i--) {
                    xc++;
                    if (xc > VIEW_WIDTH) {
                        xc = 0;
                    }
                    world.changed();
                }
            }
            case WEST -> {
                for (int i = n; i > 0; i--) {
                    xc--;
                    if (xc < 0) {
                        xc = VIEW_WIDTH;
                    }
                    world.changed();
                }
            }
            case SOUTH -> {
                for (int i = n; i > 0; i--) {
                    yc++;
                    if (yc > VIEW_WIDTH) {
                        yc = 0;
                    }
                    world.changed();
                }
            }
            case SOUTHEAST -> {
                for (int i = n; i > 0; i--) {
                    yc++;
                    if (yc > VIEW_WIDTH) {
                        yc = 0;
                    }
                    xc++;
                    if (xc > VIEW_WIDTH) {
                        xc = 0;
                    }
                    world.changed();
                }
            }
            case SOUTHWEST -> {
                for (int i = n; i > 0; i--) {
                    yc++;
                    if (yc > VIEW_WIDTH) {
                        yc = 0;
                    }
                    xc--;
                    if (xc < 0) {
                        xc = VIEW_WIDTH;
                    }
                    world.changed();
                }
            }
        }
    }
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getXc() {
        return xc;
    }

    public int getYc() {
        return yc;
    }

    public void onStart() {}

    public void onInterrupted() {}

    public void onExit() {}

    public abstract void update();
}
