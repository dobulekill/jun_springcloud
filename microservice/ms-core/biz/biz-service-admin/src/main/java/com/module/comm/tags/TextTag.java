package com.module.comm.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.module.comm.constants.DictCons;
import com.system.comm.utils.FrameStringUtil;

/**
 * 显示文本
 * 根据类型和ID显示文本
 * @author Wujun
 * @date 2013-8-29 下午6:40:13
 * @version V1.0.0
 */
public class TextTag extends TagSupport {

	private static final long serialVersionUID = 7293280902947614510L;

	private String value;
	private String dictcode;
	private String defvalue;

	@Override
	public int doStartTag() throws JspException {
		try {
			JspWriter out = this.pageContext.getOut();
			if(FrameStringUtil.isEmpty(defvalue)) {
				defvalue = "";
			}
			if(FrameStringUtil.isEmpty(value) || FrameStringUtil.isEmpty(dictcode)) {
				out.print(defvalue);
				return SKIP_BODY;
			}
			String result = DictCons.getValue(dictcode, value);
			if(FrameStringUtil.isEmpty(result)) {
				out.print(defvalue);
			} else {
				out.print(result);
			}
		} catch(Exception e) {
			throw new JspException(e.getMessage());
		}
		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	@Override
	public void release() {
		super.release();
		this.value = null;
		this.dictcode = null;
		this.defvalue = null;
	}

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDictcode() {
		return dictcode;
	}
	public void setDictcode(String dictcode) {
		this.dictcode = dictcode;
	}
	public String getDefvalue() {
		return defvalue;
	}
	public void setDefvalue(String defvalue) {
		this.defvalue = defvalue;
	}
}