package com.model;

public class Programme {
	String id, title, data;
	float cost;
	int minutes, messages;
	
	public String getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getMinutes() {
		return minutes;
	}
	
	public int getMessages() {
		return messages;
	}
	
	public String getData() {
		return data;
	}
	
	public float getCost() {
		return cost;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	
	public void setMessages(int messages) {
		this.messages = messages;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	@Override
    public String toString() {
        return "Programme [Title=" + title + ", Cost="
                + cost + "]";
    }
}
