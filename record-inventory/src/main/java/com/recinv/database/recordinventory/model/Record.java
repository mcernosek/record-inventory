package com.recinv.database.recordinventory.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "record_collection")
public class Record {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private int id;
	
	@NotNull
	private String artist;
	
	@NotNull
	private String album;
	
	private int yearReleased;
	
	private LocalDate dateAdded;  //May have problems here due to date column mapping 
	
	public Record() {
		
	}
	
	public Record(int id, String artist, String album, int yearReleased, LocalDate dateAdded) {
		super();
		this.id = id;
		this.artist = artist;
		this.album = album;
		this.yearReleased = yearReleased;
		this.dateAdded = dateAdded;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public String getAlbum() {
		return album;
	}
	
	public void setAlbum(String album) {
		this.album = album;
	}
	
	public int getYearReleased() {
		return yearReleased;
	}
	
	public void setYearReleased(int yearReleased) {
		this.yearReleased = yearReleased;
	}
	
	public LocalDate getDateAdded() {
		return dateAdded;
	}
	
	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}

	@Override
	public String toString() {
		return "Record [id=" + id + ", artist=" + artist + ", album=" + album + ", yearReleased=" + yearReleased
				+ ", dateAdded=" + dateAdded + "]";
	}
	
}
