package kenny.lang.proxyandaop.aopframe;

import java.lang.reflect.InvocationHandler;

public abstract class AbstractHandler implements InvocationHandler {

    // use to hold the target object
	protected Object targetObject;

	public Object getTargetObject() {
		return targetObject;
	}

	public void setTargetObject(Object targetObject) {
		this.targetObject = targetObject;
	}
}
