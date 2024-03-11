package com.example.demo.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Certificate;
import com.example.demo.repository.CertificateRepo;

@Service
public class CertificateServiceImpl implements CertificateService {
	
	@Autowired
	private CertificateRepo certificateRepo;
	
	@Override
	public Certificate saveCertificate(Certificate certificate) {
		 
		return certificateRepo.save(certificate);
	}
	
	@Override
	public List<Certificate> fetchCertificateList() {
		 
		return certificateRepo.findAll();
	}
	
	@Override
	public Certificate fetchCertificateById(Long CertificateId) {
		
		return certificateRepo.findById(CertificateId).get();
	}

	@Override
	public void deleteCertificateById(Long CertificateId) {
		 
		certificateRepo.deleteById(CertificateId);
	}

	@Override
	public Certificate updateCertificate(Long CertificateId, Certificate certificate) {
		 
		
		Certificate certiDB = certificateRepo.findById(CertificateId).get();
		
		if (Objects.nonNull(certificate.getCollege()) && !"".equalsIgnoreCase(certificate.getCollege()))
		{
			certiDB.setCollege(certificate.getCollege());
		}
		
		if (Objects.nonNull(certificate.getYear()))
		{
			certiDB.setYear(certificate.getYear());
		}
		
		return certificateRepo.save(certiDB);
	}
	
	
	
	
	
	

	
}
