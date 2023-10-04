package kr.ed.haebeop.config;

import kr.ed.haebeop.repository.TestRepository;
import kr.ed.haebeop.repository.TestRepositoryImpl;
import kr.ed.haebeop.test.transaction.TransactionRepository;
import kr.ed.haebeop.service.TestService;
import kr.ed.haebeop.service.TestServiceImpl;
import kr.ed.haebeop.test.transaction.TransactionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "kr.ed.haebeop")
public class ApplicationConfig {

    @Bean
    public TestService testService3() {return new TestServiceImpl();}

    @Bean
    public TestRepository testRepository3() {return new TestRepositoryImpl();}

    @Bean
    public TransactionService transactionService() {return new TransactionService();}

    @Bean
    public TransactionRepository transactionRepository() {return new TransactionRepository();}

}
