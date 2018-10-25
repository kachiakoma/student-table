package com.kachi.studentinfo.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class FileUploadController {
	
	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	Job job;
	
	private static String UploadFolder = "C:\\Users\\Kachi\\Desktop\\Test";

	@RequestMapping(method = RequestMethod.GET)
	public String showUploadPage() {
		return "upload";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String load(@RequestParam("file") MultipartFile file, ModelMap map) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		
		if(file.isEmpty()) {
			map.addAttribute("message", "Something went wrong...");
			return "status";
		}
		
		try {
			byte[] data = file.getBytes();
			Path path = Paths.get(UploadFolder + "\\" + file.getOriginalFilename());
			Files.write(path, data);
			System.out.println(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		map.addAttribute("message", "File Uploaded Successfully.");
		
		Map<String, JobParameter> maps = new HashMap<>();
		JobParameters params = new JobParameters(maps);
		JobExecution jobExecution = jobLauncher.run(job, params);
		
		System.out.println("JobExecution: " + jobExecution.getStatus());

        while (jobExecution.isRunning()) {
            System.out.println("...");
        }

        return "status";
	}
}
