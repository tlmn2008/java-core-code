package kenny.jvm.jvmti.test;

import com.sun.jdi.*;
import com.sun.jdi.connect.AttachingConnector;
import com.sun.jdi.connect.Connector;
import com.sun.jdi.event.*;
import com.sun.jdi.request.BreakpointRequest;
import com.sun.jdi.request.EventRequest;
import com.sun.jdi.request.EventRequestManager;
import com.sun.jdi.request.MethodEntryRequest;
import com.sun.tools.jdi.SocketAttachingConnector;

import java.util.List;
import java.util.Map;

public class SimpleDebugger {

    private static VirtualMachine vm;
    private static EventQueue eventQueue;
    private static EventSet eventSet;
    private static boolean vmExit;

    public static void main(String[] args) throws Exception{

        // 取得连接器
        VirtualMachineManager vmm = Bootstrap.virtualMachineManager();
        List<AttachingConnector> attachingConnectors = vmm.attachingConnectors();

        SocketAttachingConnector socketAttachingConnector = null;
        for (AttachingConnector attachingConnector : attachingConnectors) {
            if (attachingConnector instanceof SocketAttachingConnector) {
                socketAttachingConnector = (SocketAttachingConnector) attachingConnector;
                break;
            }
        }
        if (socketAttachingConnector == null) {
            System.out.println("JDI error");
            return;
        }

        // 连接到远程虚拟器
        Map defaultArguments = socketAttachingConnector.defaultArguments();
        Connector.Argument hostArg = (Connector.Argument) defaultArguments.get("hostname"); // SocketAttachingConnector#ARG_HOST
        Connector.Argument portArg = (Connector.Argument) defaultArguments.get("port");     // SocketAttachingConnector#ARG_PORT

        hostArg.setValue("127.0.0.1");
        portArg.setValue("8800");

        vm = socketAttachingConnector.attach(defaultArguments);

        // 取得要关注的类和方法
        List<ReferenceType> referenceTypes = vm.classesByName("PrintJob");
        if (referenceTypes == null || referenceTypes.size() == 0) {
            System.out.println("No class found");
            return;
        }
        ReferenceType referenceType = referenceTypes.get(0);
        List<Method> methodsByName = referenceType.methodsByName("printHello");
        if (methodsByName == null || methodsByName.size() == 0) {
            System.out.println("No method found");
            return;
        }
        Method method = methodsByName.get(0);

        // 注册监听
        vm.setDebugTraceMode(VirtualMachine.TRACE_EVENTS);
        vm.resume();
        EventRequestManager erm = vm.eventRequestManager();

        MethodEntryRequest methodEntryRequest = erm.createMethodEntryRequest();
        methodEntryRequest.addClassFilter(referenceType);
        methodEntryRequest.setSuspendPolicy(EventRequest.SUSPEND_NONE);
        methodEntryRequest.enable();

        BreakpointRequest breakpointRequest = erm.createBreakpointRequest(method.location());
        breakpointRequest.setSuspendPolicy(EventRequest.SUSPEND_EVENT_THREAD);
        breakpointRequest.enable();

        eventLoop();
    }


    private static void eventLoop() throws Exception {
        eventQueue = vm.eventQueue();
        while (true) {
            if (vmExit == true) {
                break;
            }
            eventSet = eventQueue.remove();
            EventIterator eventIterator = eventSet.eventIterator();
            while (eventIterator.hasNext()) {
                Event event = (Event) eventIterator.next();
                execute(event);
            }
        }
    }

    private static void execute(Event event) throws Exception {
        if (event instanceof VMStartEvent) {
            System.out.println("VM started");
            eventSet.resume();
        } else if (event instanceof BreakpointEvent) {
            System.out.println("Reach Method printHello of test.Test");
            eventSet.resume();
        } else if (event instanceof MethodEntryEvent) {
            MethodEntryEvent mee = (MethodEntryEvent) event;
            Method method = mee.method();
            System.out.println(method.name() + " was Entered!");
            eventSet.resume();
        } else if (event instanceof VMDisconnectEvent) {
            vmExit = true;
        } else {
            eventSet.resume();
        }
    }
}

// JAR NEED: JDK/lib/tools.jar
