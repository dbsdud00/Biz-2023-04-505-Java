package com.callor.books.service;

import java.util.List;

import com.callor.books.models.PublisherDto;

public interface PublisherService {

	public void loadPublisher();
	public void printPublisher();
	public PublisherDto getPublisher(String code);
	public List<PublisherDto> getPublisherList();
	public List<PublisherDto> getPublisherListByName(String Name);
	
}
