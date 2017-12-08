package emea.redhat.tigers.bpms;

import org.drools.core.spi.ProcessContext;
import org.kie.api.event.process.ProcessCompletedEvent;
import org.kie.api.event.process.ProcessEventListener;
import org.kie.api.event.process.ProcessNodeLeftEvent;
import org.kie.api.event.process.ProcessNodeTriggeredEvent;
import org.kie.api.event.process.ProcessStartedEvent;
import org.kie.api.event.process.ProcessVariableChangedEvent;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.api.runtime.process.WorkflowProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StartEndProcessEventListener implements ProcessEventListener {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void afterNodeLeft(ProcessNodeLeftEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void afterNodeTriggered(ProcessNodeTriggeredEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void afterProcessCompleted(ProcessCompletedEvent processCompletedEvent) {
		logger.info("StartEndProcessEventListener :: afterProcessCompleted ");
		String processId = processCompletedEvent.getProcessInstance().getProcessId();
		int processState = processCompletedEvent.getProcessInstance().getState();
		long id = processCompletedEvent.getProcessInstance().getId();
		logger.info("processId 		= "+processId);
		logger.info("instanceId 	= "+id);
		logger.info("processState 	= "+decodeProcessState(processState));
		
//		option 1
		WorkflowProcessInstance processInstance = (WorkflowProcessInstance) processCompletedEvent.getProcessInstance();
		String businessKey = (String) processInstance.getVariable("businessKey");
		logger.info("businessKey 	= "+businessKey);
		
//		option 2
//		ProcessContext processContext = new ProcessContext(processCompletedEvent.getKieRuntime());		
//		processContext.setProcessInstance(processCompletedEvent.getProcessInstance());		
//		String businessKey = (String) processContext.getVariable("businessKey");
//		logger.info("businessKey = "+businessKey);	
		
	}

	public void afterProcessStarted(ProcessStartedEvent processStartedEvent) {
		logger.info("StartEndProcessEventListener :: afterProcessStarted ");
		String processId = processStartedEvent.getProcessInstance().getProcessId();
		int processState = processStartedEvent.getProcessInstance().getState();
		long id = processStartedEvent.getProcessInstance().getId();
		logger.info("processId 		= "+processId);
		logger.info("instanceId 	= "+id);
		logger.info("processState 	= "+decodeProcessState(processState));
		
//		option 1
		WorkflowProcessInstance processInstance = (WorkflowProcessInstance) processStartedEvent.getProcessInstance();
		String businessKey = (String) processInstance.getVariable("businessKey");
		logger.info("businessKey 	= "+businessKey);
		
//		option 2
//		ProcessContext processContext = new ProcessContext(processStartedEvent.getKieRuntime());		
//		processContext.setProcessInstance(processStartedEvent.getProcessInstance());		
//		String businessKey = (String) processContext.getVariable("businessKey");
//		logger.info("businessKey = "+businessKey);	
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
	
	
    public static final String decodeProcessState(int state) {
        switch (state) {
            case ProcessInstance.STATE_PENDING:
                return "PENDING";
            case ProcessInstance.STATE_ACTIVE:
                return "ACTIVE";
            case ProcessInstance.STATE_COMPLETED:
                return "COMPLETED";
            case ProcessInstance.STATE_ABORTED:
                return "ABORTED";
            case ProcessInstance.STATE_SUSPENDED:
                return "SUSPENDED";
            default:
                return "UNKNOWN";
        }
    }
	 

}
