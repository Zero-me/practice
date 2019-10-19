package com.zero.decorator;


public class Decorator implements Sourceable {
	
	 /* 和被装饰对象同样的接口 */
    Sourceable sourceable;
    
    private void doSomeThing() {
        System.out.println("经过..........，最终赢下的官司");
    }
    
    public void setSourceable(Sourceable sourceable) {
        this.sourceable = sourceable;
    }

    
	@Override
	public void lawsuit() {
		doSomeThing();
        sourceable.lawsuit();
	}

}
