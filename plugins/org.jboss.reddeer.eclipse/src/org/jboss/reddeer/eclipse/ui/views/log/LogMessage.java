package org.jboss.reddeer.eclipse.ui.views.log;

import java.util.ArrayList;
import java.util.List;

import org.jboss.reddeer.swt.api.TreeItem;
import org.jboss.reddeer.core.condition.ShellWithTextIsActive;
import org.jboss.reddeer.swt.impl.button.PushButton;
import org.jboss.reddeer.swt.impl.menu.ContextMenu;
import org.jboss.reddeer.swt.impl.text.LabeledText;
import org.jboss.reddeer.common.wait.WaitUntil;


/**
 * Represents Log message in Error log
 * @author rawagner
 *
 */
public class LogMessage {
	
	private TreeItem treeItem;
	private int severity;
	
	public LogMessage(TreeItem treeItem, int severity){
		this.treeItem = treeItem;
		this.severity = severity;
	}
	
	/**
	 * Returns a severity.
	 * 
	 * @return severity
	 */
	public int getSeverity() {
		return severity;
	}
	
	/**
	 * Returns a message.
	 * 
	 * @return Message
	 */
	public String getMessage() {
		return treeItem.getCell(0);
	}

	/**
	 * Returns a plugin.
	 * 
	 * @return Plugin
	 */
	public String getPlugin() {
		return treeItem.getCell(1);
	}

	/**
	 * Returns the date.
	 * 
	 * @return Date
	 */
	public String getDate() {
		return treeItem.getCell(2);
	}
	
	/**
	 * Returns a stack trace.
	 * 
	 * @return Stack trace
	 */
	public String getStackTrace(){
		treeItem.select();
		new ContextMenu("Event Details").select();
		new WaitUntil(new ShellWithTextIsActive("Event Details"));
		String stackTrace = new LabeledText("Exception Stack Trace:").getText();
		new PushButton("OK").click();
		return stackTrace;
	}
	
	/**
	 * Returns session data.
	 * 
	 * @return Session data
	 */
	public String getSessionData(){
		treeItem.select();
		new ContextMenu("Event Details").select();
		new WaitUntil(new ShellWithTextIsActive("Event Details"));
		String sessionData = new LabeledText("Session Data:").getText();
		new PushButton("OK").click();
		return sessionData;
	}
	
	/**
	 * Returns sublog messages.
	 * 
	 * @return Sublog messages
	 */
	public List<LogMessage> getSubLogMessages(){
		List<LogMessage> lm = new ArrayList<LogMessage>();
		for(TreeItem i: treeItem.getItems()){
			LogMessage l = new LogMessage(i, severity);
			lm.add(l);
		}
		return lm;
	}

}
