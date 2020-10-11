import javax.swing.SwingUtilities;

public class App 
{

	public static void main(String[] args) 
	{
		/*
		 * SwingUtilities je razred
		 * invokeLater(Runnable doRun) je statična metoda iz razreda SwingUtilities
		 * Runnable je vmesnik (interface)
		 * Ustvarimo notranji razred, ki prevzame metode iz vmesnika Runnable
		 */
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new MainFrame();		
			}
			
		});		

	}

}
