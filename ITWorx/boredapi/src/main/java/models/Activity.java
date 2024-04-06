package models;

import com.google.gson.annotations.SerializedName;

public class Activity{

	@SerializedName("activity")
	private String activity;

	@SerializedName("accessibility")
	private Object accessibility;

	@SerializedName("price")
	private Object price;

	@SerializedName("link")
	private String link;

	@SerializedName("type")
	private String type;

	@SerializedName("key")
	private String key;

	@SerializedName("participants")
	private int participants;

	public String getActivity(){
		return activity;
	}

	public Object getAccessibility(){
		return accessibility;
	}

	public Object getPrice(){
		return price;
	}

	public String getLink(){
		return link;
	}

	public String getType(){
		return type;
	}

	public String getKey(){
		return key;
	}

	public int getParticipants(){
		return participants;
	}

	@Override
 	public String toString(){
		return 
			"Activity{" + 
			"activity = '" + activity + '\'' + 
			",accessibility = '" + accessibility + '\'' + 
			",price = '" + price + '\'' + 
			",link = '" + link + '\'' + 
			",type = '" + type + '\'' + 
			",key = '" + key + '\'' + 
			",participants = '" + participants + '\'' + 
			"}";
		}
}