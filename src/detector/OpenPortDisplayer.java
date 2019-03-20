package detector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class OpenPortDisplayer extends JFrame {

  private JPanel contentPane;
  static String openPort="";
  static JTextArea textArea;

  /**
   * Create the frame.
   */
  public OpenPortDisplayer() {
    setTitle("打开的端口");
    setResizable(false);
    setVisible(true);
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setBounds(100, 100, 318, 393);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    textArea = new JTextArea();
    textArea.setBounds(14, 13, 272, 263);
    textArea.setFont(new Font("微软雅黑",Font.PLAIN,14));
    textArea.setText(openPort);
    JScrollPane js=new JScrollPane(textArea);
    js.setBounds(14,13,272, 263);
    js.setVisible(true);
    contentPane.add(js);
    
    JButton button = new JButton("\u786E\u5B9A");
    button.setFont(new Font("宋体", Font.PLAIN, 18));
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        setVisible(false);
      }
    });
    button.setBounds(86, 294, 127, 39);
    contentPane.add(button);
    
  }
}
