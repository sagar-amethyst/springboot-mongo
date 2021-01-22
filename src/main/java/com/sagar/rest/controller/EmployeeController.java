package com.sagar.rest.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.bson.BsonBinarySubType;
import org.bson.Document;
import org.bson.types.Binary;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.sagar.rest.model.BusinessObject;
import com.sagar.rest.model.Doc;
import com.sagar.rest.model.Employee;
import com.sagar.rest.model.SystemDetails;
import com.sagar.rest.repository.DocRepository;

@RestController
@CrossOrigin("*")
public class EmployeeController {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired(required=true)
	private DocRepository docRepository;

	/*
	 * { "id": 1, "name": "sagar", "address": "Kameron", "dob": "10-JAN-2020" }
	 */

	List<Employee> employees = new ArrayList<Employee>();

	@PostMapping(value = "/saveapi", consumes = "application/json", produces = "application/json")
	@CrossOrigin("*")
	public void saveSystemDetails(@RequestBody Employee employee) {
		System.out.print(employee);
		employees.add(employee);

	}

	@GetMapping("/getcollection")
	@CrossOrigin("*")

	public ResponseEntity<List<Employee>> getEmployee() {

		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}

	@GetMapping("/mocktest")
	@ResponseBody
	@CrossOrigin("*")
	public ResponseEntity<List<BusinessObject>> mockList() {
		List<BusinessObject> result = Arrays.asList(
				new BusinessObject("Product0", "IDEA0", "SAP0@GMAIL.COM", "12-FEB-1990"),
				new BusinessObject("Product1", "IDEA1", "SAP1@2GMAIL.COM", "02-JAN-1991"),
				new BusinessObject("Product2", "IDEA2", "SAP2@GMAIL.COM", "21-AUG-1984"),
				new BusinessObject("Product3", "IDEA3", "SAP3@GMAIL.COM", "10-SEP-1987"),
				new BusinessObject("Product4", "IDEA4", "SAP4@GMAIL.COM", "19-DEC-2020"),
				new BusinessObject("Product0", "IDEA0", "SAP0@GMAIL.COM", "12-FEB-1990"),
				new BusinessObject("Product1", "IDEA1", "SAP1@2GMAIL.COM", "02-JAN-1991"),
				new BusinessObject("Product2", "IDEA2", "SAP2@GMAIL.COM", "21-AUG-1984"),
				new BusinessObject("Product3", "IDEA3", "SAP3@GMAIL.COM", "10-SEP-1987"),
				new BusinessObject("Product4", "IDEA4", "SAP4@GMAIL.COM", "19-DEC-2020"),
				new BusinessObject("Product0", "IDEA0", "SAP0@GMAIL.COM", "12-FEB-1990"),
				new BusinessObject("Product1", "IDEA1", "SAP1@2GMAIL.COM", "02-JAN-1991"),
				new BusinessObject("Product2", "IDEA2", "SAP2@GMAIL.COM", "21-AUG-1984"),
				new BusinessObject("Product3", "IDEA3", "SAP3@GMAIL.COM", "10-SEP-1987"),
				new BusinessObject("Product4", "IDEA4", "SAP4@GMAIL.COM", "19-DEC-2020"),
				new BusinessObject("Product0", "IDEA0", "SAP0@GMAIL.COM", "12-FEB-1990"),
				new BusinessObject("Product1", "IDEA1", "SAP1@2GMAIL.COM", "02-JAN-1991"),
				new BusinessObject("Product2", "IDEA2", "SAP2@GMAIL.COM", "21-AUG-1984"),
				new BusinessObject("Product3", "IDEA3", "SAP3@GMAIL.COM", "10-SEP-1987"),
				new BusinessObject("Product4", "IDEA4", "SAP4@GMAIL.COM", "19-DEC-2020"),
				new BusinessObject("Product0", "IDEA0", "SAP0@GMAIL.COM", "12-FEB-1990"),
				new BusinessObject("Product1", "IDEA1", "SAP1@2GMAIL.COM", "02-JAN-1991"),
				new BusinessObject("Product2", "IDEA2", "SAP2@GMAIL.COM", "21-AUG-1984"),
				new BusinessObject("Product3", "IDEA3", "SAP3@GMAIL.COM", "10-SEP-1987"),
				new BusinessObject("Product4", "IDEA4", "SAP4@GMAIL.COM", "19-DEC-2020"));

		return new ResponseEntity<List<BusinessObject>>(result, HttpStatus.OK);
	}

	@GetMapping("/api/sysdetails")
	@ResponseBody
	@CrossOrigin("*")
	public ResponseEntity<Object> getSys() {

		JSONArray array = new JSONArray();
		System.out.println(array);
		JSONObject jsonObject = new JSONObject();

		List<SystemDetails> result = Arrays.asList(
				new SystemDetails("Sys1", Arrays.asList("abc@google", "def@google"), "google"),
				new SystemDetails("Sys2", Arrays.asList("ghi@yahoo.com", "jkl@yahoo.com"), "yahoo"),
				new SystemDetails("Sys3", Arrays.asList("ghi@sap.com", "jkl@sap.com"), "sap"),
				new SystemDetails("Sys4", Arrays.asList("api4"), "gcp"),
				new SystemDetails("Sys5", Arrays.asList("api5"), "azure"),
				new SystemDetails("Sys1", Arrays.asList("abc@google", "def@google"), "google"),
				new SystemDetails("Sys2", Arrays.asList("ghi@yahoo.com", "jkl@yahoo.com"), "yahoo"),
				new SystemDetails("Sys3", Arrays.asList("ghi@sap.com", "jkl@sap.com"), "sap"),
				new SystemDetails("Sys4", Arrays.asList("api4"), "gcp"),
				new SystemDetails("Sys5", Arrays.asList("api5"), "azure"),
				new SystemDetails("Sys1", Arrays.asList("abc@google", "def@google"), "google"),
				new SystemDetails("Sys2", Arrays.asList("ghi@yahoo.com", "jkl@yahoo.com"), "yahoo"),
				new SystemDetails("Sys3", Arrays.asList("ghi@sap.com", "jkl@sap.com"), "sap"),
				new SystemDetails("Sys4", Arrays.asList("api4"), "gcp"),
				new SystemDetails("Sys5", Arrays.asList("api5"), "azure"),
				new SystemDetails("Sys1", Arrays.asList("abc@google", "def@google"), "google"),
				new SystemDetails("Sys2", Arrays.asList("ghi@yahoo.com", "jkl@yahoo.com"), "yahoo"),
				new SystemDetails("Sys3", Arrays.asList("ghi@sap.com", "jkl@sap.com"), "sap"),
				new SystemDetails("Sys4", Arrays.asList("api4"), "gcp"),
				new SystemDetails("Sys5", Arrays.asList("api5"), "azure"),
				new SystemDetails("Sys1", Arrays.asList("abc@google", "def@google"), "google"),
				new SystemDetails("Sys2", Arrays.asList("ghi@yahoo.com", "jkl@yahoo.com"), "yahoo"),
				new SystemDetails("Sys3", Arrays.asList("ghi@sap.com", "jkl@sap.com"), "sap"),
				new SystemDetails("Sys4", Arrays.asList("api4"), "gcp"),
				new SystemDetails("Sys5", Arrays.asList("api5"), "azure"));

		result.forEach(a -> array.put(a));
		jsonObject.put("weather", array);

		return new ResponseEntity<Object>(jsonObject.toMap(), HttpStatus.OK);
	}

	@RequestMapping(value = "/apiURL", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) // saveLoc
																												// uri
																												// in
																												// action="/saveLoc"
																												// jsp
	public ResponseEntity<Object> req(@RequestParam(value = "system", required = false) String system,
			@RequestParam(value = "api", required = false) String api,
			@RequestParam(value = "root", required = false) String root) {
		JSONObject jsonObject = new JSONObject();
		JSONObject response = new JSONObject();
		jsonObject.put("system", system);
		jsonObject.put("api", api);
		jsonObject.put("root", root);
		response.put("result", jsonObject);
		return new ResponseEntity<Object>(response.toMap(), HttpStatus.OK);
	}

	/*
	 * //@GetMapping("/system-mock")
	 * 
	 * @RequestMapping(value="/system-mock", method=RequestMethod.GET,
	 * produces=MediaType.APPLICATION_JSON_VALUE)
	 * 
	 * @CrossOrigin("*") public @ResponseBody ResponseEntity<JSONArray> systemList()
	 * { List<JSONObject> entities = new ArrayList<JSONObject>(); JSONArray array =
	 * new JSONArray(); JSONObject system = new JSONObject(); JSONObject sys = new
	 * JSONObject(); sys.put("name", "System1"); sys.put("api",
	 * "https://www.google.com/employee"); sys.put("root", "google");
	 * system.put("system", sys); array.put(system); entities.add(system);
	 * System.out.println(array); System.out.println(entities); //String message=;
	 * return new ResponseEntity<JSONArray>(array, HttpStatus.OK); }
	 */

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ResponseEntity<?> upload(@RequestParam("document") MultipartFile[] document) {
		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
		List<String> tempFileNames = new ArrayList<>();
		String tempFileName;
		FileOutputStream fo;

		try {
			for (MultipartFile file : document) {
				tempFileName = "/temp/" + file.getOriginalFilename();
				tempFileNames.add(tempFileName);
				fo = new FileOutputStream(tempFileName);
				fo.write(file.getBytes());
				fo.close();
				map.add("files", new FileSystemResource(tempFileName));
			}

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.MULTIPART_FORM_DATA);

			HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);
			new ResponseEntity<Object>(requestEntity, HttpStatus.FAILED_DEPENDENCY);

		} catch (IOException e) {
			e.printStackTrace();
		}

		for (String fileName : tempFileNames) {
			File f = new File(fileName);
			f.delete();
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	};

	@CrossOrigin("*")
	@RequestMapping(value = "/upload1", method = RequestMethod.POST)
	public String uploadDocument(@RequestParam("document") MultipartFile multipartFile) {

		System.out.println("name" + multipartFile.getName());
		System.out.println("content-Type" + multipartFile.getContentType());
		System.out.println("Name of file" + multipartFile.getOriginalFilename());
		System.out.println("Size of file" + multipartFile.getSize());

		return "file uploaded";
	}

	/* DONLOAD & UPLOAD */
	@CrossOrigin("*")
	@RequestMapping(value = "/uploading", method = RequestMethod.POST)
	public String singleFileUpload(@RequestParam("file") MultipartFile file,
			@RequestParam(value = "system", required = false) String system,
			@RequestParam(value = "client", required = false) String client,
			@RequestParam(value = "service", required = false) String service,
			@RequestParam(value = "root", required = false) String root) {
		try {
			Doc Doc = new Doc();
			Doc.setSystem(system);
			Doc.setClient(client);
			Doc.setService(service);
			Doc.setRoot(root);
			Doc.setFile(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
			mongoTemplate.insert(Doc);
			System.out.println(Doc);
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
		return "File is saved";
	};

	@CrossOrigin("*")
	@GetMapping("/retrieve")
	public StreamingResponseBody retrieveFile(@RequestParam("system") String system,
			@RequestParam("client") String client, @RequestParam("service") String service,
			@RequestParam("root") String root, HttpServletResponse response) {
		Doc demoDocument = mongoTemplate.findOne(new BasicQuery("{system :\"" + system + "\",client:\"" + client
				+ "\",service:\"" + service + "\",root:\"" + root + "\"}"), Doc.class);

		Binary bDoc = demoDocument.getFile();
		byte[] data = bDoc.getData();
		response.setHeader("Content-Disposition", "attachment;filename=downloaded.json");

		return outputStream -> {
			outputStream.write(data);
		};

	}
	
	
	@RequestMapping(value="/getColloctions",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)  //saveLoc uri in action="/saveLoc" jsp
	@ResponseBody
	public  ResponseEntity<?> getAllSysOnboarding(){
		List<Doc> docs=docRepository.findAll();

		StringBuilder strBuilder=new StringBuilder();
		
		strBuilder.append("[");
		for(Doc doc:docs) {
			strBuilder.append("{");
			strBuilder.append("system:"+doc.getSystem()+","+"service:"+doc.getService());
			strBuilder.append("}");
			strBuilder.append(",");
		}
		strBuilder.append(",");
		strBuilder.setLength(strBuilder.length() - 1);
		strBuilder.append("]");
		JSONArray array = new JSONArray(strBuilder.toString());
		System.out.println(array);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("response", array);
	

		return new ResponseEntity<String>(array.toString(), HttpStatus.OK);
	}
	
	@GetMapping
	@CrossOrigin("*")
	@RequestMapping(value="/api/mock/data",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> apiMock() {
	// Find the Collection
		MongoCollection<Document> collection = mongoTemplate.getCollection("entitySet");
		// It is in the form Doc
		FindIterable<Document> fit = collection.find().limit(2); // return some data only
		//FindIterable<Document> fit = collection.find();

		MongoCursor<Document> cursor = fit.iterator();
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("[");
		while (cursor.hasNext()) {

			strBuilder.append(cursor.next().toJson());
			strBuilder.append(",");
		}
		strBuilder.setLength(strBuilder.length() - 1);
			//System.out.println(strBuilder);
		strBuilder.append("]");
			//System.out.println(strBuilder.toString());
		JSONArray array = new JSONArray(strBuilder.toString());
			//System.out.println(array);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("entitySet", array);

		return new ResponseEntity<Object>(jsonObject.toMap(), HttpStatus.OK);

	}
	
}