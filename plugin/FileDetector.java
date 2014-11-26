package plugin;

public class FileDetector implements FileListener {

	@Override
	public void fileAdded(FileEvent e) {
			System.out.printf("Nouveau .class %s détecté\n", e.getSource());
	}

	@Override
	public void fileRemoved(FileEvent e) {
		System.out.printf(".class %s supprimé detecté\n", e.getSource());
		
	}

}
