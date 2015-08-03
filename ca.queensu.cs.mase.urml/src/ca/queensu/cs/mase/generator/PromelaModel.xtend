package ca.queensu.cs.mase.generator
import org.eclipse.xtend.lib.annotations.Accessors
import java.util.List

@Accessors class PromelaModel {
	RootProcess rootProcess
	List<Process> processes
}