package com.templates;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.Vector;

public class DatabaseListModel extends AbstractListModel<String> {
    private Vector<String> data = new Vector<>();

    public DatabaseListModel(ResultSet rs, int column) {
        setDataSource(rs, column);
    }

    public void setDataSource(ResultSet rs, int column)
    {
        try {
            // collection clearing
            data.clear();
            // Search query
            while ( rs.next() ) {
                // Adding rows into array
                data.add(rs.getString(column));
                // Notifying views about the addition
                fireIntervalAdded(this, 0, data.size());
            }
            rs.beforeFirst();
            // Notifying views of changes
            fireContentsChanged(this, 0, data.size());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void addElement(String element) {
        int index = data.size();
        data.addElement(element);
        fireIntervalAdded(this, index, index);
    }

    // Get size of array
    public int getSize() { return data.size(); }
    // Get element from array
    public String getElementAt(int idx) { return data.get(idx); }
    //Get index of array's element
    public int indexOf(String element) { return data.indexOf(element); }
}
