package org.jboss.reddeer.swt.impl.tab;

import org.hamcrest.Matcher;
import org.jboss.reddeer.core.matcher.WithMnemonicTextMatcher;
import org.jboss.reddeer.core.reference.ReferencedComposite;

/**
 * Default TabItem implementation
 * 
 * @author Andrej Podhradsky
 * @author Vlado Pakan
 * @author Lucia Jelinkova
 * 
 */
public class DefaultTabItem extends AbstractTabItem {

	/**
	 * TabItem with index 0
	 */
	public DefaultTabItem() {
		this((ReferencedComposite) null);
	}
	
	/**
	 * TabItem with index 0 inside given composite
	 * @param referencedComposite
	 */
	public DefaultTabItem(ReferencedComposite referencedComposite){
		this(referencedComposite, 0);
	}
	
	/**
	 * TabItem with given text
	 * @param text
	 */
	public DefaultTabItem(String text) {
		this(null, text);
	}
	
	/**
	 * TabItem with given text inside given composite
	 * @param referencedComposite
	 * @param text
	 */
	public DefaultTabItem(ReferencedComposite referencedComposite, String text) {
		this(referencedComposite, 0, new WithMnemonicTextMatcher(text));
	}
	
	/**
	 * TabItem that matches given matchers
	 * @param matchers
	 */
	public DefaultTabItem(Matcher<?>... matchers) {
		this(null, matchers);
	}
	
	/**
	 * TabItem that matches given matchers
	 * @param referencedComposite
	 * @param matchers
	 */
	public DefaultTabItem(ReferencedComposite referencedComposite, Matcher<?>... matchers) {
		this(referencedComposite, 0, matchers);
	}
	
	/**
	 * TabItem with given index that matches given matchers
	 * @param index
	 * @param matchers
	 */
	public DefaultTabItem(int index, Matcher<?>... matchers) {
		this(null, index, matchers);
	}
	
	/**
	 * TabItem with given index inside given composite that matches given matchers
	 * @param referencedComposite
	 * @param index
	 * @param matchers
	 */
	public DefaultTabItem(ReferencedComposite referencedComposite, int index, Matcher<?>... matchers) {
		super(referencedComposite, index, matchers);
	}
}
