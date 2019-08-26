package org.GeoRaptor;

import java.awt.Image;

import javax.swing.Icon;

import oracle.dbtools.raptor.utils.MessagesBase;

/**
 * 
 * @author Bessie Gong 
 * @version 24 Jul 2019
 *
 */
public class Resources extends MessagesBase {
	
	private static final ClassLoader CLASS_LOADER = Resources.class.getClassLoader();
	private static final String CLASS_NAME = Resources.class.getCanonicalName();
	private static final Resources INSTANCE = new Resources();	
    
    private Resources() {
    	super(CLASS_NAME, CLASS_LOADER);
    }

    public static String getString( String key ) {
        return INSTANCE.getStringImpl(key);
    }
    
    public static String get( String key ) {
        return getString(key);
    }
    
    public static Image getImage( String key ) {
        return INSTANCE.getImageImpl(key);
    }
    
    public static String format(String key, Object ... arguments) {
        return INSTANCE.formatImpl(key, arguments);
    }

    public static Icon getIcon(String key) {
        return INSTANCE.getIconImpl(key);
    }
    
    public static Integer getInteger(String key) {
        return INSTANCE.getIntegerImpl(key);
    }

}
