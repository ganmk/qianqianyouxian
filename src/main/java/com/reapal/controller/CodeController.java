package com.reapal.controller;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.DbType;
/*import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import com.reapal.conf.CustomerVelocityTemplateEngine;
import com.reapal.conf.MySqlTypeConvertExt;*/
import com.reapal.dao.DbConfigDao;
import com.reapal.dao.TableStrategyConfigDao;
import com.reapal.dao.TemplateDao;
import com.reapal.model.*;
import com.reapal.service.CodeService;
import com.reapal.utils.FileUtils;
import com.reapal.utils.ZipFileUtils;
import groovy.util.logging.Slf4j;
import org.apache.tools.zip.ZipOutputStream;
import org.hibernate.LazyInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.*;

@Slf4j
@Controller
@RequestMapping
public class CodeController extends BaseController{

	@Autowired
	private CodeService codeService;

	/*@Autowired
	private DbConfigDao dbConfigDao;*/

	@Autowired
	private Environment env;

	@Autowired
	private TemplateDao templateDao;

	@Autowired
	private TableStrategyConfigDao tableStrategyConfigDao;

	@RequestMapping("/index")
	public String init(HttpServletRequest request) throws UnknownHostException {
		System.out.println("???????????????index");
		if(request.getSession().getAttribute("user") == null){
			return "redirect:/login";
		}
		final String hostAddress = InetAddress.getLocalHost().getHostAddress();
		String port = env.getProperty("server.port");
		final HttpSession session = request.getSession();
		session.setAttribute("wsUrl","ws://"+hostAddress+":"+port+"/chat");
		return "/views/index/index";
		//return "/layouts/default";
	}

	@RequestMapping("/ls-service-form/index")
	public String toIndex() throws IOException {
		System.out.println("?????????/ls-service-form/index");
		return "/views/service/ls-service-form";
	}


	/*@GetMapping("/getDbList")
	@ResponseBody
	public JSONObject getDbList(Model model){

		List<DbConfig> dbConfigList = dbConfigDao.findAll();
		return respJson(0,null,dbConfigList);
	}*/

	/*@GetMapping("/getByDbId")
	@ResponseBody
	@Transactional
	public JSONObject getByDbId(Long id) throws IOException {
		logger.info("?????????getByDbId"+id);
		//logger.info("?????????getByDbId");
		try{
			DbConfig dbConfig = dbConfigDao.getOne(id);
			return respJson(0, "", dbConfig);
		}
		catch (LazyInitializationException ex){
			logger.info(ex.getMessage());
		}

		return  null;
	}*/

	/**
	 * ??????Table??????
	 */
	@RequestMapping(value = "/database-list",method=RequestMethod.GET)
	public String databaseList(Model model,DbConfig dbConfig){
		return "/views/db/database_list";
	}

	/**
	 * ??????Table??????
	 */
	/*@RequestMapping(value = "/edit",method=RequestMethod.PUT)
	@ResponseBody
	public JSONObject edit(@RequestBody DbConfig dbConfig){
		dbConfigDao.save(dbConfig);
		return respJson(0, "????????????", true);
	}*/

	/**
	 * ?????????????????????
	 */
	@ResponseBody
	@RequestMapping(value = "/test",method=RequestMethod.POST)
	public JSONObject test( DbConfig dbConfig){
		String result = codeService.testConnection(dbConfig);
		if(StringUtils.isEmpty(result)){
			return respJson(0,"????????????",result);
		}else{
			return respJson(1,"?????????????????????",result);
		}
	}

	/**
	 * ??????Table??????
	 */
	/*@RequestMapping(value = "/save",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject save(@RequestBody DbConfig dbConfig){
		dbConfigDao.save(dbConfig);
		return respJson(0,"????????????",true);
	}*/

	/**
	 * ??????Table??????
	 */
	/*@RequestMapping(value = "/delete",method=RequestMethod.GET)
	@ResponseBody
	public JSONObject delete(Model model,DbConfig dbConfig){
		dbConfigDao.delete(dbConfig);
		return respJson(0, "????????????", true);
	}*/

	@GetMapping("/to-table-list")
	public String toTableList(Model model) throws IOException {
		return "/views/db/tables_list";
	}

	/*@GetMapping("/table-list")
	@ResponseBody
	public JSONObject tableList(Long id) throws IOException {
		List<TableInfo> tableList = null;
		try {
			DbConfig dbConfig = dbConfigDao.getOne(id);
			tableList = codeService.getAllTables(dbConfig);
		} catch (Exception e) {
			return respJson(500, "?????????????????????",null);
		}
		return respJson(0, "succ", tableList);
	}*/

	@GetMapping("/to-column-list")
	public String toColumnList(){
		return "/views/db/column_list";
	}

	/*@GetMapping("/column-list")
	@ResponseBody
	public JSONObject columnList(String tableName,Long id) throws IOException {
		DbConfig dbConfig = dbConfigDao.getOne(id);
		TableInfo tableInfo = codeService.getAllColumns(tableName,dbConfig);
		return respJson(0, "succ", tableInfo);
	}*/

	@GetMapping("/get-table-strategy")
	@ResponseBody
	public JSONObject getTableStrategy(String tableName,Long id) throws IOException {
		return respJson(0, "succ", tableStrategyConfigDao.findByDbIdAndTableName(id,tableName));
	}

	/**
	 * ??????????????????
	 */
	/*@RequestMapping(value = "/columnsave",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject save(Long id , String tableName,String comments , TableStrategyConfig tableStrategyConfig){
		String[] remarks = request.getParameterValues("remarks[]");
		DbConfig dbConfig = dbConfigDao.getOne(id);
		TableInfo tableInfo = new TableInfo();
		tableInfo.setTableName(tableName);
		tableInfo.setComments(comments);
		List<ColumnInfo> listItem = new ArrayList<ColumnInfo>();
		for(String remark:remarks){
			System.out.println(remark);
			String[] mark = remark.split("@");
			ColumnInfo item = new ColumnInfo();
			item.setColName(mark[0]);
			item.setColType(mark[1]);
			if(mark.length >= 3) {
				item.setComments(mark[2]);
			}
			if (mark.length >= 4) {
				item.setExtra(mark[3]);
			}
			if (mark.length >= 5) {
				item.setNullable("true".equalsIgnoreCase(mark[4]));
			}
			if (mark.length >= 6) {
				item.setDefaultValue(mark[5]);
			}
			listItem.add(item);
		}
		tableInfo.setListColumn(listItem);
		codeService.saveComment(tableInfo,dbConfig);
		tableStrategyConfig.setDbId(id);
		tableStrategyConfig.setTableName(tableName);
		tableStrategyConfigDao.save(tableStrategyConfig);
		return respJson(0, "????????????", true);
	}*/

	/*@GetMapping("/batchGenerate")
	public String batchGenerate(String jsonStr,Long id,HttpServletResponse response){
		TableStrategyConfig tableStrategyConfig = JSON.parseObject(jsonStr, TableStrategyConfig.class);
		DbConfig dbConfig = dbConfigDao.getOne(id);
		this.buildCodes(response, dbConfig, tableStrategyConfig);
		return null;
	}*/

	/**
	 * ????????????
	 */
	/*@RequestMapping(value="/generate",method=RequestMethod.GET)
	public String generate(String tableName, Long id, HttpServletResponse response) throws IOException {
		DbConfig dbConfig = dbConfigDao.getOne(id);
        TableStrategyConfig tableStrategyConfig = tableStrategyConfigDao.findByDbIdAndTableName(id, tableName);
		this.buildCodes(response, dbConfig, tableStrategyConfig);
		return null;
	}*/

	/**
	 * ???????????????????????????
	 * @param response
	 * @param dbConfig
	 * @param tableStrategyConfig
	 */
	/*private void buildCodes(HttpServletResponse response, DbConfig dbConfig, TableStrategyConfig tableStrategyConfig) {
		AutoGenerator mpg = new AutoGenerator();
		// ????????????
		GlobalConfig gc = new GlobalConfig();
		String outPutDir = request.getSession().getServletContext().getRealPath("/") + "/WEB-INF/upload/" + request.getSession().getId();
		gc.setOutputDir(outPutDir);
		gc.setFileOverride(true);
		gc.setActiveRecord(true);
		gc.setEnableCache(false);// XML ????????????
		gc.setBaseResultMap(true);// XML ResultMap
		gc.setBaseColumnList(false);// XML columList
		gc.setAuthor(tableStrategyConfig.getAuthor());
		gc.setEntityName(tableStrategyConfig.getEntityName());
		gc.setMapperName(tableStrategyConfig.getMapperName());
		gc.setXmlName(tableStrategyConfig.getXmlName());
		gc.setServiceName(tableStrategyConfig.getServiceName());
		gc.setServiceImplName(tableStrategyConfig.getServiceImplName());
		mpg.setGlobalConfig(gc);
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setDbType(dbConfig.getDriver().indexOf("mysql")>-1? DbType.MYSQL:DbType.ORACLE);
		dsc.setDriverName(dbConfig.getDriver());
		dsc.setUsername(dbConfig.getUsername());
		dsc.setPassword(dbConfig.getPassword());
		dsc.setUrl(dbConfig.getUrl());
        dsc.setTypeConvert(new MySqlTypeConvertExt()); //dateTime ---> OFFSET_DATE_TIME
		mpg.setDataSource(dsc);
		// ????????????
		StrategyConfig strategy = new StrategyConfig();
		if(!StringUtils.isEmpty(tableStrategyConfig.getPrefix())) {
            strategy.setTablePrefix(tableStrategyConfig.getPrefix());
		}
		strategy.setInclude(tableStrategyConfig.getTableName().split(",")); // ??????????????????
		strategy.setLogicDeleteFieldName("is_delete");
		// strategy.setExclude(new String[]{"test"}); // ??????????????????
		// ?????????????????????
		strategy.setNaming(NamingStrategy.underline_to_camel);
		strategy.setColumnNaming(NamingStrategy.underline_to_camel);
		// ??????????????????????????????
		// strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
		// ????????? mapper ??????
		// strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
		// ????????? service ??????
		// strategy.setSuperServiceClass("com.baomidou.demo.TestService");
		// ????????? service ???????????????
		// strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
		// ????????? controller ??????
		// strategy.setSuperControllerClass("com.baomidou.demo.TestController");
		// ????????????????????????????????????????????? false???
		// public static final String ID = "test_id";
		// strategy.setEntityColumnConstant(true);
		// ????????????????????????????????????????????? false???
		// public User setName(String name) {this.name = name; return this;}
		// strategy.setEntityBuliderModel(true);
		mpg.setStrategy(strategy);
		// ?????????
		PackageConfig pc = new PackageConfig();
		pc.setParent("com");
		pc.setModuleName(tableStrategyConfig.getModelName());
		pc.setEntity(tableStrategyConfig.getEntityPackage());
		pc.setService(tableStrategyConfig.getServicePackage());
		pc.setServiceImpl(tableStrategyConfig.getServiceImplPackage());
		pc.setMapper(tableStrategyConfig.getMapperPackage());
		pc.setController(tableStrategyConfig.getControllerPackage());

		mpg.setPackageInfo(pc);


		//????????????
		matchTemplateConfig(mpg, outPutDir,tableStrategyConfig);

		// ????????????
		mpg.execute();
		//????????????
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition","attachment; filename=src.zip");
		try {
			ZipFileUtils zip = new ZipFileUtils();
			ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());
			String fileName = request.getSession().getServletContext().getRealPath("/")+File.separator+"WEB-INF"+File.separator+"upload"+File.separator+request.getSession().getId();
			File ff = new File(fileName);
			if(!ff.exists()){
				ff.mkdirs();
			}
			zip.zip(ff,zos,"");
			zos.flush();
			zos.close();
			//????????????
			FileUtils.DeleteFolder(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/


	/**
	 * ????????????
	 * @param mpg
	 * @param outPutDir
	 * @param tableStrategyConfig
	 */
	/*private void matchTemplateConfig(AutoGenerator mpg, String outPutDir, TableStrategyConfig tableStrategyConfig) {
		//??????????????????
		TemplateCusConf tcc = new TemplateCusConf();
		if(tableStrategyConfig.getTemplateSetId()!=null && tableStrategyConfig.getTemplateSetId()>0 ){
			mpg.setTemplateEngine(new CustomerVelocityTemplateEngine());
			//???tmp??????????????????????????????
			List<Template> templates = templateDao.findByTemplateSetId(tableStrategyConfig.getTemplateSetId());
			String path = request.getSession().getServletContext().getRealPath("/");
			for (Template t : templates) {
				String fpath = path + t.getTemplateSetId()+ File.separator + t.getTemplateName();
				if(FileUtil.exist(fpath)){
					//????????????????????????????????????
					FileUtil.del(fpath);
				}
				//???????????????
				File file = FileUtil.touch(fpath);
				FileUtil.writeString(t.getContent(), file, Charset.defaultCharset());
				switch (t.getTemplateName()){
					case "controller.java.vm":
						tcc.setControllerPath(fpath);
						break;
					case "entity.java.vm":
						tcc.setEntityPath(fpath);
						break;
					case "mapper.java.vm":
						tcc.setMapperJavaPath(fpath);
						break;
					case "mapper.xml.vm":
						tcc.setMapperXmlPath(fpath);
						break;
					case "page.html.vm":
						tcc.setPageHtmlPath(fpath);
						break;
					case "page.js.vm":
						tcc.setPageJsPath(fpath);
						break;
					case "service.java.vm":
						tcc.setServicePath(fpath);
						break;
					case "serviceImpl.java.vm":
						tcc.setServiceImplPath(fpath);
						break;
					default:
				}
			}
		}else{
			mpg.setTemplateEngine(new VelocityTemplateEngine());
		}
		// ????????????????????????????????? VM ????????? cfg.abc ????????????
		InjectionConfig cfg = new InjectionConfig() {

			void initFileOutConfigList(){
				FileOutConfig fpage = new FileOutConfig(tcc.getPageHtmlPath()) {
					@Override
					public String outputFile(com.baomidou.mybatisplus.generator.config.po.TableInfo tableInfo) {
						//???????????????
						final String fname = tableInfo.getName().replaceAll("_", "-" ).toLowerCase();
						return outPutDir + File.separator + "resource" + File.separator + "templates" + File.separator + "views" + File.separator + fname + ".html";
					}
				};
				FileOutConfig fjs = new FileOutConfig(tcc.getPageJsPath()) {
					@Override
					public String outputFile(com.baomidou.mybatisplus.generator.config.po.TableInfo tableInfo) {
						//???????????????
						final String fname = tableInfo.getName().replaceAll("_", "-" ).toLowerCase();
						return outPutDir + File.separator + "resource" + File.separator + "static"+File.separator+"js" + File.separator + fname + ".js";
					}
				};
				List<FileOutConfig> list = new ArrayList<>(Collections.emptyList());
				list.add(fpage);
				list.add(fjs);
				this.setFileOutConfigList(list);
			}

			@Override
			public void initMap() {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("entityLombokModel",true);
				map.put("restControllerStyle",true);
				this.setMap(map);
				this.initFileOutConfigList();
			}
		};
		mpg.setCfg(cfg);
		// ?????????????????????????????? copy ?????? mybatis-plus/src/main/resources/template ?????????????????????
		// ????????????????????? src/main/resources/template ?????????, ??????????????????????????????????????????????????????????????????
		TemplateConfig tc = new TemplateConfig();
		tc.setController(tcc.getControllerPath());
		tc.setEntity(tcc.getEntityPath());
		tc.setMapper(tcc.getMapperJavaPath());
		tc.setXml(tcc.getMapperXmlPath());
		tc.setService(tcc.getServicePath());
		tc.setServiceImpl(tcc.getServiceImplPath());
		mpg.setTemplate(tc);
	}*/

}

