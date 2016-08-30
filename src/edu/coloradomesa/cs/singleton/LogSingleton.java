package edu.coloradomesa.cs.singleton;

import java.io.*;
import java.nio.*;
import java.nio.charset.*;
import java.nio.file.*;

class LogSingleton extends Singleton<PrintWriter>
{
    String name;
    LogSingleton(String _name) {
        name = _name;
    }
    
    protected PrintWriter create() {
        try {
            Charset cs = Charset.forName("UTF-8");
            Path p = Paths.get("logs", name);
            BufferedWriter bw = Files.newBufferedWriter(p, cs, 
                                                        StandardOpenOption.CREATE, 
                                                        StandardOpenOption.APPEND);
            return new PrintWriter(bw);
        } catch (Exception e) {
            throw new RuntimeException("Could not create/append to '" + 
                                       name + "' log file: " + e.getMessage());
        }
    }

    public void close()
    {
        try {
            if (isCreated()) getInstance().close();
        } catch (Exception e) {
            throw new RuntimeException("Could not close '" + 
                                       name + "' log file: " + e.getMessage());
        } 
    }

}
