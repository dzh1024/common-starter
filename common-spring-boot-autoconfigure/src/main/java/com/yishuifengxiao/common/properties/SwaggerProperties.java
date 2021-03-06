/**
 * 
 */
package com.yishuifengxiao.common.properties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * swagger属性配置文件路径
 * 
 * @author yishui
 * @date 2019年1月17日
 * @Version 0.0.1
 */
@ConfigurationProperties(prefix = "yishuifengxiao.swagger")
public class SwaggerProperties {
	/**
	 * swagger 扫描的根路径
	 */
	private String basePackage;
	/**
	 * swagger 文档的标题
	 */
	private String title = "API接口文档";
	/**
	 * swagger 文档的描述
	 */
	private String description = " 易水风萧 接口说明文档";
	/**
	 * swagger 文档的中组织的链接
	 */
	private String termsOfServiceUrl = "http://www.yishuifengxiao.com/";
	/**
	 * swagger 文档的分组名
	 */
	private String groupName = "default";
	/**
	 * 版本号
	 */
	private String version = "1.0";

	/**
	 * 项目联系人
	 * 
	 */
	private String contactUser = "yishuifengxiao";

	/**
	 * 项目的url
	 */
	private String contactUrl = "http://www.yishuifengxiao.com/";

	/**
	 * 项目联系邮箱
	 */
	private String contactEmail = "zhiyubujian@163.com";
	/**
	 * 附加信息
	 */
	private List<AuthoriZationPar> auths = new ArrayList<>();

	public String getBasePackage() {
		return basePackage;
	}

	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTermsOfServiceUrl() {
		return termsOfServiceUrl;
	}

	public void setTermsOfServiceUrl(String termsOfServiceUrl) {
		this.termsOfServiceUrl = termsOfServiceUrl;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<AuthoriZationPar> getAuths() {
		return auths;
	}

	public void setAuths(List<AuthoriZationPar> auths) {
		this.auths = auths;
	}

	public String getContactUser() {
		return contactUser;
	}

	public void setContactUser(String contactUser) {
		this.contactUser = contactUser;
	}

	public String getContactUrl() {
		return contactUrl;
	}

	public void setContactUrl(String contactUrl) {
		this.contactUrl = contactUrl;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public static class AuthoriZationPar implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 7046632466056115744L;
		private String name;
		private String description;
		private String modelRef;
		private String parameterType;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getModelRef() {
			return modelRef;
		}

		public void setModelRef(String modelRef) {
			this.modelRef = modelRef;
		}

		public String getParameterType() {
			return parameterType;
		}

		public void setParameterType(String parameterType) {
			this.parameterType = parameterType;
		}

		@Override
		public String toString() {
			return "AuthoriZationPar [name=" + name + ", description=" + description + ", modelRef=" + modelRef
					+ ", parameterType=" + parameterType + "]";
		}

	}

	@Override
	public String toString() {
		return "SwaggerProperties [basePackage=" + basePackage + ", title=" + title + ", description=" + description
				+ ", termsOfServiceUrl=" + termsOfServiceUrl + ", groupName=" + groupName + ", version=" + version
				+ ", contactUser=" + contactUser + ", contactUrl=" + contactUrl + ", contactEmail=" + contactEmail
				+ ", auths=" + auths + "]";
	}

}
