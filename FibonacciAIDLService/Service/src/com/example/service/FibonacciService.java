package com.example.service;


import com.example.common.aidl.IFibonacci;
import com.example.common.aidl.Request;
import com.example.common.aidl.Response;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class FibonacciService extends Service {

	private final IFibonacci.Stub mBinder = new IFibonacci.Stub() {

		@Override
		public Response javaRecursion(Request request) throws RemoteException {
			long preTime = System.currentTimeMillis();
			int result = FibonacciUtils.javaRecursion(request.getNum());
			long afterTime = System.currentTimeMillis();
			int time = (int) (afterTime - preTime);

			Response response = new Response();
			response.setResult(result);
			response.setTime(time);

			return response;
		}

		@Override
		public Response javaInterative(Request request) throws RemoteException {
			long preTime = System.currentTimeMillis();
			int result = FibonacciUtils.javaInterative(request.getNum());
			long afterTime = System.currentTimeMillis();
			int time = (int) (afterTime - preTime);

			Response response = new Response();
			response.setResult(result);
			response.setTime(time);

			return response;
		}
		
	};

	@Override
	public IBinder onBind(Intent intent) {
		return mBinder;
	}

}
