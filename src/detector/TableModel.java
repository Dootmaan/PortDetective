package detector;

import java.util.Map;
import javax.swing.table.AbstractTableModel;

class TableModel extends AbstractTableModel {
  /*
   * 这里和刚才一样，定义列名和每个数据的值
   */
  String[] columnNames = {"扫描地址及端口","状态"};
  Object[][] data= {{" "," "},{" "," "}};
  
  /**
   * 空构造方法
   */
  public TableModel() {
    
  }

  /**
   * 构造方法，初始化二维数组data对应的数据，使用List作为参数是为了以后添加按照信息查询等功能方便一下子显示多条内容
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

  // 以下为继承自AbstractTableModle的方法，可以自定义
  /**
   * 得到列名
   */
  @Override
  public String getColumnName(int column) {
    return columnNames[column];
  }

  /**
   * 重写方法，得到表格列数
   */
  @Override
  public int getColumnCount() {
    return columnNames.length;
  }

  /**
   * 得到表格行数
   */
  @Override
  public int getRowCount() {
    return data.length;
  }

  /**
   * 得到数据所对应对象
   */
  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    return data[rowIndex][columnIndex];
  }

  /**
   * 得到指定列的数据类型
   */
  @Override
  public Class<?> getColumnClass(int columnIndex) {
    return data[0][columnIndex].getClass();
  }

  /**
   * 指定设置数据单元是否可编辑.这里设置"姓名","学号"不可编辑
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
   * 如果数据单元为可编辑，则将编辑后的值替换原来的值
   */
  @Override
  public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    data[rowIndex][columnIndex] = aValue;
    /* 通知监听器数据单元数据已经改变 */
    fireTableCellUpdated(rowIndex, columnIndex);
  }

}
