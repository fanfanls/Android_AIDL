Android_AIDL
============

To demonstrate a Binder-based service and client (based on ownDesignedService, for example Fibonacci ), we’ll create three separate projects: 1. XXCommon library project - to define our AIDL interface as well as custom types for input values (Parcelable) and return values (Parcelable) 2. XXService project - where we implement our AIDL interface and expose it to the clients as Bound Service, meanwhile service should be implemented both in JAVA (Recursive) and Native (lib) (Iterative) 3. XXClient project - where we bind to our AIDL-defined service and use the method defined in it Note: XX stands for service name
