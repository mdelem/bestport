package data;
import java.util.Date;


public class Transport {

	
	//In our simple model the date will not be handle, so this two variable will always be null
	private Date arrivalDate;
	private Date departureDate;
	
	/**
	 * We will not use this argument here because it adds many complexity if you choose to handle this
	 * @directed true
	 * @label on
	 */
	private Carrier lnkCarrier;
	
	
	/**
	 * @directed true
	 * @label to
	 */
	private PortLocation Location;
	
	/**
	 * Constructor of the class (does not include the link with the carrier for more simplicity)
	 * @param arrivalDate
	 * @param departureDate
	 * @param Location
	 */
	public Transport(PortLocation Location) {
		super();
		this.arrivalDate = null;
		this.departureDate = null;
		this.lnkCarrier = null;
		this.Location = Location;
	}

	
	public PortLocation getLocation() {
		return Location;
	}

	public void setLocation(PortLocation location) {
		Location = location;
	}

	public Date getDepartureDate() {
		return departureDate;
	}
	
	public void setDepartureDate(Date departure) {
		this.departureDate = departure;
	}
	
	public Date getArrivalDate() {
		return arrivalDate;
	}
	
	public void setArrivalDate(Date arrival) {
		this.arrivalDate = arrival;
	}

}
