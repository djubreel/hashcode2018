package com.wakanda.hashcode;

/**
 * Created by Jubril on 3/1/18.
 */
public class Ride {
    private Intersection startIntersection;
    private Intersection finishIntersection;
    private int earliestStart;
    private int latestFinish;
    public boolean isTaken = false;
    public int number;

    public Ride(Intersection startIntersection, Intersection finishIntersection, int earliestStart, int latestFinish, int number) {
        this.earliestStart = earliestStart;
        this.finishIntersection = finishIntersection;
        this.latestFinish = latestFinish;
        this.startIntersection = startIntersection;
        this.number = number;
    }

    public int getEarliestStart() {
        return earliestStart;
    }

    public int getLatestFinish() {
        return latestFinish;
    }

    public Intersection getStartIntersection() {
        return startIntersection;
    }

    public Intersection getFinishIntersection() {
        return finishIntersection;
    }

    public int getDistance() {
        return World.getDistance(getStartIntersection(), getFinishIntersection());
    }
}
