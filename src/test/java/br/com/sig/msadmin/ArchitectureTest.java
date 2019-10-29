package br.com.sig.msadmin;

import org.junit.runner.RunWith;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages="br.com.footbook", importOptions=ImportOption.DoNotIncludeTests.class)
public class ArchitectureTest {

	/**
	 * Packages
	 */
	public static final String PACKAGE_PREFIX = ArchitectureTest.class.getName();
	public static final String ANY_MAPPER_PACKAGE_PREFIX = "..mapper..";
	public static final String ANY_DATAPROVIDERS_PACKAGE_PREFIX = "..dataproviders..";
	public static final String ANY_CONFIGURATION_PACKAGE_PREFIX = "..configuration..";
	public static final String ANY_ENTRYPOINTS_PACKAGE_PREFIX = "..entrypoints..";
	public static final String ANY_USECASE_PACKAGE_PREFIX = "..usecase..";
	public static final String ANY_GATEWAY_PACKAGE_PREFIX = "..gateway..";
	
	/**
	 * DataProvider
	 */
	public static final String DATAPROVIDER_PACKAGE_PREFIX = PACKAGE_PREFIX + ".dataproviders";
	public static final String MAPPER_DATAPROVIDER_PACKAGE_PREFIX = DATAPROVIDER_PACKAGE_PREFIX + ".mappers";
	public static final String ENTITIES_DATAPROVIDER_PACKAGE_PREFIX = DATAPROVIDER_PACKAGE_PREFIX + ".entities";
	public static final String REPOSITORY_DATAPROVIDER_PACKAGE_PREFIX = DATAPROVIDER_PACKAGE_PREFIX + ".repository";
	
	/**
	 * Entrypoint
	 */
	public static final String ENTRYPOINT_PACKAGE_PREFIX = PACKAGE_PREFIX + ".entrypoints";
	public static final String MAPPER_ENTRYPOINT_PACKAGE_PREFIX = ENTRYPOINT_PACKAGE_PREFIX + ".mappers";
	public static final String ENTITIES_ENTRYPOINT_PACKAGE_PREFIX = "..entrypoints.entities..";
	
	/**
	 * Core
	 */
	public static final String CORE_PACKAGE_PREFIX = PACKAGE_PREFIX +  ".core";
	public static final String USECASE_PACKAGE_PREFIX = CORE_PACKAGE_PREFIX + ".usecase";
	public static final String GATEWAY_PACKAGE_PREFIX = CORE_PACKAGE_PREFIX + ".gateway";
	public static final String UTIL_PACKAGE_PREFIX = CORE_PACKAGE_PREFIX + ".util";
	public static final String ENTITY_CORE_PACKAGE_PREFIX = "..core.entities..";
	
	public static final String LOMBOK_BUILDER_ANNOTATION = "builder";
	public static final String MAPPER_SUFFIX = "Mapper";
	public static final String CONFIGURATION_SUFFIX = "Configuration";
	
	/**
	 * Suffix DataProvider
	 *  
	*/
	public static final String DATAPROVIDER_SUFFIX = "DataProvider";
	public static final String REPOSITORY_DATAPROVIDER_SUFFIX = "Repository";
	public static final String FEIGN_DATAPROVIDER_SUFFIX = "Feign";
	public static final String ENTITIES_DATAPROVIDER_SUFFIX = "Table";
	public static final String ENTITIES_FEIGN_DATAPROVIDER_SUFFIX = "Feign";
	
	/**
	 * Suffix Core
	 *  
	*/
	public static final String USECASE_CORE_SUFFIX = "UseCase";
	public static final String ENTITIES_CORE_SUFFIX = "Entity";
	public static final String GATEWAY_CORE_SUFFIX = "Gateway";
	public static final String UTIL_CORE_SUFFIX = "Util";
	
	/**
	 * Suffix Entrypoint
	 *  
	*/
	public static final String ENTRYPOINT_SUFFIX = "Entrypoint";
	public static final String ENTITIES_ENTRYPOINT_SUFFIX = "HttpModel";
	
	/**
	 * Regras Gerais
	 */
	/**
	 *Regra sufixo para Mapper 
	 */
	@ArchTest
	static final ArchRule mapper_package_test = ArchRuleDefinition.classes().that().resideInAPackage(ANY_MAPPER_PACKAGE_PREFIX)
			.should().haveSimpleNameEndingWith(MAPPER_SUFFIX);
	

	/**
	 *Regra sufixo para Configuration 
	 */
	@ArchTest
	static final ArchRule configuration_package_test = ArchRuleDefinition.classes().that().resideInAPackage(ANY_CONFIGURATION_PACKAGE_PREFIX)
			.should().haveSimpleNameEndingWith(CONFIGURATION_SUFFIX);
	

	/**
	 *Regra sufixo para Entrypoint 
	 */
	@ArchTest
	static final ArchRule entrypoint_package_test = ArchRuleDefinition.classes().that().resideInAPackage(ANY_ENTRYPOINTS_PACKAGE_PREFIX)
			.should().haveSimpleNameEndingWith(ENTRYPOINT_SUFFIX);
	
	/**
	 *Regra sufixo para UseCase 
	 */
	@ArchTest
	static final ArchRule usecase_package_test = ArchRuleDefinition.classes().that().resideInAPackage(ANY_USECASE_PACKAGE_PREFIX)
			.should().haveSimpleNameEndingWith(USECASE_CORE_SUFFIX);
	
	/**
	 *Regra sufixo para DataProvider 
	 */
	@ArchTest
	static final ArchRule dataprovider_package_test = ArchRuleDefinition.classes().that().resideInAPackage(DATAPROVIDER_PACKAGE_PREFIX)
			.should().haveSimpleNameEndingWith(DATAPROVIDER_SUFFIX);
	
	@ArchTest
	static final ArchRule dataprovider_annotation_test = ArchRuleDefinition.classes().that().resideInAPackage(DATAPROVIDER_PACKAGE_PREFIX)
			.should().beAnnotatedWith("Component");
	
	/**
	 *Regra sufixo para Repository 
	 */
	@ArchTest
	static final ArchRule repository_package_test = ArchRuleDefinition.classes().that().resideInAPackage(REPOSITORY_DATAPROVIDER_PACKAGE_PREFIX)
			.should().haveSimpleNameEndingWith(REPOSITORY_DATAPROVIDER_SUFFIX);
	
	@ArchTest
	static final ArchRule repository_annotation_test = ArchRuleDefinition.classes().that().resideInAPackage(REPOSITORY_DATAPROVIDER_PACKAGE_PREFIX)
			.should().beAnnotatedWith("Repository");
	
	/**
	 *Regra para Entity Core 
	 */
	@ArchTest
	static final ArchRule core_entity_builder_test = ArchRuleDefinition.classes().that().resideInAPackage(ENTITY_CORE_PACKAGE_PREFIX)
			.should().haveSimpleNameEndingWith(ENTITIES_CORE_SUFFIX)
			.orShould().haveSimpleNameEndingWith("Builder");
	
	/**
	 *Regra para Entity Entrypoint 
	 */
	@ArchTest
	static final ArchRule entrypoint_entity_test = ArchRuleDefinition.classes().that().resideInAPackage(ENTITIES_ENTRYPOINT_PACKAGE_PREFIX)
			.should().haveSimpleNameEndingWith(ENTITIES_ENTRYPOINT_SUFFIX)
			.orShould().haveSimpleNameEndingWith("Builder");
	
	/**
	 *Regra para Entity DataProvider 
	 */
	@ArchTest
	static final ArchRule dataProvider_entity_test = ArchRuleDefinition.classes().that().resideInAPackage(ENTITIES_DATAPROVIDER_PACKAGE_PREFIX)
			.should().haveSimpleNameEndingWith(ENTITIES_DATAPROVIDER_SUFFIX)
			.orShould().haveSimpleNameEndingWith("Builder");

}
