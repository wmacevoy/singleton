package edu.coloradomesa.cs.singleton;

public abstract class Singleton<T>
{
    private volatile T instance = null;

    protected abstract T create();
    public final boolean isCreated() { return instance != null; }

    public final T getInstance() 
    {
        T current = instance; // atomic
        if (current != null) return current;
        synchronized(this) {
            if (instance == null) instance = create();
            return instance;
        }
    }
}
