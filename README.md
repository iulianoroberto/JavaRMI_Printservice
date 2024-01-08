# Java_RMI_printservice
Implement a type of remote object (*PrintService*) that exposes the method **void print(String s)**, which prints on the standard output of the server a string passed by the client at method invocation time. Instantiate an object of type *PrintService* in a server process and register it with the name *printservice*.
Implement a client that continuously reads lines from the standard input (until the character “.” is encountered) and sends them to the server, by invoking the method *print(…)* of the remote object hosted by the server.
