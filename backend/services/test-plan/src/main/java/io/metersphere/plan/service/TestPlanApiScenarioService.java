package io.metersphere.plan.service;

import io.metersphere.api.dto.scenario.ApiScenarioDTO;
import io.metersphere.api.service.scenario.ApiScenarioService;
import io.metersphere.plan.constants.AssociateCaseType;
import io.metersphere.plan.domain.TestPlanApiScenario;
import io.metersphere.plan.domain.TestPlanApiScenarioExample;
import io.metersphere.plan.dto.TestPlanCaseRunResultCount;
import io.metersphere.plan.dto.TestPlanCollectionDTO;
import io.metersphere.plan.dto.request.BaseCollectionAssociateRequest;
import io.metersphere.plan.dto.request.TestPlanApiScenarioRequest;
import io.metersphere.plan.mapper.ExtTestPlanApiScenarioMapper;
import io.metersphere.plan.mapper.TestPlanApiScenarioMapper;
import io.metersphere.plan.mapper.TestPlanCollectionMapper;
import io.metersphere.sdk.constants.CaseType;
import io.metersphere.sdk.util.BeanUtils;
import io.metersphere.system.uid.IDGenerator;
import jakarta.annotation.Resource;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = Exception.class)
public class TestPlanApiScenarioService extends TestPlanResourceService {
    @Resource
    private SqlSessionFactory sqlSessionFactory;
    @Resource
    private TestPlanApiScenarioMapper testPlanApiScenarioMapper;
    @Resource
    private ExtTestPlanApiScenarioMapper extTestPlanApiScenarioMapper;
    @Resource
    private TestPlanCollectionMapper testPlanCollectionMapper;
    @Resource
    private ApiScenarioService apiScenarioService;

    @Override
    public void deleteBatchByTestPlanId(List<String> testPlanIdList) {
        TestPlanApiScenarioExample example = new TestPlanApiScenarioExample();
        example.createCriteria().andTestPlanIdIn(testPlanIdList);
        testPlanApiScenarioMapper.deleteByExample(example);
    }

    @Override
    public long getNextOrder(String projectId) {
        return 0;
    }

    @Override
    public void updatePos(String id, long pos) {
        //        todo
        //        extTestPlanApiScenarioMapper.updatePos(id, pos);
    }

    @Override
    public Map<String, Long> caseExecResultCount(String testPlanId) {
        List<TestPlanCaseRunResultCount> runResultCounts = extTestPlanApiScenarioMapper.selectCaseExecResultCount(testPlanId);
        return runResultCounts.stream().collect(Collectors.toMap(TestPlanCaseRunResultCount::getResult, TestPlanCaseRunResultCount::getResultCount));
    }

    @Override
    public long copyResource(String originalTestPlanId, String newTestPlanId, String operator, long operatorTime) {
        List<TestPlanApiScenario> copyList = new ArrayList<>();
        extTestPlanApiScenarioMapper.selectByTestPlanIdAndNotDeleted(originalTestPlanId).forEach(originalCase -> {
            TestPlanApiScenario newCase = new TestPlanApiScenario();
            BeanUtils.copyBean(newCase, originalCase);
            newCase.setId(IDGenerator.nextStr());
            newCase.setTestPlanId(newTestPlanId);
            newCase.setCreateTime(operatorTime);
            newCase.setCreateUser(operator);
            newCase.setLastExecTime(0L);
            newCase.setLastExecResult(null);
            newCase.setLastExecReportId(null);
            copyList.add(newCase);
        });

        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        TestPlanApiScenarioMapper batchInsertMapper = sqlSession.getMapper(TestPlanApiScenarioMapper.class);
        copyList.forEach(item -> batchInsertMapper.insert(item));
        sqlSession.flushStatements();
        SqlSessionUtils.closeSqlSession(sqlSession, sqlSessionFactory);
        return copyList.size();
    }

    @Override
    public void refreshPos(String testPlanId) {
        //        todo
        //        List<String> caseIdList = extTestPlanApiScenarioMapper.selectIdByTestPlanIdOrderByPos(testPlanId);
        //        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        //        ExtTestPlanApiCaseMapper batchUpdateMapper = sqlSession.getMapper(ExtTestPlanApiCaseMapper.class);
        //        for (int i = 0; i < caseIdList.size(); i++) {
        //            batchUpdateMapper.updatePos(caseIdList.get(i), i * DEFAULT_NODE_INTERVAL_POS);
        //        }
        //        sqlSession.flushStatements();
        //        SqlSessionUtils.closeSqlSession(sqlSession, sqlSessionFactory);
    }

    @Override
    public void associateCollection(String planId, Map<String, List<BaseCollectionAssociateRequest>> collectionAssociates, String userId) {
        List<BaseCollectionAssociateRequest> apiScenarios = collectionAssociates.get(AssociateCaseType.API_SCENARIO);
        // TODO: 调用具体的关联场景用例入库方法  入参{计划ID, 测试集ID, 关联的用例ID集合}
    }

    @Override
    public void initResourceDefaultCollection(String planId, List<TestPlanCollectionDTO> defaultCollections) {
        TestPlanCollectionDTO defaultCollection = defaultCollections.stream().filter(collection -> StringUtils.equals(collection.getType(), CaseType.SCENARIO_CASE.getKey())
                && !StringUtils.equals(collection.getParentId(), "NONE")).toList().get(0);
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        TestPlanApiScenarioMapper scenarioBatchMapper = sqlSession.getMapper(TestPlanApiScenarioMapper.class);
        TestPlanApiScenario record = new TestPlanApiScenario();
        record.setTestPlanCollectionId(defaultCollection.getId());
        TestPlanApiScenarioExample scenarioCaseExample = new TestPlanApiScenarioExample();
        scenarioCaseExample.createCriteria().andTestPlanIdEqualTo(planId);
        scenarioBatchMapper.updateByExampleSelective(record, scenarioCaseExample);
    }


    /**
     * 未关联接口场景列表
     *
     * @param request
     * @param isRepeat
     * @return
     */
    public List<ApiScenarioDTO> getApiScenarioPage(TestPlanApiScenarioRequest request, boolean isRepeat) {
        List<ApiScenarioDTO> scenarioPage = apiScenarioService.getScenarioPage(request, isRepeat, request.getTestPlanId());
        return scenarioPage;
    }
}
