/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package component;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author phong
 */
public class TableActionCellEditor extends DefaultCellEditor {
    
    private tableActionEvent event;
    
    public TableActionCellEditor(tableActionEvent event) {
        super(new JCheckBox());
        this.event = event;
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        ButtonShell shell = new ButtonShell();
        shell.initEvent(event, row);
        shell.setBackground(table.getSelectionBackground());
        return shell;
        
    }
    
}
