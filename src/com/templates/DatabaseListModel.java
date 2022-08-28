package com.templates;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.Vector;

public class DatabaseListModel extends AbstractListModel<String> {
    private final Vector<String> data = new Vector<>();

    public DatabaseListModel(ResultSet rs, int column) {
        setDataSource(rs, column);
    }

    public void setDataSource(ResultSet rs, int column) {
        try {
            // collection clearing
            data.clear();
            // Search query
            while ( rs.next() ) {
                // Adding rows into array
                String element = rs.getString(column);
                data.add(element);
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

    public boolean removeElement(String element) {
        int index = indexOf(element);
        boolean rv = data.removeElement(element);
        if (index >= 0) {
            fireIntervalRemoved(this, index, index);
        }
        return rv;
    }

    public void remove(int index) {
        String rv = data.elementAt(index);
        data.removeElementAt(index);
        fireIntervalRemoved(this, index, index);
    }

    public void removeAllElements() {
        int index1 = data.size()-1;
        data.removeAllElements();
        if (index1 >= 0) {
            fireIntervalRemoved(this, 0, index1);
        }
    }
}
