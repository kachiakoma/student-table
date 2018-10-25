package com.kachi.studentinfo.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import com.kachi.studentinfo.models.Student;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Bean
	public Job job(JobBuilderFactory jbf, StepBuilderFactory sbf, ItemReader<Student> ir, ItemWriter<Student> iw) {
		
		Step step = sbf.get("FileLoad")
					.<Student, Student>chunk(10)
					.reader(ir)
					.writer(iw)
					.build();
		
		return jbf.get("Load")
			.incrementer(new RunIdIncrementer())
			.start(step)
			.build();
		
	}
	
	@Bean
	public FlatFileItemReader<Student> fileReader(@Value("file:C:\\Users\\Kachi\\Desktop\\Test\\students.csv")Resource resource) {
		FlatFileItemReader<Student> ffir = new FlatFileItemReader<>();
		ffir.setResource(resource);
		ffir.setName("CSV-R");
		ffir.setLinesToSkip(1);
		ffir.setLineMapper(lineMapper());
		return ffir;
	}
	
	@Bean
	public  LineMapper<Student>lineMapper() {
		DefaultLineMapper<Student> dlm = new DefaultLineMapper<>();
		DelimitedLineTokenizer dlt = new DelimitedLineTokenizer();
		
		dlt.setDelimiter(",");
		dlt.setStrict(false);
		dlt.setNames(new String[] {"school_year", "campus_000", "id_000", "entry_date", "grade_level", "student_000"});
		
		BeanWrapperFieldSetMapper<Student> setmapper = new BeanWrapperFieldSetMapper<>();
		setmapper.setTargetType(Student.class);
		
		dlm.setLineTokenizer(dlt);
		dlm.setFieldSetMapper(setmapper);
		
		return dlm;
	}
}
