package plugins;

import plugin.Plugin;

public class ToLowerCase implements Plugin {

	/** transform all the letters to lower case
	 * @see plugin.Plugin#transform(java.lang.String)
	 */
	public String transform(String s) {
		return s.toLowerCase();
	}

	/**
	 * @see plugin.Plugin#getLabel()
	 */
	public String getLabel() {
		return "to lower case";
	}

	/**
	 * @see plugin.Plugin#helpMessage()
	 */
	public String helpMessage() {
		return "Transform all the letters to lower case";
	}

}
