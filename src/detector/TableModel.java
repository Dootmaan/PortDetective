package detector;

import java.util.Map;
import javax.swing.table.AbstractTableModel;

class TableModel extends AbstractTableModel {
  /*
   * ����͸ղ�һ��������������ÿ�����ݵ�ֵ
   */
  String[] columnNames = {"ɨ���ַ���˿�","״̬"};
  Object[][] data= {{" "," "},{" "," "}};
  
  /**
   * �չ��췽��
   */
  public TableModel() {
    
  }

  /**
   * ���췽������ʼ����ά����data��Ӧ�����ݣ�ʹ��List��Ϊ������Ϊ���Ժ���Ӱ�����Ϣ��ѯ�ȹ��ܷ���һ������ʾ��������
   */
  public TableModel(Map<String, Integer> records) {
    int i=0;
    int len=records.size();
    data=new Object[len][2];
    for(String s:records.keySet()) {
      data[i][0]=s;
      data[i][1]=records.get(s);
      i++;
    }
  }

  // ����Ϊ�̳���AbstractTableModle�ķ����������Զ���
  /**
   * �õ�����
   */
  @Override
  public String getColumnName(int column) {
    return columnNames[column];
  }

  /**
   * ��д�������õ��������
   */
  @Override
  public int getColumnCount() {
    return columnNames.length;
  }

  /**
   * �õ��������
   */
  @Override
  public int getRowCount() {
    return data.length;
  }

  /**
   * �õ���������Ӧ����
   */
  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    return data[rowIndex][columnIndex];
  }

  /**
   * �õ�ָ���е���������
   */
  @Override
  public Class<?> getColumnClass(int columnIndex) {
    return data[0][columnIndex].getClass();
  }

  /**
   * ָ���������ݵ�Ԫ�Ƿ�ɱ༭.��������"����","ѧ��"���ɱ༭
   */
  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex) {
//    if (columnIndex < 2)
//      return false;
//    else
//      return true;
    return false;
  }

  /**
   * ������ݵ�ԪΪ�ɱ༭���򽫱༭���ֵ�滻ԭ����ֵ
   */
  @Override
  public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    data[rowIndex][columnIndex] = aValue;
    /* ֪ͨ���������ݵ�Ԫ�����Ѿ��ı� */
    fireTableCellUpdated(rowIndex, columnIndex);
  }

}
