package data;

import java.util.Observable;
import java.util.Vector;

public class Container extends Observable {

	private int nextTransportIndex; //will be use to know the next destination of the Container

	/**
	 * @clientCardinality 1
	 * @directed true
	 * @label itinerary
	 * @supplierCardinality 0..*
	 */
	private Vector<Transport> Transports;

	private boolean hazardous; //true = hasardous / false = non-hasardous

	
	/**
	 * @clientNavigability NAVIGABLE
	 * @directed true
	 * @label is at
	 */
	private LeafPortLocation Location;

	private int ID;

	
	
	/**
	 * Constructor of the classes : create a container without the destinations
	 * @param hazardous
	 * @param location
	 * @param id
	 */
	public Container(int id, LeafPortLocation location,  boolean hazardous) {
		super();
		this.nextTransportIndex = -1;
		this.Transports = new Vector<Transport>();
		this.hazardous = hazardous;
		this.Location = location;
		this.ID = id;
	}

	/**
	 * insertTransport insert a new Transport(destination) to the Vector of transport
	 * @param t : new transport to insert
	 */
	public void insertTransport(Transport t) {
		this.Transports.addElement(t);
	}

	/**
	 * peekTransport : return the current destination of the container (use the nextTransportIndex)
	 * @return the next transport(destination)
	 */
	public Transport peekTransport() {
		if(nextTransportIndex<0)
			return null;
		else
			return this.Transports.elementAt(nextTransportIndex);
	}

	/**
	 * nextTransport : increase the nextTransportIndex and return the next transport
	 * @return the next transport
	 */
	public Transport nextTransport() {
		this.nextTransportIndex++;
		if(nextTransportIndex<Transports.size()) {
				return this.Transports.elementAt(nextTransportIndex);
		}
		else
			throw new IllegalStateException();
	}

	/**
	 * setLocation : set a new location for the container
	 * @param location : new location of the container
	 */
	public void setLocation(LeafPortLocation location) {
		setChanged();
		notifyObservers();
		this.Location = location;
	}

	/**
	 * Return the current locatiuon of the Container
	 * @return LeafPortLocation : the current location of the container
	 */
	public LeafPortLocation getLocation() {
		return this.Location;
	}

	/**
	 * getID : return the Id of the container
	 * @return ID
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Set a new ID for the container (normally not use)
	 * @param newId : newID for the container
	 */
	public void setID(int newId) {
		this.ID = newId;
	}

	/**
	 * isHazardous : test if the container is hasardous
	 * @return true : hasardous
	 * 		   false : non-hasardous
	 */
	public boolean isHazardous() {
		return hazardous;
	}

	/**
	 * setHasardous : set the container to hasardous or not (coulod be use if the container write non-hasardous but in fact it is)
	 * @param hazardous (true : hasardous  /  false : non-hasardous)
	 */
	public void setHazardous(boolean hazardous) {
		this.hazardous = hazardous;
	}

}
