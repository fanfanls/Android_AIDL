package com.example.common.aidl;

import android.os.Parcel;
import android.os.Parcelable;

public class Response implements Parcelable {

	private int time;
	private int result;
	
	public Response() {

	}

	public Response(Parcel parcel) {
		time = parcel.readInt();
		result = parcel.readInt();
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(time);
		dest.writeInt(result);
	}

	public static final Parcelable.Creator<Response> CREATOR = new Creator<Response>() {

		@Override
		public Response createFromParcel(Parcel source) {
			return new Response(source);
		}

		@Override
		public Response[] newArray(int size) {
			return new Response[size];
		}
	};

}
