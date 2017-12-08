package emea.redhat.tigers.bpms;

import org.jbpm.workflow.instance.node.WorkItemNodeInstance;
import org.kie.api.event.process.ProcessCompletedEvent;
import org.kie.api.event.process.ProcessEventListener;
import org.kie.api.event.process.ProcessNodeLeftEvent;
import org.kie.api.event.process.ProcessNodeTriggeredEvent;
import org.kie.api.event.process.ProcessStartedEvent;
import org.kie.api.event.process.ProcessVariableChangedEvent;
import org.kie.api.runtime.process.NodeInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebServiceTaskProcessEventListener implements ProcessEventListener {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public void afterNodeLeft(ProcessNodeLeftEvent processNodeLeftEvent) {
		logger.info("WebServiceTaskProcessEventListener :: afterNodeLeft ");
		NodeInstance node = processNodeLeftEvent.getNodeInstance();
		if (node instanceof WorkItemNodeInstance) {
			WorkItemNodeInstance wiNode = (WorkItemNodeInstance) node;
			if ("WebService".equals(wiNode.getWorkItem().getName())) {
				String wsInterface = (String) wiNode.getWorkItem().getParameter("Interface");
				String wsOperation = (String) wiNode.getWorkItem().getParameter("Operation");
				String wsUrl = (String) wiNode.getWorkItem().getParameter("Url");
				logger.info("WS invoked - Url: {}, Interface: {}, Operation: {}", wsUrl, wsInterface, wsOperation);
			}
		}
	}

	public void afterNodeTriggered(ProcessNodeTriggeredEvent event) {
		// TODO Auto-generated method stub

	}

	public void afterProcessCompleted(ProcessCompletedEvent event) {
		// TODO Auto-generated method stub

	}

	public void afterProcessStarted(ProcessStartedEvent event) {
		// TODO Auto-generated method stub

	}

	public void afterVariableChanged(ProcessVariableChangedEvent event) {
		// TODO Auto-generated method stub

	}

	public void beforeNodeLeft(ProcessNodeLeftEvent event) {
		// TODO Auto-generated method stub

	}

	public void beforeNodeTriggered(ProcessNodeTriggeredEvent event) {
		// TODO Auto-generated method stub

	}

	public void beforeProcessCompleted(ProcessCompletedEvent event) {
		// TODO Auto-generated method stub

	}

	public void beforeProcessStarted(ProcessStartedEvent event) {
		// TODO Auto-generated method stub

	}

	public void beforeVariableChanged(ProcessVariableChangedEvent event) {
		// TODO Auto-generated method stub

	}

}
