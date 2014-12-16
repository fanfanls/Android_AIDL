package com.example.client;

import com.example.common.aidl.IFibonacci;
import com.example.common.aidl.Request;
import com.example.common.aidl.Response;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private Button mJavaIterationBtn;
	private Button mJavaRecursionBtn;
	private EditText mFibonacciNum;
	private TextView mResult;

	private boolean mIsCalc = false;
	private Response mResponse;
	private IFibonacci mFibonacci;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mJavaIterationBtn = (Button) findViewById(R.id.btn_mJavaIteration);
		mJavaRecursionBtn = (Button) findViewById(R.id.btn_mJavaRecursion);
		mFibonacciNum = (EditText) findViewById(R.id.et_num);
		mResult = (TextView) findViewById(R.id.tv_mResult);

		mJavaIterationBtn.setOnClickListener(this);
		mJavaRecursionBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (mIsCalc) {
			Toast.makeText(this, "Please wait for the previous result...", Toast.LENGTH_SHORT).show();
			return;
		}
		String fibonacciNum = mFibonacciNum.getText().toString().trim();
		int num;
		if("".equals(fibonacciNum) || fibonacciNum == null){
			Toast.makeText(this, "Please enter the Fibonacci Num...", Toast.LENGTH_SHORT).show();
			return ;
		} else {
			if(Integer.parseInt(fibonacciNum) == 0){
				Toast.makeText(this, "Fibonacci Num must be greater than zero", Toast.LENGTH_SHORT).show();
				return ;
			}
			num = Integer.parseInt(fibonacciNum);
		}
		
		final Request request = new Request();
		request.setNum(num);
		mIsCalc = true;
	
		switch (v.getId()) {
		case R.id.btn_mJavaIteration:
			new Thread() {
				public void run() {
					try {
						mResponse = mFibonacci.javaInterative(request);
						updateTextView();
					} catch (RemoteException e) {
						mIsCalc = false;
						e.printStackTrace();
					}
				};
			}.start();
			break;
		case R.id.btn_mJavaRecursion:
			new Thread() {
				public void run() {
					try {
						mResponse = mFibonacci.javaRecursion(request);
						updateTextView();
					} catch (RemoteException e) {
						mIsCalc = false;
						e.printStackTrace();
					}
				};
			}.start();
			break;
		default:
			break;
		}
	}

	private void updateTextView() {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				mResult.setText("The result is " + mResponse.getResult() + ", which spends " + mResponse.getTime() + "ms");
			}
		});
		mIsCalc = false;
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		Intent intent = new Intent("android.intent.action.FibonacciService");
		bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
	}

	@Override
	protected void onStop() {
		super.onStop();
		unbindService(mServiceConnection);
	}
	
	private ServiceConnection mServiceConnection = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {

		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			mFibonacci = IFibonacci.Stub.asInterface(service);
		}
	};

}
