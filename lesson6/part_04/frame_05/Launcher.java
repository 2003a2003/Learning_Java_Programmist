package lesson6.part_04.frame_05;

public class Launcher {

	public static void main(String[] args) throws Exception {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					ActionField af = new ActionField();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}
}
