package org.arcelik.chainofresponsibility;

public class Main {

	private static AbstractWorker getChainOfWorkers(){

		AbstractWorker muteWorker = new VolumeWorker();
		AbstractWorker unmuteWorker = new VolumeWorker();
		AbstractWorker sourceWorker = new SourceWorker();
		AbstractWorker StatisticsWorker = new StatisticsWorker();

		muteWorker.setNextWorker(sourceWorker);
		sourceWorker.setNextWorker(unmuteWorker);
		unmuteWorker.setNextWorker(StatisticsWorker);

		return muteWorker;	
	}

	public static void main(String[] args) {
		AbstractWorker workerChain = getChainOfWorkers();
		
		workerChain.changeSource();
		
		System.out.println("--------------------");
		
		workerChain.setTermsStatus(true);
		workerChain.changeSource();
	}

}
