package properties;

import java.io.FileInputStream;
import java.util.Properties;

public class GUIConfiguracao {
	private Properties props;

	public void leProperties(String arq) throws Exception {
		props = new Properties();
		props.load(new FileInputStream(arq));
	}
	
	public String getPropriedade(String key) {
		return props.getProperty(key);
	}
	
	public void setProps(Properties props) {
		this.props = props;
	}
}
