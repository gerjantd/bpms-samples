# Registering a custom process event listener in Red Hat JBoss BPM Suite

Use the**`ProcessEventListener`**class to listen to process-related events, such as starting and completing processes, entering and leaving nodes, or changing values of process variables. An event object provides an access to related information, for example, what is the process and node instances linked to the event.

1. Create your own custom listener that implements **`org.kie.api.event.process.ProcessEventListener`**
2. Add it as a maven dependency to your BPMS project![](/assets/bcDependencies.png)
3. Register the custom listener in kie-deployment-descriptor.xml  on the "Event Listeners" sections and use the full qualified class name and the resolver as reflection.![](/assets/bcEventListeners.png)



