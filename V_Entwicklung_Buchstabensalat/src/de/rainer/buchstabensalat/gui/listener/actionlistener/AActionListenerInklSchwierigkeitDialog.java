package de.rainer.buchstabensalat.gui.listener.actionlistener;

import java.awt.event.ActionListener;

import javax.swing.JDialog;

public abstract class AActionListenerInklSchwierigkeitDialog implements ActionListener {

	private JDialog dialog;

	protected JDialog getDialog() {
		return this.dialog;
	}

	protected void setDialog(JDialog dialog) {
		this.dialog = dialog;
	}

	public AActionListenerInklSchwierigkeitDialog(JDialog dialog) {
		super();
		this.setDialog(dialog);
	}

	public AActionListenerInklSchwierigkeitDialog() {
		this(new JDialog());
	}
}