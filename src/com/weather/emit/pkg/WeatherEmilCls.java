package com.weather.emit.pkg;

import java.io.*;
import java.util.ArrayList;
import java.util.List;



import com.weather.emit.bean.WeatherAttrBean;

public class WeatherEmilCls {
	
	public static void main(String[] args)
	{
		String filePath = "C:\\Users\\pmuruge1\\Desktop\\Read File\\SampleData.csv";
		File jarPath=new File(WeatherEmilCls.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		String propertiesPath=jarPath.getParentFile().getAbsolutePath();
		System.out.println(propertiesPath);	
		filePath = propertiesPath+"\\"+"SampleData.csv";
		System.out.println(filePath); 
		WeatherEmilCls cls = new WeatherEmilCls();
		cls.emitWeatherData(filePath);
	}
	
	public void emitWeatherData(String filePath)
	{
		BufferedReader br = null;
		String line = null;
		 String cvsSplitBy = ",";
		try {
			br = new BufferedReader(new FileReader(filePath));
			WeatherAttrBean bean = null;
			List<WeatherAttrBean> beanList = new ArrayList<WeatherAttrBean>();
			int counter = 0;
			while((line=br.readLine())!=null)
			{
				if(counter>0)
				{
				  String[] weather = line.split(cvsSplitBy);
				  bean = new WeatherAttrBean();
				  bean.setStation(weather[0]);
				  bean.setStattionName(weather[1]);
				  bean.setElevation(Float.parseFloat(weather[2]));
				  bean.setLatitue(Float.parseFloat(weather[3]));
				  bean.setLongitude(Float.parseFloat(weather[4]));
				  bean.setTime(weather[5]);
				  bean.setTemparature(Float.parseFloat(weather[6]));
				  bean.setPressure(Float.parseFloat(weather[7])); 
				  bean.setHumidity(Float.parseFloat(weather[8]));
				  bean.setTpcp(Float.parseFloat(weather[9]));
				  bean.setEmxt(Float.parseFloat(weather[10]));
				  bean.setEmnt(Float.parseFloat(weather[11]));  
				  beanList.add(bean);				  
				}
				counter++;
			}
			System.out.println(beanList.size());
			processData(beanList);
		} catch (FileNotFoundException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void processData(List<WeatherAttrBean> list) throws IOException
	{
		File jarPath=new File(WeatherEmilCls.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		String propertiesPath=jarPath.getParentFile().getAbsolutePath();
		File file = new File(propertiesPath+"\\output.txt");
		 if(file.exists())
			 file.delete();
		 BufferedWriter output = new BufferedWriter(new FileWriter(file,true));
		 output.append("Location|Position|Local|Time|Conditions|Temperature|Pressure|Humidity");
		 output.newLine();
		for(WeatherAttrBean bo:list)
		{
			
			try {				
				output.write(bo.getStattionName()+"|"+bo.getLatitue()+","+bo.getLongitude()+","+bo.getElevation()+"|"+bo.getTime()+"|"+ getScopes(bo.getTemparature(),bo.getPressure(),bo.getHumidity())+"|"+bo.getTemparature()+"|"+bo.getPressure()+"|"+bo.getHumidity());
				output.newLine();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		output.close();
		
	}
	
	private String getScopes(float temp,float pre,float hum)
	{
		    String condition="";
		    if(temp < 0.0 && pre>=500.0 && pre<=1000.0 && hum>=15 && hum <=60){
		    	condition="Snow";
		    }
		    else if(temp >= 0.0 && temp <= 20.0 && pre>1000.0 && pre<=1200.0 && hum>60 && hum <=100){
		    	condition="Rain";
		    }else if(temp >20.0 && temp <=50.0 && pre>1200.0 && pre<=1500.0 && hum<15){
		    	condition="Sunny";
		    }
		    else{
		    	condition="Hot";
		    }
		    return condition;
	}
	
	private void writeOutput(String result,File file) throws IOException
	{
		 
	        BufferedWriter output = null;
	        try {
	           
	            output = new BufferedWriter(new FileWriter(file));
	            output.append(result);
	        } catch ( IOException e ) {
	            e.printStackTrace();
	        } finally {
	          if ( output != null ) {
	            output.close();
	          }
	        }
	    }
	}
	

