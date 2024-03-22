/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package component;

import Object.SP2;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.DefaultFormatter;
import view.BanHang1;

public class TableActionCellEditer2 extends DefaultCellEditor {

  public static  JSpinner soluong;
    private tableActionEvent event;
    private JTable table;
    private int row ;
    private SP2 item;

    public TableActionCellEditer2(tableActionEvent event) {
        super(new JCheckBox());
        soluong = new JSpinner();
        this.event = event;
        SpinnerNumberModel smodel = (SpinnerNumberModel) soluong.getModel();
        JSpinner.NumberEditor editor = (JSpinner.NumberEditor) soluong.getEditor();
        DefaultFormatter formatter = (DefaultFormatter) editor.getTextField().getFormatter();
        formatter.setCommitsOnValidEdit(true);
        editor.getTextField().setHorizontalAlignment(SwingConstants.CENTER);
        smodel.setMinimum(1);
        soluong.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                inputValueChange();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        super.getTableCellEditorComponent(table, value, isSelected, row, column);
        int so = Integer.parseInt(value.toString());
        this.table= table;
        this.row= row;
        
        soluong.setValue(so);
        return soluong;
    }

    @Override
    public Object getCellEditorValue() {
        return soluong.getValue();
    }

    public void inputValueChange() {
        event.ChangeInput();
        int so = Integer.parseInt(soluong.getValue().toString());
        System.out.println(so);
    }

    public Integer inputvalue() {
        int  so= Integer.parseInt(soluong.getValue().toString());
        return   so;
    }
}
