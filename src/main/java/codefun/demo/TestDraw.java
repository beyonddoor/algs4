package codefun.demo;

import edu.princeton.cs.algs4.BinaryIn;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;

public class TestDraw
{
    public static void main(String[] args)
    {
        StdOut.println("hello");

        StdDraw.clear(Color.GRAY);
        StdDraw.setPenColor(Color.GREEN);
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0,100);
        StdDraw.setPenRadius(0.01);
        StdDraw.line(0,0,100,100);
//        StdDraw.filledRectangle(0,0,100,100);
//        StdDraw.setCanvasSize(1000,1000);
        StdDraw.show();
    }
}