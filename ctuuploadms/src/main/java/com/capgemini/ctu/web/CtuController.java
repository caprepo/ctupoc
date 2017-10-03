package com.capgemini.ctu.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.capgemini.ctu.service.CtuService;
import com.google.api.core.ApiFuture;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;

@RestController
@ComponentScan("com.capgemini.ctu")
@CrossOrigin
@EnableAutoConfiguration
public class CtuController {

	@Autowired
	private CtuService importBillsService;
	private static Logger log = Logger.getLogger(CtuController.class);

	
	@RequestMapping(value="/ctuservices/uploadfile",method = RequestMethod.POST)
    public String uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
	    System.out.println("In uploadFile method");
	    String response = "";
	    String UPLOADED_FOLDER = "/tmp";
	    String ocrResp = null;
	    String googleCloudLocation = null;
	    String googleCloudpubLocation = null;
	    Boolean cloudFlag =false;
	    
	    if (file.isEmpty()) {
            return "empty";
        }
	    try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + "/" + file.getOriginalFilename());
            Files.write(path, bytes);

			File file2 = new File(UPLOADED_FOLDER + "/" + file.getOriginalFilename());
		   response = "success";

        } catch (IOException e) {
            e.printStackTrace();
		}
	    return response;
    }
}
