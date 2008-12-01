import java.util.Date;

public class Transport {

	
	
	private Date arrivalDate;
	private Date departureDate;
	/**
	 * @directed true
	 * @label on
	 */
	
	private Carrier lnkCarrier;
	/**
	 * @directed true
	 * @label to
	 */
	
	private PortLocation lnkLeafPortLocation;
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date property1) {
		this.departureDate = property1;
	}
	public Date getArrivalDate() {
			return arrivalDate;
		}
	public void setArrivalDate(Date property1) {
			this.arrivalDate = property1;
		}

}
