package org.arcelik.chainofresponsibility;

public class SourceWorker extends AbstractWorker {

	@Override
	protected void handleJob() {
		System.out.println(step+1 + "-Source is changed");
	}
}
