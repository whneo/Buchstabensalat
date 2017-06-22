package de.rainer.buchstabensalat.gui.button.actionlistener;

import java.awt.event.ActionListener;

import de.rainer.buchstabensalat.gui.dialog.SchwierigkeitDialog;

public abstract class AActionListenerInklSchwierigkeitDialog implements
		ActionListener {

	private SchwierigkeitDialog dialog;

	protected SchwierigkeitDialog getDialog() {
		return this.dialog;
	}

	protected void setDialog(SchwierigkeitDialog dialog) {
		this.dialog = dialog;
	}

	public AActionListenerInklSchwierigkeitDialog(SchwierigkeitDialog dialog) {
		super();
		this.setDialog(dialog);
	}

	public AActionListenerInklSchwierigkeitDialog() {
		this(new SchwierigkeitDialog());
	}
}