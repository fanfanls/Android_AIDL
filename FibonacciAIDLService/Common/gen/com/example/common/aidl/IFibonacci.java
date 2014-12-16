/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /home/ping/Common/src/com/example/common/aidl/IFibonacci.aidl
 */
package com.example.common.aidl;
public interface IFibonacci extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.example.common.aidl.IFibonacci
{
private static final java.lang.String DESCRIPTOR = "com.example.common.aidl.IFibonacci";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.example.common.aidl.IFibonacci interface,
 * generating a proxy if needed.
 */
public static com.example.common.aidl.IFibonacci asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.example.common.aidl.IFibonacci))) {
return ((com.example.common.aidl.IFibonacci)iin);
}
return new com.example.common.aidl.IFibonacci.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_javaRecursion:
{
data.enforceInterface(DESCRIPTOR);
com.example.common.aidl.Request _arg0;
if ((0!=data.readInt())) {
_arg0 = com.example.common.aidl.Request.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.example.common.aidl.Response _result = this.javaRecursion(_arg0);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_javaInterative:
{
data.enforceInterface(DESCRIPTOR);
com.example.common.aidl.Request _arg0;
if ((0!=data.readInt())) {
_arg0 = com.example.common.aidl.Request.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
com.example.common.aidl.Response _result = this.javaInterative(_arg0);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.example.common.aidl.IFibonacci
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public com.example.common.aidl.Response javaRecursion(com.example.common.aidl.Request request) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.example.common.aidl.Response _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((request!=null)) {
_data.writeInt(1);
request.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_javaRecursion, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.example.common.aidl.Response.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public com.example.common.aidl.Response javaInterative(com.example.common.aidl.Request request) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
com.example.common.aidl.Response _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((request!=null)) {
_data.writeInt(1);
request.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_javaInterative, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = com.example.common.aidl.Response.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_javaRecursion = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_javaInterative = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}
public com.example.common.aidl.Response javaRecursion(com.example.common.aidl.Request request) throws android.os.RemoteException;
public com.example.common.aidl.Response javaInterative(com.example.common.aidl.Request request) throws android.os.RemoteException;
}
