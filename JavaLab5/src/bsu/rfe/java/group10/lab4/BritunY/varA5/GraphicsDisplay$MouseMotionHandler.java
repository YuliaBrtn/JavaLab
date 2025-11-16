package bsu.rfe.java.group10.lab4.BritunY.varA5;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class GraphicsDisplay$MouseMotionHandler implements MouseMotionListener {
    public GraphicsDisplay$MouseMotionHandler(GraphicsDisplay var1) {
        this.this$0 = var1;
    }

    public void mouseMoved(MouseEvent ev) {
        GraphicsDisplay.access$6(this.this$0, this.this$0.findSelectedPoint(ev.getX(), ev.getY()));
        if (GraphicsDisplay.access$8(this.this$0) >= 0) {
            this.this$0.setCursor(Cursor.getPredefinedCursor(8));
        } else {
            this.this$0.setCursor(Cursor.getPredefinedCursor(0));
        }

        this.this$0.repaint();
    }

    public void mouseDragged(MouseEvent ev) {
        if (GraphicsDisplay.access$12(this.this$0)) {
            double[] currentPoint = this.this$0.translatePointToXY(ev.getX(), ev.getY());
            double newY = ((Double[])GraphicsDisplay.access$15(this.this$0).get(GraphicsDisplay.access$8(this.this$0)))[1] + (currentPoint[1] - ((Double[])GraphicsDisplay.access$15(this.this$0).get(GraphicsDisplay.access$8(this.this$0)))[1]);
            if (newY > GraphicsDisplay.access$13(this.this$0)[0][1]) {
                newY = GraphicsDisplay.access$13(this.this$0)[0][1];
            }

            if (newY < GraphicsDisplay.access$13(this.this$0)[1][1]) {
                newY = GraphicsDisplay.access$13(this.this$0)[1][1];
            }

            ((Double[])GraphicsDisplay.access$15(this.this$0).get(GraphicsDisplay.access$8(this.this$0)))[1] = newY;
            this.this$0.repaint();
        } else {
            double width = (double)ev.getX() - GraphicsDisplay.access$11(this.this$0).getX();
            if (width < (double)5.0F) {
                width = (double)5.0F;
            }

            double height = (double)ev.getY() - GraphicsDisplay.access$11(this.this$0).getY();
            if (height < (double)5.0F) {
                height = (double)5.0F;
            }

            GraphicsDisplay.access$11(this.this$0).setFrame(GraphicsDisplay.access$11(this.this$0).getX(), GraphicsDisplay.access$11(this.this$0).getY(), width, height);
            this.this$0.repaint();
        }

    }
}

