# Java-Threads-Parallel-Computation-with-Client-Server
Parallel computation across clients

This example has the server to slice and distribute parts of a calculation to clients.
When the clients finish calculating their part, they send it back to the server and the server
calculates the final reslult. This example has two clients and the data are sent to the clients only
if they both connect. Server wants to calculate pi, it has a number of steps, which determines how accurate the calculation will be
and uses clients as threads and the final result is compared with the pi from math.PI.
A running example is shown below.


![alt text](https://github.com/MenelaosK/Java-Threads-Parallel-Computation-with-Client-Server/blob/master/client-server-calculating-pi.png)
