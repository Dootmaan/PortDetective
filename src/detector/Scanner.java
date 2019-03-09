package detector;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Scanner implements Runnable{
  Map<String,Integer> result=Detector_Main.result;
  JPanel contentPane=Detector_Main.contentPane;
  JTextField textField=Detector_Main.textField;
  JTextField textField_1=Detector_Main.textField_1;
  JTextField textField_2=Detector_Main.textField_2;
  JTextField textField_3=Detector_Main.textField_3;
  JLabel label_2=Detector_Main.label_2;
  ExecutorService executorService = Detector_Main.executorService;
  
  @Override
  public void run() {
    // TODO Auto-generated method stub
    
    if (!textField.getText().equals("") && !textField_1.getText().equals("")
        && !textField_2.getText().equals("") && !textField_3.getText().equals("")) {
      // check if ip address is correct
      String start_address = textField.getText();
      String end_address = textField_1.getText();

      String[] start_addresses = start_address.split("\\.");
      String[] end_addresses = end_address.split("\\.");
      if (start_addresses.length != 4 || end_addresses.length != 4) {
        JOptionPane.showMessageDialog(contentPane,
            "Incorrect IP address format.\nUse \"xxx.xxx.xxx.xxx\" format.");
      } else {
        
        if (Integer.parseInt(start_addresses[0]) > Integer.parseInt(end_addresses[0])
            || Integer.parseInt(start_addresses[1]) > Integer.parseInt(end_addresses[1])
            || Integer.parseInt(start_addresses[2]) > Integer.parseInt(end_addresses[2])
            || Integer.parseInt(start_addresses[3]) > Integer.parseInt(end_addresses[3])) {
          JOptionPane.showMessageDialog(contentPane,"Range Error. Check your input.");
        }
        else {
          label_2.setText("�����У����Ժ�");
          int start_port=Integer.parseInt(textField_2.getText());
          int end_port=Integer.parseInt(textField_3.getText());
          String[] current_ip=start_addresses;
          
          
          while(!Arrays.equals(current_ip,end_addresses)) {
            String real_ip=current_ip[0]+"."+current_ip[1]+"."+current_ip[2]+"."+current_ip[3];
            // test connection
            int i;
            for(i=start_port;i<end_port+1;i++) {
              //TODO
              result.put(real_ip+":"+i, 0);
              executorService.submit(new Connector(real_ip,i));
            }
            
            //�����λ
            if(Integer.parseInt(current_ip[3])==255) {
              current_ip[3]="0";
              if(Integer.parseInt(current_ip[2])==255) {
                current_ip[2]="0";
                if(Integer.parseInt(current_ip[1])==255) {
                  current_ip[1]="0";
                  if(Integer.parseInt(current_ip[0])==255) {
                    break;
                  }else {
                    current_ip[0]= String.valueOf(Integer.parseInt(current_ip[0])+1);
                  }
                }else {
                  current_ip[1]= String.valueOf(Integer.parseInt(current_ip[1])+1);
                }
              } else {
                current_ip[2]= String.valueOf(Integer.parseInt(current_ip[2])+1);
              }
            }else {
              current_ip[3]= String.valueOf(Integer.parseInt(current_ip[3])+1);
            }
          }
          
          int i;
          //��ȫ���һ��û��ɨ��Ĳ���
          for(i=start_port;i<end_port+1;i++) {
            //TODO
            result.put(end_address+":"+i, 0);
            executorService.submit(new Connector(end_address,i));
          }
          
          executorService.shutdown();
          
          while(!executorService.isTerminated()) {
    
          }
          
          label_2.setText("�������");
          //��ʾɨ����
          System.out.println(result);
          
          JFrame frame=new ResultDisplayer();
          
        }
        
      }
    } else {
      JOptionPane.showMessageDialog(contentPane,
          "Please make sure all the fields have been filled.");
    }
  }
}
