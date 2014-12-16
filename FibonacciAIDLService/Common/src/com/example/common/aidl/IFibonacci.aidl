package com.example.common.aidl;
import com.example.common.aidl.Response;
import com.example.common.aidl.Request;
interface IFibonacci{
	Response javaRecursion(in Request request);
	Response javaInterative(in Request request);
}