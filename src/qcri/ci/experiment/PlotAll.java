package qcri.ci.experiment;

import java.io.File;
import java.io.IOException;

import java.io.*;
public class PlotAll {

	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		
		
		final File ExpFolder = new File("Experiments/");
	//	final File ExpFolder = new File("Results/");
		for (final File fileEntry : ExpFolder.listFiles())
		{
			if(!fileEntry.isDirectory())
				continue;
	        String fileName = fileEntry.getPath();
	        if(fileName.contains("DS"))
	        	continue;
	        System.out.println(fileName);
	        
	        
	        
	        drawPlots(fileName);
	        
		}
	}

	
	//Draw plots for each individual file in the dir
	public static void drawPlots(String dir) throws IOException
	{
		final File folder = new File(dir);
		for (final File fileEntry : folder.listFiles())
		{
	        String fileName = fileEntry.getName();
	        
	        if(!fileName.endsWith("csv"))
	        	continue;
	        System.out.println(dir + "/" + fileName);
	        //replace(fileEntry.getAbsolutePath(),"NumOf","# ");
	        //replace(fileEntry.getAbsolutePath(),"(s)","(secs)");
	        qcri.ci.utils.MyPlotInfo pi = null;
			try {
				pi = new  qcri.ci.utils.MyPlotInfo(dir + "/" + fileName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
				pi.startPlot();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
		}
	}
	
	
	public static void replace(String fileName,String old, String newT)
		    throws IOException {

		try
        {
        File file = new File(fileName);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = "", oldtext = "";
        while((line = reader.readLine()) != null)
            {
            oldtext += line + "\r\n";
        }
        reader.close();
        // replace a word in a file
        //String newtext = oldtext.replaceAll("drink", "Love");
        //System.out.println("Old: " + oldtext);
        //To replace a line in a file
        String newtext = oldtext.replaceAll(old,newT);
        //System.out.println("New: " + newtext);
        FileWriter writer = new FileWriter(fileName);
        writer.write(newtext);writer.close();
    }
    catch (IOException ioe)
        {
        ioe.printStackTrace();
    }
		}

}
