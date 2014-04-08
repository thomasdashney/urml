package ca.queensu.cs.mase.ui.interpreter.launch.tab.util;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

@FunctionalInterface
public interface SelectionListener2 extends SelectionListener {
	/**
	 * Sent when selection occurs in the control.
	 * The default behavior is to do nothing.
	 *
	 * @param e an event containing information about the selection
	 */
	public void widgetSelected(SelectionEvent e);

	/**
	 * Sent when default selection occurs in the control.
	 * The default behavior is to do nothing.
	 *
	 * @param e an event containing information about the default selection
	 */
	public default void widgetDefaultSelected(SelectionEvent e) {
	}
}
