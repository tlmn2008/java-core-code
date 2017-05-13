package kenny.lang.proxyandaop.proxyexample;


import java.lang.reflect.Method;

public class ABeforeHandlerImpl extends ABeforeHandler {

	@Override
	public void handleBefore(Object proxy, Method method, Object[] args) {
		System.out.println("handler before method invoke");
	}
}
