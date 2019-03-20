package detector;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class Settings extends JFrame {

  private JPanel contentPane;
  private JTextField textField;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Settings frame = new Settings();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public Settings() {
    setTitle("高级设置");
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setBounds(100, 100, 451, 388);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    JLabel label = new JLabel("\u7EBF\u7A0B\u6570\u91CF\uFF1A");
    label.setBounds(107, 191, 82, 18);
    contentPane.add(label);

    textField = new JTextField();
    textField.setBounds(218, 188, 106, 24);
    contentPane.add(textField);
    textField.setColumns(10);

    JRadioButton radioButton = new JRadioButton("\u662F");
    radioButton.setBounds(216, 124, 43, 27);
    contentPane.add(radioButton);

    JRadioButton radioButton_1 = new JRadioButton("\u5426");
    radioButton_1.setBounds(266, 124, 43, 27);
    contentPane.add(radioButton_1);
    
    JRadioButton radioButton_2 = new JRadioButton("\u5F00");
    radioButton_2.setBounds(218, 60, 43, 27);
    contentPane.add(radioButton_2);
    
    JRadioButton radioButton_3 = new JRadioButton("\u5173");
    radioButton_3.setBounds(266, 60, 43, 27);
    contentPane.add(radioButton_3);

    ButtonGroup bg_2 = new ButtonGroup();
    bg_2.add(radioButton_2);
    bg_2.add(radioButton_3);
    if(Detector_Main.openPort_preview) {
      radioButton_2.setSelected(true);
    }else {
      radioButton_3.setSelected(true);
    }
    
    radioButton_2.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Detector_Main.openPort_preview=true;
      }
    });
    
    radioButton_3.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Detector_Main.openPort_preview=false;
      }
    });

    ButtonGroup bg = new ButtonGroup();
    bg.add(radioButton);
    bg.add(radioButton_1);
    radioButton.setSelected(true);

    JButton button = new JButton("\u786E\u5B9A");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (radioButton.isSelected()) {
          if (textField.getText().equals("")) {
            JOptionPane.showMessageDialog(contentPane, "缺省的线程数将会默认设置为8");
            textField.setText("8");
          } else {
            int thread_number = Integer.parseInt(textField.getText());
            if(thread_number>16) {
              JOptionPane.showMessageDialog(contentPane, "过多的线程将可能造成系统资源被过多占用，请谨慎设置");
            }
            Detector_Main.MAX_THREADS = thread_number;
            setVisible(false);
          }
        } else if (radioButton_1.isSelected()) {
          Detector_Main.MAX_THREADS = 1;
          if (!textField.getText().equals("")) {
            int selection = JOptionPane.showConfirmDialog(contentPane, "不使用多线程会导致输入的线程数将无效，您确定吗？");
            if (selection == 0) {
              setVisible(false);
            }
          }else {
            setVisible(false);
          }
        }
      }
    });
    button.setBounds(76, 254, 113, 27);
    contentPane.add(button);

    JButton button_1 = new JButton("\u53D6\u6D88");
    button_1.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent arg0) {
        setVisible(false);
      }
    });
    button_1.setBounds(248, 254, 113, 27);
    contentPane.add(button_1);

    JLabel label_1 = new JLabel("\u542F\u7528\u591A\u7EBF\u7A0B\uFF1F");
    label_1.setBounds(107, 128, 106, 18);
    contentPane.add(label_1);
    
    JLabel label_2 = new JLabel("\u5F00\u653E\u7AEF\u53E3\u9884\u89C8\uFF1A");
    label_2.setBounds(107, 64, 106, 18);
    contentPane.add(label_2);
    
  }
}
