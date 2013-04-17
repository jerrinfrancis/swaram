package src;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MapRenderer extends JFrame {

    static MapLoader map;
    File file;
    static JPanel panel;
    static JButton button;

    public MapRenderer(String str) {
        file = new File(str);
        map = new MapLoader(file);
        button = new JButton("down");
        panel = new JPanel(new BorderLayout());
        panel.add(map, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);
        button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                map.scrollBy(0,200);
            }
        });
    }
// statements marked #1 and #2 are necessary for the browser.
//the MapLoader should be called in between #1 and #2.

    public static void main(String[] args) {
        final String start = "സ്രീകാര്യം", end = "പട്ടം";
        UIUtils.setPreferredLookAndFeel();
        NativeInterface.open();//............................#1
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MapRenderer frame = new MapRenderer("src/test/setMap.html");
                frame.setTitle("സഞ്ജാരമാര്‍ഗ്ഗം");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(panel);
                //map.setHtml();
                map.setHtml("abagnale");
                //map.changeSelection(start, end);
                //map.setColor("startplace", "red");
                //map.calcRoute();
                frame.setSize(800, 600);
                frame.setLocationByPlatform(true);
                frame.setVisible(true);
            }
        });
        NativeInterface.runEventPump();//.....................#2
    }
}