package io.metersphere.api.dto.definition.importdto;

import io.metersphere.api.dto.definition.ApiTestCaseDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ApiDefinitionImport {
    private String projectName;
    private String protocol;
    private List<ApiDefinitionImportDTO> data;

    // 新版本带用例导出
    private List<ApiTestCaseDTO> cases = new ArrayList<>();

}
