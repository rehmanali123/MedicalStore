package org.medbay;

import java.util.List;

public class Article {

	private String title;
	private String url;
	private List<String> categories;
	private List<String> tags;

	public Article(String title, String url, List<String> categories, List<String> tags) {
		super();
		this.title = title;
		this.url = url;
		this.categories = categories;
		this.tags = tags;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

}
