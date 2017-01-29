package com.has.app;
import static spark.Spark.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;
public class App 
{
	public static ArrayList<String> changeLetters(ArrayList<String> list ,String old,String current){
		ArrayList<String> temp = new ArrayList<String>();
		if(list==null){
			return null;
		}
		for(String word:list){
			temp.add(word.replaceAll(old, current));
		}
		return temp;
	}
	public static boolean search(ArrayList<String> list ,String target,String change){
		ArrayList<String> test = changeLetters(list,target,change);
		if(list==null)
			return false;
		for(String word:test){
			if(word.contains(target))
				return false;
		}
		return true;
	}
    public static void main( String[] args )
    {
        get("/", (req, res) -> "Welcome To myApp");
		post("/compute", (req, res) -> {
			String words = req.queryParams("words");
			java.util.Scanner kyb = new java.util.Scanner(words);
			java.util.ArrayList<String> inputList = new java.util.ArrayList<String>();
			while (kyb.hasNext()){
            	String value = kyb.next().replaceAll("\\s","");
            	inputList.add(value);
          	}
			String target = req.queryParams("target");
			String change = req.queryParams("change");
			java.util.ArrayList<String> newList = App.changeLetters(inputList,target,change);
			
			Map map = new HashMap();
          	map.put("result", newList);
          	return new ModelAndView(map, "compute.mustache");
        	}, new MustacheTemplateEngine());
		
		get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }
	static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }
}
