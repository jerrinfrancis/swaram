/*
 * Copyright 1999-2004 Carnegie Mellon University.
 * Portions Copyright 2004 Sun Microsystems, Inc.
 * Portions Copyright 2004 Mitsubishi Electric Research Laboratories.
 * All Rights Reserved.  Use is subject to license terms.
 *
 * See the file "license.terms" for information on usage and
 * redistribution of this file, and for a DISCLAIMER OF ALL
 * WARRANTIES.
 *
 */

package src;

import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.util.props.PropertyException;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;

/**
 * A simple HelloWorld demo showing a simple speech application built using Sphinx-4. This application uses the Sphinx-4
 * endpointer, which automatically segments incoming audio into utterances and silences.
 */
public class ChakkaTest {

    public static void main(String[] args) {
        ConfigurationManager cm;
        
try
{
        if (args.length > 0) {
            cm = new ConfigurationManager(args[0]);
        } else {
        	
            cm = new ConfigurationManager(ChakkaTest.class.getResource("final.config.xml"));
        }

        Recognizer Mainrecognizer = (Recognizer) cm.lookup("Mainrecognizer");
        if (Mainrecognizer==null)System.out.println("NULL !");
        Recognizer BusTimingRecognizer = (Recognizer) cm.lookup("BusTimingRecognizer");
        Recognizer NewsRecognizer = (Recognizer) cm.lookup("NewsRecognizer");
        Recognizer MapsRecognizer = (Recognizer) cm.lookup("MapsRecognizer");
        Recognizer WikipediaRecognizer = (Recognizer) cm.lookup("WikipediaRecognizer");
        Mainrecognizer.allocate();
        BusTimingRecognizer.allocate();
        NewsRecognizer.allocate();
        MapsRecognizer.allocate();
        WikipediaRecognizer.allocate();
        
        
        // start the microphone or exit if the programm if this is not possible
        Microphone microphone = (Microphone) cm.lookup("microphone");
        if (!microphone.startRecording()){	
            System.out.println("Cannot start microphone.");
            Mainrecognizer.deallocate();
            BusTimingRecognizer.deallocate();
            NewsRecognizer.deallocate();
            MapsRecognizer.deallocate();
            WikipediaRecognizer.deallocate();
            System.exit(1);
        }

        System.out.println("സംസാരിക്കൂ  : ");

        // loop the recognition until the programm exits.
        while (true) {
        	
        	System.out.println("1.ബസ്സ്സമയം  2.സഞ്ജാരമാര്‍ഗ്ഗം 3.വിക്കിപീഡിയ 4.പ്രധാനവാര്‍ത്തകള്‍ 5.അടയ്ക്കുക");
        	System.out.println("സംസാരിച്ച് തുടങ്ങു . സോഫ്റ്റ്വെയര്‍ അവസാനിപ്പിക്കാന്‍ 'അടയ്ക്കുക' എന്ന് പറയുക \n");
            Result MainResult = Mainrecognizer.recognize();

            if (MainResult != null) {
            	String MainResultText = MainResult.getBestFinalResultNoFiller();
                System.out.println("You said: " + MainResultText + '\n');
                if(MainResultText.equals("അടയ്ക്കുക"))
        		{
        		    System.out.println("സോഫ്റ്റ്വെയര്‍ അവസാനിപ്പിക്കുന്നു");
        		    Mainrecognizer.deallocate();
                    BusTimingRecognizer.deallocate();
                    NewsRecognizer.deallocate();
                    MapsRecognizer.deallocate();
                    WikipediaRecognizer.deallocate();
        		    System.exit(1);
        	           		
                 }
                else if(MainResultText.equals("ബസ്സ്സമയം"))
                {
                while(true){
                System.out.println("1.തമ്പാനൂര്‍  2.ആറ്റിങ്ങല്‍ 3.സ്രീകാര്യം  4.കിഴക്കേകോട്ട  5.പേരൂര്‍കട  6.പട്ടം  7.പാളയം  8.കാട്ടാകട  9.വെഞ്ഞാറമൂട്  10.മെടിക്കല്‍കോളേജ് ");	
                Result BusTimingResult = BusTimingRecognizer.recognize();
                if (BusTimingResult !=null)
                {
                	String BusTimingResultText = BusTimingResult.getBestFinalResultNoFiller();
                    System.out.println("You said: " + BusTimingResultText + '\n');
                    if(BusTimingResultText.equals("അടയ്ക്കുക"))
            		{
                    	System.out.println("പ്രധാന പേജിലേക്ക് പോകുന്നു . ");
                    	break;
            		}
                
                }
                else {
                    System.out.println("I can't hear what you said.\n");
                }
                }
                }
                else if (MainResultText.equals("സഞ്ജാരമാര്‍ഗ്ഗം"))
                		{
                			while(true){
                			System.out.println("1.തമ്പാനൂര്‍  2.ആറ്റിങ്ങല്‍ 3.സ്രീകാര്യം  4.കിഴക്കേകോട്ട  5.പേരൂര്‍കട  6.പട്ടം  7.പാളയം  8.കാട്ടാകട  9.വെഞ്ഞാറമൂട്  10.മെടിക്കല്‍കോളേജ് 11.സ്ഥലം ഒന്ന് മാറ്റണം  12.തിരയുക" );
                			Result MapsResult = MapsRecognizer.recognize();
                            if (MapsResult !=null)
                            {
                            	String MapsResultText = MapsResult.getBestFinalResultNoFiller();
                                System.out.println("You said: " + MapsResultText + '\n');
                                if(MapsResultText.equals("അടയ്ക്കുക"))
                        		{
                                	System.out.println("പ്രധാന പേജിലേക്ക് പോകുന്നു . ");
                                	break;
                        		}
                            }
                            else {
                                System.out.println("I can't hear what you said.\n");
                            }
                			}
                		}
                 else if (MainResultText.equals("വിക്കിപീഡിയ"))
        		{
                	 while(true){
        			System.out.println("1.ശാസ്ത്രം  2.സംഗീതം  3.താജ്മഹല്‍  4.നെല്ലിക്ക  5.വേഴാമ്പല്‍  6.ചക്ക  7.ഘടികാരം  8.ചലചിത്രം  9.അദ്ധ്യാപകന്‍  10.ജ്യോതിശാസ്ത്രം  11.തിരയുക" );
        			Result WikipediaResult = WikipediaRecognizer.recognize();
                    if (WikipediaResult !=null)
                    {
                    	String WikipediaResultText = WikipediaResult.getBestFinalResultNoFiller();
                        System.out.println("You said: " + WikipediaResultText + '\n');
                        if(WikipediaResultText.equals("അടയ്ക്കുക"))
                		{
                        	System.out.println("പ്രധാന പേജിലേക്ക് പോകുന്നു . ");
                        	break;
                		}
                    }
                    else {
                        System.out.println("I can't hear what you said.\n");
                    }
        		}
        		}
                else if (MainResultText.equals("പ്രധാനവാര്‍ത്തകള്‍"))
        		{
                	while(true){
        			System.out.println("1.മാത്രുഭൂമി  2.ഇന്ത്യാവിഷന്‍  3.ദി ഹിന്ദു");
        			Result NewsResult = NewsRecognizer.recognize();
                    if (NewsResult !=null)
                    {
                    	String NewsResultText = NewsResult.getBestFinalResultNoFiller();
                        System.out.println("You said: " + NewsResultText + '\n');
                        if(NewsResultText.equals("അടയ്ക്കുക"))
                		{
                        	System.out.println("പ്രധാന പേജിലേക്ക് പോകുന്നു . ");
                        	break;
                     
                		}
                    }
                    
                	}
        		}
                
                
            } else {
                System.out.println("I can't hear what you said.\n");
            }
            
        }
} catch (PropertyException e) {
    System.err.println("Problem configuring SwapTest: " + e);
    e.printStackTrace();
}
    }
}