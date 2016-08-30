package edu.coloradomesa.cs.singleton;

import java.io.*;

public class Log
{
    static LogSingleton errorLogSingleton = new LogSingleton("errors.log");
    static LogSingleton eventLogSingleton = new LogSingleton("events.log");

    static PrintWriter error() { return errorLogSingleton.getInstance(); }
    static PrintWriter event() { return eventLogSingleton.getInstance(); }

    static void close()
    {
        errorLogSingleton.close();
        eventLogSingleton.close();
    }
}
