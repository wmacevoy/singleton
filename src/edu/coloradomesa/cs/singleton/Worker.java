package edu.coloradomesa.cs.singleton;

public class Worker extends Thread
{
    String id;
    volatile boolean running;
    Worker(String id)
    {
        this.id = id;
    }

    public void begin()
    {
        running = true;
        start();
    }
    
    public void run()
    {
        while (running) {
            if (Math.random() < 0.001) {
                Log.error().println("error in thread " + id);
            }
            if (Math.random() < 0.01) {
                Log.event().println("event in thread " + id);
            }
            try {
                Thread.sleep((int)Math.random()*100);
            } catch (InterruptedException e) {}
        }
    }
    
    public void end()
    {
        running = false;
        try {
            join();
        } catch (InterruptedException e) {}
    }
}
