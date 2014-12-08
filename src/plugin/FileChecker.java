package plugin;

import java.io.FilenameFilter;
import java.util.ArrayList;

import javax.swing.Timer;

import listeners.ActionReadFileName;
import listeners.FileListener;

/**
 * Class to see the appearance and disappearance of file in a directory in
 * regular time.
 * 
 * @author dimitri marion
 * 
 */
public class FileChecker {
	protected Timer timer;
	protected ArrayList<FileListener> fileListeners;

	/**
	 * Constructor of this class
	 * 
	 * @param filter
	 */
	public FileChecker(FilenameFilter filter) {
		fileListeners = new ArrayList<FileListener>();
		timer = new Timer(1000, new ActionReadFileName(filter, this));
	}

	/**
	 * Method to add a {@link FileListener} to the {@link FileChecker}
	 * 
	 * @param l
	 */
	public synchronized void addFileListener(FileListener l) {
		if (fileListeners.contains(l)) {
			return;
		}
		fileListeners.add(l);
	}

	/**
	 * Method to remove a {@link FileListener} to the {@link FileChecker}
	 * 
	 * @param l
	 */
	public synchronized void removeFileListener(FileListener l) {
		fileListeners.remove(l);
	}

	/**
	 * Method to send a event when a file appeared
	 * 
	 * @param name
	 *            name of this file
	 */
	public void fireFileAdded(String name) {
		ArrayList<FileListener> tl = (ArrayList<FileListener>) fileListeners
				.clone();
		if (tl.size() == 0) {
			return;
		}
		FileEvent event = new FileEvent(name);
		for (FileListener listener : tl) {
			listener.fileAdded(event);
		}
	}

	/**
	 * Method to send a event when a file disappeared
	 * 
	 * @param name
	 *            name of this file
	 */
	public void fireFileRemoved(String name) {
		ArrayList<FileListener> tl = (ArrayList<FileListener>) fileListeners
				.clone();
		if (tl.size() == 0) {
			return;
		}
		FileEvent event = new FileEvent(name);
		for (FileListener listener : tl) {
			listener.fileRemoved(event);
		}
	}

	/**
	 * Method to start a detection of appearance and disappearance of this file.
	 */
	public void startTimer() {
		timer.start();
	}
}
