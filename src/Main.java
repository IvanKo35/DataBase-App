import com.gui.Window;
import com.mysql.connection.MysqlServerConnect;

import java.awt.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        MysqlServerConnect.connectToServer();
        EventQueue.invokeLater(() -> {
            try {
                com.gui.Window window = new Window();
                Window.jFrame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
