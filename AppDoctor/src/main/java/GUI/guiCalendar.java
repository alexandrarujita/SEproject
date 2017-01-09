package GUI;

import org.joda.time.DateTime;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class guiCalendar  {

    private  JFrame f ;
    private JPanel contentPane;

      /** The currently-interesting year and month and day */
    private int yy, mm, dd;
    public JButton labs[][];
    /** The number of day squares to leave blank at the start of this month */
    private int leadGap = 0;
    private Calendar calendar = new GregorianCalendar();
    private final int thisYear = calendar.get(Calendar.YEAR);
    private final int thisMonth = calendar.get(Calendar.MONTH);
    public JComboBox monthChoice;
    public JComboBox yearChoice;
    private String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December" };
    private final static int dom[] = { 31, 28, 31, 30, /* jan feb mar apr */
            31, 30, 31, 31, /* may jun jul aug */
            30, 31, 30, 31 /* sep oct nov dec */
    };
    private int activeDay = -1;

    /** One of the buttons. We just keep its reference for getBackground(). */
    private JButton b0;


    public guiCalendar() {

        setYYMMDD(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        buildGUI();
        recompute();

    }

    private void setYYMMDD(int year, int month, int today) {
        yy = year;
        mm = month;
        dd = today;
    }

    private void buildGUI() {
        f = new JFrame("Calendar");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLayout(new FlowLayout());
        f.setBounds(100,100,485, 371);

        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEtchedBorder());
        f.setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        JPanel tp = new JPanel();
        tp.add(monthChoice = new JComboBox());
        for (int i = 0; i < months.length; i++)
            monthChoice.addItem(months[i]);

        monthChoice.setSelectedItem(months[mm]);

        monthChoiceAction();

        tp.add(yearChoice = new JComboBox());
        yearChoice.setEditable(true);
        for (int i = yy - 5; i < yy + 5; i++)
            yearChoice.addItem(Integer.toString(i));
        yearChoice.setSelectedItem(Integer.toString(yy));

       yearChoiceAction();

        contentPane.add(BorderLayout.CENTER, tp);

        JPanel bp = new JPanel();
        bp.setLayout(new GridLayout(7, 7));
        labs = new JButton[6][7]; // first row is days

        bp.add(b0 = new JButton("S"));
        bp.add(new JButton("M"));
        bp.add(new JButton("T"));
        bp.add(new JButton("W"));
        bp.add(new JButton("Th"));
        bp.add(new JButton("F"));
        bp.add(new JButton("S"));

        ActionListener dateSetter = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String num = e.getActionCommand();
                if (!num.equals("")) {
                    // set the current day highlighted
                    setDayActive(Integer.parseInt(num));
                }
            }
        };

        // Construct all the buttons, and add them.
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 7; j++) {
                bp.add(labs[i][j] = new JButton(""));
                labs[i][j].addActionListener(dateSetter);
            }

        contentPane.add(BorderLayout.SOUTH, bp);

        f.pack();
        f.setVisible(true);
    }

    public void yearChoiceAction() {
        yearChoice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                int i = yearChoice.getSelectedIndex();
                if (i >= 0) {
                    yy = Integer.parseInt(yearChoice.getSelectedItem().toString());
                    recompute();
                }
            }
        });
    }

    public void monthChoiceAction() {
        monthChoice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                int i = monthChoice.getSelectedIndex();
                if (i >= 0) {
                    mm = i;
                    recompute();
                }
            }
        });
    }


    /** Compute which days to put where, in the Cal panel */
    private void recompute() {

        if (mm < 0 || mm > 11)
            throw new IllegalArgumentException("Month " + mm + " bad, must be 0-11");
        clearDayActive();
        calendar = new GregorianCalendar(yy, mm, dd);

        // Compute how much to leave before the first.
        // getDay() returns 0 for Sunday, which is just right.
        leadGap = new GregorianCalendar(yy, mm, 1).get(Calendar.DAY_OF_WEEK) - 1;

        int daysInMonth = dom[mm];
        if (isLeap(calendar.get(Calendar.YEAR)) && mm == 1)
            // if (isLeap(calendar.get(Calendar.YEAR)) && mm > 1)
            ++daysInMonth;

        // Blank out the labels before 1st day of month
        for (int i = 0; i < leadGap; i++) {
            labs[0][i].setText("");
        }

        // Fill in numbers for the day of month.
        for (int i = 1; i <= daysInMonth; i++) {
            JButton b = labs[(leadGap + i - 1) / 7][(leadGap + i - 1) % 7];
            b.setText(Integer.toString(i));
        }

        // 7 days/week * up to 6 rows
        for (int i = leadGap + 1 + daysInMonth; i < 6 * 7; i++) {
            labs[(i) / 7][(i) % 7].setText("");
        }

        // Shade current day, only if current month
        if (thisYear == yy && mm == thisMonth)
            setDayActive(dd); // shade the box for today

        contentPane.repaint();
    }

    public boolean isLeap(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
            return true;
        return false;
    }

    /** Set the year, month, and day */
    public void setDate(int yy, int mm, int dd) {
        this.yy = yy;
        this.mm = mm; // starts at 0, like Date
        this.dd = dd;
        recompute();
    }

    /** Unset any previously highlighted day */
    private void clearDayActive() {
        JButton b;
        if (activeDay > 0) {
            b = labs[(leadGap + activeDay - 1) / 7][(leadGap + activeDay - 1) % 7];
            b.setBackground(b0.getBackground());
            b.repaint();
            activeDay = -1;
        }
    }


    /** Set just the day, on the current month */
    public void setDayActive(int newDay) {

        clearDayActive();

        // Set the new one
        if (newDay <= 0)
            dd = new GregorianCalendar().get(Calendar.DAY_OF_MONTH);
        else
            dd = newDay;
        // Now shade the correct square
        Component square = labs[(leadGap + newDay - 1) / 7][(leadGap + newDay - 1) % 7];
        square.setBackground(Color.red);
        square.repaint();
        activeDay = newDay;
    }

    public void setEvents(DateTime[] events){
        int day;

        for(int i =0; i<events.length;i++){
            day = events[i].getDayOfMonth();
            Component square = labs[(leadGap + day - 1) / 7][(leadGap + day - 1) % 7];
            square.setBackground(Color.green);
            square.repaint();
        }

    }

    public int getYy() {
        return yy;
    }

    public int getMm() {
        return mm;
    }

    public int getDd() {
        return dd;
    }

}