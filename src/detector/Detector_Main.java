package detector;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class Detector_Main extends JFrame {
  
  public static Map<String,Integer> result =new TreeMap<>();
  static JPanel contentPane;
  static JTextField textField;
  static JTextField textField_1;
  static JTextField textField_2;
  static JTextField textField_3;
  static JLabel label_2;
  
  static int MAX_THREADS = 8; //定义线程数最大值
  static ExecutorService executorService;
  private JMenuBar menuBar;
  private final Action action = new SwingAction();
  private final Action action_1 = new SwingAction_1();
  private final Action action_2 = new SwingAction_2();
  private final Action action_3 = new SwingAction_3();

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Detector_Main frame = new Detector_Main();
          frame.setVisible(true);
          frame.setTitle("Port Detective");
          frame.setResizable(false);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public Detector_Main() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 604, 547);
    
    menuBar = new JMenuBar();
    setJMenuBar(menuBar);
    
    JMenu menu_1 = new JMenu("\u9009\u9879");
    menuBar.add(menu_1);
    
    JMenuItem menuItem_1 = new JMenuItem("\u8BBE\u7F6E");
    menuItem_1.setAction(action_1);
    menu_1.add(menuItem_1);
    
    JMenuItem menuItem_3 = new JMenuItem("\u5F53\u524D\u7EBF\u7A0B\u6570");
    menuItem_3.setAction(action_3);
    menu_1.add(menuItem_3);
    
    JMenuItem menuItem_2 = new JMenuItem("\u9000\u51FA");
    menuItem_2.setAction(action_2);
    menu_1.add(menuItem_2);
    
    JMenu menu = new JMenu("\u5173\u4E8E");
    menuBar.add(menu);
    
    JMenuItem menuItem = new JMenuItem("\u5173\u4E8E\u672C\u7A0B\u5E8F");
    menuItem.setAction(action);
    menu.add(menuItem);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    textField = new JTextField();
    textField.setBounds(295, 103, 147, 36);
    contentPane.add(textField);
    textField.setColumns(10);

    textField_1 = new JTextField();
    textField_1.setColumns(10);
    textField_1.setBounds(295, 170, 147, 36);
    contentPane.add(textField_1);

    JLabel lblip = new JLabel("\u8D77\u59CBIP\u5730\u5740\uFF1A");
    lblip.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    lblip.setBounds(139, 103, 155, 36);
    contentPane.add(lblip);

    JLabel lblIp = new JLabel("\u7EC8\u6B62IP\u5730\u5740\uFF1A");
    lblIp.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    lblIp.setBounds(139, 170, 155, 36);
    contentPane.add(lblIp);

    JLabel label = new JLabel("\u8D77\u59CB\u7AEF\u53E3\u53F7\uFF1A");
    label.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    label.setBounds(139, 245, 155, 36);
    contentPane.add(label);

    textField_2 = new JTextField();
    textField_2.setColumns(10);
    textField_2.setBounds(295, 245, 147, 36);
    contentPane.add(textField_2);

    JLabel label_1 = new JLabel("\u7EC8\u6B62\u7AEF\u53E3\u53F7\uFF1A");
    label_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
    label_1.setBounds(139, 313, 155, 36);
    contentPane.add(label_1);

    textField_3 = new JTextField();
    textField_3.setColumns(10);
    textField_3.setBounds(295, 313, 147, 36);
    contentPane.add(textField_3);
    
    label_2 = new JLabel("\u6B22\u8FCE\u4F7F\u7528");
    label_2.setFont(new Font("宋体", Font.PLAIN, 24));
    label_2.setHorizontalAlignment(SwingConstants.CENTER);
    label_2.setBounds(139, 40, 303, 36);
    contentPane.add(label_2);

    JButton btnNewButton = new JButton("\u5F00\u59CB\u626B\u63CF");
    btnNewButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        result.clear();
        // TODO Auto-generated method stub
        executorService = Executors.newFixedThreadPool(MAX_THREADS);
        Thread t = new Thread(new Scanner());
        t.start();
      }
    });
    btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
    btnNewButton.setBounds(104, 401, 155, 49);
    contentPane.add(btnNewButton);

    JButton button = new JButton("\u9000\u51FA");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        System.exit(0);
      }
    });
    button.setFont(new Font("微软雅黑", Font.PLAIN, 20));
    button.setBounds(337, 401, 155, 49);
    contentPane.add(button);
 
  }
  private class SwingAction extends AbstractAction {
    public SwingAction() {
      putValue(NAME, "关于本程序");
      putValue(SHORT_DESCRIPTION, "本程序的相关作者信息");
    }
    public void actionPerformed(ActionEvent e) {
      JOptionPane.showMessageDialog(contentPane, "PortDetective 2019(C)Dotman\n端口侦探 由Dotman开发");
    }
  }
  private class SwingAction_1 extends AbstractAction {
    public SwingAction_1() {
      putValue(NAME, "高级设置");
      putValue(SHORT_DESCRIPTION, "进阶选项，控制线程数");
    }
    public void actionPerformed(ActionEvent e) {
      Settings settings = new Settings();
      settings.setVisible(true);
    }
  }
  private class SwingAction_2 extends AbstractAction {
    public SwingAction_2() {
      putValue(NAME, "退出");
      putValue(SHORT_DESCRIPTION, "退出程序");
    }
    public void actionPerformed(ActionEvent e) {
      System.exit(0);
    }
  }
  private class SwingAction_3 extends AbstractAction {
    public SwingAction_3() {
      putValue(NAME, "当前线程数");
      putValue(SHORT_DESCRIPTION, "查看当前线程数");
    }
    public void actionPerformed(ActionEvent e) {
      JOptionPane.showMessageDialog(contentPane, "当前线程数："+Detector_Main.MAX_THREADS);
    }
  }
}
