package edu.coloradomesa.cs.singleton;

class SingletonExample
{
    static void run()
    {
        int n=5;
        Worker[] workers = new Worker[n];

        for (int i=0; i<n; ++i) {
            workers[i]=new Worker("#"+i);
        }

        for (int i=0; i<n; ++i) {
            workers[i].begin();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}

        for (int i=0; i<n; ++i) {
            workers[i].end();
        }

        Log.event().println("done");
    }

    public static void main(String [] args) throws Exception
    {
        try {
            run();
        } finally {
            Log.close();
        }
    }
}

