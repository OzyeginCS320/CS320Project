import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Calendar {
	public Calendar() {
	}
    static JLabel lblMonth, lblYear;
    static JButton btnPrev, btnNext,btnHome;
    static JTable tblCalendar;
    static JComboBox cmbYear;
    static JFrame frmMain;
    static Container pane;
    static DefaultTableModel mtblCalendar;
    static JScrollPane stblCalendar; 
    static JPanel pnlCalendar;
    static int realYear, realMonth, realDay, currentYear, currentMonth;
    
    public static void main (String args[]){
       
        frmMain = new JFrame ("Calendar");
        frmMain.setSize(1352, 1352); 
        pane = frmMain.getContentPane(); 
        pane.setLayout(null); 
        frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        lblMonth = new JLabel ();
        lblMonth.setFont(new Font("Sitka Text", Font.BOLD, 14));
        lblYear = new JLabel ("Change year:");  
        cmbYear = new JComboBox();
        btnHome = new JButton("Home");
      
        btnHome.setBackground(new Color(245, 245, 245));
        btnHome.setFont(new Font("Sitka Text", Font.BOLD, 14));
        btnHome.setBorderPainted(false);
        btnPrev = new JButton ("previous");
        btnPrev.setBorderPainted(false);
        btnPrev.setBackground(new Color(245, 245, 245));
        btnPrev.setFont(new Font("Sitka Text", Font.BOLD, 12));
        btnNext = new JButton ("next");
        btnNext.setBackground(new Color(245, 245, 245));
        btnNext.setBorderPainted(false);
        btnNext.setFont(new Font("Sitka Text", Font.BOLD, 12));
        mtblCalendar = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
        tblCalendar = new JTable(mtblCalendar);
        stblCalendar = new JScrollPane(tblCalendar);
        pnlCalendar = new JPanel(null);
        pnlCalendar.setBackground(new Color(245, 245, 245));
              
        btnPrev.addActionListener(new btnPrev_Action());
        btnNext.addActionListener(new btnNext_Action());
        cmbYear.addActionListener(new cmbYear_Action());
        
        pane.add(pnlCalendar);
        pnlCalendar.add(lblMonth);
        pnlCalendar.add(lblYear);
        pnlCalendar.add(cmbYear);
        pnlCalendar.add(btnPrev);
        pnlCalendar.add(btnNext);
        pnlCalendar.add(btnHome);
        pnlCalendar.add(stblCalendar);
        
        pnlCalendar.setBounds(0, 0, 1352, 1352);
        lblMonth.setBounds(126, 11, 180, 24);
        lblYear.setBounds(10, 605, 80, 20);
        cmbYear.setBounds(230, 605, 80, 20);
        btnPrev.setBounds(10, 11, 94, 25);
        btnNext.setBounds(250, 11, 80, 25);
        btnHome.setBounds(516, 11, 101, 25);
        stblCalendar.setBounds(10, 50, 1352, 1352);
        
        frmMain.setResizable(false);
        frmMain.setVisible(true);
        
        GregorianCalendar calendar = new GregorianCalendar(); 
        realDay = calendar.get(GregorianCalendar.DAY_OF_MONTH); 
        realMonth = calendar.get(GregorianCalendar.MONTH); 
        realYear = calendar.get(GregorianCalendar.YEAR); 
        currentMonth = realMonth; 
        currentYear = realYear;
        
        String[] headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; 
        for (int i=0; i<7; i++){
            mtblCalendar.addColumn(headers[i]);
        }
             
        tblCalendar.setColumnSelectionAllowed(true);
        tblCalendar.setRowSelectionAllowed(true);
        tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        tblCalendar.setRowHeight(88);
        mtblCalendar.setColumnCount(7);
        mtblCalendar.setRowCount(6);
        
        for (int i=realYear-10; i<=realYear+10; i++){
            cmbYear.addItem(String.valueOf(i));
        }
        refreshCalendar (realMonth, realYear); 
    }
    
    public static void refreshCalendar(int month, int year){
        String[] months =  {"January", "February", "March", "April", "May","June", "July", "August", "September", "October", "November", "December"};
        int numberOfDays, startOfMonth;
        
        btnPrev.setEnabled(true);
        btnNext.setEnabled(true);
        if (month == 0 && year <= realYear-10){btnPrev.setEnabled(false);} 
        if (month == 11 && year >= realYear+10){btnNext.setEnabled(false);} 
        lblMonth.setText(months[month]); 
        lblMonth.setBounds(160-lblMonth.getPreferredSize().width/2, 25, 180, 10); 
        cmbYear.setSelectedItem(String.valueOf(year)); 
        
        for (int i=0; i<6; i++){
            for (int j=0; j<7; j++){
                mtblCalendar.setValueAt(null, i, j);
            }
        }
        
        GregorianCalendar cal = new GregorianCalendar(year, month, 1);
        numberOfDays = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        startOfMonth = cal.get(GregorianCalendar.DAY_OF_WEEK);
       
          for (int i=1; i<= numberOfDays; i++){
            int row = new Integer((i+startOfMonth-2)/7);                    
            int column  =  (i+startOfMonth-2)%7;
            mtblCalendar.setValueAt(i, row, column);
        }
        tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer());
    }
    
    static class tblCalendarRenderer extends DefaultTableCellRenderer{
        public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            if (column == 0 || column == 6){ 
                setBackground(new Color(250, 250, 210));
            }
            else{ 
                setBackground(new Color(255, 255, 255));
            }
            if (value != null){
                if (Integer.parseInt(value.toString()) == realDay && currentMonth == realMonth && currentYear == realYear){
                    setBackground(new Color(220, 220, 255));
                }
            }
            return this;
        }
    }
    
    static class btnPrev_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (currentMonth == 0){ 
                currentMonth = 11;
                currentYear -= 1;
            }
            else{ 
                currentMonth -= 1;
            }
            refreshCalendar(currentMonth, currentYear);
        }
    }
    static class btnNext_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (currentMonth == 11){ 
                currentMonth = 0;
                currentYear += 1;
            }
            else{ 
                currentMonth += 1;
            }
            refreshCalendar(currentMonth, currentYear);
        }
    }
    static class cmbYear_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (cmbYear.getSelectedItem() != null){
                String b = cmbYear.getSelectedItem().toString();
                currentYear = Integer.parseInt(b);
                refreshCalendar(currentMonth, currentYear);
            }
        }
     }   	
  }  