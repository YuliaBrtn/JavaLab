package bsu.rfe.java.group10.lab4.BritunY.varA5;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GraphicsDisplay$MouseHandler extends MouseAdapter {
    public GraphicsDisplay$MouseHandler(GraphicsDisplay var1) {
        this.this$0 = var1;
    }

    public void mouseClicked(MouseEvent ev) {
        if (ev.getButton() == 3) {
            if (GraphicsDisplay.access$0(this.this$0).size() > 0) {
                GraphicsDisplay.access$1(this.this$0, (double[][])GraphicsDisplay.access$0(this.this$0).get(GraphicsDisplay.access$0(this.this$0).size() - 1));
                GraphicsDisplay.access$0(this.this$0).remove(GraphicsDisplay.access$0(this.this$0).size() - 1);
            } else {
                this.this$0.zoomToRegion(GraphicsDisplay.access$2(this.this$0), GraphicsDisplay.access$3(this.this$0), GraphicsDisplay.access$4(this.this$0), GraphicsDisplay.access$5(this.this$0));
            }

            this.this$0.repaint();
        }

    }

    public void mousePressed(MouseEvent ev) {
        if (ev.getButton() == 1) {
            GraphicsDisplay.access$6(this.this$0, this.this$0.findSelectedPoint(ev.getX(), ev.getY()));
            GraphicsDisplay.access$7(this.this$0, this.this$0.translatePointToXY(ev.getX(), ev.getY()));
            if (GraphicsDisplay.access$8(this.this$0) >= 0) {
                GraphicsDisplay.access$9(this.this$0, true);
                this.this$0.setCursor(Cursor.getPredefinedCursor(8));
            } else {
                GraphicsDisplay.access$10(this.this$0, true);
                this.this$0.setCursor(Cursor.getPredefinedCursor(5));
                GraphicsDisplay.access$11(this.this$0).setFrame((double)ev.getX(), (double)ev.getY(), (double)1.0F, (double)1.0F);
            }

        }
    }

    public void mouseReleased(MouseEvent ev) {
        if (ev.getButton() == 1) {
            this.this$0.setCursor(Cursor.getPredefinedCursor(0));
            if (GraphicsDisplay.access$12(this.this$0)) {
                GraphicsDisplay.access$9(this.this$0, false);
            } else {
                GraphicsDisplay.access$10(this.this$0, false);
                double[] finalPoint = this.this$0.translatePointToXY(ev.getX(), ev.getY());
                GraphicsDisplay.access$0(this.this$0).add(GraphicsDisplay.access$13(this.this$0));
                GraphicsDisplay.access$1(this.this$0, new double[2][2]);
                this.this$0.zoomToRegion(GraphicsDisplay.access$14(this.this$0)[0], GraphicsDisplay.access$14(this.this$0)[1], finalPoint[0], finalPoint[1]);
                this.this$0.repaint();
            }

        }
    }
}
