package org.jboss.reddeer.eclipse.wst.server.ui.view;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.jboss.reddeer.eclipse.exception.EclipseLayerException;
import org.jboss.reddeer.eclipse.wst.server.ui.wizard.NewServerWizardDialog;
import org.jboss.reddeer.swt.api.TreeItem;
import org.jboss.reddeer.swt.exception.WidgetNotAvailableException;
import org.jboss.reddeer.swt.impl.menu.ContextMenu;
import org.jboss.reddeer.swt.impl.tree.DefaultTree;
import org.jboss.reddeer.workbench.view.View;
import org.jboss.reddeer.workbench.view.ViewMatcher;

/**
 * Represents the Servers view. This class contains methods that can be invoked even 
 * if no server is selected. You can invoke server specific operations on {@link Server} instances. 
 * 
 * @author Lucia Jelinkova
 *
 */
public class ServersView extends View {
	
	public static final String TITLE = "Servers";

	private static final Logger log = Logger.getLogger(ServersView.class);
	
	public ServersView() {
		super(TITLE);
	}

	public NewServerWizardDialog newServer(){
		log.info("Creating new server");
		open();
		new ContextMenu("New", "Server").select();
		return new NewServerWizardDialog();
	}

	public List<Server> getServers(){
		List<Server> servers = new ArrayList<Server>();

		DefaultTree tree;
		try {
			tree = getServersTree();
		} catch (WidgetNotAvailableException e){
			return new ArrayList<Server>();
		}
		for (TreeItem item : tree.getItems()){
			servers.add(new Server(item));
		}
		return servers;
	}

	public Server getServer(String name){
		for (Server server : getServers()){
			if (server.getLabel().getName().equals(name)){
				return server;
			}
		}
		throw new EclipseLayerException("There is no server with name " + name);
	}

	protected DefaultTree getServersTree(){
		open();
		return new DefaultTree(new ViewMatcher(this));
	}
}
