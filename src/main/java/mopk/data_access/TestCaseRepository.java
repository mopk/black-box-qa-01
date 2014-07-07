/**
 * Created by Mopk
 * on 2014-07-06 22:51.
 */
package mopk.data_access;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TestCaseRepository
                        extends MongoRepository<TestCaseData, String> {

    public List<TestCaseData> findByTestGroupId(String testGroupId);
}