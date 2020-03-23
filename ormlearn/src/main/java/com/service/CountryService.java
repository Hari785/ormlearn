package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modal.Country;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	
	@Transactional
	public List<Country> getAllCountries() {
		if(countryRepository.findAll()==null)
			return new ArrayList<Country>();
		return countryRepository.findAll();
	}

	
	@Transactional
	public Country findCountryByCode(String ccode) {
		Country country = null;
		Optional<Country> olst = countryRepository.findById(ccode);
		if (olst.isPresent())
			return olst.get();
		return country;
	}

	
	
	@Transactional
	public void addCountry(Country country) {
		countryRepository.save(country);
	}

	
	
	@Transactional
	public void updateCountry(Country newCountry) {
		Country country = null;
		
		Optional<Country> olst = countryRepository.findById(newCountry.getCo_code());
		if (olst.isPresent())
			country = olst.get();
		country.setCo_name(newCountry.getCo_name());
		countryRepository.save(country);
	}
	
	
	@Transactional
	public void deleteCountry(String cCode) {
		Country country = null;
		Optional<Country> olst = countryRepository.findById(cCode);
		if (olst.isPresent())
			country = olst.get();
		countryRepository.delete(country);
	}

}
