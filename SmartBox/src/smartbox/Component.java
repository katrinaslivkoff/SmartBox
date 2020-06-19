package smartbox;

import java.util.*;
import java.io.Serializable;
import java.lang.reflect.*;


public class Component implements Serializable {

	private Set<Class<?>> requiredInterfaces;
	private Set<Class<?>> providedInterfaces;
	private Map<Class<?>, Field> fields;
	protected Container container;
	protected String name;

	public Component() {
		fields = new HashMap<Class<?>, Field>();
		providedInterfaces = new HashSet<Class<?>>();
		requiredInterfaces = new HashSet<Class<?>>();
		computeRequiredInterfaces();
		computeProvidedInterfaces();
		container = null;
		name = this.getClass().getSimpleName();
	}

	// add needed getters & setters

	public String toString() { return name; }

	// initializes fields and requiredInterfaces
	private void computeRequiredInterfaces() {
		Field[] fieldArray = this.getClass().getDeclaredFields();
		for(int i = 0; i < fieldArray.length; i++) {
			//if the type of field[i] is an interface, then add it to fields and requiredInterfaces ???
			if(fieldArray[i].getType().isInterface()) {
				fields.put(fieldArray[i].getType(), fieldArray[i]);
				requiredInterfaces.add(fieldArray[i].getType());
			}
		}
	}

	// initializes provided interfaces
	private void computeProvidedInterfaces() {
		// get interfaces implemented by the class of this component and add them to providedInterfaces
		Class<?>[] interfaces = this.getClass().getInterfaces();
		for(int i = 0; i < interfaces.length; i++){
			providedInterfaces.add(interfaces[i]);
		}
	}

	// set the field of this object to the provider
	public void setProvider(Class<?> intf, Component provider) throws Exception {
		Field field = fields.get(intf);
		field.set(this, provider); // field probably needs to be public for this.
	}

	public Set<Class<?>> getRequiredInterfaces() {
		return requiredInterfaces;
	}

	public Set<Class<?>> getProvidedInterfaces() {
		return providedInterfaces;
	}

	public void setContainer(Container container) {
		this.container = container;
	}

}