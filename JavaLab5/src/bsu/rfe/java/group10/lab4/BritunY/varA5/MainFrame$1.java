package bsu.rfe.java.group10.lab4.BritunY.varA5;

import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;

class MainFrame$1 extends AbstractAction {
    MainFrame$1(MainFrame var1, String $anonymous0) {
        super($anonymous0);
        this.this$0 = var1;
    }

    public void actionPerformed(ActionEvent event) {
        if (MainFrame.access$0(this.this$0) == null) {
            MainFrame.access$1(this.this$0, new JFileChooser());
            MainFrame.access$0(this.this$0).setCurrentDirectory(new File("."));
        }

        MainFrame.access$0(this.this$0).showOpenDialog(this.this$0);
        this.this$0.openGraphics(MainFrame.access$0(this.this$0).getSelectedFile());
    }
}
