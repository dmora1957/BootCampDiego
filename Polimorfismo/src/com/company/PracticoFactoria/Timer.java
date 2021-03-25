package com.company.PracticoFactoria;

public class Timer {
    public long getStartMiliseconds() {
        return startMiliseconds;
    }

    public void setStartMiliseconds(long startMiliseconds) {
        this.startMiliseconds = startMiliseconds;
    }

    public long getEndMiliseconds() {
        return endMiliseconds;
    }

    public void setEndMiliseconds(long endMiliseconds) {
        this.endMiliseconds = endMiliseconds;
    }

    public long startMiliseconds;
    public long endMiliseconds;
    public void start ()
    {
        this.startMiliseconds = System.currentTimeMillis();
    }

    public void stop ()
    {
        this.endMiliseconds = System.currentTimeMillis();
    }

    public long elapsedTime ()
    {
        return this.endMiliseconds - this.startMiliseconds;
    }
}
