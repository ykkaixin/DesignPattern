package primeDetector.PersisterService;

import java.io.*;
import java.net.*;
  
// Server class
public class PersisterService
{

    public static void main(String[] args) throws IOException 
    {
        final int REQUIRED_NUMBER_OF_ARGS = 1;
        if ((args.length != REQUIRED_NUMBER_OF_ARGS) || (args[0].equals("${port}"))
         ) {

			System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments.",
					REQUIRED_NUMBER_OF_ARGS);
			System.exit(0);
		}
        int port = Integer.parseInt(args[0]); 
        String path = "file.txt";
        // server is listening on port 1010
        ServerSocket ss = new ServerSocket(port);
          
        Socket s = null;
        s = ss.accept();
        // running infinite loop for getting
        // client request
        try
        {
            // socket object to receive incoming client requests
            System.out.println("A new client is connected : " + s);
            
            PrimeData p = new PrimeData(path);
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            while(true) {
                String a = in.readLine();
                if(a.equals("STOP")) {
                    p.writeToFile();
                    p.close();
                    break;
                }
                int prime = Integer.parseInt(a);
                p.store(prime);
                System.out.println(a);
            }
        }
        catch (Exception e){
            s.close();
            e.printStackTrace();
        }
    }

}
  
