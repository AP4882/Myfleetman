package DataProviderJSON;


	



	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
import java.text.ParsePosition;
import java.util.ArrayList;

	import org.json.simple.JSONArray;
	import org.json.simple.JSONObject;
	import org.json.simple.parser.JSONParser;



	public class GetJSONDataMultipleGuest {
		
		

		public static ArrayList<Object[]> getJSONdata(String JSON_path, String JSON_data) throws FileNotFoundException, IOException,  org.json.simple.parser.ParseException, InterruptedException
		{
			ArrayList<Object[]> Mydata = new ArrayList<Object[]>();

			Object obj = new JSONParser().parse(new FileReader(JSON_path));
			JSONObject jo = (JSONObject)obj;
			JSONArray js = (JSONArray)jo.get(JSON_data);
			
			
			
			for (int i = 0; i < js.size(); i++) 
			{ 
				JSONObject obj1 = (JSONObject)js.get(i);
				
				String prefix = String.valueOf(obj1.get("Prefix"));
				String CompanyName = String.valueOf(obj1.get("Companyname"));
				String servingCity = String.valueOf(obj1.get("ServingCity"));
				String BookingMode = String.valueOf(obj1.get("BookingMode"));
				String Year = String.valueOf(obj1.get("Year"));
				String Month = String.valueOf(obj1.get("Month"));
				String Day = String.valueOf(obj1.get("Day"));
				String NoofGuests = String.valueOf(obj1.get("No.ofGuests"));
				String BookingGivenBy = String.valueOf(obj1.get("BookingGivenBy"));
				String BookingByContactNo = String.valueOf(obj1.get("BookingByContactNo"));
				String BookingByEmailId = String.valueOf(obj1.get("BookingByEmailId"));
				String CompanyRefNo = String.valueOf(obj1.get("CompanyRefNo"));
				String PaymentType = String.valueOf(obj1.get("PaymentType"));
				String Security = String.valueOf(obj1.get("Security"));
				String VehicleType = String.valueOf(obj1.get("VehicleType"));
				String PackageFor = String.valueOf(obj1.get("PackageFor"));
				String PackageName = String.valueOf(obj1.get("PackageName"));
				String PaymentMode = String.valueOf(obj1.get("PaymentMode"));
				String RadioSelection = String.valueOf(obj1.get("RadioSelection"));
				String Vehicle_Prefix = String.valueOf(obj1.get("Vehicle_Prefix"));
				String SearchVehicle = String.valueOf(obj1.get("SearchVehicle"));
				String NewVehicle = String.valueOf(obj1.get("NewVehicle"));
				String VehicleCat = String.valueOf(obj1.get("VehicleCategory"));
				String VehicleState = String.valueOf(obj1.get("VehicleState"));
				String VehicleCityCode = String.valueOf(obj1.get("VehicleCityCode"));
				String VehicleSeries = String.valueOf(obj1.get("VehicleSeries"));
				String VehicleNumber = String.valueOf(obj1.get("VehicleNumber"));
				String DriverPrefix = String.valueOf(obj1.get("DriverPrefix"));
				String DriverName = String.valueOf(obj1.get("DriverName"));
				String Driver_Mob = String.valueOf(obj1.get("Mobile"));
				String AllocationType = String.valueOf(obj1.get("AllocationType"));
				int BookingIndex=i;
				
				
			Object ob[] = {prefix,CompanyName,servingCity,BookingMode,Year,Month,Day,NoofGuests,BookingGivenBy,BookingByContactNo,BookingByEmailId,CompanyRefNo,PaymentType,
					Security,VehicleType,PackageFor,PackageName,PaymentMode,RadioSelection,Vehicle_Prefix,SearchVehicle,NewVehicle,VehicleCat,
					VehicleState,VehicleCityCode,VehicleSeries,VehicleNumber,DriverPrefix,DriverName,Driver_Mob,AllocationType,BookingIndex};
			
			Mydata.add(ob);
			
		
			}
			return Mydata;
	}
	}
	
	



