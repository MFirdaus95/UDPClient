import java.io.*;
import java.net.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class time
{
  public static void main(String[] args) throws Exception
  {
     Calendar cal = Calendar.getInstance();
     SimpleDateFormat sdf = new SimpleDateFormat("HH.mm");
     Socket sock = new Socket("192.168.111.129", 4583);
     BufferedReader keyRead = new BufferedReader(new 
InputStreamReader(System.in));
     OutputStream ostream = sock.getOutputStream();
     PrintWriter pwrite = new PrintWriter(ostream, true);
     InputStream istream = sock.getInputStream();

     BufferedReader receiveRead = new BufferedReader(new 
InputStreamReader(istream));
     System.out.println("You are connected to SERVER Pro. Type and press Enter key");

     String receiveMessage, sendMessage;

     while(true)
     {
        //sendMessage = keyRead.readLine();
        //pwrite.println(sendMessage);
        //pwrite.println(sdf.format(cal.getTime()));
        //pwrite.flush();

	//sendMessage= keyRead.readLine();
	receiveMessage = receiveRead.readLine();

	if(receiveMessage.equalsIgnoreCase("ctime"))
	{
          pwrite.println(sdf.format(cal.getTime()));
	  pwrite.println(sdf.format(cal.getTime()));
	  //pwrite.println(sendMessage);
	  pwrite.flush();
	}

	else
        {
          System.out.println(receiveMessage);
	  //sendMessage= keyRead.readLine();
	  //pwrite.println(sendMessage);
	  //pwrite.flush();}
        }
    }
  }
}
