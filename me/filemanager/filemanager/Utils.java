package filemanager;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Vector;

import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;
import javax.microedition.io.file.FileSystemRegistry;

public class Utils {

	public static Vector listRoots() {
		Vector retorno = new Vector();
		try {
			Enumeration e = FileSystemRegistry.listRoots();
			while (e.hasMoreElements())
				retorno.addElement(e.nextElement());
		} catch (Exception e) {
			return null;
		}
		return retorno;
	}

	public static FileConnection getFC(String fileName) {
		FileConnection fc = null;
		try {
			fc = (FileConnection) Connector.open("file:///" + fileName);
		} catch (Exception ioe) {
		}
		return fc;
	}
	
	public static InputStream getInputStream(String fileName) {
		InputStream is = null;
		try {
			is = getFC(fileName).openInputStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return is;
	}
	
	public static OutputStream getOutputStream(String fileName) {
		OutputStream os = null;		
		try {
			os = getFC(fileName).openOutputStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return os;
	}

	public static boolean exists(String fileName) {
		FileConnection fc = getFC(fileName);
		if (fc == null) {
			return false;
		}

		boolean teste = false;
		try {
			teste = fc.exists();
			fc.close();
		} catch (Exception e) {
			return false;
		}
		return teste;
	}
	
	public static Vector getContent(FileConnection fc) {
		Vector itens = new Vector();
		try {
			Enumeration filelist = fc.list();
			while (filelist.hasMoreElements())
				itens.addElement(filelist.nextElement());
		} catch (Exception ioe) {
			return null;
		}
		return itens;
	}
}
