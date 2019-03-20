package detector;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResultDisplayer extends JFrame {

  private JPanel contentPane;
  private JTable table;
  private JButton button;
  
  /**
   * Create the frame.
   */
  public ResultDisplayer() {
    setResizable(false);
    setVisible(true);
    setTitle("É¨Ãè½á¹û");
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setBounds(100, 100, 451, 542);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    button = new JButton("\u786E\u5B9A");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        setVisible(false);
        Detector_Main.label_2.setText("»¶Ó­Ê¹ÓÃ");
      }
    });
    button.setFont(new Font("Menu.font", Font.PLAIN, 20));
    button.setBounds(141, 437, 152, 45);
    contentPane.add(button);
    
    table = new JTable();
    table.setBounds(38, 40, 356, 368);
    table.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
    table.setVisible(true);
    table.setModel(new TableModel(Detector_Main.result));
    JScrollPane js=new JScrollPane(table);
    js.setBounds(14,13,405,411);
    js.setVisible(true);
    contentPane.add(js);

  }
}
