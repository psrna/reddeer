package org.jboss.reddeer.core.matcher;

import org.eclipse.swt.widgets.Widget;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

/**
 * Matcher matching {@link Widget} widget classes.
 * Matching is satisfied if class specified in constructor is same or is superclass of class of object specified 
 * as argument a in method {@link ClassMatcher#matches(Object)}.
 * 
 * @author jpeterka
 * @author rawagner
 * @author Radoslav Rabara
 * 
 */
@SuppressWarnings("rawtypes")
public class ClassMatcher extends BaseMatcher {

	private Class<? extends Widget> c;
	
	/**
	 * Constructs new ClassMatcher matcher matching {@link Widget} objects.
	 * For satisfied match it is required the class specified in constructor
	 * is either same class as class of object in matches method or it is superclass
	 * of object provided in matches method.
	 * 
	 * @param c descendant of widget class to be used as a base for matching
	 */
	public ClassMatcher(Class<? extends Widget> c) {
		if(c==null)
			throw new NullPointerException("c is null");
		this.c = c;
	}
	
	@Override
	public boolean matches(Object item) {
		return c.isAssignableFrom(item.getClass());
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("has the same type as " + c +" or its type extends " + c);
	}
	
	@Override
	public String toString() {
		return "Matcher matching widget with the same type as or type extending " + c;
	}
}
