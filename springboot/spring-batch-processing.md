I'll create a Spring Batch example that reads data from a CSV file, processes it, and writes it to a database.



```java
// pom.xml dependencies
/*
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-batch</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>
*/

// Employee.java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Double salary;
}

// EmployeeRepository.java
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

// EmployeeProcessor.java
@Component
public class EmployeeProcessor implements ItemProcessor<Employee, Employee> {
    
    @Override
    public Employee process(Employee employee) throws Exception {
        // Example processing: Convert names to uppercase
        employee.setFirstName(employee.getFirstName().toUpperCase());
        employee.setLastName(employee.getLastName().toUpperCase());
        
        // Example salary processing: Add 10% bonus
        employee.setSalary(employee.getSalary() * 1.1);
        
        return employee;
    }
}

// BatchConfig.java
@Configuration
@EnableBatchProcessing
public class BatchConfig {
    
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Bean
    public FlatFileItemReader<Employee> reader() {
        FlatFileItemReader<Employee> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("employees.csv"));
        reader.setLinesToSkip(1); // Skip header line
        
        DefaultLineMapper<Employee> lineMapper = new DefaultLineMapper<>();
        
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setNames("firstName", "lastName", "email", "salary");
        
        BeanWrapperFieldSetMapper<Employee> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Employee.class);
        
        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        
        reader.setLineMapper(lineMapper);
        return reader;
    }
    
    @Bean
    public EmployeeProcessor processor() {
        return new EmployeeProcessor();
    }
    
    @Bean
    public JpaItemWriter<Employee> writer() {
        JpaItemWriter<Employee> writer = new JpaItemWriter<>();
        writer.setEntityManagerFactory(entityManagerFactory);
        return writer;
    }
    
    @Bean
    public Job importEmployeesJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importEmployeesJob")
            .incrementer(new RunIdIncrementer())
            .listener(listener)
            .flow(step1)
            .end()
            .build();
    }
    
    @Bean
    public Step step1(JpaItemWriter<Employee> writer) {
        return stepBuilderFactory.get("step1")
            .<Employee, Employee>chunk(10)
            .reader(reader())
            .processor(processor())
            .writer(writer)
            .build();
    }
}

// JobCompletionNotificationListener.java
@Component
public class JobCompletionNotificationListener implements JobExecutionListener {
    
    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("Job started!");
    }
    
    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("Job completed! Time to verify the results");
            
            employeeRepository.findAll().forEach(employee -> {
                log.info("Found <" + employee + "> in the database.");
            });
        }
    }
}

// application.properties
/*
spring.batch.job.enabled=false
spring.batch.initialize-schema=always

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
*/

// employees.csv
/*
firstName,lastName,email,salary
John,Doe,john@example.com,50000
Jane,Smith,jane@example.com,60000
Bob,Johnson,bob@example.com,55000
*/

// BatchJobLauncher.java
@Component
public class BatchJobLauncher {
    
    @Autowired
    JobLauncher jobLauncher;
    
    @Autowired
    Job job;
    
    @Scheduled(fixedRate = 5000)
    public void runBatchJob() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder()
            .addLong("time", System.currentTimeMillis())
            .toJobParameters();
            
        jobLauncher.run(job, jobParameters);
    }
}

```

This Spring Batch example demonstrates several key features:

1. File Reading: Reads employee data from a CSV file
2. Processing: Transforms employee data (uppercase names, salary bonus)
3. Writing: Saves processed data to a database
4. Job Configuration: Sets up the batch job with chunks
5. Error Handling: Includes job completion listener
6. Scheduling: Includes scheduled job launcher

Key Components:
1. Employee: Entity class representing employee data
2. EmployeeProcessor: Processes each employee record
3. BatchConfig: Main configuration for the batch job
4. JobCompletionNotificationListener: Handles job completion events

To use this example:
1. Create a `employees.csv` file in resources folder
2. Configure database properties in application.properties
3. Run the application

The batch job will:
1. Read employees from CSV
2. Convert names to uppercase
3. Add 10% to salaries
4. Save to database
5. Log completion status

Would you like me to explain any specific part in more detail or add additional functionality?