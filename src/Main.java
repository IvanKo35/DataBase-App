import com.gui.Window;
import com.mysql.connection.MysqlServerConnect;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        MysqlServerConnect.connectToServer();
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
