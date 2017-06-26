package de.rainer.buchstabensalat.gui.button;

import java.awt.Color;
import java.awt.Point;

import de.rainer.buchstabensalat.gui.button.actionlistener.SessionStartButtonActionListener;
import de.rainer.buchstabensalat.gui.panel.BuchstabensalatPanel;

public final class SessionStartButton extends FieldButton {

	private static final long serialVersionUID = -8940708434334617230L;

	public SessionStartButton(BuchstabensalatPanel bsp) {
		super("Start", new SessionStartButtonActionListener(bsp), Color.GREEN,
				new Point(669, 350));
	}
}
