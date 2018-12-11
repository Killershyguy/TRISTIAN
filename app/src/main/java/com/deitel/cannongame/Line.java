package com.deitel.cannongame;

import android.graphics.Point;

public class Line {
    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point start;
    public Point end;

    public Line()
    {
        start = new Point(0, 0);
        end = new Point(0, 0);
    }

    public Line(Point start, Point end) {
        this.start =start;
        this.end=end;
    }
}
