import java.awt.Point;

public interface CarrierFacade {

	void locationChanged(int carrierID, Point location);

	Point askDestination(int containerID);

	boolean checkUser(String user, String password, String operation);
}
