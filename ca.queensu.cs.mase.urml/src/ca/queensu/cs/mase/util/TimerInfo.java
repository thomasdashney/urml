package ca.queensu.cs.mase.util;

import ca.queensu.cs.mase.urml.TimerPort;

public class TimerInfo {
	TimerPort timerPort;
	long timeout;
	
	TimerInfo(TimerPort timerPort, long timeout) {
		this.timerPort = timerPort; 
		this.timeout = timeout;
	}
}
