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
            // Очистка коллекции
            data.clear();
            // Перебор в цикле данных
            while ( rs.next() ) {
                synchronized ( data ) {
                    // Добавление данных в коллекцию
                    data.add(rs.getString(column));
                }
                // Оповещение видов о добавлении, если они есть
                fireIntervalAdded(this, 0, data.size());
            }
            rs.beforeFirst();
            // Оповещение видов об изменении
            fireContentsChanged(this, 0, data.size());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    // Функция размера массива данных в списке
    public int getSize() {
        synchronized ( data ) {
            return data.size();
        }
    }
    // Функция извлечения элемента
    public String getElementAt(int idx) {
        synchronized ( data ) {
            return data.get(idx);
        }
    }
    //получение индекса элемента
    public int indexOf(String element) {
        return data.indexOf(element);
    }

    //функция слушает обновление модели
    public void update() {
        fireContentsChanged(this, 0,0);
    }
}
