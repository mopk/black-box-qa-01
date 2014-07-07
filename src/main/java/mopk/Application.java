/**
 * Created by Mopk
 * on 2014-07-06 23:09.
 */
package mopk;

import mopk.data_access.TestCaseData;
import mopk.data_access.TestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.List;

@EnableAutoConfiguration
public class Application implements CommandLineRunner {

    @Autowired
    private TestCaseRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        repository.save(
                new TestCaseData(
                        "group1",
                        "32.1",
                        "3.7",
                        "8.68"
                )
        );
        repository.save(
                new TestCaseData(
                        "group2",
                        "2",
                        "3",
                        "0.67"
                )
        );

        System.out.println("Test cases found with findAll():");
        for (TestCaseData testCaseData : repository.findAll()) {
            System.out.println(testCaseData);
        }
        System.out.println();

        System.out.println("Test cases found with findByTestGroupId");
        List<TestCaseData> dataOfTestCasesOf2ndGroup =
                repository.findByTestGroupId("group2");
        for (TestCaseData testCaseData : dataOfTestCasesOf2ndGroup) {
            System.out.println(testCaseData);
        }
    }
}