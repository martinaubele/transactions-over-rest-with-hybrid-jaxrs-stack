# Sample for https://github.com/atomikos/transactions-essentials/issues/186

cascadeList is lost on complex callbacks #186

Steps to reproduce the bug:

1) Start JaxrsApplication1, JaxrsApplication2 and JaxrsApplication3
2) Open http://localhost:8080/transactions/complexCall in your browser

Your will see a NullPointerException in JaxrsApplication2

java.lang.NullPointerException: null
	at com.atomikos.remoting.twopc.AtomikosRestPort.prepare(AtomikosRestPort.java:134) ~[transactions-remoting-6.0.1-SNAPSHOT.jar:na]

