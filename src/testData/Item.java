package testData;

import core.utility.Reader;

public class Item {
	
	private String id;
	private String title;
	private String description;
	private String price;
	
	public Item(String name) {
		this.id = Reader.json(name).get("id").toString();
		this.title = Reader.json(name).get("title").toString();
		this.description = Reader.json(name).get("description").toString();
		this.price = Reader.json(name).get("price").toString();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
