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
    setBounds(100, 100, 450, 300);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    JLabel label = new JLabel("\u7EBF\u7A0B\u6570\u91CF\uFF1A");
    label.setBounds(106, 120, 82, 18);
    contentPane.add(label);

    textField = new JTextField();
    textField.setBounds(217, 117, 106, 24);
    contentPane.add(textField);
    textField.setColumns(10);

    JRadioButton radioButton = new JRadioButton("\u662F");
    radioButton.setBounds(215, 53, 43, 27);
    contentPane.add(radioButton);

    JRadioButton radioButton_1 = new JRadioButton("\u5426");
    radioButton_1.setBounds(265, 53, 43, 27);
    contentPane.add(radioButton_1);

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
    button.setBounds(75, 183, 113, 27);
    contentPane.add(button);

    JButton button_1 = new JButton("\u53D6\u6D88");
    button_1.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent arg0) {
        setVisible(false);
      }
    });
    button_1.setBounds(247, 183, 113, 27);
    contentPane.add(button_1);

    JLabel label_1 = new JLabel("\u542F\u7528\u591A\u7EBF\u7A0B\uFF1F");
    label_1.setBounds(106, 57, 106, 18);
    contentPane.add(label_1);

  }
}
