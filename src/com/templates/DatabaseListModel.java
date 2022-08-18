package com.templates;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DatabaseListModel extends AbstractListModel<String> {
    private final ArrayList<String> data = new ArrayList<>();

    public DatabaseListModel(ResultSet rs, int column) {
        setDataSource(rs, column);
    }

    public void setDataSource(ResultSet rs, int column)
    {
        try {
            // ������� ���������
            data.clear();
            // ������� � ����� ������
            while ( rs.next() ) {
                synchronized ( data ) {
                    // ���������� ������ � ���������
                    data.add(rs.getString(column));
                }
                // ���������� ����� � ����������, ���� ��� ����
                fireIntervalAdded(this, 0, data.size());
            }
            rs.beforeFirst();
            // ���������� ����� �� ���������
            fireContentsChanged(this, 0, data.size());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    // ������� ������� ������� ������ � ������
    public int getSize() {
        synchronized ( data ) {
            return data.size();
        }
    }
    // ������� ���������� ��������
    public String getElementAt(int idx) {
        synchronized ( data ) {
            return data.get(idx);
        }
    }
    //��������� ������� ��������
    public int indexOf(String element) {
        return data.indexOf(element);
    }

    //������� ������� ���������� ������
    public void update() {
        fireContentsChanged(this, 0,0);
    }
}
