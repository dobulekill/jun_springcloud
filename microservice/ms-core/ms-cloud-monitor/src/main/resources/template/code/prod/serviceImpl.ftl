package ${packagePath}.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ${packagePath}.dao.${table.className}Dao;
import ${packagePath}.pojo.${table.className};
import ${packagePath}.service.${table.className}Service;
import com.system.comm.model.Page;
import com.system.handle.model.ResponseFrame;
import com.system.handle.model.ResponseCode;

/**
 * ${tablename} Service
 * @author ${user}
 * @date ${dateTime}
 * @version ${version}
 */
@Component
public class ${table.className}ServiceImpl implements ${table.className}Service {

	@Autowired
	private ${table.className}Dao ${table.beanName}Dao;
	
	@Override
	public ResponseFrame saveOrUpdate(${table.className} ${table.beanName}) {
		ResponseFrame frame = new ResponseFrame();
		if(${table.beanName}.get${table.firstKColumn.fieldNameFupcase}() == null) {
			${table.beanName}Dao.save(${table.beanName});
		} else {
			${table.beanName}Dao.update(${table.beanName});
		}
		frame.setCode(ResponseCode.SUCC.getCode());
		return frame;
	}

	@Override
	public ${table.className} get(${table.firstKColumn.typeName} ${table.firstKColumn.fieldName}) {
		return ${table.beanName}Dao.get(${table.firstKColumn.fieldName});
	}

	@Override
	public ResponseFrame pageQuery(${table.className} ${table.beanName}) {
		${table.beanName}.setDefPageSize();
		ResponseFrame frame = new ResponseFrame();
		Page<${table.className}> page = ${table.beanName}Dao.pageQuery(${table.beanName});
		frame.setBody(page);
		frame.setSucc();
		return frame;
	}
	
	@Override
	public ResponseFrame delete(${table.firstKColumn.typeName} ${table.firstKColumn.fieldName}) {
		ResponseFrame frame = new ResponseFrame();
		${table.beanName}Dao.delete(${table.firstKColumn.fieldName});
		frame.setCode(ResponseCode.SUCC.getCode());
		return frame;
	}
}