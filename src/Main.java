import com.gui.Window;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        com.mysql.connection.MysqlServerConnect.connectToServer();
        EventQueue.invokeLater(() -> {
            try {
                com.gui.Window window = new Window();
                window.jFrame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
