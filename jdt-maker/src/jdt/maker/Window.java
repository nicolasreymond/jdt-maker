package jdt.maker;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.text.DecimalFormat;
import java.awt.event.KeyEvent.*;
import java.time.Instant.*;

public class Window extends JFrame {

    private JPanel container = new JPanel();
    private JPanel hourPane = new JPanel();
    private JPanel fieldPane = new JPanel();
    private JPanel buttonPane = new JPanel();

    private JMenuBar menuBar = new JMenuBar();
    private JMenu fileMenu = new JMenu("File");
    private JMenuItem exitMenu = new JMenuItem("Exit");
    private JMenu helpMenu = new JMenu("Help");
    private JMenuItem aboutMenu = new JMenuItem("About");

    private JLabel startLabel = new JLabel("Start Time");
    private JLabel endLabel = new JLabel("Ending Time");

    private JComboBox startCombo = new JComboBox();
    private JComboBox endCombo = new JComboBox();

    private JTextArea fieldAction = new HintTextField("Type what you did here...");

    private JButton buttonPrev = new JButton("Prev");
    private JButton buttonNext = new JButton("Next");
    private JButton buttonFinish = new JButton("Finish");

   //private JDateChooser date = new JDateChooser();

    public Window() {
        this.setTitle("JDT Maker");
        this.setSize(400, 300);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        exitMenu.setToolTipText("Informations about the application");
        exitMenu.addActionListener((event) -> System.exit(0));

        fileMenu.add(exitMenu);
        helpMenu.add(aboutMenu);
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        for (int i = 0; i < 24; i++) {
            String var1 = i + ":00";
            String var2 = i + ":30";
            startCombo.addItem(var1);
            endCombo.addItem(var1);
            startCombo.addItem(var2);
            endCombo.addItem(var2);
        }

        //hourPane.add(valueDatePicker);
        hourPane.add(startLabel);
        hourPane.add(startCombo);
        hourPane.add(endLabel);
        hourPane.add(endCombo);

        fieldAction.setPreferredSize(new Dimension(350, 150));

        fieldPane.add(fieldAction);

        buttonPrev.addActionListener(new BPListener());
        buttonNext.addActionListener(new BNListener());
        buttonFinish.addActionListener(new BFListener());

        buttonPane.add(buttonPrev);
        buttonPane.add(buttonNext);
        buttonPane.add(buttonFinish);

        container.setLayout(new BorderLayout());
        container.add(hourPane, BorderLayout.NORTH);

        container.add(fieldPane, BorderLayout.CENTER);
        container.add(buttonPane, BorderLayout.SOUTH);

        this.setContentPane(container);
        this.setVisible(true);
    }

    class BPListener implements ActionListener {

        public void actionPerformed(ActionEvent arg0) {
            System.out.println("PREV");
        }
    }

    class BNListener implements ActionListener {

        public void actionPerformed(ActionEvent arg0) {
            System.out.println("NEXT");
            System.out.println(endCombo.getSelectedItem().toString());
            startCombo.setSelectedItem(endCombo.getSelectedItem());
        }
    }

    class BFListener implements ActionListener {

        public void actionPerformed(ActionEvent arg0) {
            System.out.println("FINISH");

        }
    }

}
