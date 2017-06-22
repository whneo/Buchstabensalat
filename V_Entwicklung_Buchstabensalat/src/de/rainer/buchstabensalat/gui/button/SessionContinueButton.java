package de.rainer.buchstabensalat.gui.button;

import java.awt.Color;
import java.awt.Point;

import de.rainer.buchstabensalat.gui.button.buttonactionlistener.SessionContinueButtonActionListener;
import de.rainer.buchstabensalat.gui.panel.BuchstabensalatPanel;

public final class SessionContinueButton extends FieldButton {

	private static final long serialVersionUID = -6454335992874640111L;

	public SessionContinueButton(BuchstabensalatPanel bsp) {
		super("Weiter", new SessionContinueButtonActionListener(bsp),
				Color.GREEN, new Point(669, 350));
	}
}
