package org.arcelik.chainofresponsibility;

public class StatisticsWorker extends AbstractWorker {

	@Override
	protected void handleJob() {
		if(termsAccepted)
			System.out.println(step+1 + "-Source is reported to statistics server");
	}
}
