//TranTrungKien-20210494

package hust.soict.ite6.aims.screen;

import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.ite6.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class StoreScreen extends JFrame{
	private static Store store = new Store();
	
	public StoreScreen (Store store) {
		super();
		
		this.store = store;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Store");
		this.setVisible(true);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().
							getResource("/hust/soict/ite6/aims/screen/Store.fxml"));
					StoreScreenController controller = new StoreScreenController(store);
					loader.setController(controller);
					Parent root = loader.load();

					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

}
