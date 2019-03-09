package detector;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connector implements Runnable{
  private String address;
  private int port;
  
  public Connector(String address, int port) {
    this.address=address;
    this.port=port;
  }

  @Override
  public void run() {
    // TODO Auto-generated method stub
    try {
      Socket socket = new Socket(address,port);
    } catch (UnknownHostException e) {
      // TODO Auto-generated catch block
      Detector_Main.result.replace(address+":"+port,-1);
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      Detector_Main.result.replace(address+":"+port, -2);
      e.printStackTrace();
    }
  }
  
}
