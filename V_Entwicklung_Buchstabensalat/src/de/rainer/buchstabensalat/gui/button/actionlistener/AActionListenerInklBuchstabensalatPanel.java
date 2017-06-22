package de.rainer.buchstabensalat.gui.button.actionlistener;

import de.rainer.buchstabensalat.gui.panel.BuchstabensalatPanel;

public abstract class AActionListenerInklBuchstabensalatPanel implements
		IActionListener {

	private BuchstabensalatPanel bsp;

	protected BuchstabensalatPanel getBsp() {
		return this.bsp;
	}

	protected void setBsp(BuchstabensalatPanel bsp) {
		this.bsp = bsp;
	}

	public AActionListenerInklBuchstabensalatPanel(BuchstabensalatPanel bsp) {
		super();
		this.setBsp(bsp);
	}

	public AActionListenerInklBuchstabensalatPanel() {
		this(new BuchstabensalatPanel());
	}
}