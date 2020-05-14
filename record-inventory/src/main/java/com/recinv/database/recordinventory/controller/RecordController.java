package com.recinv.database.recordinventory.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recinv.database.recordinventory.exception.ResourceNotFoundException;
import com.recinv.database.recordinventory.model.Record;
import com.recinv.database.recordinventory.repository.RecordRepository;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class RecordController {
	
	@Autowired
	private RecordRepository recordRepository;
	
	@GetMapping("/records")
	public List<Record> getAllRecords() {
		return recordRepository.findAll();
	}
	
	@GetMapping("/records/{id}")
	public ResponseEntity<Record> getRecordById(@PathVariable(value = "id") int recordId) throws ResourceNotFoundException {
		Record record = recordRepository.findById(recordId)
		          .orElseThrow(() -> new ResourceNotFoundException("Record with this ID not found :: " + recordId));
		        return ResponseEntity.ok().body(record);
	}
	
	@PostMapping("/records")
    public Record createRecord(@Valid @RequestBody Record record) {
        return recordRepository.save(record);
    }
	
	@PutMapping("/records/{id}")
	public ResponseEntity<Record> updateRecord(@PathVariable(value = "id") int recordId, @Valid @RequestBody Record recordDetails) throws ResourceNotFoundException {
		
		Record record = recordRepository.findById(recordId)
				.orElseThrow(() -> new ResourceNotFoundException("Record with this ID not found :: " + recordId));
		
		record.setArtist(recordDetails.getArtist());
		record.setAlbum(recordDetails.getAlbum());
		record.setYearReleased(recordDetails.getYearReleased());
		record.setDateAdded(recordDetails.getDateAdded());
		final Record updatedRecord = recordRepository.save(record);
		return ResponseEntity.ok(updatedRecord);
		
	}
	
	@DeleteMapping("/records/{id}")
	public Map<String, Boolean> deleteRecord(@PathVariable(value = "id") int recordId) throws ResourceNotFoundException {
		Record record = recordRepository.findById(recordId)
				.orElseThrow(() -> new ResourceNotFoundException("Record with this ID not found :: " + recordId));
		
		recordRepository.delete(record);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	
	
	

}
