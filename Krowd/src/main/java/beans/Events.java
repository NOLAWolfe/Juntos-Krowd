package beans;

import java.time.LocalDate;

public class Events {

	
	public Events() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Events(int event_id, String event_name, String event_location, String event_description, String event_type,
			LocalDate event_date, int user_id, int photo_id, LocalDate created) {
		super();
		this.event_id = event_id;
		this.event_name = event_name;
		this.event_location = event_location;
		this.event_description = event_description;
		this.event_type = event_type;
		this.event_date = event_date;
		this.user_id = user_id;
		this.photo_id = photo_id;
		this.created = created;
	}
	
	private int event_id;
	private String event_name;
	private String event_location;
	private String event_description;
	private String event_type;
	private LocalDate event_date;
	private int user_id;
	private int photo_id;
	private LocalDate created;
	public int getEvent_id() {
		return event_id;
	}
	
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public String getEvent_location() {
		return event_location;
	}
	public void setEvent_location(String event_location) {
		this.event_location = event_location;
	}
	public String getEvent_description() {
		return event_description;
	}
	public void setEvent_description(String event_description) {
		this.event_description = event_description;
	}
	public String getEvent_type() {
		return event_type;
	}
	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}
	public LocalDate getEvent_date() {
		return event_date;
	}
	public void setEvent_date(LocalDate event_date) {
		this.event_date = event_date;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getPhoto_id() {
		return photo_id;
	}
	public void setPhoto_id(int photo_id) {
		this.photo_id = photo_id;
	}
	public LocalDate getCreated() {
		return created;
	}
	public void setCreated(LocalDate created) {
		this.created = created;
	}
	@Override
	public String toString() {
		return "Events [event_id=" + event_id + ", event_name=" + event_name + ", event_location=" + event_location
				+ ", event_description=" + event_description + ", event_type=" + event_type + ", event_date="
				+ event_date + ", user_id=" + user_id + ", photo_id=" + photo_id + ", created=" + created + "]";
	}
	
	
}
