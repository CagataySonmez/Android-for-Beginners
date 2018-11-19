package org.arcelik.chainofresponsibility;

public class VolumeWorker extends AbstractWorker {

	@Override
	protected void handleJob() {
		if(step == 0)
			System.out.println(step+1 + "-TV muted");
		else
			System.out.println(step+1 + "-TV unmuted");
	}
}
