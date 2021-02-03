package org.arcelik.chainofresponsibility;

public abstract class AbstractWorker {
	   //next element in chain or responsibility
	   protected AbstractWorker nextWorker;
	   protected static boolean termsAccepted;
	   protected static int step;
	   
	   public AbstractWorker(){
		   step = 0;
	   }

	   public void setNextWorker(AbstractWorker nextWorker){
	      this.nextWorker = nextWorker;
	   }
	   
	   public void setTermsStatus(boolean termsAccepted){
		   AbstractWorker.termsAccepted = termsAccepted;
	   }
	   
	   public void changeSource(){
		   handleJob();

		   if(nextWorker != null) {
			   step++;
			   nextWorker.changeSource();
		   }
		   else {
			   step = 0;
		   }
	   }

	   abstract protected void handleJob();
		
}
